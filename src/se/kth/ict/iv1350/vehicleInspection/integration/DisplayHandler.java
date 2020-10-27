package se.kth.ict.iv1350.vehicleInspection.integration;

public class DisplayHandler {

	private int text;
	//-------------------------NEW CODE---------------------------------------
	private static DisplayHandler onlyInstance = new DisplayHandler();
	
	/**
	 * Creates an new instance of the Display class, notice the private constructor which
	 * Guarantees that only one instance of this class is created
	 */
	DisplayHandler() {
	}

	/**
	 * Returns the only instance of the Display class
	 * @return The single instance of Display class
	 */
	public static DisplayHandler getDisplay() {
		return onlyInstance;
	}
	//------------------------------------------------------------------------
	/**
	 * Updates the display to show the specified string
	 * @param queueNumber the string to show on the display
	 */
	public void updateDisplay(int queueNumber) {
		this.text = queueNumber;
	}

}