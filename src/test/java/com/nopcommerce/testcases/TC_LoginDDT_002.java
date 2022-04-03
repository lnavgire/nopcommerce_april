package com.nopcommerce.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.utilities.XLUtils;

public class TC_LoginDDT_002 extends baseClass{
	
	@Test(dataProvider="logindata")
	public void logintest(String user,String pwd) throws IOException
	{
		
		driver.get(baseurl);
		
		driver.manage().window().maximize();
		logger.info("Url is Opened");
		LoginPage lp = new LoginPage(driver);

		lp.setemail(user);
		logger.info("entered email");
		lp.setpassword(pwd);
		logger.info("entered password");
		lp.clickLogin();
		logger.info("Clicked login");
		
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			logger.info("title matched");
			lp.clicklogout();
			logger.info("login is Passes");
		}
		else
		{
	
			//captureScreen(driver,"loginTest");
			logger.info("Test case failed");
			Assert.assertTrue(false);
		}
		
	}
	
	
	@DataProvider(name="logindata")
	public String [][] getdata() throws IOException
	{
		
		String path="C:\\Users\\Sony\\eclipse-workspace\\NopCommercev3\\src\\test\\java\\com\\nopcommerce\\testData\\LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);
			}
		}
		
		
		return logindata;
	}

}
