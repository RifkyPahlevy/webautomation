package com.webautomation.scenario;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScenarioE2E {
    

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        initialization(driver, "https://www.saucedemo.com/");

        Thread.sleep(3000);

         login(driver);

        chooseProduct(driver);

        

        checkOut(driver);

        Thread.sleep(3000);

        driver.quit();
        

    }

    static void initialization (WebDriver driver, String url){
       
        driver.get(url);
    }

    static void login (WebDriver driver) throws InterruptedException{

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement((By.id("password"))).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    static void chooseProduct (WebDriver driver) throws InterruptedException{

        

        List <WebElement> listProduct = driver.findElements(By.className("inventory_item_name"));

        for (WebElement product : listProduct){
            if (product.getText().equalsIgnoreCase("Sauce Labs Backpack")){
                product.click();
                break;
            }


            
        }

        

        driver.findElement(By.id("add-to-cart")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(3000);

    }

    static void checkOut(WebDriver driver) throws InterruptedException{

        driver.findElement(By.id("checkout")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("first-name")).sendKeys("Syam");
        driver.findElement(By.id("last-name")).sendKeys("Syudin");
        driver.findElement(By.id("postal-code")).sendKeys("12321");
        driver.findElement(By.id("continue")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("finish")).click();
        


        
    }
}
