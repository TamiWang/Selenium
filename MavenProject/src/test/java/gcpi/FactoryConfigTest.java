package gcpi;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageAction.PageAction;
import pageObjects.ElementGCPI;
import resources.Base;



public class FactoryConfigTest extends Base{

	@BeforeClass
	public void setUp() throws Exception{
		// navigate to url
		driver = initDriverBase();
		driver.get(prop.getProperty("url"));
		// login
		PageAction.login(driver, prop.getProperty("username"), prop.getProperty("password"));
		
		Thread.sleep(2000);
		driver.manage().window().maximize();
		ElementGCPI.basicConfigButton(driver).click();
		Thread.sleep(2000);
		ElementGCPI.factoryConfigButton(driver).click();
		Thread.sleep(2000);
	}
	
	@Test
	public void createFactoryConfigTest() throws IOException, InterruptedException{
		
		ArrayList<String[]> csvList = readCSVFile(prop.getProperty("csvfilePath"));
		
		for(int row=0; row<csvList.size(); row++){
			
			ElementGCPI.factoryCreateButton(driver).click();
			
			// Read CSV file 
			// Refer to 虫师    “6.3.3 读取csv 文件”
			ElementGCPI.factoryCreateNameBox(driver).sendKeys(csvList.get(row)[0]);
			// String -> int : int i = Integer.parseInt(str)
			ElementGCPI.factoryTypeDropdown(driver, Integer.parseInt(csvList.get(row)[1]));
			ElementGCPI.factoryZoneDropdown(driver, Integer.parseInt(csvList.get(row)[2]));
			ElementGCPI.factoryLeftXBox(driver).sendKeys(csvList.get(row)[3]);
			ElementGCPI.factoryLeftYBox(driver).sendKeys(csvList.get(row)[4]);
			ElementGCPI.factoryWidthBox(driver).sendKeys(csvList.get(row)[5]);
			ElementGCPI.factoryHeightBox(driver).sendKeys(csvList.get(row)[6]);
			ElementGCPI.factorySampleTimeBox(driver).sendKeys(csvList.get(row)[7]);
			ElementGCPI.factoryUnitDropdown(driver, Integer.parseInt(csvList.get(row)[8]));
			ElementGCPI.factoryCreateConfirmButton(driver).click();
			Thread.sleep(2000);
			ElementGCPI.AlertButton(driver).click();
			Thread.sleep(2000);
			logger.info("------row:"+ row + "---------");

			int count = driver.findElements(By.xpath("html/body/div[5]/div/div/div/div/div[2]/table/tbody/tr")).size();
			String element = "";
			for(int i=0; i<count-1; i++){
				element = driver.findElements(By.xpath("html/body/div[5]/div/div/div/div/div[2]/table/tbody/tr/td[2]")).get(i).getText();
				logger.info("-------element---" + element);
				logger.info("-----csvList.get(row)[1]:" + csvList.get(row)[0]);
				if(element.equals(csvList.get(row)[0])){
					break;
				}
			}
				
			String expectedText = csvList.get(row)[0];
			Assert.assertEquals(element, expectedText);
		}

	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}

