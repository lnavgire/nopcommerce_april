package com.nopcommerce.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopcommerce.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {
	
	
	
	public String baseurl = "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F";
	public String username = "admin@yourstore.com";
	public String password = "admin";
	public static WebDriver driver;
	public static Logger logger;
	

	@BeforeClass
	@Parameters("browser")
	public void setup(String br) {
		
		logger=Logger.getLogger("nopCommerce");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver","C:\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		else if(br.equals("firefox"))
		{

			System.setProperty("webdriver.chrome.driver","C:\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	
	public static String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}

	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
	

}
