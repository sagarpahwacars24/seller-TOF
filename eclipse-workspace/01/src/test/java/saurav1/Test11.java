package saurav1;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test11 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();

		driver.get("https://stage-c2b-panel-internal.qac24svc.dev/login");
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
//        Boolean element=wait.until(ExpectedConditions.titleContains("C2B Panels"));
//		System.out.println(element);
//		Thread.sleep(5000);
//		WebElement shadowHost = driver.findElement(By.xpath("//descope-wc[@project-id='P2XG2zbRpuU2xTqPUKuLICINHf35']"));
//		
//        //  JavaScript to access the Shadow DOM and find the element
//        WebElement shadowChild = (WebElement) ((JavascriptExecutor) driver).executeScript(
//                "return arguments[0].shadowRoot.querySelector('[id=\"crechrNO04\"]');", shadowHost);
//        shadowChild.click();
//        Thread.sleep(5000);
//		driver.findElement(By.id("identifierId")).sendKeys("saurav2.kumar@cars24.com");
//		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Saurav@car24");
//		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
//		Thread.sleep(15000);
//		driver.findElement(By.xpath("//span[contains(text(),'Administrator View')]")).click();
//		driver.findElement(By.xpath("//span[contains(text(),'Reason Manager')]")).click();
//		driver.findElement(By.xpath("(//span[contains(text(),'Add Reason')])[2]")).click();
//		Thread.sleep(4000);
//		driver.findElement(By.xpath("//input[@id='addVerificationRejectReason']")).sendKeys(a);
//		driver.findElement(By.xpath("//button[@class='k-button k-button-md k-button-solid k-button-solid-primary k-rounded-md m-3']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@id='verificationRejection']")).sendKeys(a,Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//span[@class='k-icon k-font-icon k-i-edit m-2'])[2]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//span[@class='k-checkbox-wrap']//child::input")).click();
//		driver.findElement(By.xpath("//span[contains(text(),'Confirm')]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@id='verificationRejection']")).sendKeys(a,Keys.ENTER);
//		driver.findElement(By.xpath("(//span[@class='k-icon k-font-icon k-i-delete m-2'])[2]")).click();
//		driver.findElement(By.xpath("//button[@class='k-button k-button-md k-button-solid k-button-solid-primary k-rounded-md m-3']")).click();
//       
		
//		String popUpText="dgevfyegv56567236732378hscv";
////		System.out.println(popUpText);
//		Pattern pattern = Pattern.compile("\\d+");
//		Matcher matcher = pattern.matcher(popUpText);
//		String appointmentID = "";
//		if (matcher.find()) {
//		    appointmentID = matcher.group();
//		}
////		    System.out.println("Appointment ID: " + appointmentID);
//		
//		    long appointmentIDLong = Long.parseLong(appointmentID);
//			
//		    String search=String.valueOf(appointmentIDLong);
//		    System.out.println(search);
		
//		
//		String a="sau123rav456kumar";
//		String b="";
//		for(int i=0;i<a.length();i++) {
//			char c=a.charAt(i);
//		    if(c!='a'-'z' || c!='A'-'Z') {
//		    	
//				 b=c+b;
//				
//				
//			}
//		
//		    }
//		System.out.println(b);
		
		
		 LocalDate tomorrow = LocalDate.now().plusDays(2);

	        // Format it as "EEE d MMM" (e.g., "Sat 22 Mar")
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE d MMM");
	        String tomorrowFormatted = tomorrow.format(formatter);
	        System.out.println(tomorrowFormatted);

	}
}
