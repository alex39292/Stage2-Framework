package framework.service;

import framework.model.PricingCalculator;

public class PricingCalculatorCreator {
    private static final String TEST_NUMBER_OF_INSTANCES = "calculator.numberOfInstances";
    private static final String TEST_TEXT = "calculator.text";
    private static final String TEST_OPERATING_SYSTEM = "calculator.operatingSystem";
    private static final String TEST_MACHINE_CLASS = "calculator.machineClass";
    private static final String TEST_MACHINE_TYPE = "calculator.machineType";
    private static final String TEST_NUMBER_OF_GPU = "calculator.numberOfGPU";
    private static final String TEST_GPU_TYPE = "calculator.GPUType";
    private static final String TEST_LOCAL_SSD = "calculator.localSSD";
    private static final String TEST_DATACENTER_LOCATION = "calculator.datacenterLocation";
    private static final String TEST_COMMITTED_USAGE = "calculator.committedUsage";

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
                .setCommittedUsage(TestDataReader.getTestData(TEST_COMMITTED_USAGE));
    }
}
