package testselenium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.commons.exec.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LinkCrawler {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pupper\\Documents\\chromedriver.exe");
		// Create a map to store preferences
		Map<String, Object> prefs = new HashMap<String, Object>();

		// add key and value to map as follow to switch off browser notification
		// Pass the argument 1 to allow and 2 to block
		prefs.put("profile.default_content_setting_values.notifications", 2);

		// Create an instance of ChromeOptions
		ChromeOptions options = new ChromeOptions();

		// set ExperimentalOption - prefs
		options.setExperimentalOption("prefs", prefs);

		// Now Pass ChromeOptions instance to ChromeDriver Constructor to initialize
		// chrome driver which will switch off this browser notification on the chrome
		// browser
		WebDriver driver = new ChromeDriver(options);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		String baseUrl = "https://www.facebook.com/LienMinhHuyenThoai/";
		driver.manage().window().maximize();

		driver.get(baseUrl);
		
		while(true) {
			System.out.println("Wait 5 seconds");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
			js.executeScript("window.scrollBy(0,10000)");
			List<WebElement> contents = driver.findElements(By.className("_4-eo"));
			if (!contents.isEmpty()) {
				System.out.println("\n\n\n");
				System.out.println(contents.size());
				contents.forEach(content -> System.out.println(content.getAttribute("href")));
			} else {
				System.out.println("Found no elements");
			}
			
		}
	}
}
