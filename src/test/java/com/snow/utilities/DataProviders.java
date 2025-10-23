package com.snow.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {

        String path = "./src/test/resources/Zeiss test Data/Zeiss login credentials.xlsx";
        FileInputStream fs = new FileInputStream(path);
        XSSFWorkbook wb = new XSSFWorkbook(fs);
        XSSFSheet sh = wb.getSheet("Credentials");

        int totalRows = sh.getPhysicalNumberOfRows();
        int totalCols = sh.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[totalRows - 1][totalCols];

        for (int i = 1; i < totalRows; i++) { // skip header row
            for (int j = 0; j < totalCols; j++) {
                data[i - 1][j] = sh.getRow(i).getCell(j).getStringCellValue();
            }
        }

        wb.close();
        fs.close();

        return data;
    }
	
	@DataProvider(name="Incident data")
	public Object[][] incData() throws IOException
	{
		FileInputStream fs=new FileInputStream("./src/test/resources/Zeiss Test Data/Zeiss login Credentials.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sh=wb.getSheet("INC Field Values");
		XSSFRow row;

		int totalRows=sh.getPhysicalNumberOfRows(); 
		int totalColumns=sh.getRow(0).getPhysicalNumberOfCells();
		
		Object [][] incData= new Object[totalRows-1][totalColumns];
		
		for(int i=1;i<totalRows;i++)
		{
			row=sh.getRow(i);
			for(int j=0;j<totalColumns;j++)
			{
				incData[i - 1][j] = row.getCell(j).getStringCellValue();
			}
		}
		wb.close();
		fs.close();
		
		return incData;
	}
	
}
