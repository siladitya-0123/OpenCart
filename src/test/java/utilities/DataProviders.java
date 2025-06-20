package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider1
	@DataProvider(name = "loginData")
	public String[][] getData() throws IOException {

		String path = ".\\testData\\Login_Data.xlsx"; // Taking excel file from testdata folder

		ExcelUtils xlutil = new ExcelUtils(path); // Creating object for excelUtility
		int totalRows = xlutil.getrowcount("Login");
		int totalColumns = xlutil.getcellcount("Login", 1);

		String loginData[][] = new String[totalRows][totalColumns]; // created for 2 dimension array to store excel data

		for (int i = 1; i <= totalRows; i++) { // read the data from 2nd row so i =1 as first row will be header
			for (int j = 0; j < totalColumns; j++) {// read the data from 1st column so j=0
				loginData[i - 1][j] = xlutil.getcelldata("Login", i, j); //1,0
			}
		}
		return loginData;

	}
}
