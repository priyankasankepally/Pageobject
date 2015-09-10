package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Config.Configuration;

public class Facebooklogin {
	
	public WebDriver driver;
	public Facebooklogin(WebDriver driver){
		this.driver=driver;
	}
	
	
	@FindBy(xpath=Configuration.username)
	public WebElement username1;
	
	@FindBy(xpath=Configuration.password)
	public WebElement password1;
	
	
	@FindBy(xpath=Configuration.login)
	public WebElement login;
	
	
	public Facebookprofile login(String username, String password){
		
		username1.sendKeys(username);
		password1.sendKeys(password);
		login.click();
		return PageFactory.initElements(driver,Facebookprofile.class);
		
	}
	

}
