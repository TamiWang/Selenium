package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementGCPI {
	
	public static WebElement loginText(WebDriver driver){
		return driver.findElement(By.xpath("//p[@class='container-section-p']"));
	}
	
	public static WebElement usernameBox(WebDriver driver){
		////img[contains(@alt,'g1')]
		return driver.findElement(By.xpath("//input[contains(@class,'container-section-inputOne container-section-input')]"));
	}
	
	public static WebElement passwordBox(WebDriver driver){
		return driver.findElement(By.xpath("//input[contains(@class,'container-section-inputTwo container-section-input')]"));
	}
	
	public static WebElement loginButton(WebDriver driver){
		return driver.findElement(By.xpath("//div[@ng-click='fn_login()']"));
	}
	
	public static WebElement alertText(WebDriver driver){
		return driver.findElement(By.xpath("//li[@ng-bind='alertTxt']"));
	}
	
	public static WebElement logoutButton(WebDriver driver){
		return driver.findElement(By.xpath("//span[@title='退出当前账号']"));
	}
	
	public static WebElement basicConfigButton(WebDriver driver){
		return driver.findElement(By.xpath("//div[@id='id_basicManager_div']"));
	}
	
	public static WebElement factoryTypeButton(WebDriver driver){
		return driver.findElement(By.xpath("//li[@id='factoryTypeId']"));
	}
	
	public static WebElement createFactoryTypeButton(WebDriver driver){
		return driver.findElement(By.xpath("//span[@id='id_addNew']"));
	}
	
	public static WebElement factoryTypeNameBox(WebDriver driver){
		return driver.findElement(By.xpath("//input[@id='form-field-8']"));
	}
	
	public static WebElement factoryDefaultPhotoButton(WebDriver driver){
		return driver.findElement(By.xpath("//input[@id='use_default_photo']"));
	}
	
	public static WebElement factoryDescriptionBox(WebDriver driver){
		return driver.findElement(By.xpath("//*[@id='form-field-9']"));
	}
	
	public static WebElement factoryCreateConfirmButton(WebDriver driver){
		return driver.findElement(By.xpath("//span[@class='public_confirm_btn']"));
	}
	
	public static WebElement AlertButton(WebDriver driver){
		return driver.findElement(By.xpath("//ul[@ng-show='btnShowNum == 1']/li/span[@ng-click='var_common_close()']"));
	}
	
	public static WebElement factoryTypeModifyButton(WebDriver driver){
		return driver.findElement(By.xpath("//tbody/tr[1]/td[@class='center']/a/img"));
	}
	
	public static WebElement factoryTypeModifyButton2(WebDriver driver){
		return driver.findElement(By.xpath("//tbody/tr[2]/td[@class='center']/a/img"));
	}
	
	public static WebElement factoryTypeModifyNameBox(WebDriver driver){
		return driver.findElement(By.xpath("//input[@id='form-field-1']"));
	}

	public static WebElement factoryTypeModifyTextBox(WebDriver driver){
		return driver.findElement(By.xpath("//*[@id='form-field-9']"));
	}
	
	public static WebElement factoryTypeModifyConfirmButton(WebDriver driver){
		return driver.findElement(By.xpath("//*[@class='public_confirm_btn']"));
	}
	
	public static WebElement factoryTypeDeleteButton(WebDriver driver){
		return driver.findElement(By.xpath("//tbody/tr[1]/td[@class='center']/img"));
	}
	
	public static WebElement factoryConfigButton(WebDriver driver){
		return driver.findElement(By.xpath("//li[@id='plantFactoryId']"));
	}
	
	public static WebElement factoryCreateButton(WebDriver driver){
		return driver.findElement(By.xpath("//*[@id='id_addNew']"));
	}
	
	public static WebElement factoryCreateNameBox(WebDriver driver){
		return driver.findElement(By.xpath("//*[@id='form-field-1']"));
	}
	
	public static void factoryTypeDropdown(WebDriver driver, int index){
		Select s = new Select(driver.findElement(By.xpath("//div[@class='widget-main']/div[1]/div[2]/select")));
		s.selectByIndex(index);

	}
	
	public static void factoryZoneDropdown(WebDriver driver, int index){
		Select s = new Select(driver.findElement(By.xpath("//div[@class='widget-main']/div[2]/select")));
		s.selectByIndex(index);

	}
	
	public static WebElement factoryLeftXBox(WebDriver driver){
		return driver.findElement(By.xpath("//*[@id='form-field-171']"));
	}
	
	public static WebElement factoryLeftYBox(WebDriver driver){
		return driver.findElement(By.xpath("//*[@id='form-field-11']"));
	}
	
	public static WebElement factoryWidthBox(WebDriver driver){
		return driver.findElement(By.xpath("//*[@id='form-field-1171']"));
	}
	
	public static WebElement factoryHeightBox(WebDriver driver){
		return driver.findElement(By.xpath("//*[@id='form-field-1111']"));
	}
	
	public static WebElement factorySampleTimeBox(WebDriver driver){
		return driver.findElement(By.xpath("//div[@id='allow_drag_move_id_addFactory']/div/div[5]/div/input"));
	}
	
	public static void factoryUnitDropdown(WebDriver driver, int index){
		Select s = new Select(driver.findElement(By.xpath("//div[@class='widget-main']/div[5]/div[2]/select")));
		s.selectByIndex(index);
	}
	
	
}
