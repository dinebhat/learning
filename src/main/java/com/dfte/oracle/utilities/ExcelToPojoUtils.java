package com.dfte.oracle.utilities;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Service;

/**
 * @author dinebhat
 *
 */
@Service
public class ExcelToPojoUtils {

	public static final String BOOLEAN_TRUE = "1";
	public static final String LIST_SEPARATOR = ",";

	/**
	 * @param str
	 * @return
	 */
	private static String strToFieldName(String str) {
		str = str.replaceAll("[^a-zA-Z0-9]", "");
		return str.length() > 0 ? str.substring(0, 1).toLowerCase() + str.substring(1) : null;
	}

	/**
	 * @param <T>
	 * @param type : Type of class 
	 * @param sheet : Sheet number to read
	 * @param rowsToBeSkipped : If we want to skip row (excluding headings, headings always needed). It can be notes, informations etc
	 * @param headerRow : Header row number. Most cases its '0' (1st row)
	 * @return
	 * @throws Exception
	 * 
	 * Sample Calling of the method :  List<SodRules> pojos  = e.toPojo(SodRules.class, workbook.getSheetAt(0), tobeSkipped_SODRULE, 0);
	 */
	public static <T> List<T> toPojo(Class<T> type, Sheet sheet, String[] rowsToBeSkipped, int headerRow)
			throws Exception {
		List<T> results = new ArrayList<>();

		// header column names
		List<String> colNames = new ArrayList();
		Row headerRows = sheet.getRow(headerRow);
		for (int i = 0; i < headerRows.getPhysicalNumberOfCells(); i++) {
			Cell headerCell = headerRows.getCell(i, Row.RETURN_BLANK_AS_NULL);
			colNames.add(headerCell != null ? strToFieldName(headerCell.getStringCellValue()) : null);
		}

		System.out.println(" colNames in your sheet: " + colNames);

		for (int j = 1; j < sheet.getPhysicalNumberOfRows(); j++) {
			Row row = sheet.getRow(j);
			try {
				T result = type.getDeclaredConstructor().newInstance();
				boolean skipRows = false;
				for (int k = 0; k < row.getPhysicalNumberOfCells(); k++) {
					if (colNames.get(k) != null) {
						Cell cell = row.getCell(k, Row.RETURN_BLANK_AS_NULL);
						if (cell != null) {
							DataFormatter formatter = new DataFormatter();
							String strValue = formatter.formatCellValue(cell);
							Field field = type.getDeclaredField(colNames.get(k));
							field.setAccessible(true);
							if (field != null) {
								Object value = null;
								if (field.getType().equals(Long.class)) {
									value = Long.valueOf(strValue);
								} else if (field.getType().equals(String.class)) {
									value = cell.getStringCellValue();
								} else if (field.getType().equals(Integer.class)) {
									value = Integer.valueOf(strValue);
								} else if (field.getType().equals(LocalDate.class)) {
									value = LocalDate.parse(strValue);
								} else if (field.getType().equals(LocalDateTime.class)) {
									value = LocalDateTime.parse(strValue);
								} else if (field.getType().equals(Boolean.class)) {
									value = BOOLEAN_TRUE.equals(strValue);
								} else if (field.getType().equals(BigDecimal.class)) {
									value = new BigDecimal(strValue);
								} else if (field.getType().equals(List.class)) {
									value = Arrays.asList(strValue.trim().split("\\s*" + LIST_SEPARATOR + "\\s*"));
								}

								if (Arrays.asList(rowsToBeSkipped).contains(value)) {
									// complete row to be skipped.
									skipRows = true;
								}

								if (!skipRows) { // Do not set for skipped rows
									field.set(result, value);
								}
							}
						}
					}
				}
				if (!skipRows) {// Do not add an empty objects
					results.add(result);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return results;
	}
}
