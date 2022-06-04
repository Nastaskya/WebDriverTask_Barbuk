package by.barbuk.automation.task4.pages.email;

import by.barbuk.automation.task4.driver.Waiter;
import by.barbuk.automation.task4.pages.BasePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class EmailPage extends BasePage {
    private static final String EMAIL_PAGE_URL = "https://yopmail.com/";

    public EmailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='listeliens']//a[@href='email-generator']")
    private WebElement emailGenerator;

    public EmailPage goToEmailPage() {
        log.info("Open Email Service page");
        driver.get(EMAIL_PAGE_URL);
        log.info("EmailService page is opened.");
        return this;
    }

    public EmailGeneratorPage generateEmailAddress(){
        log.info("Go to email address generator page");
        Waiter.waitUntilClickableAndClick(driver, emailGenerator);
        return new EmailGeneratorPage(driver);
    }

}
