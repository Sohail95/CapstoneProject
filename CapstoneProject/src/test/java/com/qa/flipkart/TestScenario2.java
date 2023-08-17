package com.qa.flipkart;

import org.testng.annotations.Test;

import com.qa.Pages.FlipkartPage;

public class TestScenario2 extends BaseTest {
	
	@Test(priority=1)
	public void iphone()
	{
		FlipkartPage flipkart = new FlipkartPage(driver);
		flipkart.cancelBtn();
		flipkart.flipkartLogo();
		flipkart.searchItem();
		
		String actualUrl = driver.getTitle();
		if(actualUrl.contains("Iphone 14"))
		{
			System.out.println("Navigate to correct Page");
		}
		else
		{
			System.out.println("Navigate to wrong Page");
		}

	}

}
