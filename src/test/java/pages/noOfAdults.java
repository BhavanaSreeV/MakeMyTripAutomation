package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class noOfAdults {

	WebDriver driver;
	public noOfAdults(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//li[@class=\"menu_Hotels\"]") WebElement hotels;
	@FindBy(xpath="//label[@for=\"guest\"]") WebElement roomsGuests;
	@FindBy(xpath="//div[@class=\"gstSlct\"]") List<WebElement> adults;
	@FindBy(xpath="//*[@class=\"gstSlct__list\"]/li") List<WebElement> noOfAdults;
	
	public void noOfadults() throws InterruptedException {
		driver.navigate().to("https://www.makemytrip.com/");
		Thread.sleep(300);
		hotels.click();
		WebDriverWait load=new WebDriverWait(driver,Duration.ofSeconds(30));
		load.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for=\"guest\"]")));
		roomsGuests.click();
		adults.get(0).click();
		for(WebElement eleM:noOfAdults) {
			System.out.println(eleM.getText());
		}
	}

}
