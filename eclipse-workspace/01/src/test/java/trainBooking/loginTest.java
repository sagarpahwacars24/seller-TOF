package trainBooking;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

	public class loginTest {
		 private WebDriver driver;
		 static ExtentReports extent;
		    static ExtentTest test;
		    
		    @BeforeSuite
		    public void setupExtent() {
		        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
		        extent = new ExtentReports();
		        extent.attachReporter(sparkReporter);
		    }


		    @BeforeClass
		    public void setup() {
		        
		        driver = new ChromeDriver();
		        driver.manage().window().maximize();
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    }
		    
		    public void commonWait() {
		        new WebDriverWait(driver, Duration.ofSeconds(20))
		            .until((Function<WebDriver, Boolean>) wd ->
		                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
		        System.out.println("Page loaded completely.");
		    }

		    @Test(priority = 1)
		    public void testTrainSearch() throws IOException {
		    	 test = extent.createTest("Test Case: Enter DEL in from station");
		        driver.get("https://erail.in/");
		        commonWait();
		        railPage homePage = new railPage(driver);

		        homePage.enterFromStation("DEL");
		      
//		        homePage.Iframe();
		        String stationName = homePage.getDropdownText(4);
		        System.out.println("Selected Station: " + stationName);
                Assert.assertNotNull(stationName);
		    }
		    @Test(priority = 2)
		    public void excelComparison() throws IOException {
		    	 test = extent.createTest("Test Case: Comparing station name in excel");
		    	 List<String> expectedStations = new ArrayList<>();
		    	
		         expectedStations.add("Mumbai Station");
		         expectedStations.add("Test");
		         expectedStations.add("Delhi");
		         expectedStations.add("Bengaluru");
		         expectedStations.add("Delhi cantt");
		         expectedStations.add("Ambala cantt");
		 
		         railPage homePage = new railPage(driver);

			        homePage.enterFromStation("DEL");
//		        homePage.Iframe();
		        
		         // Capture actual station names from the webpage
		         List<WebElement> stations = homePage.list();
		         List<String> actualStations = new ArrayList<>();

		         for (WebElement station : stations) {
		        	 String stationName = station.getAttribute("title");
		        	    System.out.println(stationName); // Print station name
		        	    actualStations.add(stationName); // Adjust XPath
		        
		         
		  
		         }

		         // Create an Excel sheet
		         XSSFWorkbook workbook = new XSSFWorkbook();
		         XSSFSheet sheet = workbook.createSheet("Station Comparison");

		         // Create header row
		         XSSFRow headerRow = sheet.createRow(0);
		         headerRow.createCell(0).setCellValue("Expected Station");
		         headerRow.createCell(1).setCellValue("Actual Station");
		         headerRow.createCell(2).setCellValue("Match Status");

		         // Write data to Excel
		         int rowNum = 1;
		         for (int i = 0; i < expectedStations.size(); i++) {
		        	 XSSFRow row = sheet.createRow(rowNum++);
		             String expected = expectedStations.get(i);
		             String actual = (i < actualStations.size()) ? actualStations.get(i) : "Not Found";

		             row.createCell(0).setCellValue(expected);
		             row.createCell(1).setCellValue(actual);

		             // Compare and write match status
		             String matchStatus = expected.equalsIgnoreCase(actual) ? "MATCH" : "MISMATCH";
		             row.createCell(2).setCellValue(matchStatus);
		         }

		         // Save to file
		         FileOutputStream fileOut = new FileOutputStream("test-output/StationComparison.xlsx");
		         workbook.write(fileOut);
		         fileOut.close();
		         workbook.close();

		         System.out.println("Comparison results saved successfully!");

		    }
		    @Test(priority = 3)
		    public void selectFutureDate() throws InterruptedException {
		       railPage homePage = new railPage(driver);
		        homePage.selectDate(30);
		        LocalDate date= homePage.futureDate;
		        System.out.println("Date selected successfully!"+date);
              test.pass("Successfully selected future date: " + LocalDate.now().plusDays(30));
              Thread.sleep(2000);
		    }
		

		  
		    	@DataProvider(name = "loginData")
		        public Object[][] fetchLoginData() throws IOException {
		            return LoginData.getTestData("/src/test/resources/LoginData.xlsx","login"); 
		        }

		        @Test(dataProvider = "loginData",priority=4)
		        public void testLoginWithData(String Username, String Password) {
		        	test = extent.createTest("Login Test for User: " + Username);
		        	try {
		            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		            WebElement userField = driver.findElement(By.name("username"));
		            WebElement passField = driver.findElement(By.name("password"));
		            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

		            userField.clear();
		            userField.sendKeys(Username);
		            passField.clear();
		            passField.sendKeys(Password);
		            loginButton.click();

		            Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login Failed for: " + Username);
		            
		            test.pass("Login Successful for: " + Username);
		            } catch (Exception e) {
		                test.fail("Login Test Failed for: " + Username);
		                test.fail(e.getMessage());
		            }
		        }

		        @AfterClass
		        public void tearDown() {
		            driver.quit();
		        }
		        @AfterSuite
		        public void flushReports() {
		            extent.flush();
		            System.out.println("Extent Report generated: test-output/ExtentReport.html");
		        }
		    
		    }
		