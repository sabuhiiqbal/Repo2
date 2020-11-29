package TestPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.FindPatientRecordPage;
import pages.HomePage;
import pages.LoginPage;
import testbase.TestBase;
import utils.SessionLocationData;
import utils.TestUtils;

public class FindPatientRecordTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtils testutils;
	SessionLocationData sessionLocationData;
	FindPatientRecordPage  findpatientRecord;
	public FindPatientRecordTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginPage = new LoginPage();
		homePage =loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		testutils = new TestUtils();
		findpatientRecord = homePage.selectPatientRecord();
	}
	
	
	@Test(priority=1)

	public  void validatePageTitleTest() {
		String actualTitle = findpatientRecord.verifyPageTitle();
		String expectedTitle = "OpenMRS Electronic Medical Record";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(priority=2)
	public void validateLogoIconTest() {
		boolean actual =findpatientRecord.validateLogoIconTest();
		Assert.assertEquals(actual, true);
	}
	
	@Test(priority=3)
	public  void validateSearchInputBoxTest() {
		String textValue = findpatientRecord.verifyTextInTextBox();
		Assert.assertEquals(textValue,"Search by ID or Name");
		
		
	}
	@Test(priority=4)
	public void validateTheRowSizeTest() throws InterruptedException {
		int size = findpatientRecord.calculateTheRowSize();
		Assert.assertEquals(size, size);
	}
	
	@Test(priority=5)
	public void vlaidateTheDataInTheHeaderTest() {
		  System.out.println(findpatientRecord.extractHeaderData());
		 
		 }
		
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
		
	}

	
	
