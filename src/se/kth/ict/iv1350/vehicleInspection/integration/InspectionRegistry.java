package se.kth.ict.iv1350.vehicleInspection.integration;

import java.util.ArrayList;
import java.util.List;

public class InspectionRegistry {

	private List<InspectionDTO> availableInspections;
	private String licenseNumber;

	/**
	 * Creates an new instance of the <code>inspectionPointManager</code> for the <code>Vehicle</code> class with the specified regNumber
	 * @param licenseNumber, the registration number of the inspected vehicle
	 * @throws InvalidRegNumberException InvalidRegNumberException if the specified regNumber does not have any inspection points
	 */
	public InspectionRegistry(String licenseNumber) throws InvalidLicenseNumberException {
		this.licenseNumber = licenseNumber;
		this.availableInspections = new ArrayList<InspectionDTO>();
		createSpecifiedInspectionList();
	}

    InspectionRegistry() {
    }

	/**
	 *  Returns the inspection points in the list <code>availableInspectionPoints</code>
	 */
	public List<InspectionDTO> getAvailableInspections() {
		return availableInspections;
	}

	/**
	 * Retrieves an list of <code>InspectionPoint<code> for the vehicle with the registration number regNumber from the database
	 * In this case(where there is no database) it creates several new <code>inspectionPoints</code> for use
	 * @throws InvalidRegNumberException if the specified regNumber does not have any inspection points
	 */
	private void createSpecifiedInspectionList() throws InvalidLicenseNumberException {
		
		//-------------------------NEW CODE---------------------------------------
		//changed code! added an if-case to check the regNumber by calling checkRegNumber()
		if(checkLicenseNumber()) {
		
			String[] descriptions = {"Inspect Tires", "Inspect Engine", "Inspect Lights", "Inspect Brakes", "Inspect Airbags", "Inspect AC", "Inspect Electrical System"};
			int num = 0;
			
			for (String s: descriptions) {
				InspectionDTO inspection = new InspectionDTO(num, this.licenseNumber, s);
				this.availableInspections.add(num, inspection);
				num++;
			}
		} else {
			throw new InvalidLicenseNumberException();
		}
		//-----------------------------------------------------------------------
	}
	
	
	//-------------------------NEW CODE---------------------------------------
	/**
	 * Checks if the regNumber is valid
	 * @return returns TRUE if regNumber is valid, returns FALSE if regNumber is invalid
	 */
	private boolean checkLicenseNumber() {
		
		String validLicenseNumbers = "MN";
		
		if(this.licenseNumber.toLowerCase().contains(validLicenseNumbers.toLowerCase())) {
			return true;
		} else {
			return false;
		}
	}
	//------------------------------------------------------------------------
	
	/**
	 * 	Updates the database with the result of the inspection points
	 * @param inspectionPointResult, the list to send to the database for the desired vehicle
	 * @return, returns TRUE if database was update correctly, returns FALSE if there was an error
	 */
	public boolean updateDatabase(List<InspectionDTO> inspectionDTOResult) {
		if(inspectionDTOResult == null || inspectionDTOResult.isEmpty()) {
			throw new NullPointerException("Cannot send an empty list to database");
		} else {
			printResult();
			return true;
		}
	}
	
	/**
	 * Prints the paper with the result from the inspection
	 */
	private void printResult() {
		System.out.println("Would have printed a inspection result papaer if we had an printer...");
	}
}