package com.webautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumIntroduction {

   static String url = "https://rahulshettyacademy.com/locatorspractice/";

    public static void main(String[] args) throws InterruptedException {
        //loginScenario("rifky@gmail.com");

        loginFailed("akmalaja");

    }

    public static void loginScenario(String name) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        driver.manage().window().maximize();

        driver.findElement(By.id("inputUsername")).sendKeys(name);

        driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys("rahulshettyacademy");

        driver.findElement(By.className("submit")).click();
        Thread.sleep(5000);

        String textValidate = driver.findElement(By.xpath("//div[@class='login-container']//h2")).getText();

        if (textValidate.contains(name)) {

            System.out.println("Login Success");
        }

        driver.quit();

    }

    public static void loginFailed (String name) throws InterruptedException{

        WebDriver driver = new ChromeDriver();

        driver.get(url);

        driver.findElement(By.id("inputUsername")).sendKeys(name);

        driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("asalasal");

        driver.findElement(By.cssSelector("button.signInBtn")).click();

        Thread.sleep(2000);


        String errorValidate = driver.findElement(By.className("error")).getText();

        if (errorValidate.contains(" Incorrect")) {

            System.out.println("Login Failed");
            
        }


    }

}
