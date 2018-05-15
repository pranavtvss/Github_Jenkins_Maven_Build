package test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

public class TestNgMavenExampleTest {

	@Test
	public void testStringCompare() {
		System.out.println("This is TestNG-Maven Example");
		
		String s = "initial";
		AssertJUnit.assertEquals(s, "initial");
		AssertJUnit.assertNotNull(s);
	}
	
	@Test
	public void testNullablity() {
		System.out.println("This is TestNG-Maven Example");
		
		String s = " ";
		AssertJUnit.assertNotNull(s);
	}
	
	@Test
	public void testFailureCheck() {
		System.out.println("This is TestNG-Maven Example");
		
		String s = "g";
		AssertJUnit.assertEquals(s, "");
	}

	
}

