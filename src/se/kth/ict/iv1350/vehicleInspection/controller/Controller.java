package se.kth.ict.iv1350.vehicleInspection.controller;

import java.util.Date;
import se.kth.ict.iv1350.vehicleInspection.integration.InspectionRegistry;
import se.kth.ict.iv1350.vehicleInspection.integration.CreditCard;
import se.kth.ict.iv1350.vehicleInspection.integration.Garage;
import se.kth.ict.iv1350.vehicleInspection.integration.InspectionDTO;
import se.kth.ict.iv1350.vehicleInspection.integration.Printer;
import se.kth.ict.iv1350.vehicleInspection.integration.RegistryCreator;
import se.kth.ict.iv1350.vehicleInspection.integration.InspectionResultsRegistry;
import se.kth.ict.iv1350.vehicleInspection.integration.InvalidLicenseNumberException;
import se.kth.ict.iv1350.vehicleInspection.integration.PaymentAuthorization;
import se.kth.ict.iv1350.vehicleInspection.model.Inspection;

/**
 * This is the application's only controller class. All calls to the model pass
 * through here.
 */
public class Controller {
    private Garage garage;
    private InspectionRegistry inspectionRegistry;
    private InspectionResultsRegistry inspectionResultsRegistry;
    private Inspection inspection;
    private Printer printer;
    private CreditCard creditCard;
    private PaymentAuthorization paymentAuthorization;

    /**
     * Creates a new instance.
     *
     * @param regCreator Used to get all classes that handle database calls.
     * @param printer    Interface to printer.
     */
    public Controller(RegistryCreator regCreator, Printer printer, Garage garage) {
        this.inspectionRegistry = regCreator.getInspectionRegistry();
        this.inspectionResultsRegistry = regCreator.getInspectionResultsRegistry();
        this.printer = printer;
        this.garage = garage;
    }
    public void startNewInspection(String licenseNumber) throws InvalidLicenseNumberException {
        garage.startNewInspection();
        this.inspection = new Inspection(licenseNumber);
    }
    public InspectionDTO getNextInspection() {
	return inspection.getNextInspection();
    }
    
    public void closeDoor() {
        garage.signalCloseDoor();
    }
    /**
     * Returns the cost of the inspection
     * @return returns the cost
     */
	
	public int getCost() {
		return inspection.getCost();
	}
	
	/**
	 * Makes a new payment through the inspection class
	 * @param cardNum cardNum The number of the card used for the payment, set to null if payment is done by cash
	 */
	public void getPay(String cardNum) {
		inspection.getPay(cardNum);
	}
    
    public boolean InspectionResults(boolean results){
        return results;
    }
    
    public void InspectionsCarriedOut(boolean resultsEnd){
 
    }
}