package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import testbase.TestBase;


public class RoughDatePicker extends TestBase{
	static Properties prop;
	static FileInputStream ip;

	public static void main(String[] args)  {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get("https://demo.openmrs.org/openmrs/referenceapplication/login.page");
		prop = new Properties();
		try {
			ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\utils\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(ip);
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.get(prop.getProperty("url"));


	}
}


