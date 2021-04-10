package framep;

import java.awt.List;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_001 {

	WebDriver driver;
	
	@Test
	public void frameHl() throws InterruptedException {

		//Initializing Driver
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//Opening URL
		//driver.navigate().to("https://the-internet.herokuapp.com/ ");
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
		//Click on ‘Frames’ hyperlink available in the page 
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[22]/a")).click();
		
		//Check if the new page header has ‘Frames’ wording 
		String headtext="Frames";
		WebElement frameHead= driver.findElement(By.xpath("//h3[contains(text(),'Frames')]"));
		System.out.println(frameHead.getText());
		if(frameHead.getText().equalsIgnoreCase(headtext)) {
			System.out.println("The new Page contains the word "+frameHead.getText());
		}else {
			System.out.println("The Frames page header doesn't match");
		}
	
		//Click on iFrame link & check if we navigated to next page 
		driver.findElement(By.xpath("//a[contains(text(),'iFrame')]")).click();
		Thread.sleep(2000);
		
		//Check if the page header has text ‘TinyMCE’ in it 
		String pagehead="TinyMCE";
		WebElement iframehHead= driver.findElement(By.xpath("//h3[contains(text(),'An iFrame containing the TinyMCE WYSIWYG Editor')]"));
		String ifheadText=iframehHead.getText();
		if(ifheadText.contains(pagehead)) {
			System.out.println("Page header has text ‘TinyMCE’ in it");
		}else {
			System.out.println("The iFrames page header doesn't match");
		}
		
		//Check if the page has parent menu items as File, Edit, View, Format 
		System.out.println("The page has the below menu items perfectly");
		java.util.List<WebElement> menuBar=driver.findElements(By.className("tox-menubar"));
				
				for (int i=0;i<menuBar.size();i++ ) {
			System.out.println(menuBar.get(i).getText());
		}

		//Click on the text field and remove ‘Your content goes here.’ text 
		driver.switchTo().frame("mce_0_ifr");
		WebElement textField=driver.findElement(By.xpath("//p[contains(text(),'Your content goes here.')]"));
		textField.clear();
		
		//Enter text as ‘Test’ & select the entire text, go to Format – Formats – Headings – Heading 1 
		textField.sendKeys("Test");

		Actions action = new Actions(driver);
		action.doubleClick(textField).build().perform();

		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//span[contains(text(),'Format')]")).click();

		action.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Formats')]"))).build().perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Headings')]"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h1[contains(text(),'Heading 1')]")).click();

		Thread.sleep(2000);
		
		//Click on Elemental Selenium link at the bottom of the page 
		driver.findElement(By.xpath("//a[contains(text(),'Elemental Selenium')]")).click();

		Thread.sleep(3000);
		
		//Check if the user is taken to new tab in the same browser with link - http://elementalselenium.com/ 
		
		if(driver.getCurrentUrl()=="http://elementalselenium.com/"){

			System.out.println("We redirected to Right Page");
		}else {
			System.out.println("The page url is not matching");

		}
		
		//Navigate back to https://the-internet.herokuapp.com/iframe tab & close the tab with http://elementalselenium.com/ 
		Thread.sleep(3000);
		
		
		String handle=driver.getWindowHandle();
		driver.switchTo().window(handle);
		//driver.navigate().back();
		Thread.sleep(2000);
	
		Set windows = driver.getWindowHandles();
		Iterator iter = windows.iterator();
		String parent=(String) iter.next();
		String child=(String) iter.next();
		System.out.println();
		
		driver.switchTo().window(child);
		driver.close();
		Thread.sleep(4000);

		driver.quit();



	}

}
