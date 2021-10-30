package com.webapp.asserttest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionTest {

	@Test
	public void hardAssertTest() {
		System.out.println(" -- Hard Assert Method Started !");
		assertEquals("Hello", "Hello");
		assertTrue(true);
		assertFalse(true); // Assert Error
		System.out.println(" -- Hard Assert Method Completed !");
	}

	@Test
	public void softAssertTest() {
		System.out.println(" -- Soft Assert Method Started !");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals("Hello", "Hello");
		softAssert.assertEquals("Hello", "Hi"); // This stm does not throw Assert Error
		softAssert.assertTrue(false); // This stm does not throw Assert Error
		softAssert.assertFalse(true); // Assert Error
		System.out.println(" -- Soft Assert Method Completed !");
	}
}
