package com.webapp.group;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BrowserGroupTest {

	String amazonUrl = "https://www.amazon.in/";
	String facebookUrl = "https://www.facebook.com/";

	String chromePath = "drivers/chromedriver";
	String firefoxPath = "drivers/geckodriver";

	WebDriver driverOne;
	WebDriver driverTwo;
	WebDriverWait wait;

	// test group for chrome
	@Test(groups = "ChromeOnly")
	public void lauchChromeTest() {
		System.setProperty("webdriver.chrome.driver", chromePath);
		driverOne = new ChromeDriver();
		driverOne.get(amazonUrl);
	}

	@Test(groups = "ChromeOnly", dependsOnMethods = "lauchChromeTest", priority = 0)
	public void testHompageTitle() {
		String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		assertEquals(expected, driverOne.getTitle());
	}

	@Test(groups = "ChromeOnly", dependsOnMethods = "lauchChromeTest", priority = 1)
	public void testHompageSourceUrl() {
		assertEquals(amazonUrl, driverOne.getCurrentUrl());
	}

	@Test(groups = "ChromeOnly", dependsOnMethods = "lauchChromeTest", priority = 2)
	public void closedChrome() {
		driverOne.close();
	}

	// test group for firefox
	@Test(groups = "FirefoxOnly")
	public void lauchFirefoxTest() {
		System.setProperty("webdriver.gecko.driver", firefoxPath);
		driverTwo = new FirefoxDriver();
		wait = new WebDriverWait(driverTwo, Duration.ofSeconds(40));
		driverTwo.get(facebookUrl);
	}
	
	@Test(groups = "FirefoxOnly", dependsOnMethods="lauchFirefoxTest", priority=0)
	public void testFacebookHomepage() {
		String expected = "Facebook - Log In or Sign Up";
		assertEquals(driverTwo.getTitle(), expected);
	}
	
	@Test(groups = "FirefoxOnly", dependsOnMethods="lauchFirefoxTest", priority=1)
	void testForFaiure() {
		driverTwo.findElement(By.cssSelector("#email")).sendKeys("abc@gmail.com");
		driverTwo.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("abc@123");
		driverTwo.findElement(By.name("login")).submit();

		// evaluate failure test
		WebElement errorMsg = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#error_box > div.fsl.fwb.fcb")));
		assertEquals("Wrong Credentials", errorMsg.getText());

		WebElement errorMsg2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"error_box\"]/div[2]")));
		assertEquals("Invalid username or password", errorMsg2.getText());
	}
	
	@Test(groups = "FirefoxOnly", dependsOnMethods = "lauchFirefoxTest", priority = 2)
	public void closedFirefox() {
		driverTwo.close();
	}
}
