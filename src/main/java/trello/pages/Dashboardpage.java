package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import trello.Utils.PrintUtils;
import trello.basetest.basetest;

public class Dashboardpage extends basetest{
	public static WebDriverWait wait;
	
	
	@FindBy(xpath="//span[contains(text(),'Create new board')]")
	WebElement newboardbtn;
	
	@FindBy(xpath="//input[@data-test-id='create-board-title-input']")
	WebElement boardtitle;
	
	@FindBy(xpath="//span[contains(text(),'Create Board')]")
	WebElement createbtn;
	
	public Dashboardpage() {
		PageFactory.initElements(driver,this);
	}
	
	public Listpage createboard(String Board) {
		System.out.println("create board func is activated and board value is : "+Board);
		wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Create new board')]")));
		driver.findElement(By.xpath("//span[contains(text(),'Create new board')]")).click();
		///driver.navigate().refresh();
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].click();",newboardbtn);
		 */
		//newboardbtn.sendKeys(Keys.ENTER);
		boardtitle.sendKeys(Board);
		createbtn.click();
		PrintUtils.logMessage("Dashboard functionality is working fine");
		return new Listpage();
	}
	

}
