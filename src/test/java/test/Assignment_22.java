package test;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_22 {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
//1. Launch browser window(Chrome)
	 WebDriver driver = new ChromeDriver();
		
	 
//2. Maximize the browser window
	 driver.manage().window().maximize();
	 
//3. Delete all the cookies
	 driver.manage().deleteAllCookies();
	 
//4. Enter URL and Launch the application (https://demoqa.com/automation-practice-form)
	driver.get("https://demoqa.com/automation-practice-form");

//5. Wait for Page-load
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

//6. Enter First name and Last name
	WebElement FirstName = driver.findElement(By.xpath("//input[@id='firstName']"));
	WebElement LastName = driver.findElement(By.xpath("//input[@id='lastName']"));
	
	FirstName.clear();
	LastName.clear();
	FirstName.sendKeys("SAUMYARANJAN");
	LastName.sendKeys("HATI");
	
//7. Enter Email 
	WebElement Email = driver.findElement(By.xpath("//input[@id='userEmail']"));
	Email.sendKeys("sranjan.hati@gmail.com");
			               
//8. Select Gender (Female)
//	 WebElement radioButton= driver.findElement(By.xpath("//label[@class='custom-control-label']"));
//	 if (!radioButton.isSelected()) {
//	        radioButton.click();}
//	 selectDataAccessMode("Female");
//9. Enter mobile number
	 WebElement Mobile = driver.findElement(By.xpath("//input[@id='userNumber']"));
	 Mobile.sendKeys("9953950056");
		               
//10.Select DOB (1-Feb-1991)
//	 WebElement dob =driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
//	 dob.clear();
//	 dob.sendKeys("1-02-1991");
//	 dob.sendKeys(Keys.ENTER);
	 
	 WebElement dobField = driver.findElement(By.id("dateOfBirthInput"));
     dobField.click();
     Select yearSelect = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
     yearSelect.selectByVisibleText("1991");
     Select monthSelect = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")));
     monthSelect.selectByVisibleText("February");
     driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--001']")).click();
	               
//11.Search and Select Computer Science
	 WebElement subject = driver.findElement(By.id("subjectsInput"));
     subject.sendKeys("Computer Science");
     subject.sendKeys(Keys.ENTER);
		               
//12.Select Hobbies as Sports and Reading
     
     driver.findElement(By.xpath("//label[text()='Sports']")).click();
     driver.findElement(By.xpath("//label[text()='Reading']")).click();
		               
//13.Upload photo
     WebElement uploadPhoto = driver.findElement(By.id("uploadPicture"));
     uploadPhoto.sendKeys("C:\\Users\\user\\Documents\\Capture saraswati ma.PNG");
		               
//14. Wait till file upload
     wait.until(ExpectedConditions.attributeContains(uploadPhoto, "value", "Capture saraswati ma.PNG"));
//15. Update current address
     driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("Vasantkunj,New Delhi");
//15.Submit Details
     driver.findElement(By.id("submit")).click();

//16. Close browser window
    driver.quit();
	}

	public static void selectDataAccessMode(String option) {
		WebElement dataAccessMode = driver.findElement(By.xpath("//label[@class='custom-control-label']"));
		dataAccessMode.click();
	}

}
