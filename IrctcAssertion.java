package testIrctc;

import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Keyboard;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pagesIrctcExample.irctcEcartingOderPage;
import pagesIrctcExample.irctcEcateringPage;
import pagesIrctcExample.irctcHomePage;
import pagesIrctcExample.irctcTourismPage;

public class IrctcAssertion {

	public static WebDriver driver;
	public static WebElement element;

	@BeforeMethod
	public void openUrl() {
		driver = new FirefoxDriver();
		driver.get("http://www.irctc.co.in");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void testIrctc() throws InterruptedException {
		// ******Clicking on Hotel and Lounge******
		String parentHandle = driver.getWindowHandle();
		System.out.println("parentHandle  " + parentHandle);
		irctcHomePage.findNavigationTabHotel(driver).click();

		// Since two windows are open we need to switch to required window
		Set<String> winHandles = driver.getWindowHandles();
	//	System.out.println("winHandles   "+ winHandles);

		// ******Asserting Top Navigation Panel**********
		for (String winhan : winHandles) {
			if (!winhan.equals(parentHandle)) {
				driver.switchTo().window(winhan);
				System.out.println("Child Handle  " + winhan +"   "+driver.getCurrentUrl());
				List<WebElement> list = irctcTourismPage
						.findTopNavPanel(driver);
				int noOfTopNavPanel = list.size();
			//	System.out.println("noOfTopNavPanel   " + noOfTopNavPanel);
				Assert.assertEquals(noOfTopNavPanel, 7);
				
			}

		}
		
			//******Clicking on E-catering link
			//System.out.println("Driver current handle" + driver.getCurrentUrl());	
		
			irctcTourismPage.findECarting(driver).click();
		
			//******Find STation code and click search
			irctcEcateringPage.findStationTextBx(driver).sendKeys(Keys.ENTER,"DLI");	
			irctcEcateringPage.findStationTextBx1(driver).click();
			irctcEcateringPage.findStationSearch(driver).click();
			//Assert the title
			Assert.assertEquals("http://www.ecatering.irctc.co.in/eCatering/af/irctc/ecatering/newOrder.do", driver.getCurrentUrl());
			
			//******Click on checkout and verify alert
			irctcEcartingOderPage.findCheckOutBtn(driver).click();
			String alertMsg = irctcEcartingOderPage.findCheckOutAlert(driver).getText();
			System.out.println("Alert msg   "+ alertMsg );
			irctcEcartingOderPage.findCheckOutAlert(driver).accept();
			
			//******Go to replan button
			irctcEcartingOderPage.findReplanBtn(driver).click();
			String totalAmt = irctcEcartingOderPage.findTotalAmt(driver).getText();
			System.out.println("Total Amt is  "+totalAmt );
			Assert.assertEquals(totalAmt, 0);
			Assert.assertEquals("http://www.ecatering.irctc.co.in/eCatering/af/irctc/ecatering/newOrder.do", driver.getCurrentUrl());
	}
}
