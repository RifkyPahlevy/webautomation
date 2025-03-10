package com.webautomation.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webautomation.abstractcomponent.AbstractComponent;

public class InventoryPage extends AbstractComponent{

    WebDriver driver;

    public InventoryPage (WebDriver driver){
        super (driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (className="inventory_item_name")
    List <WebElement> listProducts;

    @FindBy (id= "add-to-cart")
    WebElement addToCart ;

    @FindBy (className="shopping_cart_link")
    WebElement iconShop ;

    By cartText = By.className("title");

    public void chooseProduct (String productName){
        WebElement product = listProducts.stream().filter(prod -> prod.getText().equals(productName)).findFirst().orElse(null);
        product.click();
        addToCart.click();

        iconShop.click();
        visibilityOfElementLocated(cartText);
        


    }
}
