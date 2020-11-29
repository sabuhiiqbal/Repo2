package pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.SessionLocationData;
import utils.TestUtils;

public class RoughPage {
	static WebDriver driver;
	TestUtils testutils = new TestUtils();

	public static void main(String[] args) throws InterruptedException {



		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.openmrs.org/openmrs/referenceapplication/login.page");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		driver.findElement(By.id("Inpatient Ward")).click();
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(1000);
		
		WebElement fpr = driver.findElement(By.xpath("//div[@id='apps']/a[1]"));
		fpr.click();
		
		/*
		 * WebElement searchBox = driver.findElement(By.id("patient-search")); String
		 * textValue = searchBox.getAttribute("placeholder");
		 * System.out.println(textValue);
		 */
		
		List<WebElement> rows  =driver.findElements(By.xpath("//table[@id='patient-search-results-table']/tbody/tr"));
		int rowSize = rows.size();
		System.out.println(rowSize);
				
		
	
	//	WebElement errorMessage = driver.findElement(By.id("error-message"));
		//System.out.println(errorMessage.getText());





		/*
		List<WebElement> sessionDatas = driver.findElements(By.id("sessionLocation"));
		ArrayList<SessionLocationData>newSessionDatas = new ArrayList<SessionLocationData>();
		//newSessionDatas.add(new SessionLocationData(sessionLocationName.getText());
		for(WebElement temp : sessionDatas) {
			//System.out.println(temp.getText());
			newSessionDatas.add(new SessionLocationData(temp.getText()));*/
	}		

}

