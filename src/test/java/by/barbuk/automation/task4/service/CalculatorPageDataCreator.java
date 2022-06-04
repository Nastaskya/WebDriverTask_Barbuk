package by.barbuk.automation.task4.service;

import by.barbuk.automation.task4.model.CalculatorPageData;
import by.barbuk.automation.task4.utill.PropertyReader;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CalculatorPageDataCreator {

    private final static String VM_CLASS_VALUE = "calculatorPageData.vm.class";
    private final static String INSTANCE_TYPE = "calculatorPageData.instance.type";
    private final static String REGION = "calculatorPageData.location";
    private final static String LOCAL_SSD = "calculatorPageData.ssd";
    private final static String COMMITMENT_TERM = "calculatorPageData.term";
    private final static String NUMBER_OF_INSTANCE = "calculatorPageData.instance.number";
    private final static String ENGINE_TYPE = "calculatorPageData.engine.type";
    private final static String OPERATION_SYSTEM = "calculatorPageData.os";
    private final static String GPU_TYPE = "calculatorPageData.gpy.type";
    private final static String NUMBER_OF_GPU = "calculatorPageData.gpy.number";
    private final static String TOTAL_COST = "calculatorPageData.total.cost";
    private final static String SERIES = "calculatorPageData.series";

    public static CalculatorPageData getDataProperties() {
        log.info("Set all data for Calculator page object");
        return new CalculatorPageData(PropertyReader.getTestData(VM_CLASS_VALUE),
                PropertyReader.getTestData(INSTANCE_TYPE),
                PropertyReader.getTestData(REGION),
                PropertyReader.getTestData(LOCAL_SSD),
                PropertyReader.getTestData(COMMITMENT_TERM),
                Integer.parseInt(PropertyReader.getTestData(NUMBER_OF_INSTANCE)),
                PropertyReader.getTestData(ENGINE_TYPE),
                PropertyReader.getTestData(OPERATION_SYSTEM),
                PropertyReader.getTestData(GPU_TYPE),
                Integer.parseInt(PropertyReader.getTestData(NUMBER_OF_GPU)),
                PropertyReader.getTestData(SERIES),
                PropertyReader.getTestData(TOTAL_COST));
    }
}
