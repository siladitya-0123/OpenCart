package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	String path;

	public ExcelUtils(String path) {
		this.path = path;
	}

	public int getrowcount(String sheetName) throws IOException {

		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		int rowcount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;

	}

	public int getcellcount(String sheetName, int rownum) throws IOException {

		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;

	}

	public String getcelldata(String sheetName, int rownum, int column) throws IOException {

		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rownum);
		cell = row.getCell(column);
		String celldata;

		try {
			DataFormatter formatter = new DataFormatter();
			celldata = formatter.formatCellValue(cell);
		} catch (Exception e) {
			celldata = "";
		}

		wb.close();
		fi.close();
		return celldata;

	}

	public void setcelldata(String sheetName, int rownum, int column, String data) throws IOException {
		File xlFile = new File(path);
		if (!xlFile.exists()) { //if file not exist then create new file
			wb = new XSSFWorkbook();
			fo = new FileOutputStream(path);
			wb.write(fo);
		}
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		if (wb.getSheetIndex(sheetName) == -1)  //if sheet not exist then create new sheet
			wb.createSheet(sheetName);
		ws = wb.getSheet(sheetName);
		if (ws.getRow(rownum) == null)  //if row not exist then create new row
			ws.createRow(rownum);
		row = ws.getRow(rownum);
		cell = row.createCell(column);
		cell.setCellValue(data);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();

	}

	public void filledGreencolor(String sheetName, int rownum, int column) throws IOException {

		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rownum);
		cell = row.createCell(column);
		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		fo = new FileOutputStream(path);

		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();

	}

	public void filledRedcolor(String sheetName, int rownum, int column) throws IOException {

		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rownum);
		cell = row.createCell(column);
		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		fo = new FileOutputStream(path);

		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();

	}
}