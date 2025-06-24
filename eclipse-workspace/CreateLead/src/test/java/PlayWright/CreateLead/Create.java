package PlayWright.CreateLead;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


//import API.GeneratePhone;
public class Create {
	 Playwright playwright;
	    Browser browser;
	    BrowserContext context;
	    Page page;
	    

	    @BeforeClass
	    public void setUp() {
	        playwright = Playwright.create();
	        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	        context = browser.newContext(new Browser.NewContextOptions()
	                .setViewportSize(390, 844)
	                .setUserAgent("Mozilla/5.0 (Linux; Android 5.0.1; Nexus 5 Build/LRX22C) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36"));
	        page = context.newPage();
	    }

	    @AfterClass
	    public void tearDown() {
	        if (page != null) page.close();
	        if (context != null) context.close();
	        if (browser != null) browser.close();
	        if (playwright != null) playwright.close();
	    }

	    public void clickElementIfPresent(String selector) {
	        try {
	            if (page.isVisible(selector)) {
	                page.click(selector);
	                System.out.println("Clicked element: " + selector);
	            } else {
	                System.out.println("Element not found: " + selector);
	            }
	        } catch (Exception e) {
	            System.err.println("An error occurred while clicking the element: " + selector + ", error: " + e.getMessage());
	        }
	    }

	    public void commonWait() {
	        page.waitForLoadState(LoadState.NETWORKIDLE);
	        System.out.println("Page loaded completely.");
	    }

	    public void clickAndSendData(String selector, String dataToSend) {
	        int attempts = 0;
	        while (attempts < 3) {
	            try {
	                page.click(selector);
	                if (dataToSend != null) {
	                    page.fill(selector, "");
	                    page.fill(selector, dataToSend);
	                }
	                System.out.println("Clicked and sent data to element: " + selector);
	                break; // Exit the loop if successful
	            } catch (Exception e) {
	                System.err.println("Failed to click element with selector: " + selector + ", error: " + e.getMessage());
	                attempts++;
	            }
	        }
	    }

	    public void clickElement(String selector) {
	        try {
	            page.click(selector);
	            System.out.println("Clicked element: " + selector);
	        } catch (Exception e) {
	            System.err.println("An error occurred while clicking the element: " + e.getMessage());
	        }
	    }

	    public void printValueAtXPath(String selector) {
	        try {
	            String value = page.textContent(selector);
	            System.out.println("Value at XPath " + selector + ": " + value);
	        } catch (Exception e) {
	            System.err.println("Failed to retrieve value at XPath: " + selector + ", error: " + e.getMessage());
	        }
	    }

	    @Test
	    public void nonloginMMVY() throws InterruptedException {
	        page.navigate("https://stage-c2b-website.qac24svc.dev/sell-used-cars");
	        System.out.println("Opened webpage: https://stage-c2b-website.qac24svc.dev/sell-used-cars");

	        try {
	            if (page.isVisible("//div[@class='wzrk-alert wiz-show-animate']")) {
	                page.click("//button[text()='Allow']");
	                System.out.println("Clicked 'Allow' on pop-up");
	            }
	        } catch (Exception e) {
	            System.err.println("An error occurred: " + e.getMessage());
	        }

	        clickElement("div.js-content div._1X1dP div._3Mpm3 div._2MRy2 ul._35k4u li._1gP-H img.img-fluid");
	        clickElement("//span[contains(text(),'skip')]");
	        commonWait();
	        clickElement("//li[contains(text(),'2023')]");
	        clickElement("//div[contains(text(),'Alto')]");
	        clickElement("//body/div[1]/div[1]/div[3]/div[1]/div[1]/ul[1]/li[1]");
	        clickElement("//li[contains(text(),'LXI O')]");
	        clickElement("//body/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]");
	        clickElement("//body/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]");
	        clickElement("//div[contains(text(),'20,000 - 30,000 km')]");
	        clickElement("//body/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/a[1]");
	        clickElement("//div[contains(text(),'Immediately now')]");

//	        String phone = GeneratePhone.generateUniquePhoneNumber();
	        String phone="9827270002";
	        clickAndSendData("//input[@name='phone']", phone);
	        commonWait();

	        clickElement("//button[@id='']");
	        commonWait();

	        clickAndSendData("//input[@type='tel']", "1111");
	        commonWait();
	        page.waitForTimeout(3000);
//            clickElementIfPresent("//span[contains(text(),'I’ve used it for too long')]");
//	        commonWait();
//	        clickElementIfPresent("//span[contains(text(),'Lawyer')]");
//	        commonWait();
//	        clickElementIfPresent("(//p[contains(text(),'Skip this question')])[1]");
//	        commonWait();
//	        clickElementIfPresent("(//p[contains(text(),'Skip this question')])[2]");
//	        commonWait();
//	        clickElement("//div[contains(text(),'Immediately now')]");
	    }

	    @Test(dependsOnMethods = {"nonloginMMVY"})
	    public void editLead() {
	        clickElement("//p[contains(text(),'Edit')]");
	        commonWait();
//	        clickElement("//div[contains(text(),'Immediately now')]");
//	        commonWait();
//	        page.waitForTimeout(3000);
//	        clickElementIfPresent("//span[contains(text(),'I’ve used it for too long')]");
//	        commonWait();
//	        clickElementIfPresent("//span[contains(text(),'Lawyer')]");
//	        commonWait();
//	        clickElementIfPresent("(//p[contains(text(),'Skip this question')])[1]");
//	        commonWait();
//	        clickElementIfPresent("(//p[contains(text(),'Skip this question')])[2]");
//	        page.waitForTimeout(2000);
//	        commonWait();
	        clickElement("//button[contains(text(),'Done')]");
	        commonWait();
	        clickElement("//div[contains(text(),'Immediately now')]");
	        commonWait();
	        clickElement("//button[@id='']");
	    }

	    @Test(dependsOnMethods = {"editLead"})
	    public void appointment() {
	        commonWait();
//	        clickElement("//button[contains(text(),'Book car inspection')]");
	        commonWait();
	        clickElement("//span[contains(text(),'Home')]");
	        commonWait();

	        clickAndSendData("//input[@placeholder='Search by area/street name/society']", "CARS24 tech office");
	        commonWait();

	        clickElement("//p[contains(text(),'Cars24 Tech Office')]");
	        commonWait();
	        clickElement("//button[contains(text(),'Confirm location')]");
	        commonWait();

	        clickAndSendData("//input[@placeholder='House/Flat No/Street name*']", "Test data");
	        commonWait();

	        clickElement("//button[contains(text(),'Submit address')]");
	        commonWait();
	        page.waitForTimeout(1000);
	        clickElementIfPresent("//p[contains(text(),'Within 2 hours')]");
	        commonWait();
	        page.waitForTimeout(1000);
	        clickElementIfPresent("//p[contains(text(),'Tomorrow')]");
	        commonWait();
	        page.waitForTimeout(1000);
	        clickElementIfPresent("//p[contains(text(),'06:00 PM - 07:00 PM')]");
	        commonWait();

	        clickAndSendData("//input[@placeholder='Enter your name']", "Saurav");
	        clickElement("//button[contains(text(),'PROCEED')]");
	        commonWait();

	        clickElement("//button[contains(text(),'Book inspection')]");
	        commonWait();
	        clickElement("//button[contains(text(),'Pay ₹211.22 to book inspection')]");
	        commonWait();

	        try {
	            FrameLocator iframe = page.frameLocator("//body/div[3]/iframe[1]");
	            iframe.locator("//div[@data-value='netbanking']").click();
	            iframe.locator("//div[@data-value='HDFC']").click();
	        } catch (Exception e) {
	            System.err.println("Iframe handling failed: " + e.getMessage());
	        }

	        commonWait();
	        clickElement("//button[contains(text(),'Success')]");
	        commonWait();
	        clickElementIfPresent("(//img[@alt='close'])[2]");
	        commonWait();
	        clickElementIfPresent("div[class='_1J55N'] img[alt='close']");
	        commonWait();
	        printValueAtXPath("//p[contains (text(),'Appointment id:')]");
	    }
	}


