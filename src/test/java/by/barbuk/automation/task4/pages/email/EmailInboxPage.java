package by.barbuk.automation.task4.pages.email;

import by.barbuk.automation.task4.driver.Waiter;
import by.barbuk.automation.task4.pages.BasePage;
import by.barbuk.automation.task4.utill.StringToCostValueParser;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class EmailInboxPage extends BasePage {

    @FindBy(id = "ifmail")
    private WebElement mailFrame;

    @FindBy(id = "mail")
    private WebElement email;

    protected EmailInboxPage(WebDriver driver) {
        super(driver);
    }

    public String readTotalCost() {
        log.info("Get total cost");
        Waiter.waitUntilVisibilityOfElement(driver, mailFrame);
        Waiter.waitUntilSwitch(driver, mailFrame);
        Waiter.waitUntilVisibilityOfElement(driver, email);
        return StringToCostValueParser.mailTextToCostParser(email.getText());
    }
}