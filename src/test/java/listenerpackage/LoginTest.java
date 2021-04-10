package listenerpackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
//import listenerpackage.*;

@Listeners(listenerpackage.ListenerTest.class)
public class LoginTest {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

	}


	@Test
	public void login() {
		driver.get("http://demo.guru99.com/V4/");					
		driver.findElement(By.name("uid")).sendKeys("mngr34926");							
		driver.findElement(By.name("password")).sendKeys("amUpenu");							
		driver.findElement(By.xpath("//tbody/tr[3]/td[2]/input[1]")).click();
	}

	@Test
	private void testToFail() {
		// TODO Auto-generated method stub
		System.out.println("This method to test fail");
		AssertJUnit.assertTrue(false);

	}


	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
