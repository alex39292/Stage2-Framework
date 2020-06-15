package framework.model;

public class PricingCalculator {
    private String numberOfInstances;
    private String text;
    private String operationSystem;
    private String machineClass;
    private String machineType;
    private String numberOfGPU;
    private String GPUType;
    private String localSSD;
    private String datacenterLocation;
    private String committedUsage;

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public PricingCalculator setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
        return this;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public PricingCalculator setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
        return this;
    }

    public String getText() {
        return text;
    }

    public PricingCalculator setText(String text) {
        this.text = text;
        return this;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public PricingCalculator setMachineClass(String machineClass) {
        this.machineClass = machineClass;
        return this;
    }

    public String getMachineType() {
        return machineType;
    }

    public PricingCalculator setMachineType(String machineType) {
        this.machineType = machineType;
        return this;
    }

    public String getNumberOfGPU() {
        return numberOfGPU;
    }

    public PricingCalculator setNumberOfGPU(String numberOfGPU) {
        this.numberOfGPU = numberOfGPU;
        return this;
    }

    public String getGPUType() {
        return GPUType;
    }

    public PricingCalculator setGPUType(String GPUType) {
        this.GPUType = GPUType;
        return this;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public PricingCalculator setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
        return this;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public PricingCalculator setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
        return this;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public PricingCalculator setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
        return this;
    }
}
