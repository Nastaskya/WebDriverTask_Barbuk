package by.barbuk.automation.task4.utill;

import lombok.extern.log4j.Log4j2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

@Log4j2
public class PropertyReader {
    private static final String LOCALE_PATH = "src/test/resources/locale.properties";

    private static final ResourceBundle dataResourceBundle = ResourceBundle.getBundle(System.getProperty("datalist"));

    public static String getTestData(String key) {
        log.info("Key - {}, property - {}", key, dataResourceBundle.getString(key));
        return dataResourceBundle.getString(key);
    }

    private static String getValue(String propertyPath, String key) {
        log.info("Get properties from file {}", propertyPath);
        FileInputStream inputStream;
        Properties property = new Properties();
        try {
            inputStream = new FileInputStream(propertyPath);
            property.load(inputStream);
            log.info("Key - {}, property - {}", key, property.getProperty(key));
            return property.getProperty(key);
        } catch (IOException e) {
            log.error(e);
            return null;
        }
    }

    public static String getLocaleValue(String key) {
        return getValue(LOCALE_PATH, key);
    }

}
