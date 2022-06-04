package by.barbuk.automation.task4.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

@Log4j2
public class DriverSingleton {

  public WebDriver driver = null;

    public WebDriver getDriver() {
        // Temporary solution, just for usability - in general case properties should be defined through maven command
        // or capabilities
        System.setProperty("browser", "chrome");
        System.setProperty("datalist", "second");
        if (driver == null) {
            switch (System.getProperty("browser")) {

                case "opera": {
                    log.info("Setup driver for Opera Browser");
                    WebDriverManager.operadriver().setup();
                    String operaBinary = "C:\\Users\\Nastassia_Barbuk\\AppData\\Local\\Programs\\Opera\\99.0.4844.51\\opera.exe";
                    OperaOptions options = new OperaOptions();
                    options.setBinary(operaBinary);
                    options.setCapability("platformName", Platform.WINDOWS);
                    try {
                        driver =new OperaDriver();
                        driver.get("http://localhost:4444/wd/hub");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "firefox": {
                    log.info("Setup driver for Firefox Browser");
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                case "edge": {
                    log.info("Setup driver for Edge Browser");
                    EdgeOptions options = new EdgeOptions();
                    options.setCapability("platformName", Platform.WINDOWS);
                    WebDriverManager.edgedriver().setup();
                    try {
                        driver =new EdgeDriver();
                        driver.get("http://localhost:4444/wd/hub");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
                default: {
                    log.info("Setup driver for Chrome Browser");
                    ChromeOptions options = new ChromeOptions();
                    options.setCapability("platformName", Platform.WINDOWS);
                    WebDriverManager.chromedriver().setup();
                    try {
                        driver =new ChromeDriver();
                        driver.get("http://localhost:4444/wd/hub");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public void closeDriver() {
        log.info("Close driver");
        driver.quit();
        driver = null;
    }
}
