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
        List<PersonAbsenceEntity> absenceList =
                this.personAbsenceRepository.findByPerson_IdInAndDateBetween(personIds, init, end);

        SortedMap<String, List<ForecastDto>> hashAbsence = new TreeMap<>();

        for (PersonEntity member : groupMembersList) {

            String key = member.getLastname() + ", " + member.getName();

            hashAbsence.put(key, extractAbsencesFromList(member.getId(), absenceList));
        }

        return hashAbsence;
    }

    @Override
    public File exportForecast(Long groupId, Date init, Date end, int type) {

        List<String> months = Arrays.asList(new String[] { "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December" });
        Integer[] monthsDays = { 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        Map<String, List<ForecastDto>> absences = getGroupAbsenceByDate(groupId, init, end);
        LocalDate initDate = init.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endDate = end.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Integer initMonth = initDate.getMonthValue();
        Integer merges = 0;

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
        } else {

            int actualMonth = initMonth;
            int actualYear = initDate.getYear();

            int endMonth = endDate.getMonthValue();
            int endYear = endDate.getYear();

            boolean complete = false;

            do {

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

                generateRowsOneTab(absences, partialInitDate, partialEndDate, workbook, headerCellStyleAusencia,
                        headerCellStyleFestivo, headerCellStyleWeekend, sheet);

                if (actualYear == endYear && actualMonth == endMonth)
                    complete = true;

                actualMonth++;
                if (actualMonth > 12) {
                    actualMonth = 1;
                    actualYear++;
                }

            } while (complete == false);
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

    /**
     * @param absences
     * @param headerCellStyleAusencia
     * @param headerCellStyleFestivo
     * @param headerCellStyleWeekend
     * @param sheet
     */
    private void headerCaptionColor(Map<String, List<ForecastDto>> absences, XSSFCellStyle headerCellStyleAusencia,
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
        headerCaptionColor(absences, headerCellStyleAusencia, headerCellStyleFestivo, headerCellStyleWeekend, sheet);
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
        //sheet.autoSizeColumn(0);
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

        //sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
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

            sheet.addMergedRegion(new CellRangeAddress(0, 0, initCol, endCol));

            accumulatedPosition += actualDays + 1;
        }

        /*
        for (int i = 0; i < headersUpper.size(); i++) {
            int index = 0;
            if (!headersUpper.get(i).equals("Detail"))
                index = months.indexOf(headersUpper.get(i)) + 1;
        
            cell = headerRowUpper.createCell(merges + 1);
        
            if (i >= 1)
                cell.setCellValue(headersUpper.get(i));
            cell.setCellStyle(headerCellStyle);
        
            merges += (monthsDays[index]);
        }
        */

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
            throw new IllegalArgumentException("Invalid method argument(s) to countBusinessDaysBetween(" + startDate
                    + "," + endDate + "," + holidays + ")");
        }

        Predicate<LocalDate> isHoliday = date -> holidays.isPresent() ? holidays.get().contains(date) : false;

        Predicate<LocalDate> isWeekend =
                date -> date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;

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
}
