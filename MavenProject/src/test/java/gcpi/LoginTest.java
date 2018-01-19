package gcpi;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ElementGCPI;

import com.gargoylesoftware.htmlunit.javascript.host.Element;

import resources.Base;

public class LoginTest extends Base{
	
	//public static Logger logger = LogManager.getLogger(Base.class.getName());
	
	@BeforeMethod
	public void init() throws IOException{
		driver = initDriverBase();
		driver.get(prop.getProperty("url2"));
		logger.info("open browser");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void loginTextAssert(){
		String loginText = ElementGCPI.loginText(driver).getText();
		logger.info("assert login text");
		Assert.assertEquals(loginText, "你好，请登录");
	}
	
	
	@Test
	public void login() throws InterruptedException{
		ElementGCPI.usernameBox(driver).clear();
		ElementGCPI.usernameBox(driver).sendKeys(prop.getProperty("username"));
		ElementGCPI.passwordBox(driver).clear();
		ElementGCPI.passwordBox(driver).sendKeys(prop.getProperty("password"));
		ElementGCPI.loginButton(driver).click();
		
		Thread.sleep(2000);
		ElementGCPI.logoutButton(driver).click();
		Thread.sleep(2000);
		String text = ElementGCPI.loginText(driver).getText();
		Assert.assertEquals(text, "你好，请登录");
	}
	
	@DataProvider
	public Object[][] getErrorData(){
		return new Object[][]{
				{"", "", "请输入用户名！"},
				{"aa", "", "请输入密码！"},
				{"error", "error", "用户名或密码错误，请重新输入！"},
		};
	}
	
	@Test(dataProvider="getErrorData")
	public void loginError(String username, String password, String text) throws InterruptedException{
		ElementGCPI.usernameBox(driver).sendKeys(username);
		ElementGCPI.passwordBox(driver).sendKeys(password);
		ElementGCPI.loginButton(driver).click();
		Thread.sleep(2000);
		
		String actualText = ElementGCPI.alertText(driver).getText();
		Assert.assertEquals(actualText, text);
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		logger.info("driver quit");
	}
	

}
