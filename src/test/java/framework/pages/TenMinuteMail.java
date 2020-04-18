package framework.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class TenMinuteMail extends AbstractPage{
    private final String URL = "https://lroid.com/ru/";
    private String mailAddress;
    private String mailPageTab;

    public TenMinuteMail(WebDriver driver) {
        super(driver);
    }

    public void getMail() {
        String googlePageTab = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(URL);
        logger.info("New page with mail agent has been opened");
        mailPageTab = driver.getWindowHandle();
        mailAddress = driver.findElement(By.id("eposta_adres")).getAttribute("value");
        driver.switchTo().window(googlePageTab);
    }

    public void clickReceivedMail() {
        WebElement mail = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(40))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='gonderen' and text() = 'Google Cloud Sales']")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
                ,mail);
        mail.click();
        logger.info("New mail message has been clicked");
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public String getMailPageTab() {
        return mailPageTab;
    }

    public String getEstimateFromEmail() {
        driver.switchTo().frame(driver.findElement(By.id("iframe")));
        String mail =  driver.findElement(
                By.xpath("//table[@class = 'quote']/tbody/tr[2]/td[2]/h3")).getText();
                mail = mail.replaceAll("[a-zA-Zа]*", "").trim();
        logger.info("Data has been received from mail message");
        return mail;
    }
}
