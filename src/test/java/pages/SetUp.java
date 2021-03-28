package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import utils.TestUtils;
public class SetUp {	

	public static WebDriver driver;
	Properties properties;
	String browser;
	String url;

	
public void doSetUpBeforeExecution() {
		
		
		 String projectPath = System.getProperty("user.dir");
	     properties = new Properties();	
	     
	     //loading properties 
	     try {
	            properties.load(new FileInputStream(new File("./src/test/resources/config/dev.properties")));
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        browser = properties.getProperty("browser");
		    url = properties.getProperty("url") ;
	      //setting driver path
	        if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver",
                        projectPath + "\\src\\test\\resources\\drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver",
                        projectPath + "\\src\\test\\resources\\drivers\\chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("internetExplorer")) {
                System.setProperty("webdriver.ie.driver",
                        projectPath + "\\src\\test\\resources\\drivers\\MicrosoftWebDriver.exe");
                driver = new InternetExplorerDriver();
            }
	       
	    	driver.manage().window().maximize();
	    	driver.manage().deleteAllCookies();
	    	driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	    	driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
	    	driver.get(url);
	    	
	}
	


}
