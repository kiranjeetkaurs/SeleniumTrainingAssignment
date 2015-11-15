package SeleniumExamples;

import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.ExcelUtils;

public class invalidLoginGmail {
	public static WebDriver driver;

	@BeforeMethod
	public void testOpenGmail() {
        //System.out.println("In before method");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=en&service=mail#identifier");
	}

	@DataProvider(name = "tesData")
	public Object[][] testData() throws Exception {
		ExcelUtils.openExcel("Sheet1");
		String[][] strArr = (String[][]) ExcelUtils.getTableArray();
		return strArr;
	}

	@Test(dataProvider = "testData")
	public void testInvalidEmailForGmailLogin(String email, String password)
			throws InterruptedException {
		System.out.println("*******************************");
		System.out.println("Email thr' excel   " + email);
		System.out.println("Password thr' excel   " + password);
		driver.findElement(By.xpath("//input[@name='Email']")).sendKeys(email);
		WebElement btnClick = driver.findElement(By
				.xpath("//input[@name='signIn']"));
		//System.out.println("currentPaswdURL before click  "+ driver.getCurrentUrl());
		btnClick.click();
		Thread.sleep(5000);
		String currentPaswdURL = driver.getCurrentUrl();
		System.out.println("currentPaswdURL after click  "+ driver.getCurrentUrl());
		try {

			if (currentPaswdURL.contains("password")) {

				// Verify correct email
				WebElement emailText = driver.findElement(By.id("email-display"));
				Thread.sleep(3000);
				String emailTextValue = emailText.getText();
				System.out
						.println("Email value thr' webelement and string variable  "
								+ emailTextValue);

				// Verifies if email id is correct
				Assert.assertEquals(emailTextValue, email, "Valid email id");

			} else {
				// Verify incorrect email
				WebElement emailIncorrect = driver.findElement(By
						.id("errormsg_0_Email"));
				Thread.sleep(2000);
				String strEmailIncorrect = emailIncorrect.getText();
				System.out.println("strEmailIncorrect  " + strEmailIncorrect);

				// Verified if email is is incorrect
				Assert.assertEquals(strEmailIncorrect,
						"Sorry, Google doesn't recognize that email.",
						"Invalid Email Id Case test case pass");
				//driver.close();
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		
		//Thread.sleep(5000);
		WebElement sign = driver.findElement(By
				.xpath("//input[@name='Passwd']"));
		sign.sendKeys(password);

		// Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		Thread.sleep(1000);
		try {
			String currentMailUrl = driver.getCurrentUrl();
			System.out.println("currentMailUrl  "+ currentMailUrl);
			if (currentMailUrl.contains("mail")) {
				// Verifies for valid login
				WebElement compose = driver.findElement(By
						.xpath("//div[contains(text(),'COMPOSE')]"));
				Thread.sleep(5000);
				String strCompose = compose.getText();

				Assert.assertEquals(strCompose, "COMPOSE", "Hurray logged inn");
				

			} else {

				// Verifies for invalid password
				WebElement pswdIncorrect = driver.findElement(By
						.id("errormsg_0_Passwd"));
				Thread.sleep(2000);
				String strPswdIncorrect = pswdIncorrect.getText();
				System.out.println("strEmailIncorrect  " + strPswdIncorrect);

				Assert.assertEquals(
						"The email and password you entered don't match.",
						strPswdIncorrect, "Password is incorrect");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void testGmailClose() {
		driver.close();
	}
}
