package hook;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp() throws IOException {

        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Rifky_118716\\Documents\\Course QA Automation\\web automation\\webautomation\\src\\main\\resources\\GlobalData.properties");

        properties.load(fileInputStream);

        String browserName = properties.getProperty("browser");

        System.out.println("Browser is :" + browserName);

        if (browserName.equals("chrome")) {
            driver = new ChromeDriver();

        } else {
            //driver edge
            driver = new EdgeDriver();
            System.out.println("Edge");
        }

        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }

    public static WebDriver initializeDriver() {

        return driver;

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }

}
