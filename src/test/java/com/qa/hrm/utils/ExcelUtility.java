package com.qa.hrm.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Reads Excel (.xlsx) files into a List of Maps for data-driven Cucumber
 * scenarios. Row 0 is treated as the header (keys); every subsequent row is
 * one test data set.
 */
public class ExcelUtility {

	private static Workbook book;
	private static Sheet sheet;

	private static void open(String path) {
		try (FileInputStream fis = new FileInputStream(path)) {
			book = new XSSFWorkbook(fis);
		} catch (IOException e) { e.printStackTrace(); }
	}

	private static void loadSheet(String name) { sheet = book.getSheet(name); }
	private static int rows() { return sheet.getPhysicalNumberOfRows(); }
	private static int cols(int r) { return sheet.getRow(r).getLastCellNum(); }
	private static String cell(int r, int c) { return sheet.getRow(r).getCell(c).toString(); }

	/**
	 * Returns the entire sheet as a List&lt;Map&gt; — each map is one row keyed by
	 * column header.
	 */
	public static List<Map<String, String>> sheetToList(String filePath, String sheetName) {
		open(filePath);
		loadSheet(sheetName);
		List<Map<String, String>> list = new ArrayList<>();
		for (int r = 1; r < rows(); r++) {
			Map<String, String> row = new LinkedHashMap<>();
			for (int c = 0; c < cols(r); c++) {
				row.put(cell(0, c), cell(r, c));
			}
			list.add(row);
		}
		return list;
	}

}
