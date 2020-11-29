package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class LoginPage extends TestBase{
	 
	
	@FindBy(id="username")
	WebElement username;

	@FindBy(id="password")
	WebElement password;


	@FindBy(id="loginButton")
	WebElement logIn;

	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div/header/div/a/img")
	WebElement logoIcon;

	@FindBy(xpath="//ul[@id='sessionLocation']/li ")
	List<WebElement> session;

	@FindBy(id="cantLogin")
	WebElement cantLogIn;

	@FindBy(xpath="//li[@id='id_19']")
	WebElement allCheckBoxItem;

	@FindBy(id="error-message")
	WebElement errorMessage;

	@FindBy(xpath="//legend[@class='w-auto']")
	WebElement LoginImg;

	@FindBy(xpath="//*[@id=\"Inpatient Ward\"]")
	WebElement impatientWard;


	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyTitle() {
		return driver.getTitle();
	}

	public boolean verifyLogoIcon() {
		boolean status = logoIcon.isDisplayed();
		return status;

	}

	public  String verifyInvalidCrediantialErrorMessage(){

		String message =errorMessage.getText();
		return message;
	}


	public boolean verifyCantLoginLink() {
		boolean status=  cantLogIn.isDisplayed();
		return status;

	}

	public  boolean validateLoginImage() {
		boolean status = LoginImg.isDisplayed();
		return status;
	}

	public HomePage validateLogin(String uname,String pword) throws IOException {
		username.sendKeys(uname);
		password.sendKeys(pword);	
		impatientWard.click();
		logIn.click();
		return new HomePage();

	}

	public int verifysessionLocationSize() {
		int size =session.size();
		return size;
	}

	public static  List<String> verifysessionLocationData() {
		List<WebElement> val = driver.findElements(By.xpath("//ul[@id='sessionLocation']/li"));
		ArrayList<String>newData = new ArrayList<String>();

		for(WebElement temp :val) {

			//System.out.println(temp.getText());

			newData.add(temp.getText());
		}

		return newData;
	}
	/*public static void main(String[] args) {
		List<String> val = verifysessionLocationData();

		for(String temp :val) {
			System.out.println(temp);

		}*/

}
