package testNGTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.cardDetails;

public class cardDetailsTest{
	WebDriver driver=BaseTest.setUp();
	public cardDetails cardPage=new cardDetails(driver);
	 public cardDetailsTest() {};
    @Test(priority = 0)
    public void customerDetails() throws InterruptedException {
        cardPage.details();
    }

    @Test(priority = 1,dependsOnMethods= {"customerDetails"})
    public void senderDetails() throws InterruptedException {
        cardPage.senderDetails();
    }

   
}
