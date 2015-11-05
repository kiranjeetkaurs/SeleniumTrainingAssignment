package SeleniumExamples;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JuniperFindAllLinks {
	public static WebDriver driver;
	
@BeforeTest
public void testUrlOpen(){
	driver = new FirefoxDriver();
	driver.get("http://www.juniper.net");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
}

@AfterTest
public void testUrlCloase(){
	driver.close();
}

@Test
public void testAllLinksPrint(){
	
	List<WebElement> AllLinks = driver.findElements(By.xpath("//a[not(@href='')]"));
	
	/*	Iterator<WebElement> itr = AllLinks.iterator();
		
		while(itr.hasNext()){
			
			System.out.println("Text Value   "+ itr.next().getText() + "Attribute Value    "+ itr.next().getAttribute("href"));
		
		} 
		
		System.out.println("For Loop starting"); */
		
		for(int i=0;i<AllLinks.size();i++){
			System.out.println("All links Text   "+AllLinks.get(i).getText() +"         "+"Attribut values   " +AllLinks.get(i).getAttribute("href"));
		}
}


}
