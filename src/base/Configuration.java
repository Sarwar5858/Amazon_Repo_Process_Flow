package base;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import utilities.Generic_Class;

public class Configuration extends Generic_Class {
 @BeforeSuite
	public void Before_Suite() {
	 applicationLogs.info("Started Test Suite");
	 //System.out.println("Started Test suite");
	}

 @AfterSuite
	public void After_Suite() {
	 applicationLogs.info("Ends Test Suite");	
	// System.out.println("Ends Test suite");
	}
//This class will hold:
	//1. Driver initialization
			//Initialization through the inheritance
	
	//2. Set up browser
@Parameters({"url", "browser"})

 
 @BeforeTest
	public void BrowserSetup (String baseURL,String BrowserName) {
	if (driver==null) {	
	if (BrowserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver","C:\\Users\\sarwa\\eclipse-workspace\\DRIVER\\geckodriver.exe");
			//System.setProperty("webdriver.gecko.driver",System.getProperty(("user.dir")+ "\\DRIVER\\geckodriver.exe"));
			driver = new FirefoxDriver();
			MaxPage();}
			else if (BrowserName.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver","C:\\Users\\sarwa\\eclipse-workspace\\DRIVER\\chromedriver.exe");
				//System.setProperty("webdriver.chrome.driver",System.getProperty(("user.dir")+ "\\DRIVER\\chromedriver.exe"));
				driver = new ChromeDriver();
				MaxPage();
				}
				
		//driver.manage().window().maximize();}			
			else 
				{throw new IllegalArgumentException ("Browser Type is undefined");}
					}
			//System.out.println("Broswser not found: "+BrowserName);
		
			driver.get(baseURL);
			applicationLogs.info("www.amazon.com is opened");
			//System.out.println("www.amazon.com is opened");
			}
	
	
	//3. Company's base URL
	/*@BeforeMethod
	
	public void BaseURL(String URL) {
		driver.get(URL);
		MaxPage();
	}
	
	@AfterMethod 
		public void CloseURL() {
		System.out.println("One test case is done");
	}*/
	
	
	//4. Database connection (if any)
		
	//5. Driver close
	@AfterTest	
	public void BrowserClose() {
			driver.close();
			applicationLogs.info("Browser is closed");
			//System.out.println("Browser is closed");
		}

}

//Sequence for annotations:
//Before Suite
//Before Test
//Before Class

//Before Method
//Test Case 1
//After Method

//Before Method
//Test Case 2
//After Method

//Before Method
//Test Case 3
//After Method

//After Class
//After Test
//After Suite


