package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase{
	
	public HomePage() {
		//super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "twotabsearchtextbox")
	public WebElement searchTab;
	
	@FindBy(id="nav-logo")
	public WebElement homeButton;
	
	@FindBy(xpath = "//div[@id='gw-card-layout']//h2")
	public List <WebElement> card1Layout;
	
	@FindBy(id="nav-xshop")
	public List <WebElement> categories;
	
	@FindBy(id="glow-ingress-line1")
	public WebElement addressLine;
	
	@FindBy(id= "glow-ingress-line2")
	public WebElement updateAddress;
	
	@FindBy(xpath = "//div[@class='a-popover-wrapper']//h4")
	public WebElement chooseLocation;
	
	@FindBy(id="nav-global-location-popover-link")
	public WebElement updateAddressLink;
	
	@FindBy(linkText = "Best Sellers")
	public WebElement BestSellerButton;
	
	public String verifySearchPlaceholder() {
		
		String ph = searchTab.getAttribute("aria-label");
		return ph;
		
	}
	
	public ArrayList<String> verifycard1Headings() {
		
		ArrayList<String> headings = new ArrayList<String>();
		for(WebElement x: card1Layout) {
			if(x.isDisplayed()) {
				headings.add(x.getText());
			}
		}
		return headings;
	}
	
	public boolean verifyCategoriesTab() {
		
		int size = categories.size();
		if (size>=1) {
			return true;
			
		}else {
			return false;
		}
		
	}
	
	public boolean verifyAddressTab() {
		
		return(addressLine.isDisplayed() && updateAddress.isDisplayed());
		
	}
	
	public boolean verifyUpdateLocation() {
		
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			
		}
		updateAddressLink.click();
		return chooseLocation.isDisplayed();
		
	}
	
	public String verifybestSellerLink() {
		
		BestSellerButton.click();
		return driver.getTitle();
	}

}
