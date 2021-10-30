package com.webapp.amazon;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class AmazonNavLinksTest {

	// step1: Formulate a test url
	String siteUrl = "https://www.amazon.in/";
	String driverPath = "drivers/chromedriver";
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(siteUrl);
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

	@Test
	public void testMobileNavLink() throws InterruptedException {
		WebElement mobileLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(2)"));
		// test for exist
		assertTrue(mobileLink.isDisplayed());
		assertTrue(mobileLink.isEnabled());

		// click on mobile
		mobileLink.click();
		String expected = "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
		assertEquals(expected, driver.getTitle());

		Thread.sleep(3000);
	}

	@Test
	public void testFashionNavLink() throws InterruptedException {
		WebElement fashionLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(5)"));

		// test for exist
		assertTrue(fashionLink.isDisplayed());
		assertTrue(fashionLink.isEnabled());

		// click on mobile
		fashionLink.click();
		String expected = "Amazon Fashion: Clothing, Footwear and Accessories online for Men, Women and Kids";
		assertEquals(expected, driver.getTitle());

		Thread.sleep(3000);
	}

}
