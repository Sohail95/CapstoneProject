package com.qa.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.qa.Pages.ContactPage;

public class TestScenario1 extends BaseTest{
	
	@Test(priority=1)
	public void verify()
	{
		//Verify Title
		String expectedTitle = "Want to practice test automation? Try these demo sites! | Automation Panda";
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle))
		{
			System.out.println("Actual Title of the page is same as Expected Title");
		}
		else
		{
			System.out.println("Actual Title of the page is not same as Expected Title");
		}
	}
	
	@Test(priority=2)
	public void contactDetails()
	{
		//Verify Contact Details
		ContactPage contact = new ContactPage(driver);
		contact.btn();
		String expectedContactUrl = "https://automationpanda.com/contact/";
		String actualContactUrl  = driver.getCurrentUrl();
		if(expectedContactUrl.equals(actualContactUrl))
		{
			System.out.println("Navigated Conatct page Correctly");
		}
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", " ");
		
		contact.contactDetails("MD Sohail","mdsohail@gmail.com","These are my details...");
		
		//Verify Message Sent message
		String message = driver.findElement(By.id("contact-form-success-header")).getText();
		if(message.contains("message has been sent"))
		{
			System.out.println(" 'Message Sent' - message sucessfully Verified");
		}
		else
		{
			System.out.println(" 'Message Sent' - message not sucessfully Verified");
		}	
		
		
	}

}
