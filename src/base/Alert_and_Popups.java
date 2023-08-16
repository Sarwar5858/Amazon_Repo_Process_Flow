//Handle JavaScript alerts, prompts, and confirmations. 
package base;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Alert_and_Popups {
	static WebDriver driver;
	public static void main(String[] args) throws Exception {
	Launch();
	driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
//	JavascriptExecutor jse = (JavascriptExecutor)driver; 
//	jse.executeScript("window.scrollBy(0,700)", "");
	driver.findElement(By.xpath("//input[@name='prompt']")).click();
	//SimpleAlert();
	//ConfirmationAlert();
	Thread.sleep(5000);
	try {
	PromptAlert();}
	catch (Exception e) {System.out.println(e.getMessage());}

	}

	
	public static void Launch() {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\sarwa\\eclipse-workspace\\DRIVER\\geckodriver.exe");
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	public static void SimpleAlert() {
		Alert SA = driver.switchTo().alert();
		SA.accept();
	}
	
	public static void ConfirmationAlert () {
		Alert CA= driver.switchTo().alert();
		CA.dismiss();
	}
	
	public static void PromptAlert () throws Exception {
		Alert PA= driver.switchTo().alert();
		PA.sendKeys("I don't want to see this");
		Thread.sleep(3000);
		PA.accept();
	}
}
