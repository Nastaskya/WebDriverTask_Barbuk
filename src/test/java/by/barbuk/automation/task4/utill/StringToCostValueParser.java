package by.barbuk.automation.task4.utill;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

@Log4j2
public class StringToCostValueParser {
    private final static String REG_EX_ONLY_NUMBERS = "\\D+";

    // Get number from string
    public static String mailTextToCostParser(String stringWithCost) {
        log.info("Parse mail text to find TotalCost");
        return StringUtils.substringBefore(Arrays.stream(stringWithCost.split(" ")).map(String::trim)
                .filter(line -> !line.matches(REG_EX_ONLY_NUMBERS) && line.length() > 1)
                .collect(Collectors.toList()).get(0), "\n");
    }
}
