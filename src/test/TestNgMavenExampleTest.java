package test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

public class TestNgMavenExampleTest {

	@Test(priority = 0)
	public void testStringCompare() {
		System.out.println("Testing class TestNgMavenExampleTest with priority 0 ");
		System.out.println("Testing function with priority 0");
		
		String s = "initial";
		AssertJUnit.assertEquals(s, "initial");
		AssertJUnit.assertNotNull(s);
	}
	
	@Test(priority = 1)
	public void testNullablity() {
		System.out.println("Testing function with priority 1");
		
		String s = " ";
		AssertJUnit.assertNotNull(s);
	}
	
	

	
}

