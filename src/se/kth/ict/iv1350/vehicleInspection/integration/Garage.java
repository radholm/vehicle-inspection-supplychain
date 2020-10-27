/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.vehicleInspection.integration;

import se.kth.ict.iv1350.vehicleInspection.integration.GarageDoor;
import se.kth.ict.iv1350.vehicleInspection.integration.DisplayHandler;

/**
 * This is a facade to the hardware of the GARAGE, namely the door and the queue
 * number display on the outside wall.
 */
public class Garage {
    private GarageDoor garageDoor = new GarageDoor();
    private DisplayHandler displayHandler = new DisplayHandler();

    /**
     * Creates an instance and connects to the door and queue number display.
     */
    public Garage() {
    }

    /**
     * Opens the door and displays the next queue number.
     */
    public void startNewInspection() {
        garageDoor.openDoor();
        displayHandler.updateDisplay(123);
    }

    /**
     * Closes the door
     */
    public void signalCloseDoor() {
        garageDoor.closeDoor();
    }

}
