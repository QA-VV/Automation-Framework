package Project.seleniumframework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSetup implements TimeOuts {

	public static ConfigManager config = new ConfigManager();
	public static WebDriver driver;
	
	@BeforeSuite
	public void setup() {
		if(driver==null) {
			if(config.getProperty("browser").equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			if(config.getProperty("browser").equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			if(config.getProperty("browser").equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			if(config.getProperty("browser").equalsIgnoreCase("Safari")) {
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
			}
			if(config.getProperty("browser").equalsIgnoreCase("IE")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		HashMap<String, String> map = new HashMap<String, String>();

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.youtube.com/watch?v=Sa7JJwQPmIY&ab_channel=SoftwareTestingMentor");
		String title = driver.getTitle();
		System.out.println(title);
		System.out.println(driver.getWindowHandle());
		map.put(title, driver.getWindowHandle());

		driver.switchTo().newWindow(WindowType.TAB);

		driver.get("https://www.google.com/");
		title = driver.getTitle();
		System.out.println(title);
		System.out.println(driver.getWindowHandle());
		map.put(title, driver.getWindowHandle());

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://github.com/bonigarcia/webdrivermanager");
		title = driver.getTitle();
		System.out.println(title);
		System.out.println(driver.getWindowHandle());
		map.put(title, driver.getWindowHandle());

		System.out.println(map);
		System.out.println();
		System.out.println(driver.getWindowHandles());

		Iterator it = map.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry m1 = (Map.Entry) it.next();

			String st = (String) m1.getValue();
			System.out.println();
			System.out.println();
			System.out.println(st);
			Thread.sleep(3000);
			driver.switchTo().window(st);

		}

		// driver.close();
	}
}