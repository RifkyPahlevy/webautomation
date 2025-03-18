package components;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public WebDriver driver;
    public WebDriver initializeDriver  () throws IOException{

        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream ("C:\\Users\\Rifky_118716\\Documents\\Course QA Automation\\web automation\\webautomation\\src\\main\\resources\\GlobalData.properties");

        properties.load(fileInputStream);
        
        String browserName = properties.getProperty("browser");

        System.out.println("Browser is :"+ browserName);

        if (browserName.equals("chrome")) {
            driver = new ChromeDriver();
            
        }else{
            System.out.println("Edge");
        }

         driver.get("https://www.saucedemo.com/");
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        return driver;
    }

}
