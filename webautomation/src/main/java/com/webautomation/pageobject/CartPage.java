package com.webautomation.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webautomation.abstractcomponent.AbstractComponent;

public class CartPage extends AbstractComponent{

    WebDriver driver;

    public CartPage (WebDriver driver){
        super (driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy (id="checkout")
    WebElement btnCheckout;

    By txtCart = By.className("title");

    public void clickBtnCheckout (){
        btnCheckout.click();
        visibilityOfElementLocated(txtCart);
        
    }
}
