package SeleniumExamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.base.Predicate;

public class FirstSeleniumTest {
	@Test
	public void testGmailLogin() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		driver.get("https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=en&service=mail#identifier");
		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys(
				"ABCDEFG");
		driver.findElement(By.xpath("//input[@name='signIn']")).click();

		WebElement sign = driver.findElement(By
				.xpath("//input[@name='Passwd']"));
		sign.sendKeys("paswd");

		driver.findElement(By.xpath("//input[@value='Sign in']")).click();

		driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]"))
				.click();
		System.out.println("Before new message");
		driver.findElement(By.xpath("//div[@class='nH nn']"));
		System.out.println("AFter new message");

		driver.findElement(
				By.xpath("//textarea[@class='vO'][contains(@name,'to')]"))
				.sendKeys("shubham.mathur@gspann.com");
		System.out.println("Found TO");

		
		driver.findElement(By.xpath("//input[(@name='subjectbox')]")).sendKeys("Automated: Email to Shubham");
		driver.findElement(By.xpath("//table[@class='iN']/tbody/tr[2]/td//div[contains(text(),'Send')]")).click();;
	
		
		driver.quit();
	}

}
