package framework.test;

import framework.driver.DriverSingleton;
import framework.pages.*;
import framework.service.PricingCalculatorCreator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class TestFramework {
    private WebDriver driver;
    private final String URL = "https://cloud.google.com/";

    @BeforeTest
    public void loadPage() {
        driver = DriverSingleton.getDriver();
        driver.get(URL);
    }

    @Test
    public void cloudPlatformCalculatorTest() {
        CloudGoogle cloudGooglePage = new CloudGoogle(driver);
        SearchingCalculatorPage searchedPage = cloudGooglePage.searchCalculator();
        CalculatorPage calculatorPage = searchedPage.openCalculator();
        IframeCalculatorPage iframeCalculatorPage = calculatorPage.addData();
        iframeCalculatorPage.setEstimateFromButton(PricingCalculatorCreator.withProperty());
        TenMinuteMail tenMinuteMail = iframeCalculatorPage.sendMail();
        tenMinuteMail.getMail();
        iframeCalculatorPage.pasteMailAndSend(tenMinuteMail.getMailAddress(),tenMinuteMail.getMailPageTab());
        tenMinuteMail.clickReceivedMail();

        assertThat(iframeCalculatorPage.getEstimateFromButton(), is(equalTo(tenMinuteMail.getEstimateFromEmail())));
    }

    @AfterTest(alwaysRun = true)
    public void browserClose() {
        DriverSingleton.closeDriver();
    }
}
