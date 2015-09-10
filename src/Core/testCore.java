package Core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import utils.excel_reader;
import Config.Configuration;

public class testCore {
	
	public static Properties config = new Properties();
	
	public static WebDriver driver = null;
	
	public static final excel_reader excel = new excel_reader("C:\\Users\\ajay\\workspace\\Pageobjcetmodel\\src\\testdata\\testdata.xlsx");
	
	public static Logger app_logs = Logger.getLogger("devpinoyLogger");
	
	@BeforeSuite
	public static void init() throws IOException{
		
		if(driver==null){
			
			
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"src\\Config\\config.properties");
			config.load(fis);
			
			
			app_logs.debug("Excel file loaded");
			//Initialize the WebDriver
			if(config.getProperty("browser").equals("firefox")){
				driver.manage().timeouts().implicitlyWait(40L,TimeUnit.SECONDS);
			driver = new FirefoxDriver();
			app_logs.debug("Firefox driver initialized");
			
		}
		
		
	}
			
	
	}
	
	
	@AfterSuite
	public static void testQuitDriver() {
		
		//code for sending mails
		//testUtil.zip(System.getProperty("user.dir")+"\\screenshot");
		//mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, "Test Report", "Please find the attached report", TestConfig.reportPath, "Reports.zip");
		
		driver.quit();
		
		
	}
	
	
	public static Set<String> changewindow(){
		
		return driver.getWindowHandles();
	}
	

	}
