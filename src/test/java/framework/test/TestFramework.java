package framework.test;

import framework.pages.CloudGoogle;
import framework.pages.IframeCalculatorPage;
import framework.pages.TenMinuteMail;
import framework.service.PricingCalculatorCreator;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class TestFramework extends CommonConditions{

    @Test
    public void cloudPlatformCalculatorTest() {
        IframeCalculatorPage iframeCalculatorPage = new CloudGoogle(driver)
                .openPage()
                .searchCalculator()
                .openCalculator()
                .addData()
                .setEstimateFromButton(PricingCalculatorCreator.withProperty());

        TenMinuteMail tenMinuteMail = iframeCalculatorPage.sendMail();
        tenMinuteMail.getMail();
        iframeCalculatorPage.pasteMailAndSend(tenMinuteMail.getMailAddress(),tenMinuteMail.getMailPageTab());
        tenMinuteMail.clickReceivedMail();

        assertThat(iframeCalculatorPage.getEstimateFromButton(), is(equalTo(tenMinuteMail.getEstimateFromEmail())));
    }
}
