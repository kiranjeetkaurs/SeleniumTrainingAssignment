package pagesIrctcExample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class irctcEcartingOderPage {
	private static By checkOutBtn = By.id("button");
	private static By  replanBtn = By.xpath("//div[@id='headnavR']//following-sibling::a[contains(text(),'Replan')]");
	private static By  totalAmt = By.xpath("//div[@id='totalAmount']/h2/strong");
	
	public static WebElement findCheckOutBtn(WebDriver driver){
		WebElement element =driver.findElement(checkOutBtn);		
		return element;
	}
	
	public static Alert findCheckOutAlert(WebDriver driver ){
		
		Alert alert = driver.switchTo().alert();
		return alert;
	}
	
	public static WebElement findReplanBtn(WebDriver driver){
		WebElement element =driver.findElement(replanBtn);		
		return element;
	}
	
	public static WebElement findTotalAmt(WebDriver driver){
		WebElement element =driver.findElement(totalAmt);		
		return element;
	}
}
