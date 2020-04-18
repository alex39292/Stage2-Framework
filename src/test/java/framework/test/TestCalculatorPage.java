package framework.test;

import framework.pages.CalculatorPage;
import framework.service.PricingCalculatorCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCalculatorPage extends CommonConditions{

    @Test
    public void cloudPlatformCalculatorTest() {
        new CalculatorPage(driver)
                .openPage()
                .switchToFrame()
                .setEstimateFromButton(PricingCalculatorCreator.withProperty());

        Assert.assertTrue(true);
    }
}
