package SeleniumExamples;

import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class macysRandomSearchPageNoVerification {

	public static WebDriver driver;

	@BeforeMethod
	public void testOpenUrl() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://www.macys.com/");
		driver.findElement(
				By.xpath(".//div[@id='tinybox']//div/a[@id='closeButton']"))
				.click();
	}

	@Test
	public void testMacysFilterAndPageNo() throws InterruptedException {
		List<WebElement> lelement = driver.findElements(By
				.xpath("//div[@id='globalMastheadCategoryMenu']/ul/li"));

		int lSize = lelement.size();
		System.out.println("Size of top navgation row  "+ lSize);

		Random rand = new Random();
		int n = rand.nextInt(lSize);
		System.out.println("Random no generated for top navigation  " + n);
		
		WebElement element = lelement.get(n);
		String childAttri= element.getAttribute("id");
		String[] split_childAttri = childAttri.split("_");
		System.out.println("Child Attribute  "+ childAttri);
		
		
		String childXpath =  "//div[@id='"+"Flyout_"+split_childAttri[1]+"']//following-sibling::li/a";
		System.out.println("Childxpath value is   "+childXpath);
		List<WebElement> childList = driver.findElements(By.xpath(childXpath));
		
		int csize = childList.size();
		System.out.println("Size of sub-level links   " + csize);
		
		int c = rand.nextInt(csize);
		System.out.println("Random no generated for child links    "+c);
		
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		
		WebElement childElementToBeClicked = childList.get(c);
		childElementToBeClicked.click();
				
		String childLinkText = childList.get(c).getText();
		System.out.println("Child text from List is "+childLinkText);
		
		
		WebElement filter =  driver.findElement(By.id("navNarrowResultSpan"));
		System.out.println("FIlter by text is  " + filter.getText());
		
		WebElement header = driver.findElement(By.id("currentCatNavHeading"));
		System.out.println("Header text is    "+header.getText());
		
		Assert.assertEquals("filter by",filter.getText());
		Assert.assertEquals(header.getText(), childLinkText);
		
		WebElement page1= driver.findElement(By.xpath("//div[@id='paginateTop']//span[@class='currentPage'][text()='1']"));
		Assert.assertEquals(page1.getText(), "1");
		
		driver.findElement(By.xpath("//div[@id='paginateTop']/a[last()]")).click();
		
		WebElement page2 = driver.findElement(By.xpath(".//div[@id='paginateTop']/a[contains(@class,'currentPage')]"));
		Assert.assertEquals(page2.getText(), "2");
		
		WebElement page11=  driver.findElement(By.xpath(".//div[@id='paginateTop']/a[@class='paginationSpacer'][text()='1']]"));
		page11.click();
		Assert.assertEquals(page11.getText(), "1");
	}

	@AfterTest
	public void testCloseUrl() {
		driver.close();
	}

}
