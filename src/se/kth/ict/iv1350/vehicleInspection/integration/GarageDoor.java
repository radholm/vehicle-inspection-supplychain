/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.ict.iv1350.vehicleInspection.integration;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Controls the garage door.
 */
class GarageDoor {
    private static final String CLOSED_TEXT = "The door is closed";
    private static final String OPEN_TEXT = "The door is open";
    private static final Color CLOSED_COLOR = Color.RED;
    private static final Color OPEN_COLOR = Color.GREEN;

    private JLabel doorStateLabel = new JLabel("", SwingConstants.CENTER);

    /**
     * Connects to the door servo and closes the door.
     */
    GarageDoor() {
        closeDoor();
        contactDoor();
    }

    /**
     * Opens garage door.
     */
    void openDoor() {
        doorStateLabel.setForeground(OPEN_COLOR);
        doorStateLabel.setText(OPEN_TEXT);
    }

    /**
     * Closes garage door.
     */
    void closeDoor() {
        doorStateLabel.setForeground(CLOSED_COLOR);
        doorStateLabel.setText(CLOSED_TEXT);
    }

    private void contactDoor() {
        JFrame frame = new JFrame("Physical Garage Door");
        Font labelFont = new Font(Font.SERIF, Font.BOLD, 30);
        doorStateLabel.setFont(labelFont);
        frame.getContentPane().setBackground(Color.GRAY);
        frame.getContentPane().add(doorStateLabel);
        frame.setBounds(200, 0, 350, 50);
        frame.setVisible(true);
    }
}
