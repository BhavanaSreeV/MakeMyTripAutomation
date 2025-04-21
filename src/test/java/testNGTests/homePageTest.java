package testNGTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.homePage;
import pages.oneWayCabSearch;

public class homePageTest{
	
	WebDriver driver=BaseTest.setUp();
	public homePage home=new homePage(driver);
   public homePageTest() {};
    @Test(priority = 0)
    public void closePopUp() throws InterruptedException {
       home.popUp();
    }
//    @Test(priority = 1)
//    public void sourceSelection() throws InterruptedException {
//        cabSearch.sourceLocation("Delhi");
//    }
//
//    @Test(priority = 2)
//    public void destinationSelection() throws InterruptedException {
//        cabSearch.destinationLocation("Manali, Himachal Pradesh, India");
//    }
//
//    @Test(priority = 3)
//    public void departure() throws InterruptedException {
//        cabSearch.departureDate("June", "2025", "01");
//    }
//
//    @Test(priority = 4)
//    public void pickUp() throws InterruptedException {
//        cabPage=cabSearch.pickUpTime("06 Hr", "30 min", "AM");
//    }
//    @Test(priority = 5)
//    public void filters() throws InterruptedException {
//        cabPage.filter();
//    }
//
//    @Test(priority = 6)
//    public void lowestPrices() {
//        giftPage=cabPage.giftCard();
//    }
//    @Test(priority = 7)
//    public void selection() throws InterruptedException {
//        cardPage=giftPage.selectCard();
//    }
//    @Test(priority = 8)
//    public void customerDetails() throws InterruptedException {
//        cardPage.details();
//    }
//
//    @Test(priority = 9)
//    public void senderDetails() throws InterruptedException {
//        cardPage.senderDetails();
//    }



   
}
