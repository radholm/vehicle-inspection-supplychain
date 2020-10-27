/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.vehicleInspection.integration;

public class InspectionDTO {

	private int cost;
	private Boolean result;
	private int num;
	private String descr;

	/**
	 * Creates an new instance of an inspectionPoint
	 * @param num the number of the inspection point
	 * @param licenseNumber the registration number of the vehicle which the description point belongs to
	 * @param descr The description of the inspection point
	 */
	public InspectionDTO(int num, String licenseNumber, String descr) {
		if (licenseNumber == null) {
			throw new NullPointerException("Invalid value for registration number.");
		}
		if(descr == null) {
			throw new NullPointerException("Invalid value for description.");
		}
		if (licenseNumber.length() != 6) {
			throw new IllegalArgumentException("The given registration number has an invalid length");
		}
		if(num < 0) {
			throw new IllegalArgumentException("Cannot have negative value on order number");
		}
		this.num = num;
		this.result = false;
		this.descr = descr;
		this.cost = 100 * num;
	}

	/**
	 * Returns the cost of the specified inspection point
	 * @return returns the cost of the inspection point
	 */
	public int getCost() {
		return cost;
	}
	
	/**
	 * Returns the description of the specified inspection point
	 * @return returns the description of the inspection point
	 */
	public String getDescr() {
		return this.descr;
	}

	/**
	 * Changes the result of an inspection point
	 * @param result the result to set the local variable to
	 */
	public void setResult(Boolean result) {
		this.result = result;
	}
	
	/**
	 * Gets the result of an inspection point
	 * @return returns TRUE if inspection point passed, returns FALSE if inspectionPoint failed
	 */
	public boolean getResult() {
		return this.result;
	}
	/**
	 * Gets the number for the specified inspection
	 * @return Returns the number of the specific instance of the specified inspection
	 */
	public int getNum() {
		return this.num;
	}
}