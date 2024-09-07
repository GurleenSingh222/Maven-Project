package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase {
	
	public LoginPage(){
		super(); //if base class constructor is not being initialized.
		PageFactory.initElements(driver, this);
		//driver.get(prop.getProperty("url"));
	}
	
	@FindBy(id = "ap_email")
	public WebElement username;
	
	@FindBy(xpath = "//input[@id='continue']")
	public WebElement continueButton;
	
	@FindBy(xpath = "(//div[@class='a-alert-content'])[4]")
	public WebElement UsernameErr;
	
	@FindBy(xpath = "(//*[@class='a-list-item'])[1]")
	public WebElement UsernameErr2;
	
	@FindBy(id = "ap_password")
	public WebElement password;
	
	@FindBy(id="signInSubmit")
	WebElement signinbutton;
	
	
	
	@FindBy(xpath = "//*[@class='a-list-item']")
	WebElement passwordErr;
	
	public void wrongUsername(String a) {
		
		username.sendKeys(a);
		continueButton.click();
		
	}
	
	public String readErr() {
		
		return UsernameErr.getText();
		
	}
	
	public void correctUsername() {
		username.sendKeys(prop.getProperty("correctEmail"));
		continueButton.click();
	}
	
	public void wrongPassword() {
		password.sendKeys(prop.getProperty("incorrectPassword"));
		signinbutton.click();
	}
	
	public String passwordErr() {
		
		String err = passwordErr.getText();
		return err;
		
	}
	
	public void correctPassword() {
		password.sendKeys(prop.getProperty("correctPassword"));
	    signinbutton.click();
	}
}
