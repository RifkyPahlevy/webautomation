package com.webautomation.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webautomation.abstractcomponent.AbstractComponent;

public class CartPage extends AbstractComponent {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='cart_item']//div[@class='cart_item_label']//div[@class='item_pricebar']//button[@class='btn btn_secondary btn_small cart_button']")
    List<WebElement> listCartProduct;

    @FindBy(id = "checkout")
    WebElement btnCheckout;

    @FindBy(className = "btn_small")
    WebElement btnRemove;

    By txtCart = By.className("title");

    public void clickBtnCheckout() {

        btnCheckout.click();
        visibilityOfElementLocated(txtCart);

    }

    public void removeProduct() {

        btnRemove.click();

    }
}
