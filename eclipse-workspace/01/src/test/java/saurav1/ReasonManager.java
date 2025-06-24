package saurav1;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReasonManager {
	WebDriver driver;
	String a="TestSaurav";
	 Random random = new Random();
	String b=random.toString();
	
	@BeforeTest
	public void Login() throws InterruptedException {
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://stage-c2b-panel-internal.qac24svc.dev/login");
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		    Boolean element=wait.until(ExpectedConditions.titleContains("C2B Panels"));
	        Thread.sleep(5000);	
		    WebElement shadowHost = driver.findElement(By.xpath("//descope-wc[@project-id='P2XG2zbRpuU2xTqPUKuLICINHf35']"));
			//  JavaScript to access the Shadow DOM and find the element
		    WebElement shadowChild = (WebElement) ((JavascriptExecutor) driver).executeScript(
		            "return arguments[0].shadowRoot.querySelector('[id=\"crechrNO04\"]');", shadowHost);
		    shadowChild.click();
		    Thread.sleep(5000);
			driver.findElement(By.id("identifierId")).sendKeys("saurav2.kumar@cars24.com");
			driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Saurav@car24");
			driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
			Thread.sleep(15000);
	}
	
	@Test(priority=1)
	public void AddChallanRejectionReason() throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'Administrator View')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Reason Manager')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[contains(text(),'Add Reason')])[1]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='addRejectReason']")).sendKeys(a);
		driver.findElement(By.xpath("//button[@class='k-button k-button-md k-button-solid k-button-solid-primary k-rounded-md m-3']")).click();
		Thread.sleep(3000);
	}
		@Test(priority=2)
		public void EditChallanRejectionReason() throws InterruptedException {
			driver.findElement(By.xpath("//input[@id='Rejection']")).sendKeys(a,Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span[@class='k-icon k-font-icon k-i-edit m-2'])[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@class='k-checkbox-wrap']//child::input")).click();
			driver.findElement(By.xpath("//span[contains(text(),'Confirm')]")).click();
		}
		
        @Test(priority=3)
		public void DeleteChallanRejectionReason() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='Rejection']")).sendKeys(a,Keys.ENTER);
		driver.findElement(By.xpath("(//span[@class='k-icon k-font-icon k-i-delete m-2'])[1]")).click();
		driver.findElement(By.xpath("//button[@class='k-button k-button-md k-button-solid k-button-solid-primary k-rounded-md m-3']")).click();
		Thread.sleep(2000);
        }
	@Test(priority=4)
	public void AddVerificationRejectionReason() throws InterruptedException {
		driver.findElement(By.xpath("(//span[contains(text(),'Add Reason')])[2]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='addVerificationRejectReason']")).sendKeys(a);
		driver.findElement(By.xpath("//button[@class='k-button k-button-md k-button-solid k-button-solid-primary k-rounded-md m-3']")).click();
		Thread.sleep(2000);
	}
		@Test(priority=5)
		public void EditVerificationRejectionReason() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='verificationRejection']")).sendKeys(a,Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='k-icon k-font-icon k-i-edit m-2'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='k-checkbox-wrap']//child::input")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Confirm')]")).click();
	}
		
        @Test(priority=6)
		public void DeleteVerificationRejectionReason() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='verificationRejection']")).sendKeys(a,Keys.ENTER);
		driver.findElement(By.xpath("(//span[@class='k-icon k-font-icon k-i-delete m-2'])[2]")).click();
		driver.findElement(By.xpath("//button[@class='k-button k-button-md k-button-solid k-button-solid-primary k-rounded-md m-3']")).click();
		Thread.sleep(2000);
		Actions action=new Actions(driver);
		for (int i = 0; i < 10; i++) {
            action.sendKeys(Keys.PAGE_DOWN).build().perform();
        }
    }
        @Test(priority=7)
    	public void AddDelayReason() throws InterruptedException {
    		driver.findElement(By.xpath("(//span[contains(text(),'Add Reason')])[3]")).click();
    		Thread.sleep(4000);
    		driver.findElement(By.xpath("//input[@id='addDelayReason']")).sendKeys(a);
    		driver.findElement(By.xpath("//button[@class='k-button k-button-md k-button-solid k-button-solid-primary k-rounded-md m-3']")).click();
    		Thread.sleep(2000);
   }
    		@Test(priority=8)
    		public void EditDelayReason() throws InterruptedException {
    		driver.findElement(By.xpath("//input[@id='Delay']")).sendKeys(a,Keys.ENTER);
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("(//span[@class='k-icon k-font-icon k-i-edit m-2'])[3]")).click();
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//span[@class='k-checkbox-wrap']//child::input")).click();
    		driver.findElement(By.xpath("//span[contains(text(),'Confirm')]")).click();
    		
    }
    		
            @Test(priority=9)
    		public void DeleteDelayReason() throws InterruptedException {
    		Thread.sleep(2000);
    		driver.findElement(By.xpath("//input[@id='Delay']")).sendKeys(a,Keys.ENTER);
    		driver.findElement(By.xpath("(//span[@class='k-icon k-font-icon k-i-delete m-2'])[3]")).click();
    		driver.findElement(By.xpath("//button[@class='k-button k-button-md k-button-solid k-button-solid-primary k-rounded-md m-3']")).click();
    		Thread.sleep(3000);
    		Actions action=new Actions(driver);
    		for (int i = 0; i < 10; i++) {
                action.sendKeys(Keys.PAGE_DOWN).build().perform();
    }
//    		action.moveByOffset(0, 1000).perform();
//    		JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    		
    }
            @Test(priority=10)
        	public void AddUnableToFulfillReason() throws InterruptedException {
        		driver.findElement(By.xpath("(//span[contains(text(),'Add Reason')])[4]")).click();
        		Thread.sleep(4000);
        		driver.findElement(By.xpath("//input[@id='addUnFullfillReason']")).sendKeys(a);
        		driver.findElement(By.xpath("//button[@class='k-button k-button-md k-button-solid k-button-solid-primary k-rounded-md m-3']")).click();
        		Thread.sleep(2000);
//        		Actions action=new Actions(driver);
//        		action.moveByOffset(0, 600).perform();     		
     }
        		@Test(priority=11)
        		public void EditUnableToFulfillReason() throws InterruptedException {
        		driver.findElement(By.xpath("//input[@id='UnFulfill']")).sendKeys(a,Keys.ENTER);
        		Thread.sleep(2000);
        		driver.findElement(By.xpath("(//span[@class='k-icon k-font-icon k-i-edit m-2'])[4]")).click();
        		Thread.sleep(2000);
        		driver.findElement(By.xpath("//span[@class='k-checkbox-wrap']//child::input")).click();
        		driver.findElement(By.xpath("//span[contains(text(),'Confirm')]")).click();
 }
        		
                @Test(priority=12)
        		public void DeleteUnableToFulfillReason() throws InterruptedException {
        		Thread.sleep(2000);
        		driver.findElement(By.xpath("//input[@id='UnFulfill']")).sendKeys(a,Keys.ENTER);
        		driver.findElement(By.xpath("(//span[@class='k-icon k-font-icon k-i-delete m-2'])[4]")).click();
        		driver.findElement(By.xpath("//button[@class='k-button k-button-md k-button-solid k-button-solid-primary k-rounded-md m-3']")).click();
        		Thread.sleep(3000);
                }
                @Test(priority=13)
            	public void AddOffenceType() throws InterruptedException {
            		driver.findElement(By.xpath("//span[contains(text(),'Add Offence')]")).click();
            		Thread.sleep(4000);
            		driver.findElement(By.xpath("//input[@id='addDelayReason']")).sendKeys(a);
            		driver.findElement(By.xpath("//button[@class='k-button k-button-md k-button-solid k-button-solid-primary k-rounded-md m-3']")).click();
            		Thread.sleep(2000);
            		driver.quit();
   }
}
