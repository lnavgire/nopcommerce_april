package com.nopcommerce.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_loginTest extends baseClass {
	

	@Test
	public void logintestcase() throws IOException {
		driver.get(baseurl);
		
		logger.info("Url is Opened");
		LoginPage lp = new LoginPage(driver);

		lp.setemail(username);
		logger.info("entered email");
		lp.setpassword(password);
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
	
			captureScreen(driver,"loginTest");
			logger.info("Test case failed");
			Assert.assertTrue(false);
		}
			
		
	}

	
}
