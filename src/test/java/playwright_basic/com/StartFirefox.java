package playwright_basic.com;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class StartFirefox {

	Playwright playwright;
	BrowserType browserType;
	Browser browser;
	BrowserContext browserContext;
	Page page;
	
	@BeforeSuite
	public void start() {
		playwright = Playwright.create();
		browserType = playwright.firefox();
		browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
		browserContext = browser.newContext(new Browser.NewContextOptions());
		page = browserContext.newPage();
		
	}
	
	@Test
	public void URL() throws InterruptedException {
		page.navigate("https://github.com/");
		Thread.sleep(5000);
	}
	
	@AfterSuite
	public void close() {
		page.close();
		browser.close();
		playwright.close();
	}
}
