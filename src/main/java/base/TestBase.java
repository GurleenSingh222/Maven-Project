package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		try {

			FileInputStream file = new FileInputStream(
					"/Users/gurleenpadda/Desktop/QA/Selenium_Workspace/MyMavenProject/src/main/java/config/config.properties");
			prop = new Properties();
			prop.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialize() {

		String browser = prop.getProperty("browser");
		if (browser.equals("Chrome"))
			driver = new ChromeDriver();
		else if (browser.equals("Firefox"))
			driver = new FirefoxDriver();
		else
			driver = new SafariDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public static void closeBrowser() {
		driver.quit();
	}

}


