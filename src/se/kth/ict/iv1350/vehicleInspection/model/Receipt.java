package se.kth.ict.iv1350.vehicleInspection.model;

public class Receipt {
	
	private int cost;
	private String licenseNumber;
	
	/**
	 * Creates a receipt to be printed for the customer
	 * @param licenseNumber The registration number of the vehicle
	 * @param cost The cost of the inspection
	 */
	public Receipt(String licenseNumber, int cost) {
		this.licenseNumber = licenseNumber;
		this.cost = cost;
	}
        
            public String createReceiptString() {
        StringBuilder builder = new StringBuilder();
        appendLine(builder, "Car Rental");
        endSection(builder);
        
        return builder.toString();
    }

    private void appendLine(StringBuilder builder, String line) {
        builder.append(line);
        builder.append("\n");
    }

    private void endSection(StringBuilder builder) {
        builder.append("\n");
    }
	
	public void printReceipt() {
		//Prints receipt if there was an printer connection...
	}
}