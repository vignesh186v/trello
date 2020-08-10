package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import trello.Utils.PrintUtils;
import trello.basetest.basetest;

public class Listpage extends basetest {
	
	public static WebDriverWait wait;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement listtitleone;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement listtitletwo;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement listtitlethree;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement listtitlefour;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement addlistbtn;
	
	@FindBy(xpath="//span[contains(text(),'Add a card')]")
	WebElement addacardbtn;
	
	@FindBy(xpath="//textarea[@placeholder='Enter a title for this card…']")
	WebElement titlecard1;
	
	@FindBy(xpath="//textarea[@placeholder='Enter a title for this card…']")
	WebElement titlecard2;
	
	@FindBy(xpath="//textarea[@placeholder='Enter a title for this card…']")
	WebElement titlecard3;
	
	@FindBy(xpath="//textarea[@placeholder='Enter a title for this card…']")
	WebElement titlecard4;
		
	@FindBy(xpath="//input[@type='submit']")
	WebElement addcard;
	

	@FindBy(xpath="//span[contains(text(),'Card2')]")
	WebElement movecard_12;
	
	@FindBy(xpath="//div[@id='surface']//div[2]//div[1]//div[3]//a[1]//span[2]")
	WebElement movecard_21;
	
	@FindBy(xpath="//span[contains(text(),'Card3')]")
	WebElement movecard_13;
	
	@FindBy(xpath="//div[@class='board-canvas']//div[3]//div[1]//div[3]")
	WebElement movecard_31;
	
	@FindBy(xpath="//div[@class='board-canvas']//div[3]//div[1]//div[3]//a[1]//span[3]")
	WebElement movecard_32;
	
	@FindBy(xpath="//span[contains(text(),'Card1')]")
	WebElement Entercard_11;
	
	@FindBy(xpath="//span[contains(text(),'Members')]")
	WebElement membersbtn;
	
	@FindBy(xpath="//span[@class='username']")
	WebElement membersel;
	
	@FindBy(xpath="//a[@class='pop-over-header-close-btn icon-sm icon-close']")
	WebElement closepop;
	
	@FindBy(xpath="//textarea[@placeholder='Write a comment…']")
	WebElement commentbox;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement savecomment;
	
	
	public Listpage() {
		PageFactory.initElements(driver,this);
	}
	
	public void createlists(String List1,String List2,String List3,String List4) {
		listtitleone.sendKeys(List1);
		addlistbtn.click();
		listtitletwo.sendKeys(List2);
		addlistbtn.click();
		listtitlethree.sendKeys(List3);
		addlistbtn.click();
		listtitlefour.sendKeys(List4);
		addlistbtn.click();
		PrintUtils.logMessage("Create list functionality is working fine");
		
	}
	
	public void createcard(String card1,String card2,String card3,String card4) {
		addacardbtn.click();
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(titlecard1));
		titlecard1.sendKeys(card1);
		addcard.click();
		titlecard2.sendKeys(card2);
		addcard.click();
		titlecard3.sendKeys(card3);
		addcard.click();
		titlecard4.sendKeys(card4);
		addcard.click();
		PrintUtils.logMessage("create card functionality is working fine");
			
	}

	public void movecards() {
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(movecard_12));
		Actions act = new Actions(driver);
		act.dragAndDrop(movecard_12,movecard_21).build().perform();
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(movecard_13));
		act.dragAndDrop(movecard_13,movecard_31).build().perform();
		act.dragAndDrop(movecard_12,movecard_32).build().perform();
		PrintUtils.logMessage("Moving cards functionality is working fine");	
	}
	
	public void entercomment(String Message) {
		wait.until(ExpectedConditions.visibilityOf(Entercard_11));
		Entercard_11.click();
		membersbtn.click();
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(membersel));
		membersel.click();
		closepop.click();
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(commentbox));
		//commentbox.click();
		//wait.until(ExpectedConditions.visibilityOf(commentbox));
		commentbox.sendKeys(Message);
		savecomment.click();
		PrintUtils.logMessage("Enter comment functionality is working fine");
		
	}
	
	
	

}
