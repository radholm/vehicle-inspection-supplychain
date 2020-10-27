package se.kth.ict.iv1350.vehicleInspection.model;

import se.kth.ict.iv1350.vehicleInspection.integration.PaymentAuthorization;
import se.kth.ict.iv1350.vehicleInspection.model.Receipt;
import se.kth.ict.iv1350.vehicleInspection.integration.InvalidLicenseNumberException;
import se.kth.ict.iv1350.vehicleInspection.integration.InspectionDTO;

public class Inspection {

	private Vehicle vehicle;
	private Receipt receipt;

	/**
	 * Creates an new instance of an inspection
	 * @param regNumber, the regNumber of the vehicle being inspected
	 * @throws InvalidRegNumberException InvalidRegNumberException if the specified regNumber does not have any inspection points
	 */
	public Inspection(String licenseNumber) throws InvalidLicenseNumberException {
		if (licenseNumber.length() != 6) {
			throw new IllegalArgumentException("Invalid regNumber for vehicle");
		}
		vehicle = new Vehicle(licenseNumber);
	}

	/**
	 * Sets the result of an specified inspection point
	 * @param num the index of the inspection point
	 * @param result the result of the inspection point
	 */
	public void setInspectionResult(int num, boolean result) {
		vehicle.setInspectionDTOResult(num, result);
	}

	/**
	 * Retrieves the next inspection point
	 * @return returns the next inspection point
	 */
	public InspectionDTO getNextInspection() {
		return vehicle.getNextInspection();
	}
	
	/**
	 * Retrieves the cost of the inspection
	 * @return the cost of the inspection
	 */
	public int getCost() {
		return vehicle.getTotalCost();
	}

	/**
	 * Creates an new instance of the <code>PaymentAuthorization</code> class and uses it to process the payment
	 * @param cardNum The number of the card used for the payment, set to null if payment is done by cash
	 */
	public void getPay(String cardNum) {
		PaymentAuthorization PA = new PaymentAuthorization();
		boolean payComplete = PA.getPay(cardNum, vehicle.getTotalCost());
		if(payComplete) {
			System.out.println("Payment was successfull");
			this.receipt = new Receipt(vehicle.getLicenseNumber(), vehicle.getTotalCost());
			System.out.println("Printing receipt...");
			this.receipt.printReceipt();
		}
	}
	
	/**
	 * Resets the iterator for the inspectionPoints contained in the list for the vehicle class
	 */
	public void resetInspectionPointIterator() {
		vehicle.resetListIterator();
	}
    }