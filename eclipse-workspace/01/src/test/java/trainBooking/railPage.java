package trainBooking;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class railPage {
	 WebDriver driver;
	 LocalDate futureDate;
	private By fromField = By.id("txtStationFrom");
    private By toField = By.id("txtStationTo");
    private By sortDate = By.xpath("//input[@title='Select Departure date for availability']");
    private By dropDownList = By.xpath("(//div[contains(@class, 'autocomplete')]/div/div[@title])");
    

    
    public railPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFromStation(String station) {
        WebElement from = driver.findElement(fromField);
        from.clear();
        from.sendKeys(station);
    }
    public void Iframe() {
    	WebElement iFrameElement=driver.findElement(By.xpath("//iframe[@title='Criteo GUM iframe']"));
    	driver.switchTo().frame(iFrameElement);
    }
    public List<WebElement> list() {
    	
//    	 enterFromStation("DEL"); 
    	 


         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
         wait.until(ExpectedConditions.visibilityOfElementLocated(dropDownList));

         // Return list of station suggestions
         return driver.findElements(dropDownList);
    }
   

    public void enterToStation(String station) {
        WebElement to = driver.findElement(toField);
        to.clear();
        to.sendKeys(station);
    }

    public void selectDate(int daysToAdd) {
    	 LocalDate futureDate = LocalDate.now().plusDays(daysToAdd);
         
         
         String day = String.valueOf(futureDate.getDayOfMonth());
         driver.findElement(sortDate).click();
        
        WebElement  dateElement = driver.findElement(By.xpath("//td[text()='" + day + "']"));
         dateElement.click();
    }

    public String getDropdownText(int position) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(dropDownList, position - 1));

        List<WebElement> dropdownOptions = driver.findElements(dropDownList);
        
        if (position - 1 < dropdownOptions.size()) {
            return dropdownOptions.get(position - 1).getAttribute("title");
        } else {
            throw new IndexOutOfBoundsException("Index " + (position - 1) + " out of bounds for length " + dropdownOptions.size());
        }
    }

    }



