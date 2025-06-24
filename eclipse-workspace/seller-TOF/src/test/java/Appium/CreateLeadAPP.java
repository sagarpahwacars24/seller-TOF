package Appium;
import io.appium.java_client.AppiumDriver;

//import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.List;




public class CreateLeadAPP {
	



	private AppiumDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() throws Exception {
    	  UiAutomator2Options options = new UiAutomator2Options()
    	            .setDeviceName("Pixel 7")
    	            .setPlatformName("Android")
    	            .setApp("/path/to/app.apk")
    	            .setAutomationName("UiAutomator2")
    	            .setApp("/Users/a35294/Downloads/app-staging1-release (3).apk")
    	            .setNewCommandTimeout(Duration.ofSeconds(30));

    	  driver = new AndroidDriver(
    	            new URL("http://127.0.0.1:4723"), 
    	            options);

    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testCarInspectionFlow() {
        // Tap by coordinates (47%, 90%)
        tapByPercentage(0.47, 0.90);
        
        // Tap by ID
        tapById("com.google.android.gms:id/touch_outside");
        
        // Tap by text
        tapByText("SKIP");
        
        // Type text
        WebElement inputField = driver.findElement(By.className("android.widget.EditText"));
        inputField.sendKeys("8789999777");
    }

    private void tapByPercentage(double xPercent, double yPercent) {
        Dimension size = driver.manage().window().getSize();
        int x = (int)(size.width * xPercent);
        int y = (int)(size.height * yPercent);
        
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1)
            .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y))
            .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
            .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        
        driver.perform(List.of(tap));
    }

    private void tapById(String id) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
        element.click();
    }

    private void tapByText(String text) {
        String xpath = String.format("//*[@text='%s']", text);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        element.click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
