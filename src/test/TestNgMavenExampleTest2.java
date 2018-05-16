package test;

import org.testng.annotations.Test;

import org.testng.AssertJUnit;

public class TestNgMavenExampleTest2 {

	
	@Test
	public void testEquality() {
		System.out.println("This is TestNG-Maven Example");
		
		String s = " ";
		AssertJUnit.assertEquals(" ",s);
	}
	
}
