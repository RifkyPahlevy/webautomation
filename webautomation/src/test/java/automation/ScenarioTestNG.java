package automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScenarioTestNG {

    WebDriver driver;

    @BeforeTest
    public void initialization() {

        driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

    }

    @Test
    public void createOrder() throws InterruptedException {

        Thread.sleep(3000);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement((By.id("password"))).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    

    

        List<WebElement> listProduct = driver.findElements(By.className("inventory_item_name"));

        // for (WebElement product : listProduct) {
        //     if (product.getText().equalsIgnoreCase("Sauce Labs Backpack")) {
        //         product.click();
        //         break;
        //     }
        // }
        WebElement product = listProduct.stream().filter(prod -> prod.getText().equals("Sauce Labs Backpack")).findFirst().orElse(null);

        product.click();

        driver.findElement(By.id("add-to-cart")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(3000);

    

    

        driver.findElement(By.id("checkout")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("first-name")).sendKeys("Syam");
        driver.findElement(By.id("last-name")).sendKeys("Syudin");
        driver.findElement(By.id("postal-code")).sendKeys("12321");
        driver.findElement(By.id("continue")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("finish")).click();

    }


    @AfterTest
    public void afterRunTest(){

        driver.quit();
        driver.close();
    }

}
