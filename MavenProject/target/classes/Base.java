package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.csvreader.CsvReader;



public class Base{
	
	public static WebDriver driver;
	public static Properties prop;
	public static Logger logger = LogManager.getLogger(Base.class.getName());
	public static FileInputStream fis;
	
	static {
		prop = new Properties();
		try {
			fis = new FileInputStream("E:\\selenium\\mavenRepo\\MavenProject\\src\\main\\java\\resources\\data.properties");
	        prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public WebDriver initDriverBase() throws IOException{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("E:\\selenium\\mavenRepo\\MavenProject\\src\\main\\java\\resources\\data.properties");
        prop.load(fis);
        
        String browserName = prop.getProperty("browser");
        System.out.println("browser name :" + browserName);
        
        if(browserName.contains("chrome")){
    		System.setProperty("webdriver.chrome.driver", System.getProperties().getProperty("user.dir")+"\\chromedriver.exe");  
    		driver = new ChromeDriver();
        }
        else if(browserName.contains("firefox")){
        	driver = new FirefoxDriver();
        }
        else{
        	driver = new InternetExplorerDriver();
        }
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
        return driver;
	}
	
	public void getScreenShotBase(String result) throws IOException{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E://selenium//mavenRepo//ScreenShot//" + result + "screenshot.png"));
		
	}
	
	public ArrayList<String[]> readCSVFile(String filePath) throws IOException{
		// ArrayList 用来保存数据
		ArrayList<String[]> csvList = new ArrayList<String[]>();
		// �?��用这编码读就可以�?
		CsvReader reader = new CsvReader(filePath, ',', Charset.forName("SJIS"));
		// 跳过表头，如果需要表头，不要写这�?
		reader.readHeaders();
		
		while(reader.readRecord()){  // 逐行读入除表头的数据
			csvList.add(reader.getValues());
		}
		
		reader.close();
		
		for(int row=0; row<csvList.size(); row++){
			System.out.println(csvList.get(row)[0]);
			System.out.println(csvList.get(row)[1]);
			System.out.println(csvList.get(row)[2]);
			System.out.println(csvList.get(row)[3]);
			System.out.println(csvList.get(row)[4]);
			System.out.println(csvList.get(row)[5]);
			System.out.println(csvList.get(row)[6]);
			System.out.println(csvList.get(row)[7]);
			System.out.println(csvList.get(row)[8]);
			System.out.println("---------------------------");
		}	
		
		return csvList;
	}
}
