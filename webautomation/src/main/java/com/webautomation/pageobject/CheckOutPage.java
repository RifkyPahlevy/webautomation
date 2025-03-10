package com.webautomation.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webautomation.abstractcomponent.AbstractComponent;

public class CheckOutPage extends AbstractComponent {

    WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement postalCode;

    @FindBy(id = "continue")
    WebElement btnContinue;

    @FindBy(id = "finish")
    WebElement btnFinish;

    @FindBy(className = "complete-header")
    WebElement txtSuccessOrder;

    By btnFinishValidate = By.id("finish");

    public void fillFormCheckOut(String firstNameType, String lastNameType, String postCodeType) {
        firstName.sendKeys(firstNameType);
        lastName.sendKeys(lastNameType);
        postalCode.sendKeys(postCodeType);

        btnContinue.click();
        visibilityOfElementLocated(btnFinishValidate);
        btnFinish.click();
    }

    public String getTextSuccess() {
        return txtSuccessOrder.getText();

    }
}
