package automation;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webautomation.pageobject.CartPage;
import com.webautomation.pageobject.CheckOutPage;
import com.webautomation.pageobject.InventoryPage;
import com.webautomation.pageobject.LoginPage;

public class ScenarioTestngImpl {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @Test(dataProvider = "dataTestMapping")
    public void checkout(HashMap<String, String> input) {

        LoginPage login = new LoginPage(driver);
        login.login(input.get("username"), input.get("password"));
        InventoryPage inventory = new InventoryPage(driver);
        inventory.chooseProduct(input.get("product"));
        CartPage cart = new CartPage(driver);
        cart.clickBtnCheckout();
        CheckOutPage checkOut = new CheckOutPage(driver);
        checkOut.fillFormCheckOut(input.get("username"), input.get("password"), input.get("postcode"));
        Assert.assertEquals(checkOut.getTextSuccess(), "Thank you for your order!");

    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();

    }

    @DataProvider
    public Object[][] dataTestMapping() {
        HashMap map = new HashMap<String, String>();
        map.put("username", "standard_user");
        map.put("password", "secret_sauce");
        map.put("product", "Sauce Labs Backpack");
        map.put("postcode", "13215");

        return new Object[][]{{map}};

    }

}
