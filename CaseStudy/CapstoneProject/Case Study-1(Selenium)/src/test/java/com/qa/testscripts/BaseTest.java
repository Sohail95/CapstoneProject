package com.qa.testscripts;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	WebDriver driver;
	@Parameters("browser")
	@BeforeSuite
	public void setUp(String browser) 
	{
		if(browser.equals(browser))
		{
                   WebDriverManager.chromedriver().setup();
	           driver = new ChromeDriver();
		 
		}
                else
                {
                   WebDriverManager.edgedriver().setup();
	           driver = new EdgeDriver();
                 }
		
	}
	
	@Parameters("url")
	@Test(priority=0)
	public void launchUrl(String url)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@AfterSuite()
	public void tearDown()
	{
		driver.quit();
	}

}
