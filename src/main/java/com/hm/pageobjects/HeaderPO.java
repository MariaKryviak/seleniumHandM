package com.hm.pageobjects;

import com.hm.config.DriverManager;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

@Log4j
public class HeaderPO {

    private final WebDriver webDriver = DriverManager.getInstance().getWebDriver();

    private final By basketButton = By.xpath("//*[@class=\"minicart parbase\"]/a");
    private final By favoriteButton = By.xpath("//header/nav/ul[1]/li[3]/a");
    private final By searchTextField = By.xpath("//*[@id=\"main-search\"]");
    private final By searchButton = By.xpath("//section/form/button");
    private final By womenCatalogButton = By.linkText("Women");

    @Step
    public BasketPO clickBasketButton() {
        log.info("Click [basket] button.");
        webDriver.findElement(basketButton).click();
        return new BasketPO();
    }

    @Step
    public FavoritePO clickFavoriteButton() {
        log.info("Click [favorite] button.");
        webDriver.findElement(favoriteButton).click();
        return new FavoritePO();
    }

    @Step
    public HeaderPO setSearchCriteria(String searchCriteria) {
        log.info(String.format("Search criteria: %s", searchCriteria));
        webDriver.findElement(searchTextField).sendKeys(searchCriteria);
        return this;
    }

    @Step
    public SearchPO clickSearch() {
        log.info("Click [search] button.");
        webDriver.findElement(searchButton).submit();
        return new SearchPO();
    }
}
