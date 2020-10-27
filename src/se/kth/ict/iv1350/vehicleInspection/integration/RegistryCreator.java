package se.kth.ict.iv1350.vehicleInspection.integration;

/**
 * This class is responsible for instantiating all registries.
 */
public class RegistryCreator {
    private InspectionRegistry inspectionRegistry = new InspectionRegistry();
    private InspectionResultsRegistry inspectionResultsRegistry = new InspectionResultsRegistry();

    /**
     * Get the value of rentalRegistry
     *
     * @return the value of rentalRegistry
     */
    public InspectionResultsRegistry getInspectionResultsRegistry() {
        return inspectionResultsRegistry;
    }

    /**
     * Get the value of carRegistry
     *
     * @return the value of carRegistry
     */
    public InspectionRegistry getInspectionRegistry() {
        return inspectionRegistry;
    }
}
