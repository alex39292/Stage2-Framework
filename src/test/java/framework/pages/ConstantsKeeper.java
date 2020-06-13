package framework.pages;

import framework.service.TestDataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

//It keeps all constant selectors
public interface ConstantsKeeper {
    Logger logger = LogManager.getRootLogger();
    //Constant for CalculatorPage Class
    By IFRAME = By.tagName("iframe");

    //Constants with timeouts
    int WAIT_TIMEOUT_SECONDS = 40;

    //Constant for CloudGoogle Class
    String SEARCH_FIELD = "q";
    String SEARCHING_TEXT = TestDataReader.getTestData("cloudgoogle.searchingField");

    //Constants with url addresses
    String URL_TO_GOOGLE = "https://cloud.google.com/";
    String URL_TO_GOOGLE_CALCULATOR = "https://cloud.google.com/products/calculator";
    String URL_TO_MAIL_HANDLER = "https://lroid.com/ru/";

    //Constants for MailHandler Class
    String MAIL_ADDRESS = "eposta_adres";
    String MAIL = "//div[@class='gonderen' and text() = 'Google Cloud Sales']";
    String MAIL_DATA = "//table[@class = 'quote']/tbody/tr[2]/td[2]/h3";

    //Constants of selectors for FrameCalculatorPage Class
    String GPU_NUMBER_BUTTON = "select_value_label_335";
    String GPU_TYPE_BUTTON = "select_value_label_336";
    String SEND_MAIL_BUTTON = "email_quote";
    String TABLE_FROM_BUTTON = "//b[@class = 'ng-binding']";
    String EMAIL_INPUT = "//input[@type=\"email\"]";
    String SEND_EMAIL_BUTTON = "md-dialog-actions.layout-row > button:nth-child(2)";

    //Button's selectors for FrameCalculatorPage Class
    String NUMBER_OF_INSTANCES = "input_58";
    String INSTANCE_FOR = "input_59";
    String OPERATION_SYSTEM = "select_value_label_51";
    String VM_CLASS = "select_value_label_52";
    String MACHINE_TYPE = "select_83";
    String ADD_GPU = "//div[@class = 'md-container md-ink-ripple']";
    String LOCAL_SSD = "select_170";
    String DATACENTER_LOCATION = "select_85";
    String COMMITTED_USAGE = "select_92";
    String SUBMIT_BUTTON = "//button[@class = 'md-raised md-primary cpc-button md-button md-ink-ripple']";
}
