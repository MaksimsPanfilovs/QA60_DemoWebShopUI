package com.demowebshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductHelper extends BaseHelper {

    public ProductHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isProductPresentInCart() {
        return isElementPresent(By.xpath("//a[.='14.1-inch Laptop']"));
    }

    public void clickOnCartLink() {
        click(By.cssSelector("li#topcartlink"));
    }

    public void clickOnAddToCartButton() {
        click(By.cssSelector("input.button-2.button-2.product-box-add-to-cart-button[onclick*='/addproducttocart/catalog/31/1/1']"));
    }

    public void removeProductFromCart() {
        click(By.cssSelector("td.remove-from-cart"));
        click(By.cssSelector("input[name='updatecart']"));
    }
}
