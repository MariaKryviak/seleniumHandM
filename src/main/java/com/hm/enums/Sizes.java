package com.hm.enums;

import org.openqa.selenium.By;

public enum Sizes {

    XS(By.xpath("//*[@id=\"picker-1\"]//li[2]//button")),
    S(By.xpath("//*[@id=\"picker-1\"]//li[3]//button")),
    M(By.xpath("//*[@id=\"picker-1\"]//li[4]//button")),
    L(By.xpath("//*[@id=\"picker-1\"]//li[5]//button")),
    XL(By.xpath("//*[@id=\"picker-1\"]//li[6]//button")),
    XXL(By.xpath("//*[@id=\"picker-1\"]//li[7]//button"));

    private By by;

    Sizes(By by) {
        this.by = by;
    }

    public By getBy() {
        return by;
    }
}
