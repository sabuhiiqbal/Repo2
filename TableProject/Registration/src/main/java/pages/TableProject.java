package pages;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableProject {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		//WebDriverManager.chromeDriver.setup();
		driver = new ChromeDriver();
		driver.get("https://colorlib.com/etc/tb/Table_Fixed_Header/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(500,TimeUnit.MILLISECONDS);
		Set<Object> st = new HashSet<Object>();
		List<WebElement> table = driver.findElements(By.xpath("/html/body/div/div/div/div[1]/div[1]/table/thead/tr"));
		for(WebElement temp :table) {
			System.out.println("The Header of the table is " + temp.getText());
		}

		List<WebElement> tableBody = driver.findElements(By.xpath("/html/body/div/div/div/div[1]/div[2]/table/tbody"));
		System.out.println(tableBody.size());
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//sjs.executeScript("window.scrollBy(0,1000)");
		Actions action = new Actions(driver);
		WebElement scrollBar =driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div[2]/div"));
		
		//action.moveToElement(scrollBar, 50, 50).build();
		action.moveToElement(scrollBar).clickAndHold().moveByOffset(0, 150).release().perform();
		action.perform();

		
		List<TrainingClass> trainingClasses = new ArrayList<TrainingClass>();

		WebElement bodyElement = tableBody.get(0);
		List<WebElement> tableRows = bodyElement.findElements(By.xpath("tr"));
		int  rowCount = tableRows.size();
		System.out.println("The number of row Available on WebPage"+rowCount);
		Set<String> classNames = new HashSet<String>();
		int counter=0;
		for(WebElement tempRow :tableRows ){
			TrainingClass trainingclass = new TrainingClass();

			List<WebElement> columns = tempRow.findElements(By.xpath("td"));
			if(columns.get(0).getText().trim().length() ==0 ) {
				System.out.println("no data in table counter=" + counter++);
				continue;
			}
			counter++;
			trainingclass.setClassName(columns.get(0).getText());
			trainingclass.setType(columns.get(1).getText());
			trainingclass.setHours(columns.get(2).getText());
			trainingclass.setTrainer(columns.get(3).getText());
			trainingclass.setSpots(columns.get(4).getText());
			trainingClasses.add(trainingclass);
			if(classNames.contains(trainingclass.getClassName())) {
				System.out.println("duplicate class found=" + trainingclass.getClassName());
			}else {
				classNames.add(trainingclass.getClassName());
			}
			System.out.println("training class read = " + trainingclass);
		}
	}

}
