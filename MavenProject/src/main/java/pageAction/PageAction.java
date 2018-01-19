package pageAction;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pageObjects.ElementGCPI;
import resources.Base;

public class PageAction extends Base{
	
	public static void login(WebDriver driver, String username, String password) throws Exception{
		ElementGCPI.usernameBox(driver).clear();
		ElementGCPI.usernameBox(driver).sendKeys(username);
		ElementGCPI.passwordBox(driver).clear();
		ElementGCPI.passwordBox(driver).sendKeys(password);
		ElementGCPI.loginButton(driver).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public static void logout(WebDriver driver){
		ElementGCPI.logoutButton(driver).click();
		//String text = ElementGCPI.loginText(driver).getText();
		//Assert.assertEquals(text, "你好，请登录");
	}
	
	public static void createFactoryType(WebDriver driver, String factoryTypeName) throws InterruptedException{
		ElementGCPI.createFactoryTypeButton(driver).click();
		ElementGCPI.factoryTypeNameBox(driver).sendKeys(factoryTypeName);
		ElementGCPI.factoryDefaultPhotoButton(driver).click();
		ElementGCPI.factoryCreateConfirmButton(driver).click();
		Thread.sleep(2000);
		ElementGCPI.AlertButton(driver).click();
		Thread.sleep(2000);
	}
	
	public static void modifyFactoryType(WebDriver driver, String factoryTypeName, String text) throws Exception{
		ElementGCPI.factoryTypeModifyButton(driver).click();
		ElementGCPI.factoryTypeModifyNameBox(driver).clear();
		ElementGCPI.factoryTypeModifyNameBox(driver).sendKeys(factoryTypeName);
		ElementGCPI.factoryTypeModifyTextBox(driver).clear();
		ElementGCPI.factoryTypeModifyTextBox(driver).sendKeys(text);
		Thread.sleep(2000);
		//driver.manage().window().maximize();
		//将页面滚动条拖到底部
		//((JavascriptExecutor)driver).executeScript("window.scrollTo(100,450);");
		ElementGCPI.factoryTypeModifyConfirmButton(driver).click();
		Thread.sleep(2000);
		ElementGCPI.AlertButton(driver).click();
		Thread.sleep(2000);
	}
	
	public static void modifyFactoryType2(WebDriver driver, String factoryTypeName, String text) throws Exception{
		ElementGCPI.factoryTypeModifyButton2(driver).click();
		ElementGCPI.factoryTypeModifyNameBox(driver).clear();
		ElementGCPI.factoryTypeModifyNameBox(driver).sendKeys(factoryTypeName);
		ElementGCPI.factoryTypeModifyTextBox(driver).clear();
		ElementGCPI.factoryTypeModifyTextBox(driver).sendKeys(text);
		Thread.sleep(2000);
		//driver.manage().window().maximize();
		//将页面滚动条拖到底部
		//((JavascriptExecutor)driver).executeScript("window.scrollTo(100,450);");
		ElementGCPI.factoryTypeModifyConfirmButton(driver).click();
		Thread.sleep(2000);
		ElementGCPI.AlertButton(driver).click();
		Thread.sleep(2000);
	}
	
	public static void deleteFactoryType(WebDriver driver) throws Exception{
		
		int count = driver.findElements(By.xpath("//div[@class='panel-body']/table/tbody/tr")).size();
		logger.info("==============count:" + count + "=================");
		for(int i=1; i<count-2; i++){
			driver.findElement(By.xpath("//div[@class='panel-body']/table/tbody/tr["+i+"]/td[8]/img")).click();
			//Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@ng-click='confirmBtn_fn()']")).click();
			Thread.sleep(2000);
			ElementGCPI.AlertButton(driver).click();
			Thread.sleep(2000);
			
		}
	}
	


}
