package Mobile1;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class TestNGmobile {
	AndroidDriver driver;
	@BeforeClass()
	public void start() throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("deviceName", "sdk_gphone64_arm64"); // Replace with your device name
		dc.setCapability("platformVersion", "15"); // Replace with your device platform version
		dc.setCapability("appPackage", "com.cars24.seller.staging1");
//		dc.setCapability("appActivity", "com.cars24.seller.MainActivity");
		dc.setCapability("app", "/Users/a35294/Downloads/app-staging1-release (9).apk");
		dc.setCapability("automationName", "UiAutomator2");
		dc.setCapability("autoGrantPermissions", true);
    
       driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
//       Thread.sleep(12000);
       WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(15));
       WebElement start=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@content-desc=\"Get Started\"]")));
start.click();
driver.findElement(By.className("android.widget.ImageView")).click();


//driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Get Started\"]")).click();

driver.findElement(By.id("com.google.android.gms:id/touch_outside")).click();
//       driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView")).click();
       Thread.sleep(2000);

}
@Test()
public void login() throws InterruptedException {
	
	driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView")).click();
    driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Orbit\"]/android.view.ViewGroup")).click();
    driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.ImageView")).click();
    driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView")).click();
    driver.findElement(By.xpath("//android.widget.TextView[@text=\"Skip\"]")).click();
    driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"2023\"]")).click();
    driver.findElement(By.xpath("(//android.widget.TextView[@text=\"Alto\"])[1]")).click();
    driver.findElement(By.xpath("//android.widget.TextView[@text=\"Petrol\"]")).click();
    driver.findElement(By.xpath("//android.widget.TextView[@text=\"Haryana\"]")).click();
    driver.findElement(By.xpath("//android.widget.TextView[@text=\"HR-26\"]")).click();
    driver.findElement(By.xpath("//android.widget.TextView[@text=\"30,000 - 40,000 km\"]")).click();
    driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Ghaziabad\"]/android.view.ViewGroup/android.widget.ImageView")).click();
    driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Within 1 week\"]")).click();
    driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("8897612301");
    driver.findElement(By.xpath("//android.widget.TextView[@text=\"PROCEED\"]")).click();
    driver.findElement(By.xpath("//android.widget.TextView[@text=\"LXI O\"]")).click();
    driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.EditText")).sendKeys("1");
	  driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.EditText")).sendKeys("1");
	  driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.EditText")).sendKeys("1");
	  driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.widget.EditText")).sendKeys("1");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//android.widget.TextView[@text=\"I wanted to change the model\"]")).click();
	  driver.findElement(By.xpath("//android.widget.TextView[@text=\"Skip this question\"]")).click();
	  
	  driver.findElement(By.xpath("//android.widget.TextView[@text=\"Skip this question\"]")).click();
	  Thread.sleep(8000);
	  driver.findElement(By.xpath("//android.widget.TextView[@text=\"LXI O\"]")).click();
	  driver.findElement(By.xpath("//android.widget.TextView[@text=\"LXI O\"]")).click();  
	  driver.findElement(By.xpath("//android.widget.TextView[@text=\"LXI O\"]")).click();
	  driver.findElement(By.xpath("//android.widget.TextView[@text=\"LXI O\"]")).click();
	  driver.findElement(By.xpath("//android.widget.TextView[@text=\"LXI O\"]")).click();
	  driver.findElement(By.xpath("//android.widget.TextView[@text=\"LXI O\"]")).click();
	  driver.findElement(By.xpath("//android.widget.TextView[@text=\"LXI O\"]")).click();
	  driver.findElement(By.xpath("//android.widget.TextView[@text=\"LXI O\"]")).click();
	  driver.findElement(By.xpath("//android.widget.TextView[@text=\"LXI O\"]")).click();
	  
	
	
	
	
	
	
	
	
	
	
	
	  driver.findElement(By.xpath("//android.widget.EditText[@text=\"Enter mobile number\"]")).sendKeys("9200000006");
	  driver.findElement(By.xpath("//android.widget.TextView[@text=\"GET OTP\"]")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.EditText")).sendKeys("1");
	  driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.EditText")).sendKeys("1");
	  driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.EditText")).sendKeys("1");
	  driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.widget.EditText")).sendKeys("1");
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//android.widget.TextView[@text=\"SKIP\"]")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//android.widget.TextView[@text=\"Allow\"]")).click();
	  Thread.sleep(5000);
	
//	  driver.findElement(By.xpath("//android.widget.EditText[@text=\"Search your city\"]")).sendKeys("mumbai",Keys.ENTER);
	  driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//android.widget.TextView[@text=\"Sellcar\"]")).click();
	  
//			
//	  driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")).click();
//	  Thread.sleep(3000);
//	  driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")).click();
//	  Thread.sleep(3000);
//	  driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")).click();
//	  Thread.sleep(3000);
//	  driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")).click();
//	  Thread.sleep(3000);
//	  driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")).click();
//	 Thread.sleep(5000);
//	  driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.cars24.seller.staging1:id/bottom_navigation_item_icon\"])[3]")).click();
//	  
	Thread.sleep(3000);
	
}
@Test()
public void lead() throws InterruptedException {
	driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"MARUTI SUZUKI\"]/android.widget.ImageView")).click();
	 Thread.sleep(2000);
	  driver.findElement(By.xpath("//android.widget.TextView[@text=\"2020\"]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//android.widget.TextView[@text=\"Swift\"]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//android.widget.TextView[@text=\"Manual\"]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//android.widget.TextView[@text=\"LXI \"]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//android.widget.TextView[@text=\"Haryana\"]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//android.widget.TextView[@text=\"HR-26\"]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//android.widget.TextView[@text=\"10,000 - 20,000 Kms\"]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//android.widget.TextView[@text=\"Gurgaon\"]")).click();
	  Thread.sleep(2000);
	  WebElement sellcar=driver.findElement(By.xpath("//android.widget.TextView[@text=\"Upgrading my car\"]"));
	  if(sellcar==null)
	  driver.findElement(By.xpath("//android.widget.TextView[@text=\"Upgrading my car\"]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//android.widget.TextView[@text=\"Immediately now\"]")).click();
	  Thread.sleep(2000); 
	
}
//@Test()
//public void leadEdit() throws InterruptedException {
//	
//}

//driver.context("NATIVE_APP");

//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(715, 2761);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(1260, 298);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(226, 2082);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//driver.context("NATIVE_APP");
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(699, 2786);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//driver.executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 187));
//driver.executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 187));
//driver.executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 187));

//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var start = new Point(673, 1440);
//var end = new Point (1316, 1383);
//var swipe = new Sequence(finger, 1);
//swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), start.getX(), start.getY()));
//swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
//    PointerInput.Origin.viewport(), end.getX(), end.getY()));
//swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(swipe));
//  
//driver.executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 3));
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(1146, 2524);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(905, 1414);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(987, 1681);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(781, 1152);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(175, 1969);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(668, 2766);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var start = new Point(740, 1188);
//var end = new Point (735, 1188);
//var swipe = new Sequence(finger, 1);
//swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), start.getX(), start.getY()));
//swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
//    PointerInput.Origin.viewport(), end.getX(), end.getY()));
//swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(swipe));
//  
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(355, 910);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(324, 761);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(673, 1069);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(231, 1003);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(211, 1182);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(643, 1162);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(226, 1172);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//driver.executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 4));
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(252, 1409);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(961, 1110);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(663, 797);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(663, 797);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//var el1 = driver.findElement(AppiumBy.className("android.widget.EditText"));
//el1.sendKeys("8888443480");
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(771, 2694);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(1085, 1866);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(365, 895);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(905, 2283);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//var el2 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)"));
//el2.sendKeys("1");
//el2.sendKeys("1");
//var el3 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"));
//el3.sendKeys("1");
//var el4 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(2)"));
//el4.sendKeys("1");
//var el5 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(3)"));
//el5.sendKeys("1");
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(781, 2339);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//driver.executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 4));
//driver.executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 3));
//driver.executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 187));
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(730, 936);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//driver.executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 4));
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(1141, 1691);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(992, 1666);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(689, 1378);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(1064, 560);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(247, 1424);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(1131, 1044);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(730, 1059);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(730, 1059);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(869, 1383);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(694, 1275);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(380, 2262);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//driver.executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 4));
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(679, 1743);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(751, 1727);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(699, 1044);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(658, 1049);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(586, 1249);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(324, 1748);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//driver.context("NATIVE_APP");
//var el6 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(16)"));
//el6.click();
//var els1 = driver.findElements(AppiumBy.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]\n"));
//var el7 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(16)"));
//el7.click();
//var els2 = driver.findElements(AppiumBy.xpath("//android.widget.ScrollView/android.view.ViewGroup"));
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(689, 1254);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var start = new Point(31, 972);
//var end = new Point (1203, 987);
//var swipe = new Sequence(finger, 1);
//swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), start.getX(), start.getY()));
//swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
//    PointerInput.Origin.viewport(), end.getX(), end.getY()));
//swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(swipe));
//  
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var start = new Point(334, 2164);
//var end = new Point (1213, 2164);
//var swipe = new Sequence(finger, 1);
//swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), start.getX(), start.getY()));
//swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
//    PointerInput.Origin.viewport(), end.getX(), end.getY()));
//swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(swipe));
//  
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(303, 1733);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
//    
//
//final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//var tapPoint = new Point(900, 1260);
//var tap = new Sequence(finger, 1);
//tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
//    PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
//tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//tap.addAction(new Pause(finger, Duration.ofMillis(50)));
//tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//driver.perform(Arrays.asList(tap));
    

//
}	
