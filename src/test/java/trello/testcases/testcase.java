package trello.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import trello.extentreports.*;
import trello.listener.customlistener;
import trello.basetest.basetest;
import trello.pages.Dashboardpage;
import trello.pages.Homepage;
import trello.pages.Listpage;
import trello.pages.Loginpage;

@Listeners(customlistener.class)
public class testcase extends basetest {
	public static Homepage homepage;
	public static Loginpage loginpage;
	public static Dashboardpage dashboardpage;
	public static Listpage listpage;
	
	
	public testcase() {
		super();
	}
	@BeforeSuite
	public void StartReport(){
		
		ExtentreporterNG.startReport();
	}
	
	@BeforeMethod
	public void startmethod() {
		System.out.println("Start method is executed");
		basetest.initialisation();
		homepage = new Homepage();
		
	}
	
	@Test(enabled=false)
	public void Applogin() {
		System.out.println("Test method is started executing");
		homepage.initiatelogin();
		System.out.println("homepage is initiated");
		loginpage = new Loginpage();
		loginpage.trellologin();
		
	}
	
	@DataProvider
	public Object[][] gettestdata()
	{
		Object data[][] = basetest.getboarddata("Sheet1");
		return data;
	}
	
	@Test(dataProvider = "gettestdata")
	public void process(String Board,String List1,String List2,String List3,
			String List4,String card1,String card2,String card3,String card4,String Message) 
	{
		ExtentreporterNG.setTestName("Trello", "To check the login functionality of cards");
		homepage.initiatelogin();
		loginpage = new Loginpage();
		loginpage.trellologin();
		ExtentreporterNG.setTestName("Trello", "To check the Dashboard functionality of site");
		dashboardpage=new Dashboardpage();
		dashboardpage.createboard(Board);
		ExtentreporterNG.setTestName("Trello", "To check the List functionality of site");
		listpage= new Listpage();
		listpage.createlists(List1,List2,List3,List4);
		ExtentreporterNG.setTestName("Trello", "To check the card functionality of site");
		listpage.createcard(card1, card2, card3, card4);
		ExtentreporterNG.setTestName("Trello", "To check the cards movement of site");
		listpage.movecards();
		ExtentreporterNG.setTestName("Trello", "To check the Comments functionality of site");
		listpage.entercomment(Message);
		
	}
	
	
	
	@AfterMethod
	public void stopmethod() {
		System.out.println("stop method is executed");
	}

	@AfterSuite
	public void EndReport(){
		
		ExtentreporterNG.endReport();
	}
	
}
