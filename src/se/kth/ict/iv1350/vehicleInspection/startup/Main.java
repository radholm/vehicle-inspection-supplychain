package se.kth.ict.iv1350.vehicleInspection.startup;

import java.util.Scanner;
import se.kth.ict.iv1350.vehicleInspection.controller.Controller;
import se.kth.ict.iv1350.vehicleInspection.integration.Garage;
import se.kth.ict.iv1350.vehicleInspection.integration.Printer;
import se.kth.ict.iv1350.vehicleInspection.integration.RegistryCreator;

/**
 * Starts the program and runs an sample execution
 *
 */
public class Main{

	private Controller controller;

	/**
	 * Creates an new instance of the <code>View</code> class of the application
	 * @param control, passes through an referees to the control class created in the <code>startUp</code> class
	 */
	
	/**
	 * The main method for the program
	 * @param args - this program does not handle any parameters
	 */
	public static void main(String[] args) {
                RegistryCreator creator = new RegistryCreator();
                Printer printer = new Printer();
                Garage garage = new Garage();
		Controller contr = new Controller(creator, printer, garage);
	}
        
        public void sampleExecution() {
		
		//Create input scanner
		Scanner in = new Scanner(System.in);
		boolean done = false;
		String licenseNumber = "";
		
		//Starts new inspection
		System.out.println("Enter a registration number for the vehicle: \n");
		while(!done) {
			try{
				licenseNumber = in.nextLine();
				controller.startNewInspection(licenseNumber);
				done = true;
			} catch(IllegalArgumentException exc) {
				System.out.println("(IllegalArgumentException thrown!)Invalid registration number for the vehicle, length of regNumber not supported, try again: \n");
			} 
			//-------------------------NEW CODE---------------------------------------
			catch(InvalidLicenseNumberException exc) {
				//NEW CODE! catch block to catch the new exception for regNumbers with no inspections
				System.out.println("(InvalidRegNumberException thrown!)There are no inspection points for the entered registration number, try again: \n");
			}
			//------------------------------------------------------------------------
		}
		System.out.println("Inspection Started! \n");
		
		//-------------------------NEW CODE---------------------------------------
		//Add ObserverImpl as observer to vehicle
		controller.addObserver(obs);
		//------------------------------------------------------------------------
		
		//Updates Display and open garage doors
		controller.updateDisplay(licenseNumber);
		controller.openGarageDoors();
		
		//Customer enters garage, close garage doors
		controller.closeGarageDoors();
		
		//Get cost for inspection
		System.out.println("The cost of the inspection is: " + controller.getCost() + " kr \n");
		
		//Customer enters card information
		System.out.println("Enter a valid cardnumber or leave it blank to pay by cash: \n");
		done = false;
		while(!done) {
			try{
				controller.makePayment(in.nextLine());
				done = true;
			} catch(IllegalArgumentException exc) {
				System.out.println("Invalid card number, try again: \n");
			}
		}
		
		//Perform inspection
		done = false;
		controller.resetInspectionPointIterator();
		while(!done) {
			
			//Gets next inspection point
			inspectionPoint point = controller.getNextInspectionPoint();
			if(point != null) {
				//-------------------------NEW CODE---------------------------------------
				//Sets the result of the inspection(causes the vehicle to call the notifyNewResult)
				controller.enterInspectionResult(point.getNum(), true);
				//------------------------------------------------------------------------
			} else {
				//If there are no more inspection points, we are done
				done = true;
			}
		}
		
		//Store inspection result and prints them
		controller.updateDatabase();
		
		//Open garage doors for customer to leave
		controller.openGarageDoors();
		
		in.close();

	}
}
}
