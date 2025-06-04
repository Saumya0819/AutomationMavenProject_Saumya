package test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
public class Assignment_21 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
//1. Launch browser window	
		WebDriver driver = new ChromeDriver();
//2. Maximize the browser window  
		driver.manage().window().maximize();

//3. Delete all browser cookies 
		driver.manage().deleteAllCookies();

//4. Enter URL and Launch the Application (https://www.google.co.in/)  
		driver.get("https://parabank.parasoft.com/parabank/index.htm");		
//5. Verify application title	
		//driver.findElement(By.xpath("//div[@id='mainPanel']/child::div/child::a[2]//img[@title='ParaBank']"));
		String expectedTitle = "ParaBank | Welcome | Online Banking";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Title verified: " + actualTitle);
        } else {
            System.out.println("Title mismatch! Expected: " + expectedTitle + ", Actual: " + actualTitle);}
            
//5.Verify application title
        WebElement title = driver.findElement(By.xpath("//div[@id='mainPanel']/child::div/child::a[2]//img[@title='ParaBank']"));

        if (title.isDisplayed()) {
            System.out.println("Title is displayed.");
        } else {
            System.out.println("Title is not displayed.");
        }      
       
//6. Verify application logo
        
        WebElement logo = driver.findElement(By.xpath("//div[@id='mainPanel']/child::div/child::a[2]//img[@class='logo']"));

        if (logo.isDisplayed()) {
            System.out.println("Logo is displayed.");
        } else {
            System.out.println("Logo is not displayed."); }
        
//7. Verify application caption	
        
        WebElement caption = driver.findElement(By.xpath("//div[@id='mainPanel']/child::div/child::p[text()='Experience the difference']"));
        String expectedCaption = "Experience the difference";
        String actualCaption = caption.getText();

        if (expectedCaption.equals(actualCaption)) {
            System.out.println("Caption Verified: " + actualCaption);
        } else {
            System.out.println("Caption Mismatch. Expected: " + expectedCaption + ", but got: " + actualCaption);
        }
//8. Enter Invalid credentials in Username and Password textboxes
//        WebElement Username = driver.findElement(By.xpath("//div[@id='mainPanel']/child::div[3]/child::div/child::div/child::form/child::div//input[@name='username']"));  
//        Username.sendKeys("Saumya");
//        WebElement Password = driver.findElement(By.xpath("//div[@id='mainPanel']/child::div[3]/child::div/child::div/child::form/child::div[2]//input[@name='password']"));  
//        Password.sendKeys("Saumya@1234");
        driver.findElement(By.name("username")).sendKeys("Saumya");
        driver.findElement(By.name("password")).sendKeys("Saumya@1234");
//9. Click on Login Button
//        WebElement Login = driver.findElement(By.xpath("//div[@id='mainPanel']/child::div[3]/child::div/child::div/child::form/child::div[3]//input[@class='button']"));  
//        Login.click();
        driver.findElement(By.xpath("//div[@id='mainPanel']/child::div[3]/child::div/child::div/child::form/child::div[3]//input[@class='button']")).click();
//10. Verify error message is displayed (An internal error has occurred and has been logged.) 
        WebElement errorMsg = driver.findElement(By.xpath("//div[@id='mainPanel']/child::div[3]/child::div[2]//p[@class='error']"));
        String expectedError = "An internal error has occurred and has been logged.";
        String actualError = errorMsg.getText();
        if (expectedError.equals(actualError)) {
            System.out.println("Error verified: " + actualError);
        } else {
            System.out.println("Error message mismatch! Expected: " + expectedError + ", Actual: " + actualError);}
//11. Click on Adminpage link   
        driver.findElement(By.linkText("Admin Page")).click();
        
//12. Wait for admin page 
        Thread.sleep(3000);
//13.Select Data access mode as ' SOAP'
        WebElement radioButton = driver.findElement(By.xpath("//div[@id='mainPanel']/child::div[3]/child::div[2]/child::form/child::table/child::tbody/child::tr/child::td//input[@type='radio']"));
		radioButton.click();
//14.Scrolldown till Loan provider		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", "Loan Provider");
		
//15. Select Loanprovider as 'Web Service'
		
       WebElement dropdown = driver.findElement(By.xpath("//div[@id='mainPanel']/child::div[3]/child::div[2]/child::form/child::table[3]/child::tbody/child::tr[4]/child::td[2]//select[@id='loanProvider']"));   
		Select select = new Select(dropdown);
		List<WebElement> options = select.getOptions();
		for (WebElement option : options) {
			System.out.println(option.getText()); // Print each option text
		}
		//select.selectByVisibleText("Option 1"); // Select by visible text
		select.selectByValue("Web Service"); // Select by value attribute
		//select.selectByIndex(1); // Select by index (0-based)
		driver.close();
		
        
        
        
        
        
        
        
        
        
        
        
        
        
	}

}
