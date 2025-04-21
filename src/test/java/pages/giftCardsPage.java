package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class giftCardsPage {

	WebDriver driver;
	public giftCardsPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//*[text()='Best Wishes Gift Card']") WebElement giftCard;
	
	public void selectCard() throws InterruptedException {
		   Thread.sleep(3000);
		   JavascriptExecutor js=(JavascriptExecutor) driver;
		   js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div[1]/div[2]/div[2]/div[3]/ul/li[1]/div/div/h3")));
		   Thread.sleep(3000);
		    giftCard.click();    
	}


}
