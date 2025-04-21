package testNGTests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.oneWayCabSearch;

public class oneWayCabSearchTest{
    WebDriver driver=BaseTest.setUp();
    public oneWayCabSearch cabSearch=new oneWayCabSearch(driver);
    public oneWayCabSearchTest() {};
    @Test(priority = 1)
    public void sourceSelection() throws InterruptedException {
        cabSearch.sourceLocation("Delhi");
    }

    @Test(priority = 2,dependsOnMethods= {"sourceSelection"})
    public void destinationSelection() throws InterruptedException {
        cabSearch.destinationLocation("Manali, Himachal Pradesh, India");
    }

    @Test(priority = 3,dependsOnMethods= {"destinationSelection"})
    public void departure() throws InterruptedException {
        cabSearch.departureDate("June", "2025", "01");
    }

    @Test(priority = 4,dependsOnMethods= {"departure"})
    public void pickUp() throws InterruptedException {
        cabSearch.pickUpTime("06 Hr", "30 min", "AM");
    }
    

    @Test(priority = 5,dependsOnMethods= {"pickUp"})
    public void filters() throws InterruptedException {
        cabSearch.filter();
    }

    @Test(priority = 6,dependsOnMethods= {"filters"})
    public void lowestPrices() throws FileNotFoundException, IOException, InterruptedException {
        cabSearch.giftCard();
    }


   
}
