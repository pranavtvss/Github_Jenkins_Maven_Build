package test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

public class TestNgMavenExampleTest {

	@Test
	public void exampleOfTestNgMaven() {
		System.out.println("This is TestNG-Maven Example");
		
		String s = "initial";
		AssertJUnit.assertEquals(s, "initial");
	}
	
	
}
