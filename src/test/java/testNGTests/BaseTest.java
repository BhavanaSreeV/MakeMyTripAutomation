package testNGTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import pages.cardDetails;
import pages.giftCardsPage;
import pages.homePage;
import pages.oneWayCabSearch;

public class BaseTest {
	public static WebDriver driver;
	  
	    @BeforeClass
	    public static WebDriver setUp() {
	    	System.out.println("driver setup");
	       
	      if(driver==null) {
	    	  
	    	  driver = new EdgeDriver();
	    	  
	    	  driver.get("http://www.makemytrip.com");
	    	  driver.manage().window().maximize();
	      }
	        
	        return driver;
	      
	    }
	    @AfterClass
	    public void tearDown() {
	    	
	    }

}
