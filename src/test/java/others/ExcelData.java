package others;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterClass;

public class ExcelData {
  @Test
  public void readData() throws IOException {
	  File file = new File(System.getProperty("user.dir")+"\\Data Files\\UserFields.xlsx");
	  System.out.println(file.getName());
	  String filename= file.getName();
	  String ext= filename.substring(filename.indexOf("."));
	  System.out.println(ext);
	 
	  FileInputStream ip=new FileInputStream(file);
	  XSSFWorkbook wb=new XSSFWorkbook(ip);
	  XSSFSheet sheet=wb.getSheet("Passenger");
	  int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
	  XSSFSheet sheet11=wb.getSheet("Sheet2");
	  
	  
	  for(int i=0;i<=rowCount;i++)
	  {
		  int cellCount=sheet.getRow(i).getLastCellNum();
		  
		  for(int j=0;j<cellCount;j++) {
			  
			  System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+"--");
			  Row row=sheet11.createRow(i);
			  row.createCell(0).setCellValue(sheet.getRow(i).getCell(0).getStringCellValue());
			  row.createCell(1).setCellValue(sheet.getRow(i).getCell(1).getStringCellValue());
			  row.createCell(2).setCellValue(sheet.getRow(i).getCell(2).getStringCellValue());
			  row.createCell(3).setCellValue(sheet.getRow(i).getCell(3).getStringCellValue());
			  
		  }
		  System.out.println();
	  }
	  FileOutputStream op=new FileOutputStream(System.getProperty("user.dir")+"\\Data Files\\UserFields.xlsx");
	  wb.write(op);
	  wb.close();
	  
  }
  
  @Test(enabled = false)
  public void writeData() throws IOException {
	  File file=new File(System.getProperty("user.dir")+"\\Data Files\\UserFields.xlsx");
	  FileInputStream ip1=new FileInputStream(file);
	  XSSFWorkbook wb1=new XSSFWorkbook(ip1);
	  XSSFSheet sheet11=wb1.getSheet("Sheet2");
	  
	  Row row5=sheet11.createRow(0);
	  row5.createCell(0).setCellValue("Saravanan");
	  row5.createCell(1).setCellValue("9524435162");
	  row5.createCell(2).setCellValue("jsarans92@gmail.com");
	  row5.createCell(3).setCellValue("Route 1 Pickup");
	  
	  FileOutputStream op=new FileOutputStream(System.getProperty("user.dir")+"\\Data Files\\UserFields.xlsx");
	  wb1.write(op);
	  wb1.close();
  }
  
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
