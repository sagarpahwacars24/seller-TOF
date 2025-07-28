package PlayWright01.seller_TOF;


import java.io.File;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;


public class BaseClass {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected ExtentTest test;
    private static boolean reportGenerated = false;

    @BeforeSuite
    public void beforeSuite() {
        ExtentReportManager.setupExtentReport();
    }

    @BeforeClass
    public void setUp() {
        System.setProperty("PLAYWRIGHT_BROWSERS_PATH", "0");
        playwright = Playwright.create();
        browser = playwright.webkit().launch(new BrowserType.LaunchOptions()
                .setChannel("webkit")
                .setHeadless(false));
        
        context = browser.newContext(new Browser.NewContextOptions()
                .setDeviceScaleFactor(3)
                .setHasTouch(true)
                .setIsMobile(true)
                .setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 16_0 like Mac OS X) " +
                        "AppleWebKit/605.1.15 (KHTML, like Gecko) Version/16.0 Mobile/15E148 Safari/604.1")
                .setViewportSize(398, 820));
        
        page = context.newPage();
        environmentEndpoints stageURL = environmentEndpoints.STAGE;
        String url=stageURL.getBaseUrl();
        page.navigate(url);
    }
    
    @BeforeMethod
    public void setup(ITestResult result) {
        ExtentReportManager.startTest(result.getMethod().getMethodName(), "Test Description");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                ExtentReportManager.logStep("fail", "Test Failed: " + result.getThrowable());
                SlackReporter.sendTestResults(0, 0, null);
                if (page != null) {
                    ExtentReportManager.addScreenshot(page, result.getName() + "_failure");
                }
            } else if (result.getStatus() == ITestResult.SKIP) {
                ExtentReportManager.logStep("skip", "Test Skipped: " + result.getName());
                SlackReporter.sendTestResults(0, 0, null);
            } else {
                ExtentReportManager.logStep("pass", "Test Passed");
                SlackReporter.sendTestResults(0, 0, null);
            }
        } catch (Exception e) {
            System.err.println("Error in tearDown: " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDownResources() {
        try {
            if (page != null) page.close();
            if (context != null) context.close();
            if (browser != null) browser.close();
            if (playwright != null) playwright.close();
        } catch (Exception e) {
            System.err.println("Error closing resources: " + e.getMessage());
        }
    }

    @AfterSuite
    public void afterSuite() {
        if (!reportGenerated) {
            ExtentReportManager.flushReport();
            reportGenerated = true;
            System.out.println("Extent report generated at: " + ExtentReportManager.getReportPath());
            
            // Optionally open report in default browser
            try {
                java.awt.Desktop.getDesktop().browse(
                    new File(ExtentReportManager.getReportPath()).toURI());
            } catch (Exception e) {
                System.out.println("Could not open report automatically");
            }
        }
    }
}