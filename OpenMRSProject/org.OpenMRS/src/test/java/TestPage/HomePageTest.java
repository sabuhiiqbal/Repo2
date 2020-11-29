package TestPage;



import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import testbase.TestBase;
import utils.HomeList;
import utils.SessionLocationData;
import utils.TestUtils;



public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtils testutils;
	SessionLocationData sessionLocationData;
	
	
	public HomePageTest() {
	super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginPage = new LoginPage();
		homePage =loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		testutils = new TestUtils();
		//sessionLocationData = new SessionLocationData(sessionLocation);
	}

	@Test(priority=1)

	public  void validatePageTitleTest() {
		String actualTitle = loginPage.verifyTitle();
		String expectedTitle = "Home";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(priority=2)
	public void validateLogoIconTest() {
		boolean actual =loginPage.verifyLogoIcon();

		Assert.assertEquals(actual, true);
	}

	@Test(priority=3)
	public void validateLogOutLinkTest() {
		boolean actualStatus =  homePage.verifyLogOutLink();
		boolean expectedStatus =true;
		Assert.assertEquals(actualStatus, expectedStatus);
	}

	@Test(priority=4)
	public String  validateLogInMessageTest() {
		String actualMessage = homePage.getTheHeaderMessage();
		String expectedmessage = "Logged in as Super User (admin) at Registration Desk.";
		Assert.assertEquals(actualMessage, expectedmessage);
		return expectedmessage;
	}

	@Test(priority=5)
	public boolean validateAdminLinkTest() {
		boolean actualStatus = homePage.verifyAdminLink();
		boolean expectedStatus = true;
		Assert.assertEquals(actualStatus, expectedStatus);
		return expectedStatus;

	}

	@Test(priority=6)
	public void validateAdminLinkIsWorkingTest() {


	}

	@Test(priority=7)
	public void validateLoginAsImpatientWard() {
		String actualLoginAs = homePage.getTheHeaderMessage();
		String expectedLoginAs ="Logged in as Super User (admin) at Inpatient Ward";
		Assert.assertEquals(actualLoginAs, expectedLoginAs);
	}

	@Test(priority=8)
	public void validateHomeListTest() {
		List<HomeList> actualData = homePage.getHomeListData();
		for( HomeList itemName :actualData) {
			itemName.getHomeListName();
			itemName.getHomeListLink();
			//WebDriver wait = new WebDriverWait();
			//wait.untils(ExpectedConditions.invisibilityOf(element))

//			Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver).withTimeout(30,TimeUnit.MICROSECONDS).pollingEvery(20,TimeUnit.SECONDS).ignoring(NoSuctELementException.class);
//			wait1.until(new )

		}
	}
		
		@Test(priority=9)
		public FindPatientRecordTest selectPatientRecordLinkTest() {
			homePage.selectPatientRecord();
			return new FindPatientRecordTest();
			
			
		}
	


	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	}


