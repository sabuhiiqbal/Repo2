package TestPage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import testbase.TestBase;
import utils.SessionLocationData;
import utils.TestUtils;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtils testutils;
	SessionLocationData sessionLocationData;

	String sheetName ="register";

	public LoginPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		testutils = new TestUtils();
		//sessionLocationData = new SessionLocationData(sessionLocation);
	}

	@Test(priority=1)

	public  void validatePageTitleTest() {
		System.out.println(loginPage.verifyTitle());
	}




	@Test(priority=2)
	public void validateLogoIconTest() {
		boolean actual =loginPage.verifyLogoIcon();

		Assert.assertEquals(actual, true);
	}

	@Test(priority=3)
	public void validateCantLoginTest() {
		boolean actualStatus = loginPage.verifyCantLoginLink();
		boolean expectedStatus = true;
		Assert.assertEquals(actualStatus, expectedStatus);
	}

	@Test(priority=6)
	public void verifyInvalidCrediantialErrorMessageTest() throws InterruptedException {
		try {
			loginPage.validateLogin(prop.getProperty("invalidusername"),prop.getProperty("invalidpassword"));
			Thread.sleep(1000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		String actualMessage =loginPage.verifyInvalidCrediantialErrorMessage();
		String expectedMessage = "Invalid username/password. Please try again.";
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	@Test(priority=4)
	public  void verifyLoginImageTest() {
		boolean actualStatus = loginPage.validateLoginImage();
		boolean expectedStatus = true;
		Assert.assertEquals(actualStatus, expectedStatus);
	}

	@Test(priority=5)
	public void verifyLoginTest() throws IOException {
		homePage = loginPage.validateLogin(prop.getProperty("username"),prop.getProperty("password"));
		System.out.println(driver.getCurrentUrl());
	}

	@Test(priority=6)
	public void verifySesionLocationSize() {
		int actualSize = loginPage.verifysessionLocationSize();
		int expectedSize =6;
		Assert.assertEquals(actualSize, expectedSize);
	}

	@Test(priority=7)
	public void verifySessionLocationData() {
		ArrayList<String> expectedvalue = testutils.testDataForLocation();
		List<String> actualvalue = loginPage.verifysessionLocationData();
		Assert.assertEquals(actualvalue.size(),expectedvalue.size());
		for(int i =0;i<expectedvalue.size();i++) {
			
			Assert.assertEquals(actualvalue.get(i), expectedvalue.get(i));
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
