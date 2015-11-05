package SeleniumExamples;

import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MacysSearchJeansFilterByBoys {
	@Test
	public void macysSearchProduct() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("http://www.macys.com/");

		driver.findElement(
				By.xpath(".//div[@id='tinybox']//div/a[@id='closeButton']"))
				.click();
		System.out.println("closed");

		driver.findElement(
				By.xpath("//div[@id='nav-search-box']//input[@name='keyword']"))
				.sendKeys("jeans");
		WebElement searchButton =driver.findElement(
				By.xpath("//div[@id='nav-search-box']//input[@id='subnavSearchSubmit']"));
	//	System.out.println("Before search");
		searchButton.submit();
		
	//	System.out.println("Found Jeanns");
		
		
	//	WebDriverWait wait = new WebDriverWait(driver, 10);
	//	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='facets']//following::h2[@id='GENDER']")));
		WebElement gender = driver.findElement(By.xpath("//div[@id='facets']//following::h2[@id='GENDER']"));
		
		gender.click();
		
		driver.findElement(By.xpath("//div[@class='facet']//following::ul[@class='defaultFacet']//following::span[contains(text(),'Boys')]")).click();
	}
}
