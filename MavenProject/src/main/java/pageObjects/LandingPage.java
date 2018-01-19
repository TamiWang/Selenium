package pageObjects;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage{
	public WebDriver driver;
	
	public LandingPage(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement getTitle(){
		return driver.findElement(By.xpath("//div[@id='lg']/map/area"));
	}
}
