package com.example;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    @Description("Verify the title of Google")
    @Story("Title Verification")
    public void testGoogleTitle() {
        driver.get("https://www.google.com");
        assert driver.getTitle().equals("Google");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
