package SeleniumExamples;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class irctcFlightPassengerCount {
	public static WebDriver driver;

	@BeforeTest
	public void testUrlOpen() {
		driver = new FirefoxDriver();
		driver.get("https://www.irctc.co.in");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@AfterTest
	public void testUrlClose() {
		driver.quit();;
	}

	@Test
	public void testPassengerCountPrint() {
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window handle  " + parentWindowHandle);

		driver.findElement(
				By.xpath("//*[@id='bluemenu']/ul//following-sibling::li//a[contains(text(),'Flights')]"))
				.click();
		Set<String> allWindowHandles = driver.getWindowHandles();

		for (String win : allWindowHandles) {
			if (!parentWindowHandle.equals(win)) {
				driver.switchTo().window(win);
				System.out.println(driver.getTitle());
			}
		}
		flightDetails(driver);
		
		flightCount(driver);
	}
	
	public void flightDetails(WebDriver driver){
		driver.findElement(By.id("origin")).sendKeys("Delhi (New Delhi),DEL");
		driver.findElement(By.xpath("//a[text()='Delhi (New Delhi),DEL']")).click();
		
		driver.findElement(By.id("destination")).sendKeys("Bombay (Mumbai),BOM");
		driver.findElement(By.xpath("//a[text()='Bombay (Mumbai),BOM']")).click();
		
		driver.findElement(By.id("departDate")).sendKeys("21/11/2015");
		
		Select noOfAdults = new Select(driver.findElement(By.id("noOfAdult")));
		noOfAdults.selectByValue("2");
		
		Select noOfChilds = new Select(driver.findElement(By.id("noOfChild")));
		noOfChilds.selectByValue("1");
		
		driver.findElement(By.xpath("//div[@id='showdometic']//div[@class='srchbtn']")).click();
			
	}
	public void flightCount(WebDriver driver){
		Assert.assertEquals("http://www.air.irctc.co.in/IndianRailways/af/irctc/flight/flightSearch.do", driver.getCurrentUrl());
		List<WebElement> flightCountList = driver.findElements(By.xpath("//div[@id='flightListResult']//div[@class='onewayflightinfo']"));
		
		int flightCount =flightCountList.size();
		System.out.println("Number of flights   "+ flightCount);
		
		driver.findElement(By.id("minPrice")).click();
		
		WebElement WebElPrice = driver.findElement(By.xpath("//div[@id='flightListResult']/div[1]/table/tbody//td[@width]//span[@class='onewayprice']"));
		
		int iWebElPrice = Integer.parseInt(WebElPrice.getText());
		
		if(iWebElPrice<50000){
			System.out.println("Hurray!! price is less than 50000 rs and value is  "+ iWebElPrice +" rs");
		}
		else{
			System.out.println("Price is not less than 50000 rs");
		}
	}}
