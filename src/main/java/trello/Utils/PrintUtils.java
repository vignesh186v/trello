package trello.Utils;

import org.testng.Reporter;

import trello.basetest.basetest;
import trello.extentreports.ExtentreporterNG;

public class PrintUtils extends basetest {

	public static void logMessage(String logmsg) {
		System.out.println(logmsg);
		Reporter.log(logmsg);
		ExtentreporterNG.testStep(logmsg,"PASS");
	}
	
	public static void logError (String logmsg) {
		System.err.println(logmsg);
		Reporter.log(logmsg);
		ExtentreporterNG.testStep(logmsg,"FAIL");
	}
		

}
