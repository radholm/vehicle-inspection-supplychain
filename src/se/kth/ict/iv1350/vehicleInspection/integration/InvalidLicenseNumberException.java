/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.vehicleInspection.integration;

@SuppressWarnings("serial")
public class InvalidLicenseNumberException extends Exception {

	public InvalidLicenseNumberException() {
		super("There is no inspections for the entered registration number");
	}
}
