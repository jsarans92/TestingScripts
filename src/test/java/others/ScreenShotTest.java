package others;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class ScreenShotTest {
	WebDriver driver;
	
  @Test
  public void f() throws IOException {
	  driver.get("https://demoqa.com");
	  
	  File scrshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  File destination=new File(System.getProperty("user.dir")+"\\Data Files\\HomePagePartial.jpg");
	  File destination1=new File(System.getProperty("user.dir")+"\\Data Files\\HomePageFull.jpg");
	  FileUtils.copyFile(scrshot,destination );
	  
	  Screenshot s=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
	  ImageIO.write(s.getImage(), "jpg", destination1);
	  
	  WebElement form=driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/a[1]/img[1]"));
	  File formscr=form.getScreenshotAs(OutputType.FILE);
	  File destination2=new File(System.getProperty("user.dir")+"\\Data Files\\FormElement.jpg");
	  FileUtils.copyFile(formscr, destination2);
  }
  
  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
