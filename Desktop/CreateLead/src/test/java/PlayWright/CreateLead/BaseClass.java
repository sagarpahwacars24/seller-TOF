package PlayWright.CreateLead;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;


public class BaseClass {
	protected String phoneNumber;
	protected Page page;
	@BeforeClass
	public void setBrowser() {
		System.setProperty("PLAYWRIGHT_BROWSERS_PATH", "0");

		Playwright playwright = Playwright.create();

		Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setChannel("webkit") 
																											
				.setHeadless(false));

		BrowserContext context = browser
				.newContext(new Browser.NewContextOptions().setDeviceScaleFactor(3).setHasTouch(true).setIsMobile(true)
						.setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 16_0 like Mac OS X) "
								+ "AppleWebKit/605.1.15 (KHTML, like Gecko) Version/16.0 Mobile/15E148 Safari/604.1")
						.setViewportSize(398, 800));

		page = context.newPage();
		page.navigate("https://stage-c2b-website.qac24svc.dev/sell-used-cars");

		System.out.println("Page Title: " + page.title());

	}

	@BeforeMethod
	public void phone() {
		phoneNumber = UtilityClass.generateUniquePhoneNumber();

	}
	 @AfterClass
	    public void tearDown() {
	        // Close the browser after tests
	        if (page != null) {
	            page.context().browser().close();
	        }
	    }
}