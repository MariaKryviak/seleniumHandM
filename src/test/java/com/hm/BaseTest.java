package com.hm;

import com.hm.config.DriverManager;
import com.hm.enums.Sizes;
import com.hm.pageobjects.*;
import net.bytebuddy.utility.RandomString;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class BaseTest {

    @Test
    public void addProductToBasketTest() {
        WomenCatalogPO womenCatalogPO = new WomenCatalogPO();
        String expectedName = womenCatalogPO.getFirstProductName();

        ProductPO productPO = womenCatalogPO.clickFirstProductNameLink();
        productPO.selectSize(Sizes.S).addProductToBasket();
        BasketPO basketPO = new HeaderPO().clickBasketButton();
        String actualName = basketPO.getFirstProductName();

        Assert.assertEquals(actualName, expectedName, "Products name in basket not the same");
    }

    @Test
    public void addProductToFavoriteTest() {
        WomenCatalogPO womenCatalogPO = new WomenCatalogPO();
        String expectedName = womenCatalogPO.getFirstProductName();

        womenCatalogPO.clickFirstProductFavoritesButton();
        FavoritePO favoritePO = new HeaderPO().clickFavoriteButton();
        String actualName = favoritePO.getFirstFavoriteProductName();

        Assert.assertEquals(actualName, expectedName, "Products name in favorite not matching");
    }

    @Test
    public void searchInvalidProductTest() {
        String expectedName = "No matching items";

        String searchCriteria = RandomString.make(4);
        HeaderPO headerPO = new HeaderPO();
        SearchPO searchPO = headerPO.setSearchCriteria(searchCriteria).clickSearch();
        String actualName = searchPO.geSearchResult();

        Assert.assertEquals(actualName, expectedName, "Found result by search criteria: " + searchCriteria);
    }

    @AfterMethod
    public void closeDriver() {
        DriverManager.getInstance().closeWebDriver();
    }
}
