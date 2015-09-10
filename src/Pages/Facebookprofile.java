package Pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Config.Configuration;
import Core.testCore;

public class Facebookprofile {
	
	public WebDriver driver;
	public Facebookprofile(WebDriver driver){
		this.driver=driver;
	}
	
	@FindBy(xpath=Configuration.profilelink)
	public WebElement profilelink;

	@FindBy(xpath=Configuration.updateprofilelink)
	public WebElement updateprofilelink;
	
	
	@FindBy(linkText=Configuration.closelink)
	public WebElement closelink;
	
	public void updateprofile() throws InterruptedException{
	
		profilelink.click();
		Thread.sleep(2000L);
		updateprofilelink.click();
		Thread.sleep(2000L);
		closelink.click();
	}

	

}
