package testcases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import config.DataFile;
import pages.HomePage;

public class HomepageTest extends TestBase {

	HomePage hp;
	DataFile df;
	public HomepageTest() {
		super();
	}

	@BeforeMethod
	public void beforeMethod() {
        initialize();
		driver.get(prop.getProperty("homepageUrl"));
		hp =new HomePage();
		df = new DataFile();

	}

	@AfterMethod
	public void afterMethod() {

		closeBrowser();
	}

	@Test
	public void verifyTitleTest() {

		String actualTitle = driver.getTitle();
		String expectedTitle = df.gethomepageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test // user should be able to see valid placeholder for searchtab
	public void verifyPlaceholderTest() {

		String actualph = hp.verifySearchPlaceholder();
		String expectedph = df.getSearchPlaceholder();
		Assert.assertEquals(actualph, expectedph);
	}

	@Test // when user click on home button to navigate back to homepage
	public void verifyHomebuttonTest() {

		hp.homeButton.click();
		String actualTitle = driver.getTitle();
		String expectedTitle = df.gethomepageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	// @Test//user should be able to see different cards with different headings
	public void verifyCard1HeadingsTest() {

		ArrayList<String> actualHeadings = hp.verifycard1Headings();
		ArrayList<String> expectedHeadings = df.gethomepagecard1Headings();
		Assert.assertEquals(actualHeadings, expectedHeadings);
	}

	@Test // when user visits homepage/ categories tab should be visible
	public void verifyCategoryTabTest() {
		Assert.assertEquals(hp.verifyCategoriesTab(), true);
	}

	@Test // user should able to see the address tab on homepage
	public void verifyAddressTabTest() {
		Assert.assertEquals(hp.verifyAddressTab(), true);
	}

	//@Test // After clicking on update location, new popup should appear with update
			// location heading.
	public void verifyUpdateAddressLinkTest() {
		Assert.assertEquals(hp.verifyUpdateLocation(), true);
	}

	@Test // After clicking on Best Seller, user should land on best seller page
	public void verifyBestSellerTest() {
		// BestSellerPage bs = hp.verifybestSellerLink();
		// String actualTitle = bs.verifyTitle();
		String actualTitle = hp.verifybestSellerLink();
		String expectedTitle = df.getBestSellerPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

}
