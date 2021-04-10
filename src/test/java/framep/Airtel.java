package framep;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Airtel {
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void broad() {
		driver.get("https://www.airtel.in/");
		Actions act = new Actions(driver);
		WebElement broadParent=driver.findElement(By.xpath("//h3[contains(text(),'BROADBAND')]"));
		//act.moveToElement(broadParent).build().perform();
		broadParent.click();
		
		List<WebElement> broadItems=driver.findElements(By.tagName("ul"));
		
		for(int i=1;i<4;i++) {
			System.out.println(driver.findElement(By.xpath("//header/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li["+i+"]/a[1]")).getText());
			//System.out.println(broadItems.get(i).getText());
		}
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		
	}

}
