package trello.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import trello.Utils.PrintUtils;
import trello.basetest.basetest;

public class Loginpage extends basetest {

	@FindBy(id="user")
	WebElement Emailtext;
	
	@FindBy(xpath="//input[@value='Log in with Atlassian']")
	WebElement loginatl;
	
	@FindBy(id="password")
	WebElement Passwordtext;
	
	@FindBy(xpath="//*[text()='Log in']")
	WebElement loginbtn;
	
	
	public Loginpage() {
		PageFactory.initElements(driver, this);
	}
	
	public Dashboardpage trellologin() {
		
		Emailtext.sendKeys(prop.getProperty("Emailid"));
		loginatl.click();
		Passwordtext.sendKeys(prop.getProperty("pwd"));
		loginbtn.click();
		PrintUtils.logMessage("Login functionality is working fine");
		return new Dashboardpage();
		
	}
	
	
}
