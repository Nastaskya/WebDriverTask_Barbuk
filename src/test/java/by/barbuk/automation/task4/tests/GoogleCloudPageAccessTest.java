package by.barbuk.automation.task4.tests;

import by.barbuk.automation.task4.pages.google.GoogleCloudPage;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

import static by.barbuk.automation.task4.pages.google.GoogleCloudPage.GOOGLE_CLOUD_PAGE_URL;

@Log4j2
public class GoogleCloudPageAccessTest extends BaseTest {
    @Test
    public void testGoggleCloudAccess() {
        log.info("Thread number from smoke test = " + Thread.currentThread().getId());
        GoogleCloudPage cloudPage = new GoogleCloudPage(driver);
        cloudPage.goToGoogleCloudPage();
        Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(GOOGLE_CLOUD_PAGE_URL));
    }
}
