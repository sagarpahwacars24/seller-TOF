package saurav1;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class AdministratorView {
	WebDriver driver;
@BeforeTest
public void Login() throws InterruptedException {
	 driver=new ChromeDriver();
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
@Test(enabled = false)
public void AddRegion() throws InterruptedException {
	driver.findElement(By.xpath("//span[contains(text(),'Administrator View')]")).click();
	driver.findElement(By.xpath("//span[contains(text(),'Agent Manager')]")).click();
	Thread.sleep(6000);
	driver.findElement(By.xpath("(//button[@class='k-button k-button-md k-button-outline k-button-outline-primary k-rounded-md m-2'])[1]")).click();
	driver.findElement(By.xpath("//input[@id='addRegion']")).sendKeys("testSaurav");
	driver.findElement(By.xpath("//button[@class='k-button k-button-md k-button-solid k-button-solid-primary k-rounded-md m-3']")).click();
	Thread.sleep(3000);
}
	@Test(enabled = false)
	public void editRegion() throws InterruptedException {
	driver.findElement(By.xpath("//input[@id='Region']")).sendKeys("testSaurav",Keys.ENTER);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//body/div[@id='root']/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[2]")).click();
	driver.findElement(By.xpath("//span[@class='k-checkbox-wrap']//child::input")).click();
	driver.findElement(By.xpath("//button[@class='k-button k-button-md k-button-solid k-button-solid-primary k-rounded-md m-3']")).click();
	Thread.sleep(3000);
	}
	@Test(enabled = false)
	public void deleteRegion() throws InterruptedException {
	driver.findElement(By.xpath("//input[@id='Region']")).sendKeys("testSaurav",Keys.ENTER);
	driver.findElement(By.xpath("(//span[@class='k-icon k-font-icon k-i-delete m-2'])[1]")).click();
	driver.findElement(By.xpath("//button[@class='k-button k-button-md k-button-solid k-button-solid-primary k-rounded-md m-3']")).click();
	Thread.sleep(2000);
}	
	@Test(enabled = false)
	public void AddCourtList() throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'Administrator View')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Agent Manager')]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//button[@class='k-button k-button-md k-button-outline k-button-outline-primary k-rounded-md m-2'])[2]")).click();
		driver.findElement(By.xpath("//input[@id='regionList']")).sendKeys("AP",Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='addCourt']")).sendKeys("TestCourt");
		driver.findElement(By.xpath("//button[@class='k-button k-button-md k-button-solid k-button-solid-primary k-rounded-md m-3']")).click();
		Thread.sleep(8000);
}
	@Test(enabled = false)
	public void editCourt() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='Region']")).sendKeys("AP",Keys.ENTER);	
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='Court']")).sendKeys("TestCourt",Keys.ENTER);
	Thread.sleep(4000);
	driver.findElement(By.xpath("//body/div[@id='root']/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[2]")).click();
	driver.findElement(By.xpath("//span[@class='k-checkbox-wrap']//child::input")).click();
	driver.findElement(By.xpath("//button[@class='k-button k-button-md k-button-solid k-button-solid-primary k-rounded-md m-3']")).click();
	Thread.sleep(8000);
	}
	@Test(enabled = false)
	public void deleteCourt() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='Region']")).sendKeys("AP",Keys.ENTER);	
	Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='Court']")).sendKeys("TestCourt",Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//body/div[@id='root']/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]")).click();
		driver.findElement(By.xpath("//button[@class='k-button k-button-md k-button-solid k-button-solid-primary k-rounded-md m-3']")).click();
	Thread.sleep(5000);
	}	
	@Test(priority=0)
	public void addAgent() throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'Administrator View')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Agent Manager')]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//button[@class='k-button k-button-md k-button-outline k-button-outline-primary k-rounded-md m-2'])[3]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='agentName']")).sendKeys("Test");
	    driver.findElement(By.xpath("(//span[@class='k-checkbox-wrap']//child::input)[1]")).click();
		driver.findElement(By.xpath("//input[@id='sapCode']")).sendKeys("1234");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='k-checkbox-wrap']//child::input)[2]")).click();
		WebElement uploadAadhar=driver.findElement(By.xpath("(//input[@class='form-control fileUploadField'])[1]"));
		uploadAadhar.sendKeys("/Users/a35294/Downloads/car-sample.jpeg");
		Thread.sleep(2000);
		WebElement uploadPAN=driver.findElement(By.xpath("(//input[@class='form-control fileUploadField'])[2]"));
		uploadPAN.sendKeys("/Users/a35294/Downloads/car-sample.jpeg");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='k-button k-button-md k-button-solid k-button-solid-primary k-rounded-md m-3']")).click();
		Thread.sleep(3000);
		}
	}

