package framework.service;

import framework.model.PricingCalculator;

public class PricingCalculatorCreator {
    public static final String TEST_NUMBER_OF_INSTANCES = "calculator.numberOfInstances";
    public static final String TEST_TEXT = "calculator.test";
    public static final String TEST_OPERATING_SYSTEM = "calculator.operatingSystem";
    public static final String TEST_MACHINE_CLASS = "calculator.machineClass";
    public static final String TEST_MACHINE_TYPE = "calculator.machineType";
    public static final String TEST_NUMBER_OF_GPU = "calculator.numberOfGPU";
    public static final String TEST_GPU_TYPE = "calculator.GPUType";
    public static final String TEST_LOCAL_SSD = "calculator.localSSD";
    public static final String TEST_DATACENTER_LOCATION = "calculator.datacenterLocation";
    public static final String TEST_COMMITED_USAGE = "calculator.commitedUsage";

    public static PricingCalculator withProperty() {
        return new PricingCalculator()
                .setNumberOfInstances(TestDataReader.getTestData(TEST_NUMBER_OF_INSTANCES))
                .setText(TestDataReader.getTestData(TEST_TEXT))
                .setOperatingSystem(TestDataReader.getTestData(TEST_OPERATING_SYSTEM))
                .setMachineClass(TestDataReader.getTestData(TEST_MACHINE_CLASS))
                .setMachineType(TestDataReader.getTestData(TEST_MACHINE_TYPE))
                .setNumberOfGPU(TestDataReader.getTestData(TEST_NUMBER_OF_GPU))
                .setGPUType(TestDataReader.getTestData(TEST_GPU_TYPE))
                .setLocalSSD(TestDataReader.getTestData(TEST_LOCAL_SSD))
                .setDatacenterLocation(TestDataReader.getTestData(TEST_DATACENTER_LOCATION))
                .setCommitedUsage(TestDataReader.getTestData(TEST_COMMITED_USAGE));
    }
}
