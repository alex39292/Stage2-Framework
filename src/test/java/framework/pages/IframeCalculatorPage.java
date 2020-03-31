package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IframeCalculatorPage {
    private WebDriver driver;
    private String estimateFromButton;

    @FindBy(id = "input_55")
    private WebElement numberOfInstances;

    @FindBy(id = "input_56")
    private WebElement instanceFor;

    @FindBy(id = "select_value_label_48")
    private WebElement operatingSystem;

    @FindBy(id = "select_value_label_49")
    private WebElement vmClass;

    @FindBy(xpath = "//div[@class = 'md-container md-ink-ripple']")
    private WebElement addGpu;

    @FindBy(id = "select_167")
    private WebElement localSsd;

    @FindBy(id = "select_82")
    private WebElement dataCenterLocation;

    @FindBy(id = "select_89")
    private WebElement commitedUsage;

    @FindBy(xpath = "//button[@class = 'md-raised md-primary cpc-button md-button md-ink-ripple']")
    private WebElement button;

    public IframeCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Add some data to Google Cloud Pricing Calculator form
    private void addToEstimate() {
        numberOfInstances.sendKeys("4");
        instanceFor.clear();

        //Operating System/Software
        operatingSystem.click();
        driver.findElement(By.id("select_option_57")).click();

        //Machine Class
        vmClass.click();
        driver.findElement(By.id("select_option_69")).click();

        //Machine Type
        driver.findElement(By.id("select_value_label_52")).click();
        driver.findElement(By.id("select_option_208")).click();

        //Add GPU
        addGpu.click();
        driver.findElement(By.id("select_value_label_326")).click();
        driver.findElement(By.id("select_option_333")).click();
        driver.findElement(By.id("select_value_label_327")).click();
        driver.findElement(By.id("select_option_340")).click();

        //Local SSD
        localSsd.click();
        driver.findElement(By.id("select_option_229")).click();

        //Data center Location
        dataCenterLocation.click();
        driver.findElement(By.id("select_option_177")).click();

        //Committed Usage
        commitedUsage.click();
        driver.findElement(By.id("select_option_87")).click();

        //Press button ADD TO ESTIMATE
        button.click();
    }

    public TenMinuteMail sendMail() {
        driver.findElement(By.id("email_quote")).click();
        return new TenMinuteMail(driver);
    }

    public void setEstimateFromButton() {
        addToEstimate();
        estimateFromButton = driver.findElement(By.xpath("//b[@class = 'ng-binding']")).getText();
        estimateFromButton = estimateFromButton.substring(estimateFromButton.lastIndexOf("USD") + 4,estimateFromButton.indexOf("per")).trim();
    }

    public void pasteMailAndSend(String mailAddress, String mailPageTab) {
        driver.findElement(By.id("input_395")).sendKeys(mailAddress);
        driver.findElement(By.cssSelector("md-dialog-actions.layout-row > button:nth-child(2)")).click();

        driver.switchTo().window(mailPageTab);
    }

    public String getEstimateFromButton() {
        return estimateFromButton;
    }
}
