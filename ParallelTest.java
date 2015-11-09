package SeleniumExamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTest {

	public WebDriver driver;

	@Test
	@Parameters("browser")
	public void testParallel(String browser) throws InterruptedException {

		if (browser.equals("FF")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("Chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Admin\\Documents\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
		
			System.setProperty("webdriver.ie.driver","C:\\Users\\Admin\\Documents\\IEDriverServer_x64_2.48.0\\IEDriverServer.exe");
			Thread.sleep(5000);
			driver = new InternetExplorerDriver();
			Thread.sleep(5000);

		}

		driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement textbox = driver.findElement(By.name("q"));

		Actions builder = new Actions(driver);

		Action seriesOfAction = builder.moveToElement(textbox).click()
				.keyDown(textbox, Keys.SHIFT).sendKeys(textbox, "Kiraanjeet")
				.keyUp(textbox, Keys.SHIFT).doubleClick(textbox).contextClick()
				.build();

		seriesOfAction.perform();

	}

	@AfterTest
	public void testUrlClose() {
		driver.quit();
	}
}
