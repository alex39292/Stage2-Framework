package framework.test;

import framework.pages.CloudGoogle;
import framework.pages.FrameCalculatorPage;
import framework.pages.MailHandler;
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

        MailHandler mailHandler = frameCalculatorPage.sendMail();
        mailHandler.getMail();
        frameCalculatorPage.pasteMailAndSend(mailHandler.getMailAddress(),mailHandler.getMailPageTab());
        mailHandler.clickReceivedMail();

        assertThat(frameCalculatorPage.getEstimateFromButton(), is(equalTo(mailHandler.getEstimateFromEmail())));
    }
}
