package com.capgemini.coedevon.teammanager.forecast;

import java.io.File;
import java.io.FileOutputStream;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.coedevon.teammanager.forecast.model.ForecastDto;
import com.capgemini.coedevon.teammanager.person.PersonRepository;
import com.capgemini.coedevon.teammanager.person.model.PersonEntity;
import com.capgemini.coedevon.teammanager.personabsence.PersonAbsenceRepository;
import com.capgemini.coedevon.teammanager.personabsence.model.PersonAbsenceEntity;

/**
 * @author aolmosca
 *
 */
@Service
@Transactional(readOnly = true)
public class ForecastServiceImpl implements ForecastService {

  @Autowired
  PersonAbsenceRepository personAbsenceRepository;

  @Autowired
  PersonRepository personRepository;

  /**
   * {@inheritDoc}
   */
  @Override
  public Map<String, List<ForecastDto>> getGroupAbsenceByDate(Long groupId, Date init, Date end) {

    List<PersonEntity> groupMembersList = this.personRepository.findPersonByGroupId(groupId);

    List<Integer> personIds = extractListPersonId(groupMembersList);
    List<PersonAbsenceEntity> absenceList = this.personAbsenceRepository.findByPerson_IdInAndDateBetween(personIds,
        init, end);

    HashMap<String, List<ForecastDto>> hashAbsence = new HashMap<>();

    for (PersonEntity member : groupMembersList) {

      String key = member.getLastname() + ", " + member.getName();

      hashAbsence.put(key, extractAbsencesFromList(member.getId(), absenceList));
    }

    return hashAbsence;
  }

  private int countAusenciasOFestivosMonth(int month, boolean type, List<ForecastDto> absences) {

    int count = 0;

    if (type) {
      for (ForecastDto absence : absences) {
        if ((absence.getMonth() == month) && (absence.getType().equals("A") || absence.getType().equals("P")))
          count++;
      }
    } else {
      for (ForecastDto absence : absences) {
        if ((absence.getMonth() == month) && (absence.getType().equals("F")))
          count++;
      }
    }
    return count;
  }

  private int countAusenciasOFestivos(boolean type, List<ForecastDto> absences) {

    int count = 0;
    if (type) {
      for (ForecastDto absence : absences) {

        if ((absence.getType().equals("A") || absence.getType().equals("P")))
          count++;
      }
    } else {
      for (ForecastDto absence : absences) {
        if ((absence.getType().equals("F")))
          count++;
      }

    }
    return count;
  }

  @Override
  public File exportForecast(Long groupId, Date init, Date end, int type) {

    List<String> months = Arrays.asList(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
    "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" });
    Integer[] monthsDays = { 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    Map<String, List<ForecastDto>> absences = getGroupAbsenceByDate(groupId, init, end);
    LocalDate initDate = init.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    LocalDate endDate = end.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    Integer initMonth = initDate.getMonthValue();
    Integer merges = 0;
    boolean typeTemp = true;

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFCellStyle headerCellStyle = workbook.createCellStyle();
    headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
    XSSFCellStyle headerCellStyleAusencia = workbook.createCellStyle();
    headerCellStyleAusencia.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
    headerCellStyleAusencia.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    XSSFCellStyle headerCellStyleFestivo = workbook.createCellStyle();
    headerCellStyleFestivo.setFillForegroundColor(IndexedColors.BLUE.getIndex());
    headerCellStyleFestivo.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    XSSFCellStyle headerCellStyleWeekend = workbook.createCellStyle();
    headerCellStyleWeekend.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
    headerCellStyleWeekend.setFillPattern(FillPatternType.SOLID_FOREGROUND);

    if (type == 2) {
      XSSFSheet sheet = workbook.createSheet("Forecast Detail");
      createHeaders(months, monthsDays, initDate, endDate, initMonth, merges, workbook, sheet);
      generateRowsOneTab(absences, initDate, endDate, workbook, headerCellStyleAusencia, headerCellStyleFestivo,
          headerCellStyleWeekend, sheet);
    } else
      generateRowsMultTabs(months, absences, initDate, endDate, initMonth, workbook, headerCellStyleAusencia,
          headerCellStyleFestivo, headerCellStyleWeekend, headerCellStyle);
    try {
      // Write the workbook in file system
      File file = File.createTempFile("excel_" + System.currentTimeMillis(), "xlsx");
      FileOutputStream outputStream = new FileOutputStream(file);
      workbook.write(outputStream);
      outputStream.close();
      workbook.close();

      return file;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;

  }

  /**
   * @param months
   * @param absences
   * @param initDate
   * @param endDate
   * @param initMonth
   * @param workbook
   * @param headerCellStyleAusencia
   * @param headerCellStyleFestivo
   * @param headerCellStyleWeekend
   */
  private void generateRowsMultTabs(List<String> months, Map<String, List<ForecastDto>> absences, LocalDate initDate,
      LocalDate endDate, Integer initMonth, XSSFWorkbook workbook, XSSFCellStyle headerCellStyleAusencia,
      XSSFCellStyle headerCellStyleFestivo, XSSFCellStyle headerCellStyleWeekend, XSSFCellStyle headerCellStyle) {

    int rowCount = 1;
    List<XSSFSheet> sheets = new ArrayList<>();
    for (int l = initDate.getMonthValue(); l <= endDate.getMonthValue(); l++) {
      XSSFSheet sheet = workbook.createSheet(months.get(l));
      Row totalRow = sheet.createRow(absences.size() + 2);
      org.apache.poi.ss.usermodel.Cell cellName = totalRow.createCell(0);
      cellName.setCellValue("Total");
      org.apache.poi.ss.usermodel.Cell cellLab = totalRow.createCell(1);
      cellLab.setCellValue(0);
      org.apache.poi.ss.usermodel.Cell cellAu = totalRow.createCell(2);
      cellAu.setCellValue(0);
      org.apache.poi.ss.usermodel.Cell cellFes = totalRow.createCell(3);
      cellFes.setCellValue(0);
      sheets.add(sheet);
    }

    for (Map.Entry<String, List<ForecastDto>> entry : absences.entrySet()) {
      int dateCellCount = 4;
      Row absencesRowMonth = sheets.get(0).createRow(rowCount);
      Row headerLower = sheets.get(0).createRow(0);
      org.apache.poi.ss.usermodel.Cell cellName = headerLower.createCell(0);
      cellName.setCellValue("Name");
      org.apache.poi.ss.usermodel.Cell cellLab = headerLower.createCell(1);
      cellLab.setCellValue("Labor");
      org.apache.poi.ss.usermodel.Cell cellAu = headerLower.createCell(2);
      cellAu.setCellValue("Absence");
      org.apache.poi.ss.usermodel.Cell cellFes = headerLower.createCell(3);
      cellFes.setCellValue("Festive");

      LocalDate dateCount = LocalDate.of(initDate.getYear(), initDate.getMonthValue(), initDate.lengthOfMonth());
      long countAusencia = countAusenciasOFestivosMonth(initDate.getMonthValue(), true, entry.getValue());
      long countFestivos = countAusenciasOFestivosMonth(initDate.getMonthValue(), false, entry.getValue());
      long countLaborales = countBusinessDaysBetween(initDate, dateCount, Optional.empty()) + 1
          - (countFestivos + countAusencia);
      Row totalRow = sheets.get(0).getRow(absences.size() + 2);
      cellLab = totalRow.getCell(1);
      cellLab.setCellValue(countLaborales + cellLab.getNumericCellValue());
      cellAu = totalRow.getCell(2);
      cellAu.setCellValue(countAusencia + cellAu.getNumericCellValue());
      cellFes = totalRow.getCell(3);
      cellFes.setCellValue(countFestivos + cellFes.getNumericCellValue());

      cellName = absencesRowMonth.createCell(0);
      cellName.setCellValue(entry.getKey());
      cellLab = absencesRowMonth.createCell(1);
      cellLab.setCellValue(countLaborales);
      cellAu = absencesRowMonth.createCell(2);
      cellAu.setCellValue(countAusencia);
      cellFes = absencesRowMonth.createCell(3);
      cellFes.setCellValue(countFestivos);
      sheets.get(0).autoSizeColumn(0);

      for (LocalDate date = initDate; date.isAfter(endDate) == false; date = date.plusDays(1)) {
        if (initMonth != date.getMonthValue()) {
          if (sheets.get(date.getMonthValue() - initDate.getMonthValue()).getRow(rowCount) == null) {
            dateCellCount = 4;
            if (date.getMonthValue() == endDate.getMonthValue())
              dateCount = LocalDate.of(date.getYear(), date.getMonthValue(), endDate.getDayOfMonth());
            else
              dateCount = LocalDate.of(date.getYear(), date.getMonthValue(), date.lengthOfMonth());

            headerLower = sheets.get(date.getMonthValue() - initDate.getMonthValue()).createRow(0);
            totalRow = sheets.get(date.getMonthValue() - initDate.getMonthValue()).getRow(absences.size() + 2);
            cellName = headerLower.createCell(0);
            cellName.setCellValue("Name");
            cellLab = headerLower.createCell(1);
            cellLab.setCellValue("Labor");
            cellAu = headerLower.createCell(2);
            cellAu.setCellValue("Absence");
            cellFes = headerLower.createCell(3);
            cellFes.setCellValue("Festive");
            countAusencia = countAusenciasOFestivosMonth(date.getMonthValue(), true, entry.getValue());
            countFestivos = countAusenciasOFestivosMonth(date.getMonthValue(), false, entry.getValue());
            countLaborales = (countBusinessDaysBetween(date, dateCount, Optional.empty()) + 1)
                - (countFestivos + countAusencia);
            cellLab = totalRow.getCell(1);
            cellLab.setCellValue(countLaborales + cellLab.getNumericCellValue());
            cellAu = totalRow.getCell(2);
            cellAu.setCellValue(countAusencia + cellAu.getNumericCellValue());
            cellFes = totalRow.getCell(3);
            cellFes.setCellValue(countFestivos + cellFes.getNumericCellValue());

            absencesRowMonth = sheets.get(date.getMonthValue() - initDate.getMonthValue()).createRow(rowCount);
            cellName = absencesRowMonth.createCell(0);
            cellName.setCellValue(entry.getKey());
            cellLab = absencesRowMonth.createCell(1);
            cellLab.setCellValue(countLaborales);
            cellAu = absencesRowMonth.createCell(2);
            cellAu.setCellValue(countAusencia);
            cellFes = absencesRowMonth.createCell(3);
            cellFes.setCellValue(countFestivos);
            sheets.get(date.getMonthValue() - initDate.getMonthValue()).autoSizeColumn(0);
          } else {
            sheets.get(date.getMonthValue() - initDate.getMonthValue()).autoSizeColumn(5);
            absencesRowMonth = sheets.get(date.getMonthValue() - initDate.getMonthValue()).getRow(rowCount);
          }
        }
        org.apache.poi.ss.usermodel.Cell cellDay = headerLower.createCell(dateCellCount);
        cellDay.setCellValue(date.getDayOfMonth());
        org.apache.poi.ss.usermodel.Cell dateCell = absencesRowMonth.createCell(dateCellCount);
        String typeDay = typeOfDay(date, entry.getValue());

        switch (typeDay) {
          case "A":
            dateCell.setCellStyle(headerCellStyleAusencia);
            break;
          case "P":
            dateCell.setCellStyle(headerCellStyleAusencia);
            break;
          case "F":
            dateCell.setCellStyle(headerCellStyleFestivo);
            break;
          case "W":
            dateCell.setCellStyle(headerCellStyleWeekend);
            break;
          default:
            // code block
        }
        dateCellCount++;

      }
      headerLower.setRowStyle(headerCellStyle);
      rowCount++;

    }
  }

  /**
   * @param absences
   * @param initDate
   * @param endDate
   * @param sheet
   * @param headerCellStyleAusencia
   * @param headerCellStyleFestivo
   * @param headerCellStyleWeekend
   */
  private void generateRowsOneTab(Map<String, List<ForecastDto>> absences, LocalDate initDate, LocalDate endDate,
      XSSFWorkbook workbook, XSSFCellStyle headerCellStyleAusencia, XSSFCellStyle headerCellStyleFestivo,
      XSSFCellStyle headerCellStyleWeekend, XSSFSheet sheet) {

    int rowCount = 2;
    Row totalRow = sheet.createRow(absences.size() + 2);
    org.apache.poi.ss.usermodel.Cell cellTotalName = totalRow.createCell(0);
    cellTotalName.setCellValue("Total");
    org.apache.poi.ss.usermodel.Cell cellTotalLab = totalRow.createCell(1);
    cellTotalLab.setCellValue(0);
    org.apache.poi.ss.usermodel.Cell cellTotalAu = totalRow.createCell(2);
    cellTotalAu.setCellValue(0);
    org.apache.poi.ss.usermodel.Cell cellTotalFes = totalRow.createCell(3);
    cellTotalFes.setCellValue(0);
    for (Map.Entry<String, List<ForecastDto>> entry : absences.entrySet()) {
      int dateCellCount = 4;
      Row absencesRow = sheet.createRow(rowCount);
      long countAusencia = countAusenciasOFestivos(true, entry.getValue());
      long countFestivos = countAusenciasOFestivos(false, entry.getValue());
      long countLaborales = (countBusinessDaysBetween(initDate, endDate, Optional.empty()) - 1)
          - (countAusencia - countFestivos);
      org.apache.poi.ss.usermodel.Cell cellName = absencesRow.createCell(0);
      cellName.setCellValue(entry.getKey());
      org.apache.poi.ss.usermodel.Cell cellLab = absencesRow.createCell(1);
      cellLab.setCellValue(countLaborales);
      org.apache.poi.ss.usermodel.Cell cellAu = absencesRow.createCell(2);
      cellAu.setCellValue(countAusencia);
      org.apache.poi.ss.usermodel.Cell cellFes = absencesRow.createCell(3);
      cellFes.setCellValue(countFestivos);
      totalRow = sheet.getRow(absences.size() + 2);

      cellTotalLab.setCellValue(countLaborales + cellTotalLab.getNumericCellValue());
      cellTotalAu.setCellValue(countAusencia + cellTotalAu.getNumericCellValue());
      cellTotalFes.setCellValue(countFestivos + cellTotalFes.getNumericCellValue());
      for (LocalDate date = initDate; date.isAfter(endDate) == false; date = date.plusDays(1)) {
        org.apache.poi.ss.usermodel.Cell dateCell = absencesRow.createCell(dateCellCount);
        String typeDay = typeOfDay(date, entry.getValue());
        switch (typeDay) {
          case "A":
            dateCell.setCellStyle(headerCellStyleAusencia);
            break;
          case "P":
            dateCell.setCellStyle(headerCellStyleAusencia);
            break;
          case "F":
            dateCell.setCellStyle(headerCellStyleFestivo);
            break;
          case "W":
            dateCell.setCellStyle(headerCellStyleWeekend);
            break;
          default:
            // code block
        }
        dateCellCount++;

      }
      rowCount++;

    }
    sheet.autoSizeColumn(0);
  }

  private String typeOfDay(LocalDate date, List<ForecastDto> absences) {

    DayOfWeek d = date.getDayOfWeek();
    if (d == DayOfWeek.SATURDAY || d == DayOfWeek.SUNDAY)
      return "W";
    for (ForecastDto absence : absences) {
      LocalDate datAbsence = absence.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
      if (datAbsence.equals(date)) {
        return absence.getType();
      }
    }
    return "L";
  }

  /**
   * @param months
   * @param monthsDays
   * @param initDate
   * @param endDate
   * @param initMonth
   * @param merges
   * @param workbook
   * @param sheet
   */
  private void createHeaders(List<String> months, Integer[] monthsDays, LocalDate initDate, LocalDate endDate,
      Integer initMonth, Integer merges, XSSFWorkbook workbook, XSSFSheet sheet) {

    List<String> headersUpper = new ArrayList<String>();
    headersUpper.add("Info");
    List<String> headersLower = new ArrayList<String>();
    headersLower.add("Nombre");
    headersLower.add("Laborales");
    headersLower.add("Festivos");
    headersLower.add("Ausencias");

    XSSFFont headerFont = workbook.createFont();
    headerFont.setBold(true);

    // Create a CellStyle with the font
    CellStyle headerCellStyle = workbook.createCellStyle();
    headerCellStyle.setFont(headerFont);

    Row headerRowUpper = sheet.createRow(0);
    Row headerRow = sheet.createRow(1);
    monthsDays[initMonth] = initDate.lengthOfMonth() - initDate.getDayOfMonth();
    headersUpper.add(months.get(initDate.getMonthValue() - 1));

    for (LocalDate date = initDate; date.isAfter(endDate) == false; date = date.plusDays(1)) {
      if ((initMonth != date.getMonthValue()) && (endDate.getMonthValue() != date.getMonthValue())) {
        initMonth = date.getMonthValue();
        headersUpper.add(months.get(date.getMonthValue() - 1));
        monthsDays[initMonth] = date.lengthOfMonth();
      }
      headersLower.add(String.valueOf(date.getDayOfMonth()));
    }
    if (initDate.getMonthValue() != endDate.getMonthValue()) {
      monthsDays[endDate.getMonthValue()] = initDate.getDayOfMonth();
      headersUpper.add(months.get(endDate.getMonthValue() - 1));
    }
    sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
    org.apache.poi.ss.usermodel.Cell cell = headerRowUpper.createCell(0);
    cell.setCellStyle(headerCellStyle);
    cell.setCellValue(headersUpper.get(0));
    for (int i = 0; i < headersUpper.size(); i++) {
      int index = 0;
      if (!headersUpper.get(i).equals("Info"))
        index = months.indexOf(headersUpper.get(i)) + 1;
      cell = headerRowUpper.createCell(merges + 1);

      /*
       * if (initDate.getMonthValue() == index || index == 0) sheet.addMergedRegion(new CellRangeAddress(0, 0, (merges),
       * monthsDays[index] + merges)); else sheet.addMergedRegion(new CellRangeAddress(0, 0, (merges - 1),
       * monthsDays[index] + (merges - 1))); merges++;
       */
      if (i >= 1)
        cell.setCellValue(headersUpper.get(i));
      cell.setCellStyle(headerCellStyle);

      merges += (monthsDays[index]);
    }
    for (int i = 0; i < headersLower.size(); i++) {
      cell = headerRow.createCell(i);
      cell.setCellType(CellType.NUMERIC);
      if (i > 3)
        cell.setCellValue(Integer.parseInt(headersLower.get(i)));
      else
        cell.setCellValue(headersLower.get(i));
      cell.setCellStyle(headerCellStyle);
      sheet.autoSizeColumn(i);
    }
  }

  private List<ForecastDto> extractAbsencesFromList(Integer integer, List<PersonAbsenceEntity> absenceList) {

    List<ForecastDto> listAbsence = new ArrayList<>();
    Map<Date, ForecastDto> mapAbsences = new HashMap<>();
    for (PersonAbsenceEntity absence : absenceList) {

      if (integer.equals(absence.getPerson().getId()) == false)
        continue;

      int weekDay = absence.getDate().getDay();

      if (weekDay == 0 || weekDay == 6)
        continue;

      String absenceType = absence.getType();
      ForecastDto absenceDto = mapAbsences.get(absence.getDate());
      if (absenceDto == null) {
        absenceDto = new ForecastDto();
        absenceDto.setDate(absence.getDate());
        absenceDto.setMonth(absence.getMonth());
        absenceDto.setYear(absence.getYear());
        absenceDto.setType(absenceType);

        listAbsence.add(absenceDto);
        mapAbsences.put(absence.getDate(), absenceDto);
      }

      String absenceDtoType = absenceDto.getType();

      if (absenceType.equals("F")) {
        absenceDto.setType(absenceType);
      } //
      else if (absenceType.equals("P") || absenceType.equals("A")) {
        if (absenceDtoType.equals("P") || absenceDtoType.equals("A")) {
          absenceDto.setType(absenceType);
        }
      }

    }

    return listAbsence;
  }

  private long countBusinessDaysBetween(LocalDate startDate, LocalDate endDate, Optional<List<LocalDate>> holidays) {

    if (startDate == null || endDate == null || holidays == null) {
      throw new IllegalArgumentException(
          "Invalid method argument(s) to countBusinessDaysBetween(" + startDate + "," + endDate + "," + holidays + ")");
    }

    Predicate<LocalDate> isHoliday = date -> holidays.isPresent() ? holidays.get().contains(date) : false;

    Predicate<LocalDate> isWeekend = date -> date.getDayOfWeek() == DayOfWeek.SATURDAY
        || date.getDayOfWeek() == DayOfWeek.SUNDAY;

    long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

    long businessDays = Stream.iterate(startDate, date -> date.plusDays(1)).limit(daysBetween)
        .filter(isHoliday.or(isWeekend).negate()).count();
    return businessDays;
  }

  /**
   * @param groupId
   */
  private List<Integer> extractListPersonId(List<PersonEntity> groupMembersList) {

    List<Integer> personIds = new ArrayList<>();

    for (PersonEntity groupMember : groupMembersList) {
      personIds.add(groupMember.getId());
    }

    return personIds;
  }
}
