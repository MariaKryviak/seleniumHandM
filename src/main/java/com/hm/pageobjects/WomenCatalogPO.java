package com.hm.pageobjects;

import com.hm.config.DriverManager;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j
public class WomenCatalogPO {

    private final WebDriver webDriver = DriverManager.getInstance().getWebDriver();

    private final By productNameLink = By.xpath("//*[@id=\"page-content\"]//article/div[2]/h3/a");
    private final By addToFavoriteButton = By.xpath("//article/div[1]/a/div/button");

    @Step
    public ProductPO clickFirstProductNameLink() {
        log.info("Click first product name link.");
        webDriver.findElement(productNameLink).click();
        return new ProductPO();
    }

    @Step
    public void clickFirstProductFavoritesButton() {
        log.info("Click first product favorites button.");
        webDriver.findElement(addToFavoriteButton).click();
    }

    @Step
    public String getFirstProductName() {
        String productName = webDriver.findElement(productNameLink).getText();
        log.info(String.format("First product name: [%s].", productName));
        return productName;
    }
}
