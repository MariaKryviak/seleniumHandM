package com.hm.pageobjects;

import com.hm.config.DriverManager;
import com.hm.enums.Sizes;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j
public class ProductPO {

    private final WebDriver webDriver = DriverManager.getInstance().getWebDriver();

    private final By productSizesOption = By.xpath("//*[@id=\"main-content\"]//div[1]/button/span");
    private final By addProductButton = By.xpath("//div[@class=\"product-button-wrapper\"]/button");

    @Step
    public ProductPO selectSize(Sizes size) {
        webDriver.findElement(productSizesOption).click();
        webDriver.findElement(size.getBy()).click();
        log.info(String.format("Click '%s' size button on Product page", size));
        return this;
    }

    @Step
    public ProductPO addProductToBasket() {
        webDriver.findElement(addProductButton).click();
        log.info("Click 'add' product button on Product page");
        return this;
    }
}
