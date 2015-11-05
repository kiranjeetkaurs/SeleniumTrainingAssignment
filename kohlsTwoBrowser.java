package SeleniumExamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class kohlsTwoBrowser {
	public static WebDriver driver;
	
@BeforeMethod
public void testUrlOpen(){
	driver = new FirefoxDriver();
	driver.get("http://www.kohls.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Assert.assertEquals(driver.getCurrentUrl(), "http://www.kohls.com/");
	System.out.println("BeforeMethod");
	System.out.println(" ");
}

@Test(priority=0)
public void men() throws InterruptedException{
	driver.findElement(By.xpath("//ul[@id ='navigation']//li/h2/a[contains(text(),'Men')]")).click();;
	Assert.assertEquals(driver.getCurrentUrl(), "http://www.kohls.com/sale-event/mens-clothing.jsp");
	System.out.println("Executed Men of kohlsTwoBrowser");
}
@Test(priority=1)
public void jeans() throws InterruptedException{
	Assert.assertEquals(driver.getCurrentUrl(), "http://www.kohls.com/");
	driver.findElement(By.xpath("//input[@id='search']")).sendKeys("jeans");
	driver.findElement(By.xpath("//input[@name='submit-search']")).click();
	Assert.assertEquals(driver.getCurrentUrl(), "http://www.kohls.com/search.jsp?search=jeans&submit-search=web-regular");
	System.out.println("Executed Jeans of kohlsTwoBrowser");
}

@AfterMethod
public void testUrlClose(){
	driver.close();
	System.out.println("AfterMethod");
	System.out.println(" ");
}
}

