package framework.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverSingleton {
    private static WebDriver driver;

    public DriverSingleton() {}

    //Доделать все браузеры!
    public static WebDriver getDriver() {
        if (driver == null) {
            switch (System.getProperty("browser")) {
                case "firefox" : {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                case "chrome" : {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
                default: {
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
