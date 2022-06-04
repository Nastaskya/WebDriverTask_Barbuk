package by.barbuk.automation.task4.pages.google;

import by.barbuk.automation.task4.driver.Waiter;
import by.barbuk.automation.task4.pages.BasePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class GoogleCloudPage extends BasePage {
    public static final String GOOGLE_CLOUD_PAGE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//div[contains(@class, 'devsite-searchbox')]")
    private WebElement searchBox;

    public GoogleCloudPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPage goToGoogleCloudPage() {
        log.info("Go to cloud.google.com");
        driver.get(GOOGLE_CLOUD_PAGE_URL);
        log.info("Cloud page is opened.");
        return this;
    }

    public SearchResultPage useSearchBoxAndGoToSearchResultPage() {
        log.info("Go to searching result page");
        Waiter.waitUntilVisibilityOfElement(driver, searchBox);
        moveToElementAndClick(searchBox);
        Waiter.justWait(60);
        sendText(searchBox, "google cloud platform pricing calculator"  + "\n");
        return new SearchResultPage(driver);
    }
}
