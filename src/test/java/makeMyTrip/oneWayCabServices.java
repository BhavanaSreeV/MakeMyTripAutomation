package makeMyTrip;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class oneWayCabServices {
	public static void main(String[] args) throws InterruptedException {
//		Scanner sc=new Scanner(System.in);
//		String input=sc.next();
		WebDriver driver=new ChromeDriver();
		String baseUrl="https://www.makemytrip.com/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/div/section/span")).click();
		driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div/div/nav/ul/li[7]/span/a/span[1]/span")).click();
		
		Thread.sleep(3000);
		//source
		driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div[1]/div[1]/label")).click();
		 // Wait for the dropdown to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"react-autowhatever-1\"]/div/div/p")));
       List<WebElement> li=driver.findElements(By.xpath("//li[@role='option']"));
       for(WebElement ele:li) {
    	   String string=ele.getText();
    	   System.out.println(string);
    	   if(string.equals("Delhi")) {
    		   ele.click();
    		   break;
    	   }
       }
      
//      //destination
		
        driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div/input")).sendKeys("Manali");
        Thread.sleep(3000);        
        List<WebElement> ele=driver.findElements(By.xpath("//li[@role='option']"));
        for(WebElement e:ele) {
        	if(e.getText().equals("Manali, Himachal Pradesh, India")) {
        	//System.out.println(e.getText());
        		e.click();
        		break;
        	}
        }
        
        driver.switchTo().activeElement();
  	  driver.findElement(By.xpath("//label[@for=\"departure\"]")).click();
  	  Thread.sleep(1000);
     // driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[2]/div[1]")).click();
  	  String month="June";
  	  String year="2025";
      while(true) {
    	  String current=driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[1]/div")).getText();
    	  String[] monthDate=current.split(" ");
    	  String current_month=monthDate[0];
    	  String current_year=monthDate[1];
    	  if(current_month.equals(month) && current_year.equals(year)) {
    		  break;
    	  }else {
    		  driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]")).click();
    	  }
      }
      driver.findElement(By.xpath("//div[contains(@aria-label, \"Jun 01 2025\")]")).click(); 
      //pick-up time
      driver.switchTo().activeElement();
      driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div[1]/div[5]/label")).click();
      Thread.sleep(3000);
      List<WebElement> hrs=driver.findElements(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div[1]/div[5]/div[1]/div[2]/ul[1]/li"));
      for(WebElement hr:hrs) {
    	  if(hr.getText().equals("06 Hr")) {
    		  hr.click();
    	  }
      }
      List<WebElement> min=driver.findElements(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div[1]/div[5]/div[1]/div[2]/ul[2]/li"));
      for(WebElement m:min) {
    	  if(m.getText().equals("30 min")) {
    		  m.click();
    	  }
      }
      List<WebElement> noon=driver.findElements(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div[1]/div[5]/div[1]/div[2]/ul[3]/li"));
      for(WebElement n:noon) {
    	  if(n.getText().equals("AM")) {
    		  n.click();
    	  }
      }
      driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/div[1]/div[5]/div[1]/div[1]/div[5]/span")).click();
      driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div[2]/p/a")).click();
      //SUV
    //  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div/section/span")).click();
      
      driver.switchTo().activeElement();
      Thread.sleep(3000);
      WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(30));
      wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='SUV']")));
      WebElement element = driver.findElement(By.xpath("//*[text()='SUV']"));	
    element.click(); 
   List<WebElement> list=driver.findElements(By.xpath("//*[contains(@class,'font28 latoBlack blackText')]"));
   for(WebElement l:list) {
	   System.out.println(l.getText());
   }
   
   //giftcard
   driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/nav/ul/li[10]")).click();
   driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/nav/ul/li[10]/div/a[2]")).click();
   Thread.sleep(3000);
   JavascriptExecutor js=(JavascriptExecutor) driver;
   js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div[1]/div[2]/div[2]/div[3]/ul/li[1]/div/div/h3")));
   Thread.sleep(3000);
   driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div[1]/div[2]/div[2]/div[3]/ul/li[1]/div/div/h3")).click();
   
   //
   WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(30));
   w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"amount\"]")));
 
   driver.findElement(By.xpath("//*[@id=\"amount\"]")).click();
   Actions act=new Actions(driver);
   act.keyDown(Keys.CONTROL).sendKeys("A").keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).keyUp(Keys.CONTROL).build().perform();
   Thread.sleep(30);
   driver.findElement(By.xpath("//*[@id=\"amount\"]")).sendKeys("1000");
   String noOfCards="5";
   while(true) {
	String value=driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div[2]/div[1]/div[1]/div/div/div[2]/div/span[2]")).getText();
		if(value.equals(noOfCards)) {
			break;
		}else {
	   		driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div[2]/div[1]/div[1]/div/div/div[2]/div/span[3]")).click();
		}
   
   }
   
   //
   
   js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//div[@id=\"deliveredSection\"]")));
   driver.findElement(By.xpath("//*[@id=\"deliveredSection\"]/div/div/div[1]/div/input")).sendKeys("BhavanaSree");
   driver.findElement(By.xpath("//*[@id=\"deliveredSection\"]/div/div/div[2]/div[2]/div/input")).sendKeys("9876543210");
   driver.findElement(By.xpath("//*[@id=\"deliveredSection\"]/div/div/div[3]/div/input")).sendKeys("bhavana");
   driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div/div[1]/div[3]/div[2]/div[1]/div[3]/button")).click();
System.out.println(driver.findElement(By.xpath("//*[@id=\"deliveredSection\"]/div/div/div[3]/p")).getText());
   //driver.quit();
	driver.navigate().to("https://www.makemytrip.com/");
	driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div/div/nav/ul/li[2]/span")).click();
	 WebDriverWait load=new WebDriverWait(driver,Duration.ofSeconds(30));
	   load.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for=\"guest\"]")));
driver.findElement(By.xpath("//label[@for=\"guest\"]")).click();
driver.findElements(By.xpath("//div[@class=\"gstSlct\"]")).get(1).click();
List<WebElement> adults=driver.findElements(By.xpath("//*[@class=\"gstSlct__list\"]/li"));
for(WebElement eleM:adults) {
	System.out.println(eleM.getText());
}
   
	}
	
	

}
