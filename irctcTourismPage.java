package pagesIrctcExample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class irctcTourismPage {

	private static By topNavPanel = By.xpath("//ul[@id='main-menu']/li/a");
	private static By ecarting  = By.xpath("//ul[@id='main-menu']//li[@class='more']//following-sibling::ul//a[contains(text(),'E-catering')]");
	private static By more = By.xpath("//ul[@id='main-menu']//following-sibling::li[@class='more']/a/span");
	
	public static List<WebElement> findTopNavPanel(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(topNavPanel));
		
		List<WebElement> list = driver.findElements(topNavPanel);
		Thread.sleep(5000);
	//	System.out.println(list.size()+ "  "+list);
		return list;

	}

	public static WebElement findECarting(WebDriver driver) throws InterruptedException {
		
		WebElement moreOption = driver.findElement(more);
		System.out.println("More is found");
		
		Actions action = new Actions(driver);
	
		System.out.println("Action is build");
	//	action.clickAndHold(moreOption).build().perform();
		action.moveToElement(moreOption).build().perform();
	
		System.out.println("More is hovered about to click carting");
		WebElement element =driver.findElement(ecarting);
		
		System.out.println("found catering");
		return element;
		}
		
	

}
