package com.qa.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartPage {
	
	WebDriver driver;
	public FlipkartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
	WebElement cancel;
	public void cancelBtn()
	{
		cancel.click();
	}
	
	@FindBy(className="_2xm1JU")
	WebElement logo;
	public void flipkartLogo()
	{
		if(logo.isDisplayed())
		{
			System.out.println("Flipkart logo is present on the left side of the top");
		}
		else
		{
			System.out.println("Flipkart logo is not present on the left side of the top");
		}
	}
	
	@FindBy(name="q")
	WebElement search;
	
	@FindBy(className="L0Z3Pu")
	WebElement enter;
	
	@FindBy(className="_4rR01T")
	List<WebElement> count;
	
	@FindBy(className="_4rR01T")
	WebElement firstItem;
	
	public void searchItem()
	{
		search.sendKeys("iphone 14");
		enter.click();
		System.out.println(count.size());
		firstItem.click();
	}	

}
