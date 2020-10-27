/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.vehicleInspection.model;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import se.kth.ict.iv1350.vehicleInspection.integration.InvalidLicenseNumberException;
import se.kth.ict.iv1350.vehicleInspection.integration.InspectionRegistry;
import se.kth.ict.iv1350.vehicleInspection.integration.InspectionDTO;

public class Vehicle {

	private String licenseNumber;

	private List<InspectionDTO> inspectionDTOList;
	private ListIterator<InspectionDTO> iterator;

	private InspectionRegistry inspectionRegistry;

	/**
	 * Creates an new instance of the <code>Vehicle</code> class, also calls the <code>getInspectionPoints()</code> function to update the inspectionPointList
	 * @param regNumber, the registration number of the vehicle, entered in the view and passed through controller and inspection classes
	 * @throws InvalidRegNumberException InvalidRegNumberException if the specified regNumber does not have any inspection points
	 */
	public Vehicle(String licenseNumber) throws InvalidLicenseNumberException {
		this.licenseNumber = licenseNumber;
		this.inspectionRegistry = new InspectionRegistry(this.licenseNumber);
		this.inspectionDTOList = new ArrayList<InspectionDTO>();
		getInspections();
		this.iterator = this.inspectionDTOList.listIterator();
	}
	
	/**
	 * Resets the list iterator for the <code>inspectionPoint</code> list
	 */
	public void resetListIterator() {
		iterator = inspectionDTOList.listIterator();
	}

	/**
	 *  Calculates the total cost of all the inspections in the <code>inspectionPointList</code>
	 */
	public int getTotalCost() {
		this.resetListIterator();
		InspectionDTO inspection;
		boolean iterate = true;
		int cost = 0;
		
		while(iterate) {
			
			inspection = this.getNextInspection();
			
			if (inspection == null) {
				iterate = false;
			} else {
				cost += inspection.getCost();
			}
		}
		return cost;
	}

	/**
	 *  Sets the inspection point result of an <code>inspectionPoint</code> instance in the <code>inspectionPointList</code>
	 *  Also calls the notifyObservers method to notify all observers of the change
	 */
	public void setInspectionDTOResult(int num, Boolean result) {
		this.inspectionDTOList.get(num).setResult(result);
	}

	/**
	 *  Gets the inspection points for the vehicle from the <code>inspectionPointManager</code> class
	 */
	private void getInspections() {
		this.inspectionDTOList = this.inspectionRegistry.getAvailableInspections();
	}
	
	/**
	 * Gets the next inspectionPoint from the inspectionPoint list
	 * @return Returns the next inspection point if it exists, Returns null if there is no moer inspection points
	 */
	public InspectionDTO getNextInspection() {
		try {
			return this.iterator.next();
		} catch(NoSuchElementException exc) {
			return null;
		}
	}
	
	/**
	 * Gets the regNumber variable of the specific instance of the <code>Vehicle</code> class
	 * @return returns the regNumber variable
	 */
	public String getLicenseNumber() {
		return this.licenseNumber;
	}
}