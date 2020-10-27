package se.kth.ict.iv1350.vehicleInspection.integration;

import java.util.ArrayList;
import java.util.List;
import se.kth.ict.iv1350.vehicleInspection.model.Inspection;

/**
 * Contains all calls to the data store with performed rentals.
 */
public class InspectionResultsRegistry {
    private List<Inspection> inspections = new ArrayList<>();
    
    InspectionResultsRegistry() {
    }

    /**
     * Saves the specified inspections permanently.
     *
     * @param inspection The rental that will be saved.
     */
    public void storeInspectionResults(Inspection inspection) {
        inspections.add(inspection);
    }
}