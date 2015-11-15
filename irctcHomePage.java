package pagesIrctcExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class irctcHomePage {

	private static By hotel = By.id("hotelsAndLounges");
	private static By hotelnlounge = By.xpath(".//a[@id='hotelsAndLounges']//following-sibling::ul/li/a[contains(text(),'Lounge')]");
	
	public static WebElement findNavigationTabHotel(WebDriver driver){
		
		WebElement hotelElement = driver.findElement(hotel);
		Actions action = new Actions(driver);
		action.moveToElement(hotelElement).build().perform();
		
		WebElement element = driver.findElement(hotelnlounge);
		return element;
	}
}
