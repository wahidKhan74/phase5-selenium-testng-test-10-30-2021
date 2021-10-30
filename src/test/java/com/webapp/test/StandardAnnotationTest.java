package com.webapp.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class StandardAnnotationTest {
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("--- Before Test Method ---");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("--- After Test Method ---");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("--- Before class ---");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("--- After class ---");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("--- Before Test element  ---");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("--- After Test element  ---");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("--- Before Test Suite ---");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("--- After Test Suite ---");
  }

  @Test
  public void testOne() {
	  System.out.println(" Test One is executed !");
  }
  
  @Test
  public void testTwo() {
	  System.out.println(" Test Two is executed !");
  }
  
  @Test
  public void testThree() {
	  System.out.println(" Test Three is executed !");
  }
}
