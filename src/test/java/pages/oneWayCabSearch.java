package pages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class oneWayCabSearch {
    WebDriver driver;

    public oneWayCabSearch(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[text()=\"Cabs\"]")
    WebElement sourceBox;
	@FindBy(xpath="//label[@for=\"fromCity\"]")
	WebElement findBox;
	@FindBy(xpath="//li[@role='option']") 
	List<WebElement> locations;
	@FindBy(xpath="//input[@placeholder=\"To\"]") 
	WebElement destination;
	@FindBy(xpath="//label[@for=\"departure\"]")
	WebElement departure;
	@FindBy(xpath="//div[@class=\"DayPicker-Caption\"]/div") 
	WebElement current_display;
	@FindBy(xpath="//span[@aria-label=\"Next Month\"]")
	WebElement nextButton;
	@FindBy(xpath="//label[@for=\"pickupTime\"]")
	WebElement pickUpBox;
	@FindBy(xpath="//*[@class=\"hrSlotItemParent\"]")
	List<WebElement> hours;
	@FindBy(xpath="//*[@class=\"minSlotItemParent\"]")
	List<WebElement> mins;
	@FindBy(xpath="//*[@data-cy=\"MeridianSlots_82\"]")
	List<WebElement> meridian;
	@FindBy(xpath="//span[@class=\"applyBtnText\"]")
	WebElement applyBtn;
	@FindBy(xpath="//a[contains(@class,'primaryBtn') and text()='Search']") 
	WebElement searchBtn;
	@FindBy(xpath="//*[text()='SUV']") WebElement suvCheckBox;
	@FindBy(xpath="//*[contains(@class,'font28 latoBlack blackText')]") 
	List<WebElement> prices;
	@FindBy(xpath="//*[text()='More' and @class=\"darkGreyText\"]") 
	WebElement moreBtn;
	@FindBy(xpath="//*[text()='Giftcards']")
	WebElement card;
	

	

    public void sourceLocation(String location) throws InterruptedException {
    	
    	sourceBox.click();
    	Thread.sleep(3000);
        findBox.click();
		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"react-autowhatever-1\"]/div/div/p")));
        for (WebElement ele : locations) {
            String string = ele.getText();
            System.out.println(string);
            if (string.equals(location)) {
                ele.click();
                break;
            }
        }
    }

    public void destinationLocation(String location) throws InterruptedException {
        destination.sendKeys(location);
        Thread.sleep(3000);
        for (WebElement ele : locations) {
            String string = ele.getText();
            System.out.println(string);
            if (string.equals(location)) {
                ele.click();
                break;
            }
        }
    }

    public void departureDate(String current_M, String current_Y, String day) throws InterruptedException {
        driver.switchTo().activeElement();
        departure.click();
        Thread.sleep(1000);
        String month = current_M;
        String year = current_Y;
        while (true) {
            String current = current_display.getText();
            String[] monthDate = current.split(" ");
            String current_month = monthDate[0];
            String current_year = monthDate[1];
            if (current_month.equals(month) && current_year.equals(year)) {
                break;
            } else {
                nextButton.click();
            }
        }
        //driver.findElement(By.xpath("//div[contains(@aria-label, \"" + month + " " + day + " " + year + "\")]")).click();
        driver.findElement(By.xpath("//div[contains(@aria-label, \"Jun 01 2025\")]")).click(); 

    }

    public void pickUpTime(String hrs, String min, String mer) throws InterruptedException {
        driver.switchTo().activeElement();
        pickUpBox.click();
        Thread.sleep(3000);
        for (WebElement hr : hours) {
            if (hr.getText().equals(hrs)) {
                hr.click();
            }
        }
        for (WebElement m : mins) {
            if (m.getText().equals(min)) {
                m.click();
            }
        }
        for (WebElement n : meridian) {
            if (n.getText().equals(mer)) {
                n.click();
            }
        }
        applyBtn.click();
        searchBtn.click();
        
    }

	public void filter() throws InterruptedException {
		Thread.sleep(3000);
	  driver.switchTo().activeElement();
      Thread.sleep(3000);
      WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(30));
      wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='SUV']")));
      suvCheckBox.click();
	}
	public void giftCard() throws FileNotFoundException, IOException, InterruptedException {
		int a=0;
		 Workbook workbook = new XSSFWorkbook();
	        Sheet sheet = workbook.createSheet("LowestPrices");
	        Row headerRow = sheet.createRow(0);
	        headerRow.createCell(0).setCellValue("Price");
	        for (WebElement l:prices) {
	            a = a + 1;
	            String price = l.getText();
	            System.out.println(" Price: " + price);

	            // Write data to Excel
	            Row row = sheet.createRow(a);
	            row.createCell(0).setCellValue(price);
	        }
	        File directory = new File(System.getProperty("user.dir") + "\\dataSheet");
	        if (!directory.exists()) {
	            directory.mkdirs();
	        }
	        // Write the output to a file
	        try (FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.dir") + "\\dataSheet\\Data.xlsx")) {
	            workbook.write(fileOut);
	        }catch(Exception e) {
	        workbook.close();
	        System.out.println("Excel file created successfully.");
	        }
	        
	        Thread.sleep(30000);
		moreBtn.click();
		card.click();
		
	}
	
}
