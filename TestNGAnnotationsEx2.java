package SeleniumExamples;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotationsEx2 {

	@Test
	public void testMethod1(){
		System.out.println("In testMethod1 of class2");
	}
	
	@Test
	public void testMethod2(){
		System.out.println("In testMethod2 of class2");
	}
	
	@BeforeSuite
	public void testBeforeSuite(){
		System.out.println("in testBeforeSuite of class2");
	}
	
	@AfterSuite
	public void testAfterSuite(){
		System.out.println("in testAfterSuite of class2");
	}
	
	@AfterTest
	public void testAfterTest(){
		System.out.println("in testAfterTest of class2");
	}
	
	@BeforeTest
	public void testBeforeTest(){
		System.out.println("in testBeforeTest of class2");
	}
	
	@BeforeClass
	public void testBeforeClass(){
		System.out.println("in testBeforeClass of class2");
	}
	
	@AfterClass
	public void testAfterClass(){
		System.out.println("in testAFterClass of class2");
	}
	
	@BeforeMethod
	public void testBeforeMethod(){
		System.out.println("in testBeforeMethod of class2");
	}
	@AfterMethod
	public void testAfterMethod(){
		System.out.println("in testAfterMethod of class2");
	}
}




