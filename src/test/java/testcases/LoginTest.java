package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import config.DataFile;
import org.testng.Assert;
import pages.LoginPage;

public class LoginTest extends TestBase {
	
	LoginPage lp;
	DataFile df;
	
	public LoginTest() {
		super();
	}
	
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  initialize();
	  driver.get(prop.getProperty("url"));
	  lp = new LoginPage();
	  df = new DataFile();
  }

  @AfterMethod
  public void afterMethod() {
	  
	  TestBase.closeBrowser();
	  
  }
  
  @Test(priority = 1)
  public void loginWithWrongUsername() {
	  
	  lp.wrongUsername("dncdjnjdd");
	  String actualErr = lp.readErr();
	  String expectedErr = df.getUsernameErr();
	  Assert.assertEquals(expectedErr, actualErr);
	  
  }
  
  //@Test(priority = 2) //Failing because of captcha
  public void loginWithWrongPassword() {
	  lp.correctUsername();
	  lp.wrongPassword();
	  String actualErr = lp.passwordErr();
	  System.out.println(actualErr);
	  String expectedErr = df.getPasswordErr();
	  Assert.assertEquals(expectedErr, actualErr);
  }
  
  //@Test  //Failing because of captcha
  public void correctCredentials() {
	  lp.correctUsername();
	  lp.correctPassword();
	  String actualTitle = driver.getTitle();
	  String expectedTitle = df.gethomepageTitle();
	  Assert.assertEquals(expectedTitle, actualTitle);
  }

}
