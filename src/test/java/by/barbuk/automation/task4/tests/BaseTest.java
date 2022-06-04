package by.barbuk.automation.task4.tests;

import by.barbuk.automation.task4.driver.DriverSingleton;
import by.barbuk.automation.task4.utill.TestListener;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

@Log4j2
@Listeners({TestListener.class})
public abstract class BaseTest {

    WebDriver driver;
    SoftAssert softAssert;

    @BeforeMethod
    public void setup() {
        log.info("Create driver");
        driver = new DriverSingleton().getDriver();
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void tearDown() {
        log.info("Close driver");
        driver.close();
    }
}
