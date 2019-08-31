package testselenium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PostCrawler {
	private static final String COMMENT = "UFICommentBody";
	private static final String SHOW_MORE_COMMENT = "UFICommentLink";

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

		String baseUrl = "https://www.facebook.com/LienMinhHuyenThoai/photos/a.640879075996343/2561195570631341/?type=3&eid=ARAlKas3G2xMDxA1CpW_6R9mYc7F78WlVI0_z04bci5jceHX89tb7RUR3Fpb4Cx-RyVdZ9xPc891cRfb&__xts__%5B0%5D=68.ARAHQ9Mk4t1scx79OJ2-6U5Nj098J1TA8SZT54PheTU3pY3Dq85RG3icngr6EQVW-uAd2T-94my0b4yWDpqxjHknDUPE2F8RqnjPsQxZvmFCbG9-u8zA7i4kjobpZFOtf7sJ6YXnky7Oy8hE6xUMwTXKjokH-zno-G10cYFfugnGzrzkaftGEC3bkrAznMNYZwQxnD-P275OHwwF4pYuYGp0-fiNWGuRYLTuKDUdkKprvFLgP80E-TJJyVsRS7eS8YuCZhlUPO7ESqofPCsWmbfepLdg-JIdOQDXc-FhuHoy46XRaINnPNnznQxbBQCHWE87XYl6tiPUYtl7CvFQqOrvDw&__tn__=EEHH-R";
		driver.manage().window().maximize();
		driver.get(baseUrl);
		
		// find picture link to click
		WebElement element = driver.findElement(By.className("_4-eo"));
		element.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// find "more comments" link to click
		element = driver.findElement(By.className(SHOW_MORE_COMMENT));
		element.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// get comments after showing more comments
		List<WebElement> elements = driver.findElements(By.className(COMMENT));
		if (elements != null) {
			elements.forEach(elem-> System.out.println(elem.getText()));
		}
	}
}
