package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.Utility;
import Config.Configuration;
import Core.testCore;
import ErrorCollectors.ErrorCollector;
import Pages.Facebooklogin;
import Pages.Facebookprofile;
public class LoginTest {


	@BeforeTest
	
	public void checkrunmode(){
		
		if(!Utility.isExecutable("LoginTest",testCore.excel))
			throw new SkipException("Skipping the test");
		
	}
	
	
		@Test(dataProvider = "getdata")
	public void sampletest(String username, String password){
			
			try{
		WebDriver driver = new FirefoxDriver();
		driver.get(Configuration.testsite);
		Facebooklogin login = PageFactory.initElements(driver,Facebooklogin.class);
		Facebookprofile profile = login.login(username,password);
		profile.updateprofile();
			}
			catch(Exception t){
				ErrorCollector.addVerificationFailure(t);
			}
		}
		
		
		@DataProvider
		
		public Object[][] getdata(){
			
			
			
			return Utility.getData("LoginTest", testCore.excel);
			
		}
		
		
	}


