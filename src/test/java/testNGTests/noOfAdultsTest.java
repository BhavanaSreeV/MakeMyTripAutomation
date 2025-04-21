package testNGTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.noOfAdults;
import pages.oneWayCabSearch;

public class noOfAdultsTest {
	
	 	WebDriver driver=BaseTest.setUp();
	    public noOfAdults nat=new noOfAdults(driver);
	    public noOfAdultsTest() {};
	    @Test(priority = 1)
	    public void sourceSelection() throws InterruptedException {
	        nat.noOfadults();
	    }
	    

}
