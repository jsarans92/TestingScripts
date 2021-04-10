package others;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class DataProviderTest {
	WebDriver driver;
	@Test(enabled = false)
	@Parameters({"author","searchkey"})
	public void paraTest(String author,String searchkey) {

		driver.get("https://www.google.com/"); WebElement
		searchbox=driver.findElement(By.name("q")); searchbox.sendKeys(searchkey);
		System.out.println("Authour-> "+author+" Searchkey is -> "+searchkey);
		System.out.println("Value in the bos is "+searchbox.getAttribute("value")+"::: givenby="+searchkey);


	}
	@Test(dataProvider = "dp")
	public void dProvider(String author,String searchkey) {
		
		
		WebElement searchbox=driver.findElement(By.name("q")); 
		searchbox.sendKeys(searchkey);
		
		System.out.println("Authour-> "+author+" Searchkey is -> "+searchkey);
		System.out.println("Value in the bos is "+searchbox.getAttribute("value")+"::: givenby="+searchkey);
		searchbox.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@DataProvider(name="dp")
	public Object[][] dPmethod(){
		return new Object[][] {
			{"a","India"},{"b","England"},{"c","Australia"}
		};
		
	}

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.google.com/"); 
	}

	@AfterClass
	public void tearDown() {
	}

}
