package com.hm.pageobjects;

import com.hm.config.DriverManager;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j
public class SearchPO {

    private final WebDriver webDriver = DriverManager.getInstance().getWebDriver();

    private final By searchTextField = By.xpath("//*[@id=\"main-content\"]/div[2]/h1");

    @Step
    public String geSearchResult() {
        String result = webDriver.findElement(searchTextField).getText();
        log.info(String.format("Search result: [%s].", result));
        return result;
    }
}
