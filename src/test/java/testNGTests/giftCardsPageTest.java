package testNGTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.giftCardsPage;

public class giftCardsPageTest {
	WebDriver driver=BaseTest.setUp();
	
	public giftCardsPage giftPage=new giftCardsPage(driver);
	public giftCardsPageTest() {};
    @Test(priority = 0)
    public void selection() throws InterruptedException {
        giftPage.selectCard();
    }

    
}
