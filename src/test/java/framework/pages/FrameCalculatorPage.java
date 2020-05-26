package framework.pages;

import framework.model.PricingCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class FrameCalculatorPage extends AbstractPage {
    private String estimateFromButton;

    //@FindBy(id = "input_58")
    private WebElement numberOfInstances;

    @FindBy(id = "input_59")
    private WebElement instanceFor;

    @FindBy(id = "select_value_label_51")
    private WebElement operatingSystem;

    @FindBy(id = "select_value_label_52")
    private WebElement vmClass;

    @FindBy(id = "select_83")
    private WebElement machineType;

    @FindBy(xpath = "//div[@class = 'md-container md-ink-ripple']")
    private WebElement addGpu;

    @FindBy(id = "select_170")
    private WebElement localSsd;

    @FindBy(id = "select_85")
    private WebElement dataCenterLocation;

    @FindBy(id = "select_92")
    private WebElement committedUsage;

    @FindBy(xpath = "//button[@class = 'md-raised md-primary cpc-button md-button md-ink-ripple']")
    private WebElement button;

    public FrameCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    //Add some data to Google Cloud Pricing Calculator form
    private void addToEstimate(PricingCalculator calculator) {
        if (existsElement(By.id("input_58"))) {
            numberOfInstances = driver.findElement(By.id("input_58"));
        }
        else{
            logger.info("No such element exception with firs selector\"input_58\"");
            throw new NoSuchElementException("");
        }
        numberOfInstances.sendKeys(calculator.getNumberOfInstances());
        instanceFor.sendKeys(calculator.getText());

        //Operating System/Software
        operatingSystem.click();
        driver.findElement(By.id(calculator.getOperatingSystem())).click();

        //Machine Class
        vmClass.click();
        driver.findElement(By.id(calculator.getMachineClass())).click();

        //Machine Type
        machineType.click();
        driver.findElement(By.id(calculator.getMachineType())).click();

        //Add GPU
        addGpu.click();
        driver.findElement(By.id("select_value_label_332")).click();
        driver.findElement(By.id(calculator.getNumberOfGPU())).click();
        driver.findElement(By.id("select_value_label_333")).click();
        driver.findElement(By.id(calculator.getGPUType())).click();

        //Local SSD
        localSsd.click();
        driver.findElement(By.id(calculator.getLocalSSD())).click();

        //Data center Location
        dataCenterLocation.click();
        driver.findElement(By.id(calculator.getDatacenterLocation())).click();

        //Committed Usage
        committedUsage.click();
        driver.findElement(By.id(calculator.getCommittedUsage())).click();

        //Press button ADD TO ESTIMATE
        button.click();
        logger.info("Button Add to estimate has been pressed");
    }

    public TenMinuteMail sendMail() {
        driver.findElement(By.id("email_quote")).click();
        return new TenMinuteMail(driver);
    }

    public FrameCalculatorPage setEstimateFromButton(PricingCalculator calculator) {
        addToEstimate(calculator);
        estimateFromButton = driver.findElement(By.xpath("//b[@class = 'ng-binding']")).getText();
        estimateFromButton = estimateFromButton.substring(estimateFromButton.lastIndexOf("USD") + 4,estimateFromButton.indexOf("per")).trim();
        logger.info("The estimate data from button has been taken");
        return this;
    }

    public void pasteMailAndSend(String mailAddress, String mailPageTab) {
        driver.findElement(By.xpath("//input[@type=\"email\"]")).sendKeys(mailAddress);
        driver.findElement(By.cssSelector("md-dialog-actions.layout-row > button:nth-child(2)")).click();
        logger.info("The mail has been sent");

        driver.switchTo().window(mailPageTab);
        logger.info("Switched to Mail Page");
    }

    public String getEstimateFromButton() {
        return estimateFromButton;
    }

    private boolean existsElement(By by) {
        try {
            new FluentWait<>(driver).withTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
