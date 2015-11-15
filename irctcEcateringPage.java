package pagesIrctcExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class irctcEcateringPage {

	private static By stnCode = By.id("stnCode");
	private static By stnSearch  = By.xpath("//div[@id='stncode']//input[@id='btnSearch']");
	private static By stnCodeDli = By.xpath("//ul[@id='ui-id-1']//following-sibling::li[contains(text(),'DLI')]");
	
	public static WebElement findStationTextBx(WebDriver driver){
		WebElement element =driver.findElement(stnCode);
		return element;
	}
	
	public static WebElement findStationTextBx1(WebDriver driver){
		WebElement element = driver.findElement(stnCodeDli);
		return element;
	}
	public static WebElement findStationSearch(WebDriver driver){
		WebElement element =driver.findElement(stnSearch);
		
		return element;
	}
}
