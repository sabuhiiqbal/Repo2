package utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RoughHomeList {
	static String val;
	static String val1;
	WebDriver driver;

		
	public List<HomeList>findMenuAndLocationsFromWidget(){
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.openmrs.org/openmrs/");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		driver.findElement(By.id("Inpatient Ward")).click();
		driver.findElement(By.id("loginButton")).click();

		List<WebElement> datas = driver.findElements(By.xpath("//div[@id='apps']/a"));
		List<HomeList> dataFromPage = new ArrayList<HomeList>(datas.size());
		for(WebElement data :datas) {
			dataFromPage.add(new HomeList(data.getText(),data.getAttribute("href")));
		}
		return dataFromPage;

	}	
	@Test 
	public void verifyMenuSizeTest() {
		int actual = findMenuAndLocationsFromWidget().size();
		System.out.println(actual);
		int expected = 10;
		Assert.assertEquals(actual, expected);
	}

	@Test void verifyWidgetNameTest() {
		List<HomeList> homelistActualData = new ArrayList<HomeList>();
		homelistActualData.add(new HomeList("Find Patient Record","https://demo.openmrs.org/openmrs/coreapps/findpatient/findPatient.page?app=coreapps.findPatient"));
		homelistActualData.add(new HomeList("Active Visits","https://demo.openmrs.org/openmrs/coreapps/activeVisits.page?app=coreapps.activeVisits"));
		homelistActualData.add(new HomeList("Register a patient","https://demo.openmrs.org/openmrs/registrationapp/registerPatient.page?appId=referenceapplication.registrationapp.registerPatient"));
		homelistActualData.add(new HomeList("Capture Vitals","https://demo.openmrs.org/openmrs/coreapps/findpatient/findPatient.page?app=referenceapplication.vitals"));
		homelistActualData.add(new HomeList("Appointment Scheduling","https://demo.openmrs.org/openmrs//appointmentschedulingui/home.page"));
		homelistActualData.add(new HomeList("Reports","https://demo.openmrs.org/openmrs/reportingui/reportsapp/home.page"));
		homelistActualData.add(new HomeList("Register a patient","https://demo.openmrs.org/openmrs/registrationapp/registerPatient.page?appId=registrationapp.basicRegisterPatient"));
		homelistActualData.add(new HomeList("Data Management","https://demo.openmrs.org/openmrs/coreapps/datamanagement/dataManagement.page"));
		homelistActualData.add(new HomeList("Configure Metadata","https://demo.openmrs.org/openmrs/adminui/metadata/configureMetadata.page"));
		homelistActualData.add(new HomeList("System Administration","https://demo.openmrs.org/openmrs/coreapps/systemadministration/systemAdministration.page"));

		List<HomeList> actualMenus = findMenuAndLocationsFromWidget();
		int actualMenuSize  = actualMenus.size();
		System.out.println("The actual widget size is "+actualMenuSize);
		int expectedsize = homelistActualData.size();		
		Assert.assertEquals(actualMenuSize ,expectedsize);

		//Extract the Data
		for (int i =0;i<expectedsize;i++) {
			HomeList expectedMenu = homelistActualData.get(i);
			HomeList actualMenu = actualMenus.get(i);
			Assert.assertEquals(actualMenu.getHomeListName(), expectedMenu.getHomeListName());
			Assert.assertEquals(actualMenu.getHomeListLink(), expectedMenu.getHomeListLink());
		}
	}


}
