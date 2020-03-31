package framework.test;

import framework.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Framework {
    private WebDriver driver;
    private final String URL = "https://cloud.google.com/";

    @BeforeTest
    public void loadPage() {
        //WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        //driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @Test
    public void cloudPlatformCalculatorTest() {
        CloudGoogle cloudGooglePage = new CloudGoogle(driver);
        SearchingCalculatorPage searchedPage = cloudGooglePage.searchCalculator();
        CalculatorPage calculatorPage = searchedPage.openCalculator();
        IframeCalculatorPage iframeCalculatorPage = calculatorPage.addData();
        iframeCalculatorPage.setEstimateFromButton();
        TenMinuteMail tenMinuteMail = iframeCalculatorPage.sendMail();
        tenMinuteMail.getMail();
        iframeCalculatorPage.pasteMailAndSend(tenMinuteMail.getMailAddress(),tenMinuteMail.getMailPageTab());
        tenMinuteMail.clickRecievedMail();

        Assert.assertEquals(iframeCalculatorPage.getEstimateFromButton(),tenMinuteMail.getEstimateFromEmail());
    }

    @AfterTest(alwaysRun = true)
    public void browserClose() {
        driver.quit();
        driver = null;
    }
}
