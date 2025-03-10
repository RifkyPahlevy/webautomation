package com.webautomation.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webautomation.abstractcomponent.AbstractComponent;

public class LoginPage extends AbstractComponent{

    WebDriver driver;

    public LoginPage (WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id="user-name")
    WebElement username;

    @FindBy(id="password")
    WebElement password;

    @FindBy(id="login-button")
    WebElement loginBtn;

    By iconOption = By.id("react-burger-menu-btn");
    


    public void login (String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginBtn.click();
        visibilityOfElementLocated(iconOption);
        

    }

}
