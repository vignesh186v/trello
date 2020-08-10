package trello.basetest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class basetest {
	public static Properties prop;
	public static WebDriver driver;
	public static String path="C:\\Users\\Vignesh\\eclipse-workspace\\trello\\Resources\\Testdata.xlsx";
	public static Workbook book;
	public static Sheet sheet;
	
	
	public basetest(){
    prop = new Properties();
    
    try {
		FileInputStream fis = new FileInputStream("C:\\Users\\Vignesh\\eclipse-workspace\\trello\\Resources\\config.properties");
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
	public static void initialisation() {
		String browsername = prop.getProperty("browser");
		if(browsername.contentEquals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Vignesh\\eclipse-workspace\\trello\\Resources\\chromedriver.exe");
			driver = new ChromeDriver();			
		}
		else if(browsername.contentEquals("Firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Vignesh\\eclipse-workspace\\trello\\Resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	public static Object[][] getboarddata(String sheetname){
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet=book.getSheet(sheetname);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				System.out.println(data[i][j]);
			}
		}
		return data;
	}
	
	public static void failed(String testmethodname) {
		File sourcefile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(sourcefile,new File("C:\\Users\\Vignesh\\eclipse-workspace\\trello\\Screenshots\\"+"failedcase_"+testmethodname+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
