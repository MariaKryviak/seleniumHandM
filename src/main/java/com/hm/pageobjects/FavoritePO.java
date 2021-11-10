package com.hm.pageobjects;

import com.hm.config.DriverManager;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j
public class FavoritePO {

    private final WebDriver webDriver = DriverManager.getInstance().getWebDriver();

    private final By firstProductButton = By.xpath("//article/div[2]/h2/a");

    @Step
    public String getFirstFavoriteProductName() {
        DriverManager.waitForElement(firstProductButton);
        String productName = webDriver.findElement(firstProductButton).getText();
        log.info(String.format("First product name: [%s].", productName));
        return productName;
    }
}
