package Selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumXpathAdvanced {

	
	/********************Level 4 - advanced Xpath by using relationships **********************/
	// Syntax 8 : referenceElementXpath/relationship::targetElementXapath
	
	//child
	//parent
	//preceding
	//following
	//ancestor
	//preceding-sibling
	//following-sibling
	//
	
	
	//ancestor ==> //ul[@class='leftmenu']
	//parent ==> //li
	//target ==> //a[text()='Services']
	
	//ul[@class='leftmenu']/child::li/child::a[text()='Services']
	//ul[@class='leftmenu']//a[text()='Services']
	
	// target --> sibling --> parent --> ancestor --> ancestor's parent

	public static void main(String[] args) {  
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");		
//Find the 'services' link using xpath locator -syntax 8
		driver.findElement(By.xpath("//ul[@class='leftmenu']//a[text()='Services']"));
//Find the 'Parabank Logo' using xpath
		driver.findElement(By.xpath("//div[@id='mainPanel']/child::div/child::a[2]//img[@title='ParaBank']"));
//Find the 'solution'link using xpath
		driver.findElement(By.xpath("//ul[@class='leftmenu']//li"));
//Find "About Us"
		driver.findElement(By.xpath("//ul[@class='leftmenu']/child::li[2]/child::a[contains(text(),'About Us')]"));
//Find "Products" 
		driver.findElement(By.xpath("//ul[@class='leftmenu']/child::li[4]//a[text()='Products']"));
//Find 	"Locations"
		driver.findElement(By.xpath("//ul[@class='leftmenu']/child::li[5]//a[text()='Locations']"));
//Find "Admin Page"
		driver.findElement(By.xpath("//ul[@class='leftmenu']/child::li[6]/child::a[text()='Admin Page']"));
				

	}
}
