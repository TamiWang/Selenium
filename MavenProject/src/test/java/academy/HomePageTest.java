package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import resources.Base;

public class HomePageTest extends Base{
	
	public static Logger logger = LogManager.getLogger(Base.class.getName());
	
	//@Test
	public void basePage() throws IOException{
		driver = initDriverBase();
		driver.get("http://www.baidu.com");
		//driver.findElement(By.id("aaa")).click();
		logger.info("home page");
	}
	
	//@AfterClass
	//@AfterTest
	public void teadDown(){
		driver.quit();
		logger.info("home page quit");
	}
	

}
