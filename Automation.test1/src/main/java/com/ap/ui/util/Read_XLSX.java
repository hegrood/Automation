package com.ap.ui.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_XLSX 
{
public String fileName;
public FileInputStream exel = null;
public FileOutputStream opExel = null;
private XSSFWorkbook  wbk;
private XSSFSheet sht;
List<String> list = new ArrayList<String>();
	
public Read_XLSX(String fileName, String path) 
	{	
		this.fileName=fileName;
		try
		{	
			exel = new FileInputStream(/*System.getProperty("user.dir")+*/path+fileName);
			//FileInputStream exel;
			wbk = new XSSFWorkbook(exel);
			sht = wbk.getSheetAt(0);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public int retrieveNoOfRows(String shtName) 
	{
		int sheetIndex = wbk.getSheetIndex(shtName);
		if(sheetIndex==1)
			return 0;
		else
		{
			sht=wbk.getSheetAt(sheetIndex);
			int rowCount = sht.getLastRowNum()+1;
			return rowCount;
			
		}
	}

	public int retrieveNoOfCols(String shtName) 
	{
		int sheetIndex = wbk.getSheetIndex(shtName);
		if(sheetIndex==1)
			return 0;
		else
		{
			sht=wbk.getSheetAt(sheetIndex);
			int colCount = sht.getRow(0).getLastCellNum()+1;
			return colCount;
			
		}
	}

	public String retrieveToRunFlag(String wsName, String colName, String rowName)
	{
		int sheetIndex = wbk.getSheetIndex(wsName);
		if(sheetIndex== -1)
			return null;
		else
		{
			int rowNum = retrieveNoOfRows(wsName);
			int colNum = retrieveNoOfCols(wsName);
			int rowNumber = -1;
			int colNumber = -1;
			
			XSSFRow Suiterow = sht.getRow(0);
			for(int i=0; i < colNum; i++)
			{
				if (Suiterow.getCell(i).getStringCellValue().equals(colName.trim()))
				{
					
				}
				
			}
			if(colNumber==-1)
			return "";
			
			for(int j=0; j < rowNum; j++)
			{
				XSSFRow Suitecol = sht.getRow(j);
				if(Suitecol.getCell(0).getStringCellValue().equals(rowName.trim()))
				{
					rowNumber = j;
				}
			}
			if(rowNumber==-1)
				return "";
				
			XSSFRow row = sht.getRow(rowNumber);
			XSSFCell cell = row.getCell(colNumber);
			if(cell == null)
				return "";
				
			String value = cellToString(cell);
			return value;
					
				/*for(int j=0; j < rowNum; j++)
				{
					XSSFRow Suitecol = sht.getRow(j);
					if(Suitecol.getCell(0).getStringCellValue().equals(rowName.trim()))
					{
						rowNumber = j;
					}
				}*/
		}
	}
	
	@SuppressWarnings({"deprecation","unused"})
	public List<String> retrieveTestData(String sheetName)
	{
		int sheetIndex = wbk.getSheetIndex(sheetName);
		if (sheetIndex == -1)
			return null;
		else
		{
			int rowNumber = retrieveNoOfRows(sheetName);
			int colNumber = retrieveNoOfCols(sheetName);
			
			for(int i=0; i < rowNumber; i++)
			{
				XSSFRow row = sht.getRow(i);
				for(int j=0;j<colNumber;j++)
					if (row == null)
						list = null;
					else
					{
						XSSFCell cell = row.getCell(j);
						if(cell == null)
							list=null;
						else
						{
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String value = cellToString(cell);
							System.out.println(value);
							list.add(value);
						}
					}
			}
		}
		return list;
	}
	
	@SuppressWarnings({"deprecation","unused"})
	public Object[][] retrieveTestData1(String sheetName) 
	{
		int sheetIndex = wbk.getSheetIndex(sheetName);
		if (sheetIndex == -1)
			return null;
		else
		{
			int rowNumber = retrieveNoOfRows(sheetName);
			int colNumber = retrieveNoOfCols(sheetName);
			
			Object data[][] = new Object[rowNumber -1][colNumber];
			for(int i=0; i < rowNumber; i++)
			{
				XSSFRow row = sht.getRow(i+1);
				for(int j=0;j<colNumber;j++)
					if (row == null)
						data[i][j] = " ";
					else
					{
						XSSFCell cell = row.getCell(j);
						if(cell == null)
							data[i][j] = " ";
						else
						{
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String value = cellToString(cell);
							data[i][j]=value;
						}
					}
			}
			return data;
		}
	}
	
	@SuppressWarnings({"deprecation","unused"})
	public static String cellToString(XSSFCell cell)
	{
		int type;
		Object result;
		type= cell.getCellType();
		switch (type)
		{ 
		case 0:
			result = cell.getNumericCellValue();
			break;
		case 1:
			result = cell.getNumericCellValue();
			break;
		default:
			throw new RuntimeException("Unsupported cell.");
		}
		return result.toString();
	}

}
