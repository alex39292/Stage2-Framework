package framework.test;

import framework.driver.DriverSingleton;
import framework.pages.CalculatorPage;
import framework.pages.IframeCalculatorPage;
import framework.service.PricingCalculatorCreator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCalculatorPage {
    private WebDriver driver;
    private final String URL = "https://cloud.google.com/products/calculator";

    @BeforeMethod
    public void loadPage() {
        driver = DriverSingleton.getDriver();
        driver.get(URL);
    }

    @Test
    public void cloudPlatformCalculatorTest() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        IframeCalculatorPage iframeCalculatorPage = calculatorPage.addData();
        iframeCalculatorPage.setEstimateFromButton(PricingCalculatorCreator.withProperty());
        Assert.assertTrue(true);
    }

    @AfterMethod(alwaysRun = true)
    public void browserClose() {
        DriverSingleton.closeDriver();
    }
}
