package framep;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestCombine extends BaseClass {
	
	/*
	@Test
	public void download() {
		driver.get("http://demo.guru99.com/test/yahoo.html");
		WebElement download= driver.findElement(By.linkText("Download Now"));
		String sourceLoacation=download.getAttribute("href");
		String Wget="cmd /c C:\\wget\\wget.exe -P E: --no-check-certificate"+sourceLoacation;
		try {
			Process exec = Runtime.getRuntime().exec(Wget);
			int exitVal = exec.waitFor();
			System.out.println("Exit Value is: "+exitVal);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		
	}
	
	@Test
	public void closeTab() {
		driver.get("https://the-internet.herokuapp.com/iframe");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Elemental Selenium")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iter = windows.iterator();
		String parent = iter.next();
		String child = iter.next();
		System.out.println(parent);
		driver.switchTo().window(child);
		System.out.println(driver.getCurrentUrl());
		driver.switchTo().window(parent);
		driver.switchTo().window(child);
		driver.close();
				
	}
	
	
	@Test
	public void tableTest() {
		
		driver.get("http://demo.guru99.com/test/web-table-element.php");
		List<WebElement> rows=driver.findElements(By.xpath("//tbody/tr"));
		System.out.println(rows.size());
		List<WebElement> cols=driver.findElements(By.xpath("//tbody/tr/td"));
		System.out.println(cols.size());
		List<WebElement> cols1=driver.findElements(By.xpath("//tbody/tr[1]/td"));
		System.out.println(cols1.size());
		//for (int i = 0; i < rows.size()*5; i++) {
			
			//System.out.println(cols.get(i).getText());
		
		//}
		
	}
	
	@Test
	public void maxCount() throws Exception {
		
		 driver.get("http://demo.guru99.com/test/web-table-element.php"); 
		 String max;
	     double m=0,r=0;
		 
	       //No. of Columns
	        List  col = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/thead/tr/th"));
	        System.out.println("Total No of columns are : " +col.size());
	        //No.of rows
	        List  rows = driver.findElements(By.xpath (".//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
	        System.out.println("Total No of rows are : " + rows.size());
	        for (int i =1;i<rows.size();i++)
	        {    
	            max= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr["+(i+1)+"]/td[4]")).getText();
	            NumberFormat f =NumberFormat.getNumberInstance(); 
	            Number num = f.parse(max);
	            max = num.toString();
	            m = Double.parseDouble(max);
	            if(m>r)
	             {    
	                r=m;
	             }
	        }
	        System.out.println("Maximum current price is : "+ r);
	        Thread.sleep(10000);
    }*/
	@Test
	public void toolTip() {
		driver.get("http://demo.guru99.com/test/social-icon.html");
		String expTip="Home";
		WebElement actTipElement= driver.findElement(By.xpath("//a[contains(text(),'Demo Site')]"));
		String actTip=actTipElement.getAttribute("title");
		if(actTip.equalsIgnoreCase(expTip)) {
			System.out.println("The tooltip text is: "+actTip);
		}
	}
	

}
