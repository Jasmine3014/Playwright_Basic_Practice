package playwright_basic.com;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LocatorExamples {
	
	Playwright playwright;
	BrowserType browserType;
	Browser browser;
	BrowserContext browserContext;
	Page page;
	
	@BeforeSuite
	public void start() {
		
		playwright = Playwright.create();
		browserType = playwright.chromium();
		browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
		browserContext = browser.newContext(new Browser.NewContextOptions() );
		page = browser.newPage();		
	}
	
	@Test(priority=0)
	public void URL() throws InterruptedException {
		
		page.navigate("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
		Thread.sleep(2000);
		
	}
	
	@Test (priority=1)
	public void locateById() throws InterruptedException {
		ElementHandle element = page.querySelector("#name");
		element.fill("jasmine");
		Thread.sleep(2000);
	}
	
	@Test (priority=2)
	public void locateByName() {
		ElementHandle email = page.querySelector("[name ='email']");
		email.fill("jasmine@gmail.com");
	}
	
	@AfterSuite
	public void close() {
		page.close();
		browser.close();
		playwright.close();
	}

}

