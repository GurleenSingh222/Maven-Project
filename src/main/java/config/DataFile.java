package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class DataFile {

	Properties prop;

	public DataFile() {

		try {

			FileInputStream fi = new FileInputStream(
					"/Users/gurleenpadda/Desktop/QA/Selenium_Workspace/MyMavenProject/src/main/java/config/config.properties");
			prop = new Properties();
			prop.load(fi);

		} catch (IOException e) {

		}
		

	}

	public String geturl() {
		String url = prop.getProperty("url");
		return url;
	}

	public String getEmail() {
		String email = prop.getProperty("correctEmail");
		return email;
	}

	public String getUsernameErr() {
		String err = prop.getProperty("wrongUsernameErr");
		return err;
	}

	public String getPasswordErr() {
		String err = prop.getProperty("wrongPasswordErr");
		return err;
	}

	public String gethomepageTitle() {
		String title = prop.getProperty("homepageTitle");
		return title;
	}

	public String getHomepageUrl() {
		String url = prop.getProperty("homepageUrl");
		return url;
	}

	public String getSearchPlaceholder() {
		String ph = prop.getProperty("searchplaceholder");
		return ph;
	}

	public ArrayList<String> gethomepagecard1Headings() {
		ArrayList<String> card1headings = new ArrayList<String>(Arrays.asList("Today’s Deals", "Shop by grade",
				"Customers' most-Loved fashion", "Sign in for your best experience", "Refresh your home",
				"Sports & Outdoors store", "Explore Amazon Basics", "Shop our Kitchen store"));
		return card1headings;
	}

	public String getBestSellerPageTitle() {
		String title = "Amazon.ca Best Sellers: The most popular items on Amazon";
		return title;
	}

}
