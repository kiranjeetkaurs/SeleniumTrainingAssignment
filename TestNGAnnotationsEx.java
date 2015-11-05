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

public class TestNGAnnotationsEx {

	@Test
	public void testMethod1(){
		System.out.println("In testMethod1");
	}
	
	@Test
	public void testMethod2(){
		System.out.println("In testMethod2");
	}
	
	@BeforeSuite
	public void testBeforeSuite(){
		System.out.println("in testBeforeSuite");
	}
	
	@AfterSuite
	public void testAfterSuite(){
		System.out.println("in testAfterSuite ");
	}
	
	@AfterTest
	public void testAfterTest(){
		System.out.println("in testAfterTest");
	}
	
	@BeforeTest
	public void testBeforeTest(){
		System.out.println("in testBeforeTest");
	}
	
	@BeforeClass
	public void testBeforeClass(){
		System.out.println("in testBeforeClass");
	}
	
	@AfterClass
	public void testAfterClass(){
		System.out.println("in testAFterClass");
	}
	
	@BeforeMethod
	public void testBeforeMethod(){
		System.out.println("in testBeforeMethod");
	}
	@AfterMethod
	public void testAfterMethod(){
		System.out.println("in testAfterMethod");
	}
}




