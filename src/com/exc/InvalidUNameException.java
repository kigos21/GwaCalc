package com.exc;

import javax.swing.JOptionPane;

public class InvalidUNameException extends Exception {
	
	public InvalidUNameException() {
		JOptionPane.showMessageDialog(null, "Add username!", "Error", JOptionPane.ERROR_MESSAGE);
	}
}
