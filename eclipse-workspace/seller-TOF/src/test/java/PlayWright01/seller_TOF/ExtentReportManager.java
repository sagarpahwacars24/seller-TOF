package PlayWright01.seller_TOF;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.microsoft.playwright.Page;

import java.util.Base64;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;




public class ExtentReportManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static Map<Status, AtomicInteger> statusCount =new ConcurrentHashMap<>();

   static   {  
   statusCount.put(Status.PASS, new AtomicInteger(0));
   statusCount.put(Status.FAIL, new AtomicInteger(0));
   statusCount.put(Status.SKIP, new AtomicInteger(0));
    }

    public static void setupExtentReport() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent.attachReporter(spark);
    }

    public static void startTest(String testName) {
        test.set(extent.createTest(testName));
    }

    public static void startTest(String testName, String description) {
        test.set(extent.createTest(testName, description));
    }

    public static void logStep(String status, String message) {
        if (test.get() == null) {
            System.err.println("Test not initialized. Call startTest() first.");
            return;
        }
        
        Status testStatus;
        switch (status.toLowerCase()) {
            case "pass":
                testStatus = Status.PASS;
                statusCount.get(Status.PASS).incrementAndGet();
                break;
            case "fail":
                testStatus = Status.FAIL;
                statusCount.get(Status.FAIL).incrementAndGet();
                break;
            case "skip":
                testStatus = Status.SKIP;
                statusCount.get(Status.SKIP).incrementAndGet();
                break;
            default:
                testStatus = Status.INFO;
        }
        test.get().log(testStatus, message);  // Changed to use testStatus
    }

    public static void addScreenshot(Page page, String title) {
        if (page == null || test.get() == null) return;
        
        try {
            byte[] screenshot = page.screenshot();
            test.get().addScreenCaptureFromBase64String(
                Base64.getEncoder().encodeToString(screenshot), title);
        } catch (Exception e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
        }
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }

    public static String getReportPath() {
        return "test-output/ExtentReport.html";
    }

    public static void endTest() {
        if (extent != null) {
            extent.flush();
        }
        
    }
    public static int getPassedTestsCount() {
        return statusCount.get(Status.PASS).get();
    }

    public static int getFailedTestsCount() {
        return statusCount.get(Status.FAIL).get();
    }
}