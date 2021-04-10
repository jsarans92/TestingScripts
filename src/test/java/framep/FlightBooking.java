package framep;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FlightBooking extends BaseClass {
	@Test
	public void flightLowCost() {
		driver.manage().window().maximize();
		driver.get("https://blazedemo.com/");
		
		driver.findElement(By.tagName("input")).click();
		
		List<WebElement> cols=driver.findElements(By.tagName("td"));
		for(int i=0;i<cols.size();i++) {
			//System.out.println(driver.findElement(By.xpath("//td[startswith(text(),'$')]")).getText());
			//if(cols.contains('$')) {
			System.out.println(cols.get(i).getText());
			
			
		}
		
	}

}
