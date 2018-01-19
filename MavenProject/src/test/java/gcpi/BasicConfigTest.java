package gcpi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.Page;

import pageAction.PageAction;
import pageObjects.ElementGCPI;
import resources.Base;


public class BasicConfigTest extends Base{
	
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
		ElementGCPI.factoryTypeButton(driver).click();
		Thread.sleep(2000);
		
	}
	
	//@BeforeMethod
	public void locateFactoryConfig(){
		ElementGCPI.basicConfigButton(driver).click();
		ElementGCPI.factoryTypeButton(driver).click();
	}
	
	@DataProvider
	public Object[][] getFactoryTypeName(){
		Object[][] data = new Object[3][1];
		data[0][0] = "奶油生菜工厂类型";
		data[1][0] = "蘑菇工厂类型";
		data[2][0] = "香菇工厂类型";
		
		return data;
	}
	
	@DataProvider
	public Object[][] getFactoryTypeModifyName(){
		Object[][] data = new Object[2][2];
		data[0][0] = "aaaFactoryType";
		data[0][1] = "aaa";
		data[1][0] = "bbbFactoryType";
		data[1][1] = "bbb";
		
		return data;
		
	}
	
	@DataProvider
	public Object[][] getFactoryTypeModifyName2(){
		Object[][] data = new Object[1][2];
		data[0][0] = "aaaFactoryType";
		data[0][1] = "aaa";
		
		return data;
		
	}
	
	@Test(priority = 1, dataProvider = "getFactoryTypeName")
	public void createFactoryType(String factoryTypeName) throws Exception{
		PageAction.createFactoryType(driver, factoryTypeName);
		// driver.findElements().size()
		int count = driver.findElements(By.xpath("//table[contains(@class,'table table-striped table-bordered table-hover')]/tbody/tr")).size();
		String element = "";
		for(int i=0; i<count; i++){
			element = driver.findElements(By.xpath("//table[contains(@class,'table table-striped table-bordered table-hover')]/tbody/tr/td[2]")).get(i).getText();

			if(element.equals(factoryTypeName)){
				logger.info("element" + element + "=== factoryTypeName:" + factoryTypeName);
				break;
			}
		}
		Assert.assertEquals(element, factoryTypeName);
	}
	
	@Test(priority = 2, dataProvider = "getFactoryTypeModifyName", dependsOnMethods = {"createFactoryType"})
	public void modifyFactoryType(String factoryTypeName, String text) throws Exception{
		driver.manage().window().maximize();
		PageAction.modifyFactoryType(driver, factoryTypeName, text);
		String name = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
		logger.info("======"+name+"==========="+factoryTypeName+"===========");
		Assert.assertEquals(name, factoryTypeName);
	}
	
	@Test(priority = 3, dataProvider = "getFactoryTypeModifyName2", dependsOnMethods = {"createFactoryType"})
	public void modifyFactoryType2(String factoryTypeName, String text) throws Exception{
		driver.manage().window().maximize();
		PageAction.modifyFactoryType2(driver, factoryTypeName, text);
		String name = driver.findElement(By.xpath("//tbody/tr[2]/td[2]")).getText();
		logger.info("======"+name+"==========="+factoryTypeName+"===========");
		Assert.assertEquals(name, factoryTypeName);
	}
	
	@Test(priority = 4, dependsOnMethods = {"createFactoryType"})
	public void deleteFactoryType() throws Exception{
		PageAction.deleteFactoryType(driver);
		logger.info("====deleted ============================");
	}
	
	@AfterClass
	public void tearDown() throws Exception{
		PageAction.logout(driver);
		driver.quit();
	}

}
