package framework.test;

import framework.pages.CloudGoogle;
import framework.pages.FrameCalculatorPage;
import framework.pages.TenMinuteMail;
import framework.service.PricingCalculatorCreator;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class TestFramework extends CommonConditions{

    @Test
    public void cloudPlatformCalculatorTest() {
        FrameCalculatorPage frameCalculatorPage = new CloudGoogle(driver)
                .openPage()
                .searchCalculator()
                .openCalculator()
                .switchToFrame()
                .setEstimateFromButton(PricingCalculatorCreator.withProperty());

        TenMinuteMail tenMinuteMail = frameCalculatorPage.sendMail();
        tenMinuteMail.getMail();
        frameCalculatorPage.pasteMailAndSend(tenMinuteMail.getMailAddress(),tenMinuteMail.getMailPageTab());
        tenMinuteMail.clickReceivedMail();

        assertThat(frameCalculatorPage.getEstimateFromButton(), is(equalTo(tenMinuteMail.getEstimateFromEmail())));
    }
}
