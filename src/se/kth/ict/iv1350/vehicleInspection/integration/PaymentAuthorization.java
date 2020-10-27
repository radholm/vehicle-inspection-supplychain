package se.kth.ict.iv1350.vehicleInspection.integration;

public class PaymentAuthorization {

	/**
	 * Creates an new instance of the paymentAuthorization system that is used to complete payments
	 */
	public PaymentAuthorization() {
		
	}
	/**
	 * Sends an payment request to the database
	 * @param cardNum The number of the card used for payment
	 * @param amount The amount to draw from 
	 * @return Returns TRUE if payment was successful
	 * @throws IllegalArgumentException if the arguments are not correct
	 */
	public boolean getPay(String cardNum, int amount) {
		if ((cardNum.length() == 16 && amount > 0) || (cardNum == "" && amount > 0)) {
			return true;
		} else {
			throw new IllegalArgumentException("There was an problem with the arguments entered for payment");
		}
	}
}