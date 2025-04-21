package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
	WebDriver driver;
	public homePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath="//span[@class=\"commonModal__close\"]") WebElement popUp;
	
	public oneWayCabSearch popUp() throws InterruptedException {
		Thread.sleep(3000);
		popUp.click();
		return new oneWayCabSearch(driver);
	}
	

}
