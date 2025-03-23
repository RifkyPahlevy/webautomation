package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.webautomation.pageobject.CartPage;
import com.webautomation.pageobject.CheckOutPage;
import com.webautomation.pageobject.InventoryPage;
import com.webautomation.pageobject.LoginPage;

import components.BaseTest;
import hook.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionsImpl extends BaseTest{

    WebDriver driver;

    @Given("Buyer landed to website")
    public void landingPage() throws IOException {
        // driver = new ChromeDriver();
        // driver.get("https://www.saucedemo.com/");
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
       driver = Hooks.initializeDriver();

    }

    @Given("^Buyer logged to website email (.+) and password (.+)$")
    public void loggingWebsite(String email, String password) {
        LoginPage login = new LoginPage(driver);
        login.login(email, password);

    }

    @When("^Buyer add the product (.+) to cart$")
    public void addProduct(String product) {
        InventoryPage inventory = new InventoryPage(driver);
        inventory.chooseProduct(product);

    }

    @And("Buyer checkout the product")
    public void checkout() {
        CartPage cart = new CartPage(driver);
        cart.clickBtnCheckout();

    }

    @And("^Buyer fill form data first name (.+), last name (.+), and postal code (.+)$")
    public void fillForm(String first_name, String last_name, String postcode) {
        CheckOutPage checkOut = new CheckOutPage(driver);
        checkOut.fillFormCheckOut(first_name, last_name, postcode);
        

    }

    @Then("^Buyer will see message is displayed on confirmation page (.+)$")
    public void confirmationPage(String successCheckout) {
        CheckOutPage checkOut = new CheckOutPage(driver);
        Assert.assertEquals(checkOut.getTextSuccess(), successCheckout);
        
    }

    @Then ("^Buyer will see alert failed message (.+)$")
    public void validateLogin (String validateFailed){

        LoginPage login = new LoginPage(driver);
        Assert.assertEquals(login.validateLoginFailed(), validateFailed);
        

    }

    @When ("Buyer can delete the product in cart")
    public void deleteProduct (){
        CartPage cart = new CartPage(driver);
        cart.removeProduct();
        
    }

    @Then ("Buyer will see count of product")
    public void listCartProduct(){
        CartPage cart = new CartPage(driver);
        cart.listProductCart();
    }


}
