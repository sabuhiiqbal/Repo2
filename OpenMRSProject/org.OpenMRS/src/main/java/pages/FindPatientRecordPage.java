package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class FindPatientRecordPage  extends TestBase{


	@FindBy(xpath="//div[@class='logo']/a/img")
	WebElement logoIcon;

	@FindBy(xpath="//ul[@id='breadcrumbs']/li/a")
	WebElement smallhomeIconLink;

	@FindBy(id="patient-search")
	WebElement searchInputBox;

	@FindBy(xpath="//*[@id='patient-search-results-table_wrapper']/div")
	WebElement footerLink;

	@FindBy(xpath="//table[@id='patient-search-results-table']")
	WebElement table;


	@FindBy(xpath="//div[@id='content']/h2") 
	WebElement headerName;


	@FindBy(xpath="//input[@id='patient-search']")
	WebElement findPatientRecordTextBox;
	
	//@FindBy(xpath="//table[@id='patient-search-results-table']/tbody/tr")
	//WebElement  row;

	

	public FindPatientRecordPage() {
		PageFactory.initElements(driver, this);
	}



	public String verifyPageTitle() { 
		String title = driver.getTitle(); 
		return title; 
	}

	public boolean validateLogoIconTest() { 
		boolean actualStatus = logoIcon.isDisplayed(); 
		return actualStatus; 

	}

	public HomePage verifyHomeSmallIconLink() throws IOException {
		smallhomeIconLink.click();
		return new HomePage();
	}

	public String verifyTextInTextBox() {
		String textValue =searchInputBox.getAttribute("placeholder");
		return textValue; 
		//String textValue =
	}
	
	public int calculateTheRowSize() throws InterruptedException {
		List<WebElement> rows  =driver.findElements(By.xpath("//table[@id='patient-search-results-table']/tbody/tr"));
		Thread.sleep(1000);
		int rowSize = rows.size();
		return rowSize;
	}
	
	public ArrayList<String> extractHeaderData() {
		ArrayList<String>headerNames = new ArrayList<String>();
		List<WebElement> headerDatas =driver.findElements(By.xpath("//table[@id='patient-search-results-table']/thead/tr/th"));
		for(WebElement headerData :headerDatas) {
			String headerName = headerData.getText();
			//ArrayList<String>headerNames = new ArrayList<String>();
			headerNames.add(headerName);
		}
		
		for(String headeraName : headerNames) {
		System.out.println(headeraName);
		
		}
		return headerNames;
		
			}
	
}

