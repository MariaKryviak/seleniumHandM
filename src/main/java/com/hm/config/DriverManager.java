package com.hm.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverManager {

    private static final String BASE_URL = "https://www2.hm.com/en_gb/ladies/new-arrivals/view-all.html";

    private static DriverManager driverManagerInstance = new DriverManager();
    private WebDriver webDriver = null;

    private DriverManager() {
    }

    public static DriverManager getInstance() {
        if (driverManagerInstance == null) {
            driverManagerInstance = new DriverManager();
        }
        return driverManagerInstance;
    }

    public WebDriver getWebDriver() {
        if (webDriver == null) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            webDriver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(3));
            webDriver.get(BASE_URL);
        }
        return webDriver;
    }

    public static void waitForElement(By by) {
        (new WebDriverWait(DriverManager.getInstance().getWebDriver(), Duration.ofSeconds(10)))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void closeWebDriver() {
        webDriver.quit();
        webDriver = null;
    }
}
