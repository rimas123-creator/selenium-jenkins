package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.Assert.assertEquals;

public class SeleniumTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Setup WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Set Chrome options for headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run Chrome in headless mode
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage"); // Overcome limited resource problems

        // Initialize ChromeDriver with options
        driver = new ChromeDriver(options);
    }

    @Test
    public void testGoogleTitle() {
        // Navigate to Google
        driver.get("https://www.google.com");

        // Assert title
        String pageTitle = driver.getTitle();
        assertEquals("Google", pageTitle);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}