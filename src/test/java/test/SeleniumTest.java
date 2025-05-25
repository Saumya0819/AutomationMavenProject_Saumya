package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {
     
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://www.google.com"); // Open a website
        System.out.println("Title: " + driver.getTitle()); // Print page title
        Thread.sleep(5000); // Wait for 5 seconds

        driver.close(); // Close the browser

    }
}