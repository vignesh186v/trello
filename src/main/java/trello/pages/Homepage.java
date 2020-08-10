package trello.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import trello.basetest.basetest;

public class Homepage extends basetest {
	
	@FindBy(linkText="Log In")
	WebElement loginbtn;
	
	public Homepage() {
		PageFactory.initElements(driver, this);
	}
	
	public Loginpage initiatelogin() {
		System.out.println("inititalogin func has started executing");
		loginbtn.click();
		return new Loginpage();
	}
	

}
