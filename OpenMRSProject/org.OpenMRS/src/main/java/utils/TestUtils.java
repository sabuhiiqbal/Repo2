package utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.chainsaw.Main;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import testbase.TestBase;


public class TestUtils extends TestBase{
	
	public static long Page_load_TimeOut=20;
	public static long Implicit_Wait=10;
	TestUtils testUtils;
	String sheetName ="register";
	static ArrayList<String> testValues = new ArrayList<String>();

	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")+"\\src\\main\\java\\util\\Registeration.xlsx";

	static Workbook book;
	static Sheet sheet;

	public static void switchToFrame() {
		driver.switchTo().frame("customFieldFrame_41");

	}

	public static boolean isAlertPresent() {

		try{
			driver.switchTo().alert();
			System.out.println("Alert is There");
			return true;
		}
		catch(NoAlertPresentException e ) {
			System.out.println("No Alert is Present");
		}
		return false;

	}


	public boolean isElementPresent(By by) {
		try {
			driver.findElements(by);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public static String getCurrentDateTime() {
		SimpleDateFormat customFormat = new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}

	public static void selectAllCheckBox() {
		List<WebElement> checkItems = driver.findElements(By.xpath("//li[@class='form-line form-line-column form-col-1 form-line-column-clear']"));
		checkItems.size();


	}

	public static String getScreenshot(WebDriver driver) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/Screenshot/"+ System.currentTimeMillis()+ getCurrentDateTime()+".png";
		File destination = new File(path);
		try 
		{
			FileUtils.copyFile(src, destination);
		}
		catch(IOException e)
		{
			System.out.println("Capture Failed"+e.getMessage());

		}
		return path;
	}


	public static Object[][] getTestData(String sheetName)  {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	
	public static ArrayList<String> testDataForLocation() {
		testValues =  new ArrayList<String>();
		//SessionLocationData sd = new SessionLocationData(sheetName);
		//menuTestData.add(new Menu("Mail", "https://mail.yahoo.com/"));
		testValues.add("Inpatient Ward");
		testValues.add("Isolation Ward");
		testValues.add("Laboratory");
		testValues.add("Outpatient Clinic");
		testValues.add("Pharmacy");
		testValues.add("Registration Desk");
		return testValues;
		
		}
	
	
	public void verifyHomeListdata() {
		List<HomeList> homelistActualData = new ArrayList<HomeList>();
		homelistActualData.add(new HomeList("Find Patient Record","https://demo.openmrs.org/openmrs/coreapps/findpatient/findPatient.page?app=coreapps.findPatient"));
		homelistActualData.add(new HomeList("Active Visits","https://demo.openmrs.org/openmrs/coreapps/activeVisits.page?app=coreapps.activeVisits"));
		homelistActualData.add(new HomeList("Register a patient","https://demo.openmrs.org/openmrs/registrationapp/registerPatient.page?appId=referenceapplication.registrationapp.registerPatient"));
		homelistActualData.add(new HomeList("Capture Vitals","https://demo.openmrs.org/openmrs/coreapps/findpatient/findPatient.page?app=referenceapplication.vitals"));
		homelistActualData.add(new HomeList("Appointment Scheduling","https://demo.openmrs.org/openmrs//appointmentschedulingui/home.page"));
		homelistActualData.add(new HomeList("Reports","https://demo.openmrs.org/openmrs/reportingui/reportsapp/home.page"));
		homelistActualData.add(new HomeList("Data Management","https://demo.openmrs.org/openmrs/coreapps/datamanagement/dataManagement.page"));
		homelistActualData.add(new HomeList("Configure Metadata","https://demo.openmrs.org/openmrs/adminui/metadata/configureMetadata.page"));
		homelistActualData.add(new HomeList("System Administration","https://demo.openmrs.org/openmrs/coreapps/systemadministration/systemAdministration.page"));
		
		
	}
	
	public static int testDataForLocationSize() {
		
		return testValues.size();
		
	}
	
	public void useTabKey() throws AWTException {
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		
		
		
	}
	
	public static boolean getHomeAppList() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.openmrs.org/openmrs/referenceapplication/home.page");
		List<WebElement> data = driver.findElements(By.xpath("//div[@id='apps']/a"));
		for(WebElement temp :data) {
			System.out.println(temp);
		}
		return false;
	}	
	public static void main(String[] args) {
		System.out.println(getHomeAppList());
	}
	
	}

