package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import config.DataFile;
import pages.BestSellerPage;
import pages.HomePage;

public class BestSellerPageTest extends TestBase {

	public BestSellerPageTest() {
		super();
	}
	
	DataFile df;
	BestSellerPage bs;
	HomePage hp;

	@BeforeMethod
	public void beforeMethod() {
		initialize();
		driver.get(prop.getProperty("homepageUrl"));
		
		hp = new HomePage();
		hp.BestSellerButton.click();
		bs = new BestSellerPage();
		df = new DataFile();

	}

	@AfterMethod
	public void afterMethod() {

	
		TestBase.closeBrowser();

	}

	@Test
	public void verifyBestSellerTitleTest() {
		
		String actualTitle = bs.verifyTitle();
		String expectedTitle = df.getBestSellerPageTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}

    @Test
	public void verifyDealTabTest() {
		
		Assert.assertEquals(bs.verifyDealsTab(), true);

	}

	@Test
	public void verifyBannerTest() {
		
		Assert.assertEquals(bs.verifyBanner(), true);
	}

}
