package Mobile1;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.appium.java_client.android.AndroidDriver;

public class test1 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver driver;
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("deviceName", "sdk_gphone64_arm64"); // Replace with your device name
		dc.setCapability("platformVersion", "14"); // Replace with your device platform version
		dc.setCapability("appPackage", "com.cars24.inspection");
		dc.setCapability("appActivity", "com.cars24.inspection.cars.ui.activities.LoginActivity");
		dc.setCapability("app", "/Users/a35294/Downloads/Cars24-Inspection-STAGINGRELEASE-2.7.1382RELEASE.apk");
		dc.setCapability("automationName", "UiAutomator2");
		dc.setCapability("autoGrantPermissions", true);
    
       driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
//       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       System.out.println("done");
//       Thread.sleep(20000);
       
       
//       for handling the permission in the app
//       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//       WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("*//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']")));
//       element.click();
//       Thread.sleep(3000);
//     driver.findElement(MobileBy.xpath("*//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']")).click();
//     Thread.sleep(3000);
//     System.out.println("done");
//     driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")).click();
//     Thread.sleep(3000);
//     System.out.println("done");
//     
//     
//     driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")).click();
//     Thread.sleep(3000);
//     System.out.println("done");
//  
//    driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")).click();
//    Thread.sleep(3000);
//    System.out.println("done");
//    driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")).click();
//    Thread.sleep(3000);
//    System.out.println("done");
//  
//     driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")).click();
//     Thread.sleep(3000);
//     System.out.println("done");
//     driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")).click();
//     Thread.sleep(3000);
//     System.out.println("done");
//     driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_all_button\"]")).click();
//     Thread.sleep(3000);
//     System.out.println("done");
//     driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")).click();
//     Thread.sleep(3000);
//     System.out.println("done");
     driver.findElement(By.xpath("//android.widget.TextView[@text='Gmail Sign In']")).click();
     Thread.sleep(15000);
 
     driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.android.chrome:id/signin_fre_continue_button']")).click();
   Thread.sleep(5000);
//     driver.findElement(By.xpath("//android.widget.Button[@text='Close']")).click();
   WebElement element1=  driver.findElement(By.xpath("//android.view.View[@resource-id='yDmH0d']/android.view.View[2]/android.view.View/android.view.View[1]/android.widget.TextView[2]"));
   Actions actions = new Actions(driver);
   Thread.sleep(3000);
   actions.sendKeys(element1, "saurav2.kumar@cars24.com").perform();
   Thread.sleep(3000);
     driver.findElement(By.xpath("//android.widget.Button[@text='Next']")).click();
     Thread.sleep(1000);
     driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("saurav2.kumar@cars24.com");
    
     Thread.sleep(3000);
     driver.findElement(By.xpath("//android.widget.Button[@text='Next']")).click();
     Thread.sleep(3000);
     driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("Saurav@car24");
     
     driver.findElement(By.xpath("//android.widget.Button[@text='Next']")).click();
     Thread.sleep(7000);
     driver.findElement(By.xpath("//android.widget.Button[@text='I agree']")).click();
     Thread.sleep(1000);
     driver.findElement(By.xpath(" //android.widget.Button[@text='ACCEPT']")).click();
     Thread.sleep(1000);
     driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.android.chrome:id/signin_fre_footer']")).click();
     Thread.sleep(1000);
     driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.android.chrome:id/fre_uma_dialog_dismiss_button']")).click();
     Thread.sleep(1000);
     driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.android.chrome:id/signin_fre_continue_button']")).click();
     Thread.sleep(1000);
     driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.android.chrome:id/button_primary']")).click();
     Thread.sleep(1000);
     driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id='com.android.permissioncontroller:id/allow_always_radio_button']")).click();
     Thread.sleep(3000);
   
     driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.cars24.inspection:id/btnPunchIn']")).click();
     Thread.sleep(1000);
     driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Back']")).click();
     
    System.out.println("done");
    driver.quit();
//    driver.navigate().back();
		
  //android.widget.Button[@resource-id="com.android.permissioncontroller:id/permission_allow_foreground_only_button"]
		

	}

}
