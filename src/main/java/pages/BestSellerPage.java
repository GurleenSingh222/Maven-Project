package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class BestSellerPage extends TestBase {



	public BestSellerPage() {

		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "nav-subnav")
	public WebElement dealsCategory;

	@FindBy(xpath = "//div[@class='_p13n-zg-banner-landing-page-header_style_zgLandingPageBannerTitleContainer__3pQqv']")
	public WebElement banner;

	@FindBy(id = "CardInstance_wURejQZK8XO37ghC8xvFw")
	public WebElement departmentList;

	@FindBy(id = "CardInstancepdGxccxO-56aKhHu1bEMOw")
	WebElement topCardInstance;

	public String verifyTitle() {

		String title = driver.getTitle();
		
		return title;
	}

	public boolean verifyDealsTab() {
		
		return dealsCategory.isDisplayed();
	}

	public boolean verifyBanner() {
		
		return banner.isDisplayed();
	}

	public boolean verifyDepartmentList() {
		
		return departmentList.isDisplayed();
	}

	public boolean verifyTopCardInstance() {
		
		return topCardInstance.isDisplayed();
	}

}
