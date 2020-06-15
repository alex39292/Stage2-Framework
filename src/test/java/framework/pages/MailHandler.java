package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class MailHandler extends AbstractPage{
    private static final String MAIL_ADDRESS = "eposta_adres";
    private static final String MAIL = "//div[@class='gonderen' and text() = 'Google Cloud Sales']";
    private static final String MAIL_DATA = "//table[@class = 'quote']/tbody/tr[2]/td[2]/h3";
    private static final String URL_TO_MAIL_HANDLER = "https://lroid.com/ru/";

    private String mailAddress;
    private String mailPageTab;

    public MailHandler(WebDriver driver) {
        super(driver);
    }

    public void getMail() {
        String googlePageTab = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB)
                .navigate().to(URL_TO_MAIL_HANDLER);
        logger.info("New page with mail agent has been opened");
        mailPageTab = driver.getWindowHandle();
        mailAddress = driver.findElement(By.id(MAIL_ADDRESS)).getAttribute("value");
        driver.switchTo().window(googlePageTab);
    }

    public void clickReceivedMail() {
        (getElement(By.xpath(MAIL), driver)).click();

        logger.info("New mail message has been clicked");
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public String getMailPageTab() {
        return mailPageTab;
    }

    public String getEstimateFromEmail() {
        logger.info("Data has been received from mail message");

        return driver.switchTo().frame(0).findElement(By.xpath(MAIL_DATA))
                .getText().replaceAll("[a-zA-Zа]*", "").trim();
    }
}
