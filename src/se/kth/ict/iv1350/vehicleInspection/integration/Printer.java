package se.kth.ict.iv1350.vehicleInspection.integration;

import se.kth.ict.iv1350.vehicleInspection.model.Receipt;

/**
 * The interface to the printer, used for all printouts initiated by this
 * program.
 */
public class Printer {
    public void printReceipt(Receipt receipt) {
        System.out.println(receipt.createReceiptString());
    }
}