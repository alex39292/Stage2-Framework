package framework.test;

import framework.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Framework {
    private WebDriver driver;
    private final String URL = "https://cloud.google.com/";

    @BeforeTest
    public void loadPage() {
        driver = new FirefoxDriver();
        driver.get(URL);
        driver.manage().window().maximize();
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

        assertThat(iframeCalculatorPage.getEstimateFromButton(), is(equalTo(tenMinuteMail.getEstimateFromEmail())));
    }

    @AfterTest(alwaysRun = true)
    public void browserClose() {
        driver.quit();
        driver = null;
    }
}
