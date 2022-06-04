package by.barbuk.automation.task4.pages.email;

import by.barbuk.automation.task4.driver.Waiter;
import by.barbuk.automation.task4.pages.BasePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class EmailGeneratorPage extends BasePage {

    @FindBy(xpath = "//*[@id='egen']")
    private WebElement emailAddress;

    @FindBy(xpath = "//button[contains(@onclick, 'egengo();')]")
    private WebElement checkInbox;

    @FindBy(xpath = "//button[contains(@onclick, 'newgen();')]")
    private WebElement newRandomAddress;

    protected EmailGeneratorPage(WebDriver driver) {
        super(driver);
    }

    public EmailGeneratorPage generateNewAddress(){
        log.info("Generate new email address");
        Waiter.waitUntilClickableAndClick(driver, newRandomAddress);
        return this;
    }

    public EmailInboxPage checkInboxEmails(){
        log.info("Wait a minute for letter to pass and go to Inbox page");
        Waiter.justWait(30000);
        Waiter.waitUntilClickableAndClick(driver, checkInbox);
        return new EmailInboxPage(driver);
    }

    public String getEmailAddress() {
        log.info("Getting mail address");
        log.info("email address is {}", emailAddress.getText());
        return emailAddress.getText();
    }
}
