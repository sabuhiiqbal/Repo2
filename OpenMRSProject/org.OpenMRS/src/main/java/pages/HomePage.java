package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;
import utils.HomeList;


public class HomePage extends TestBase{



	@FindBy(xpath="/html/body/header/nav/div[1]/a/img")
	WebElement logoIcon;


	@FindBy(xpath="//li[@class='nav-item logout']/a")
	WebElement logOutLink;

	@FindBy
	WebElement adminLink;

	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div/h4")
	WebElement logInMessage;

	@FindBy(xpath="//span[@id=\"selected-location\"]")
	WebElement loginAsImpatientWard;

	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div/h4")
	WebElement headerMessage;

	@FindBy(xpath="//div[@id='apps']/a")
	List<WebElement> homeList;
	
	@FindBy(xpath="//div[@id='apps']/a[1]")
	WebElement findPatientRecord;

	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public String verifyTitle() {
		return driver.getTitle();
	}

	public boolean verifyLogoIcon() {
		boolean status = logoIcon.isDisplayed();
		return status;

	}
	public String  getTheHeaderMessage() {
		String headermesg = headerMessage.getText();
		return headermesg;
	}

	public  List<HomeList>getHomeListData() {
		int expectedSize = homeList.size();
		List<HomeList>expectedValue = new ArrayList<HomeList>();
		//homeList.get(index)
		//for(int i =0;i<homeList.size();i++) {
		for(WebElement item :homeList) {
			//String expectedValueInfo  = homeList.get(i).getText();
			expectedValue.add(new HomeList(item.getText(), item.getAttribute("href")));
		}
		return expectedValue;
	}

	public boolean verifyLogOutLink() {
		return logOutLink.isDisplayed();
	}

	public boolean verifyAdminLink() {
		return adminLink.isDisplayed();
	}
	
	public FindPatientRecordPage selectPatientRecord() {
		findPatientRecord.click();
		return new FindPatientRecordPage();
	}



}
