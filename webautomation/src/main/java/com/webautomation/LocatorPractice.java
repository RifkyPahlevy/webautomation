package com.webautomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LocatorPractice {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        initialization(driver);

        // radioButton(driver);
        //suggestion(driver);
        //dropDown(driver);
        //checkBox(driver);
        // table(driver);
        switchTabAndWindows(driver);

        Thread.sleep(3000);
        driver.quit();

    }

    static void initialization(WebDriver driver) {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();

    }

    static void radioButton(WebDriver driver) {

        driver.findElement(By.cssSelector("[value='radio2']")).click();

    }

    static void suggestion(WebDriver driver) {

        driver.findElement(By.id("autocomplete")).sendKeys("Ind");

        List<WebElement> listCountry = driver.findElements(By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete ui-front']//li"));

        for (WebElement elem : listCountry) {
            if (elem.getText().equalsIgnoreCase("Indonesia")) {
                elem.click();
                break;
            }
        }
    }

    static void dropDown(WebDriver driver) {

        WebElement selectElement = driver.findElement(By.id("dropdown-class-example"));

        Select dropDownOption = new Select(selectElement);

        dropDownOption.selectByVisibleText("Option1");

    }

    static void checkBox(WebDriver driver) {

        driver.findElement(By.id("checkBoxOption1")).click();

        driver.findElement(By.id("checkBoxOption2")).click();

        driver.findElement(By.id("checkBoxOption3")).click();

    }

    static void table(WebDriver driver) {

        List<WebElement> tableColumn = driver.findElements(By.xpath("//table[@id='product']//tbody/tr//th"));

        List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='product']//tbody/tr//td"));

        System.out.println(tableColumn.size());

        for (WebElement elm : tableColumn) {
            System.out.println(elm.getText());
        }

        System.out.println("Rows Size : " + tableRows.size());

        for (WebElement elm : tableRows) {

            System.out.println(elm.getText());
        }

    }

    static void switchTabAndWindows(WebDriver driver) {

        //click on link to open a new window
        driver.findElement(By.id("opentab")).click();
        //fetch handles of all windows, there will be two, [0]- default, [1] - new window
        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
        //assert on title of new window
        String title = driver.getTitle();
        System.out.println(title);
        driver.findElement(By.className("main-btn")).click();
    }
}
