package by.barbuk.automation.task4.model;

import java.util.Objects;

public class CalculatorPageData {
    private String virtualMachineClass;
    private String instanceType;
    private String location;
    private String localSsd;
    private String usageTime;
    private int instanceNumber;
    private String engineType;
    private String operationSystem;
    private String gpuType;
    private int numberOfGPU;
    private String totalCost;
    private String series;

    public CalculatorPageData(String vmClass, String instanceType, String region, String localSsd, String commitmentTerm,
                              int instanceNumber, String engineType, String operationSystem, String gpuType, int numberOfGPU, String series, String totalCost) {
        this.virtualMachineClass = vmClass;
        this.instanceType = instanceType;
        this.location = region;
        this.localSsd = localSsd;
        this.usageTime = commitmentTerm;
        this.instanceNumber = instanceNumber;
        this.engineType = engineType;
        this.operationSystem = operationSystem;
        this.gpuType = gpuType;
        this.numberOfGPU = numberOfGPU;
        this.series = series;
        this.totalCost = totalCost;
    }


    public String getVirtualMachineClass() {
        return virtualMachineClass;
    }

    public void setVirtualMachineClass(String virtualMachineClass) {
        this.virtualMachineClass = virtualMachineClass;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocalSsd() {
        return localSsd;
    }

    public void setLocalSsd(String localSsd) {
        this.localSsd = localSsd;
    }

    public String getUsageTime() {
        return usageTime;
    }

    public void setUsageTime(String usageTime) {
        this.usageTime = usageTime;
    }

    public int getInstanceNumber() {
        return instanceNumber;
    }

    public void setInstanceNumber(int instanceNumber) {
        this.instanceNumber = instanceNumber;
    }

    private String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getSeries() {
        return series;
    }

    private void setSeries(String series){
        this.series = series;
    }
    public String getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public int getNumberOfGPU() {
        return numberOfGPU;
    }

    public void setNumberOfGPU(int numberOfGPU) {
        this.numberOfGPU = numberOfGPU;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CalculatorPageData)) return false;
        CalculatorPageData calculatorPageData = (CalculatorPageData) o;
        return getInstanceNumber() == calculatorPageData.getInstanceNumber() &&
                getNumberOfGPU() == calculatorPageData.getNumberOfGPU() &&
                Objects.equals(getVirtualMachineClass(), calculatorPageData.getVirtualMachineClass()) &&
                Objects.equals(getInstanceType(), calculatorPageData.getInstanceType()) &&
                Objects.equals(getLocation(), calculatorPageData.getLocation()) &&
                Objects.equals(getLocalSsd(), calculatorPageData.getLocalSsd()) &&
                Objects.equals(getUsageTime(), calculatorPageData.getUsageTime()) &&
                Objects.equals(getEngineType(), calculatorPageData.getEngineType()) &&
                Objects.equals(getOperationSystem(), calculatorPageData.getOperationSystem()) &&
                Objects.equals(getGpuType(), calculatorPageData.getGpuType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVirtualMachineClass(), getInstanceType(), getLocation(),
                getLocalSsd(), getUsageTime(), getInstanceNumber(),
                getEngineType(), getOperationSystem(), getGpuType(), getNumberOfGPU());
    }


    @Override
    public String toString() {
        return "CalculatorPageData{" +
                "virtualMachineClass='" + virtualMachineClass + '\'' +
                ", instanceType='" + instanceType + '\'' +
                ", location='" + location + '\'' +
                ", localSsd='" + localSsd + '\'' +
                ", usageTime='" + usageTime + '\'' +
                ", instanceNumber=" + instanceNumber +
                ", engineType='" + engineType + '\'' +
                ", operationSystem='" + operationSystem + '\'' +
                ", gpuType='" + gpuType + '\'' +
                ", numberOfGPU=" + numberOfGPU +
                '}';
    }


}
