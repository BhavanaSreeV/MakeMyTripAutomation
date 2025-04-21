package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class cardDetails {
	
	WebDriver driver;
	public cardDetails(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id=\"amount\"]") WebElement amount;
	@FindBy(xpath="//span[@class=\"font14 lato-black\"]") WebElement quantity;
	@FindBy(xpath="//*[@data-cy=\"Counter_443\"]") WebElement plusBtn;
	@FindBy(xpath="//div[@id=\"deliveredSection\"]") WebElement senderSection;
	@FindBy(xpath="//input[@name=\"senderName\"]") WebElement name;
	@FindBy(xpath="//input[@name=\"senderMobileNo\"]") WebElement contact;
	@FindBy(xpath="//input[@name=\"senderEmailId\"]") WebElement email;
	@FindBy(xpath=" //button[text()='BUY NOW']") WebElement submitBtn;
	

	public void details() throws InterruptedException {
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(30));
		   w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"amount\"]")));
		 amount.click();
		 Actions act=new Actions(driver);
		   act.keyDown(Keys.CONTROL).sendKeys("A").keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).keyUp(Keys.CONTROL).build().perform();
		   Thread.sleep(30);
		   amount.sendKeys("10000");
		   String noOfCards="5";
		   while(true) {
			String value=quantity.getText();
			System.out.println(value);
				if(value.equals(noOfCards)) {
					break;
				}else {
			   		plusBtn.click();
				}
		   }
	}
	public void senderDetails() {
		   JavascriptExecutor js=(JavascriptExecutor) driver;
		   js.executeScript("arguments[0].scrollIntoView()", senderSection);
		   name.sendKeys("BhavanaSree");
		   contact.sendKeys("9876543210");
		   email.sendKeys("bhavana");
		   submitBtn.click();
		   System.out.println(driver.findElement(By.xpath("//*[@id=\"deliveredSection\"]/div/div/div[3]/p")).getText());
		 
	}
	
	   
	   
	  

}
