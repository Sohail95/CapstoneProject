package com.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	WebDriver driver;
	public ContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[normalize-space()='Contact']")
	WebElement contactbtn;
	public void btn()
	{
		contactbtn.click();
	}
	
	@FindBy(id="g3-name")
	WebElement username;
	
	@FindBy(id="g3-email")
	WebElement useremail;
	
	@FindBy(id="contact-form-comment-g3-message")
	WebElement comment;
	
	@FindBy(xpath="//button[@type='submit']//strong")
	WebElement submit;
	
	public void contactDetails(String uname, String uemail, String comments)
	{
		username.sendKeys(uname);
		useremail.sendKeys(uemail);
		comment.sendKeys(comments);
		submit.click();
		
	}
}

	


