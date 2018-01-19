package academy;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateTitle extends Base{
	
	public static Logger logger = LogManager.getLogger(Base.class.getName());
	
	//@BeforeTest
	public void initialize() throws IOException{
		driver = initDriverBase();
		logger.info("Driver is initialized");
		driver.get(prop.getProperty("url1"));
		logger.info("Navigated to Home page");
	}
	
	//@Test
	public void basePageNavigation(){
		LandingPage lp = new LandingPage(driver);
		boolean flag = lp.getTitle().isDisplayed();
		Assert.assertTrue(flag);
		logger.info("Successfully validated Text message");
	}
	
	//@AfterClass
	//@AfterTest
	public void tearDown(){
		driver.quit();
		logger.info("Driver quit");
	}

}
