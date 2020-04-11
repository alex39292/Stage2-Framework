package framework.pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected final String SEARCHING_FIELD = "Google Cloud Platform Pricing Calculator";

    protected WebDriver driver;

    protected final int WAIT_TIMEOUT_SECONDS = 20;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
}
