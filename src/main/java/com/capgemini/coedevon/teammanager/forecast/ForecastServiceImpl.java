package com.capgemini.coedevon.teammanager.forecast;

import java.io.File;
import java.io.FileOutputStream;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.coedevon.teammanager.config.security.UserUtils;
import com.capgemini.coedevon.teammanager.forecast.model.ForecastDetailDto;
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

  private static final Logger LOG = LoggerFactory.getLogger(ForecastServiceImpl.class);

  @Autowired
  PersonAbsenceRepository personAbsenceRepository;

  @Autowired
  PersonRepository personRepository;

  private String getUserGrade() {

    String username = UserUtils.getUserDetails().getUsername();
    PersonEntity personUser = this.personRepository.findByUsernameAndActiveTrue(username);

    return normalizePersonGrade(personUser);
  }

  private String normalizePersonGrade(PersonEntity person) {

    if (person == null || person.getGrade() == null || person.getGrade().trim().length() == 0)
      return "A";

    return person.getGrade();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Map<String, ForecastDetailDto> getGroupAbsenceByDate(Long groupId, Date init, Date end) {

    String userGrade = getUserGrade();
    List<PersonEntity> groupMembersList = this.personRepository.findPersonByGroupId(groupId);

    List<Integer> personIds = extractListPersonId(groupMembersList);
    List<PersonAbsenceEntity> absenceList = this.personAbsenceRepository.findByPerson_IdInAndDateBetween(personIds,
        init, end);

    SortedMap<String, ForecastDetailDto> hashAbsence = new TreeMap<>();

    for (PersonEntity member : groupMembersList) {
      ForecastDetailDto absence = new ForecastDetailDto();
      String key = member.getName() + ", " + member.getLastname();
      List<ForecastDto> forecastList = new ArrayList<>();
      absence.setVisible(isVisibleByGrade(userGrade, member));

      if (absence.isVisible())
        absence.setAbsences(extractAbsencesFromList(member.getId(), absenceList));
      else
        absence.setAbsences(forecastList);
      hashAbsence.put(key, absence);
    }

    return hashAbsence;
  }

  private boolean isVisibleByGrade(String userGrade, PersonEntity person) {

    String personGrade = normalizePersonGrade(person);

    if (personGrade.equals("E") || personGrade.equals("F")) {
      return userGrade.compareTo(personGrade) >= 0;
    }

    return true;
  }

  @Override
  public File exportForecast(Long groupId, Date init, Date end, int type) {

    List<String> months = Arrays.asList(new String[] { "January", "February", "March", "April", "May", "June", "July",
    "August", "September", "October", "November", "December" });
    List<String> partialMonths = new ArrayList();
    Integer[] monthsDays = { 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    Map<String, ForecastDetailDto> absences = getGroupAbsenceByDate(groupId, init, end);
    LocalDate initDate = init.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    LocalDate endDate = end.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    Integer initMonth = initDate.getMonthValue();
    Integer merges = 0;

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFCellStyle headerCellStyle = workbook.createCellStyle();
    headerCellStyle.setAlignment(HorizontalAlignment.CENTER);

    XSSFCellStyle headerCellStyleAusencia = workbook.createCellStyle();
    headerCellStyleAusencia.setFillForegroundColor(new XSSFColor(new java.awt.Color(255, 255, 170)));
    headerCellStyleAusencia.setFillPattern(FillPatternType.SOLID_FOREGROUND);

    XSSFCellStyle headerCellStyleFestivo = workbook.createCellStyle();
    headerCellStyleFestivo.setFillForegroundColor(new XSSFColor(new java.awt.Color(170, 227, 255)));
    headerCellStyleFestivo.setFillPattern(FillPatternType.SOLID_FOREGROUND);

    XSSFCellStyle headerCellStyleWeekend = workbook.createCellStyle();
    headerCellStyleWeekend.setFillForegroundColor(new XSSFColor(new java.awt.Color(218, 218, 218)));
    headerCellStyleWeekend.setFillPattern(FillPatternType.SOLID_FOREGROUND);

    if (type == 2) {
      XSSFSheet sheet = workbook.createSheet("Forecast Detail");
      createHeaders(months, monthsDays, initDate, endDate, initMonth, merges, workbook, sheet);
      generateRowsOneTab(absences, initDate, endDate, workbook, headerCellStyleAusencia, headerCellStyleFestivo,
          headerCellStyleWeekend, sheet);
    } else {

      int actualMonth = initMonth;
      int actualYear = initDate.getYear();
      XSSFSheet sheetTotal = workbook.createSheet("Forecast Detail");
      Map<String, List<Integer>> totals = new HashMap<String, List<Integer>>();
      for (Map.Entry<String, ForecastDetailDto> entry : absences.entrySet()) {
        List<Integer> myList = new ArrayList();
        totals.put(entry.getKey(), myList);
      }
      int endMonth = endDate.getMonthValue();
      int endYear = endDate.getYear();

      boolean complete = false;

      do {
        Map<String, List<Integer>> partialTotals = new HashMap<String, List<Integer>>();
        String tabName = months.get(actualMonth - 1) + " " + actualYear;

        LocalDate partialInitDate = null;

        if (actualMonth == initMonth && actualYear == initDate.getYear()) {
          partialInitDate = initDate;
        } else {
          partialInitDate = LocalDate.of(actualYear, actualMonth, 1);
        }

        LocalDate partialEndDate = null;

        if (actualMonth == endMonth && actualYear == endYear) {
          partialEndDate = endDate;
        } else {
          partialEndDate = LocalDate.of(actualYear, actualMonth, 1);
          partialEndDate = partialEndDate.with(TemporalAdjusters.lastDayOfMonth());
        }

        XSSFSheet sheet = workbook.createSheet(tabName);
        createHeaders(months, monthsDays, partialInitDate, partialEndDate, actualMonth, 0, workbook, sheet);

        partialTotals = generateRowsOneTab(absences, partialInitDate, partialEndDate, workbook, headerCellStyleAusencia,
            headerCellStyleFestivo, headerCellStyleWeekend, sheet);

        for (Map.Entry<String, List<Integer>> entry : totals.entrySet()) {
          entry.getValue().addAll(partialTotals.get(entry.getKey()));
        }

        if (actualYear == endYear && actualMonth == endMonth)
          complete = true;
        partialMonths.add(months.get(actualMonth - 1));
        actualMonth++;
        if (actualMonth > 12) {
          actualMonth = 1;
          actualYear++;
        }

      } while (complete == false);
      summarySheet(sheetTotal, totals, partialMonths, workbook);
    }

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

  private void summarySheet(XSSFSheet sheet, Map<String, List<Integer>> totals, List<String> months,
      XSSFWorkbook workbook) {

    int headerLoop = 1;
    int valuesCellLoop = 1;
    int valuesLoopRow = 2;
    int summsTotal[] = new int[(months.size() * 3) + 3];

    CellStyle style = workbook.createCellStyle();// Create style
    Font font = workbook.createFont();// Create font
    font.setBold(true);// Make font bold
    style.setFont(font);// set it to bold
    style.setAlignment(HorizontalAlignment.CENTER);
    Row upperHeaderRow = sheet.createRow(0);
    Row headerRow = sheet.createRow(1);
    org.apache.poi.ss.usermodel.Cell cell = headerRow.createCell(0);
    cell.setCellValue("Name");
    for (int j = 0; j < 3; j++) {
      for (int i = 0; i < months.size(); i++) {
        cell = headerRow.createCell(headerLoop);
        cell.setCellValue(months.get(i));
        headerLoop++;
      }
      cell = headerRow.createCell(headerLoop);
      cell.setCellValue("Total");
      headerLoop++;
    }

    for (Map.Entry<String, List<Integer>> entry : totals.entrySet()) {
      int summs[] = new int[3];
      Row valuesRow = sheet.createRow(valuesLoopRow);
      cell = valuesRow.createCell(0);
      cell.setCellValue(entry.getKey());
      int loop = 0;
      int upperLoop = 0;
      for (int i = 0; i < entry.getValue().size(); i++) {
        if (loop < 3) {
          cell = valuesRow.createCell((months.size() * loop) + 1 + upperLoop + loop);
          cell.setCellValue(entry.getValue().get(i));
          summsTotal[(months.size() * loop) + upperLoop + loop] += entry.getValue().get(i);
          summs[loop] += entry.getValue().get(i);
          if (loop == 2) {
            upperLoop++;
            loop = 0;
          } else
            loop++;
        }

      }
      cell = valuesRow.createCell((months.size() * 1) + 1);
      cell.setCellValue(summs[0]);
      summsTotal[(months.size() * 1)] += summs[0];
      cell = valuesRow.createCell((months.size() * 2) + 2);
      cell.setCellValue(summs[1]);
      summsTotal[(months.size() * 2) + 1] += summs[1];
      cell = valuesRow.createCell((months.size() * 3) + 3);
      cell.setCellValue(summs[2]);
      summsTotal[(months.size() * 3) + 2] += summs[2];
      valuesLoopRow++;
    }
    cell = upperHeaderRow.createCell(1);
    cell.setCellValue("Working Days");
    sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, (months.size() + 1)));
    cell.setCellStyle(style);
    cell = upperHeaderRow.createCell((months.size() + 2));
    cell.setCellValue("Festives");
    sheet.addMergedRegion(new CellRangeAddress(0, 0, (months.size() + 2), ((months.size() * 2) + 2)));
    cell.setCellStyle(style);
    cell = upperHeaderRow.createCell((months.size() * 2) + 3);
    cell.setCellValue("Inactivities");
    sheet.addMergedRegion(new CellRangeAddress(0, 0, (months.size() * 2) + 3, (months.size() * 3) + 3));
    cell.setCellStyle(style);
    Row totalsRow = sheet.createRow(totals.size() + 2);
    for (int i = 0; i < summsTotal.length; i++) {
      cell = totalsRow.createCell(i + 1);
      cell.setCellValue(summsTotal[i]);
    }
    sheet.autoSizeColumn(0);
  }

  /**
   * @param absences
   * @param headerCellStyleAusencia
   * @param headerCellStyleFestivo
   * @param headerCellStyleWeekend
   * @param sheet
   */
  private void headerCaptionColor(Map<String, ForecastDetailDto> absences, XSSFCellStyle headerCellStyleAusencia,
      XSSFCellStyle headerCellStyleFestivo, XSSFCellStyle headerCellStyleWeekend, XSSFSheet sheet) {

    org.apache.poi.ss.usermodel.Cell cellName;
    Row leyendaRow = sheet.createRow(absences.size() + 4);
    cellName = leyendaRow.createCell(0);
    cellName = leyendaRow.createCell(1);
    cellName.setCellValue("Weekend");
    cellName = leyendaRow.createCell(2);
    cellName.setCellValue("Inactivity");
    cellName = leyendaRow.createCell(3);
    cellName.setCellValue("Festive");

    Row leyendaRowColor = sheet.createRow(absences.size() + 5);
    cellName = leyendaRowColor.createCell(0);
    cellName = leyendaRowColor.createCell(1);
    cellName.setCellStyle(headerCellStyleWeekend);
    cellName = leyendaRowColor.createCell(2);
    cellName.setCellStyle(headerCellStyleAusencia);
    cellName = leyendaRowColor.createCell(3);
    cellName.setCellStyle(headerCellStyleFestivo);
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
  private Map<String, List<Integer>> generateRowsOneTab(Map<String, ForecastDetailDto> absences, LocalDate initDate,
      LocalDate endDate, XSSFWorkbook workbook, XSSFCellStyle headerCellStyleAusencia,
      XSSFCellStyle headerCellStyleFestivo, XSSFCellStyle headerCellStyleWeekend, XSSFSheet sheet) {

    XSSFFont headerFont = workbook.createFont();
    headerFont.setBold(true);

    // Create a CellStyle with the font
    CellStyle totalCellStyle = workbook.createCellStyle();
    totalCellStyle.setFont(headerFont);

    int rowCount = 2;
    Row totalRow = sheet.createRow(absences.size() + 2);
    org.apache.poi.ss.usermodel.Cell cellTotalName = totalRow.createCell(0);
    cellTotalName.setCellValue("Total");
    org.apache.poi.ss.usermodel.Cell cellTotalLab = totalRow.createCell(1);
    cellTotalLab.setCellValue(0);
    org.apache.poi.ss.usermodel.Cell cellTotalFes = totalRow.createCell(2);
    cellTotalFes.setCellValue(0);
    org.apache.poi.ss.usermodel.Cell cellTotalAu = totalRow.createCell(3);
    cellTotalAu.setCellValue(0);

    cellTotalName.setCellStyle(totalCellStyle);
    cellTotalLab.setCellStyle(totalCellStyle);
    cellTotalFes.setCellStyle(totalCellStyle);
    cellTotalAu.setCellStyle(totalCellStyle);
    Map<String, List<Integer>> partialTotal = new HashMap<String, List<Integer>>();

    headerCaptionColor(absences, headerCellStyleAusencia, headerCellStyleFestivo, headerCellStyleWeekend, sheet);
    for (Map.Entry<String, ForecastDetailDto> entry : absences.entrySet()) {
      int dateCellCount = 4;
      Row absencesRow = sheet.createRow(rowCount);
      long countAusencia = countAusenciasOFestivos(true, entry.getValue().getAbsences(), initDate, endDate);
      long countFestivos = countAusenciasOFestivos(false, entry.getValue().getAbsences(), initDate, endDate);
      long countLaborales = (countBusinessDaysBetween(initDate, endDate, Optional.empty()))
          - (countAusencia + countFestivos);
      org.apache.poi.ss.usermodel.Cell cellName = absencesRow.createCell(0);
      cellName.setCellValue(entry.getKey());
      org.apache.poi.ss.usermodel.Cell cellLab = absencesRow.createCell(1);
      cellLab.setCellValue(countLaborales);
      org.apache.poi.ss.usermodel.Cell cellFes = absencesRow.createCell(2);
      cellFes.setCellValue(countFestivos);
      org.apache.poi.ss.usermodel.Cell cellAu = absencesRow.createCell(3);
      cellAu.setCellValue(countAusencia);
      totalRow = sheet.getRow(absences.size() + 2);

      List<Integer> partial = new ArrayList<Integer>();
      partial.add((int) countLaborales);
      partial.add((int) countFestivos);
      partial.add((int) countAusencia);
      partialTotal.put(entry.getKey(), partial);

      XSSFCellStyle headerCellStyleBlocked = workbook.createCellStyle();
      headerCellStyleBlocked.setFillForegroundColor(new XSSFColor(new java.awt.Color(234, 234, 234)));
      headerCellStyleBlocked.setFillPattern(FillPatternType.SOLID_FOREGROUND);

      cellTotalLab.setCellValue(countLaborales + cellTotalLab.getNumericCellValue());
      cellTotalAu.setCellValue(countAusencia + cellTotalAu.getNumericCellValue());
      cellTotalFes.setCellValue(countFestivos + cellTotalFes.getNumericCellValue());

      for (LocalDate date = initDate; date.isAfter(endDate) == false; date = date.plusDays(1)) {
        org.apache.poi.ss.usermodel.Cell dateCell = absencesRow.createCell(dateCellCount);
        String typeDay = typeOfDay(date, entry.getValue().getAbsences(), entry.getValue().isVisible());
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
          case "B":
            dateCell.setCellStyle(headerCellStyleBlocked);
            break;
          default:
            // code block
        }
        dateCellCount++;

      }
      rowCount++;

    }
    // dsheet.autoSizeColumn(0);

    return partialTotal;
  }

  private String typeOfDay(LocalDate date, List<ForecastDto> absences, boolean visible) {

    if (!visible)
      return "B";
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
    headersUpper.add("Detail");
    List<String> headersLower = new ArrayList<String>();
    headersLower.add("Name");
    headersLower.add("Working Days");
    headersLower.add("Festives");
    headersLower.add("Inactivities");

    XSSFFont headerFont = workbook.createFont();
    headerFont.setBold(true);

    // Create a CellStyle with the font
    CellStyle headerCellStyle = workbook.createCellStyle();
    headerCellStyle.setFont(headerFont);
    headerCellStyle.setAlignment(HorizontalAlignment.CENTER);

    Row headerRowUpper = sheet.createRow(0);
    Row headerRow = sheet.createRow(1);

    monthsDays[initMonth] = initDate.lengthOfMonth() - initDate.getDayOfMonth();
    if (initDate.getMonthValue() == endDate.getMonthValue()) {
      monthsDays[initMonth] = endDate.getDayOfMonth() - initDate.getDayOfMonth();
    }

    headersUpper.add(months.get(initDate.getMonthValue() - 1));

    int month = initMonth;
    for (LocalDate date = initDate; date.isAfter(endDate) == false; date = date.plusDays(1)) {
      if ((month != date.getMonthValue()) && (endDate.getMonthValue() != date.getMonthValue())) {
        month = date.getMonthValue();
        headersUpper.add(months.get(date.getMonthValue() - 1));
        monthsDays[month] = date.lengthOfMonth() - 1;
      }
      headersLower.add(String.valueOf(date.getDayOfMonth()));
    }

    if (initDate.getMonthValue() != endDate.getMonthValue()) {
      monthsDays[endDate.getMonthValue()] = endDate.getDayOfMonth() - 1;
      headersUpper.add(months.get(endDate.getMonthValue() - 1));
    }

    org.apache.poi.ss.usermodel.Cell cell;
    int accumulatedPosition = 0;

    for (int i = 0; i < headersUpper.size(); i++) {

      int actualDays = monthsDays[i];

      if (i > 0) {
        actualDays = monthsDays[initMonth + i - 1];
      }

      cell = headerRowUpper.createCell(accumulatedPosition);
      cell.setCellStyle(headerCellStyle);
      cell.setCellValue(headersUpper.get(i));

      int initCol = accumulatedPosition;
      int endCol = accumulatedPosition + actualDays;

      for (int j = initCol + 1; j <= endCol; j++)
        cell = headerRowUpper.createCell(j);

      if (endCol > initCol)
        sheet.addMergedRegion(new CellRangeAddress(0, 0, initCol, endCol));

      accumulatedPosition += actualDays + 1;
    }

    for (int i = 0; i < headersLower.size(); i++) {
      cell = headerRow.createCell(i);
      cell.setCellType(CellType.NUMERIC);
      if (i > 3)
        cell.setCellValue(Integer.parseInt(headersLower.get(i)));
      else
        cell.setCellValue(headersLower.get(i));
      cell.setCellStyle(headerCellStyle);

      if (i >= 4)
        sheet.setColumnWidth(i, 3 * 256);
    }

    sheet.setColumnWidth(0, 50 * 256);
    sheet.setColumnWidth(1, 14 * 256);
    sheet.setColumnWidth(2, 14 * 256);
    sheet.setColumnWidth(3, 15 * 256);

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

    long businessDays = Stream.iterate(startDate, date -> date.plusDays(1)).limit(daysBetween + 1)
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

  private int countAusenciasOFestivos(boolean countAbsences, List<ForecastDto> absences, LocalDate initLocalDate,
      LocalDate endLocalDate) {

    int count = 0;

    Date initDate = Date.from(initLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    Date endDate = Date.from(endLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

    for (ForecastDto absence : absences) {

      if (absence.getDate().before(initDate))
        continue;
      if (absence.getDate().after(endDate))
        continue;

      if (countAbsences) {
        if ((absence.getType().equals("A") || absence.getType().equals("P")))
          count++;
      } else {
        if ((absence.getType().equals("F")))
          count++;

      }
    }
    return count;
  }
}
