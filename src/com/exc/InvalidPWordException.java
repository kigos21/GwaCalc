package com.exc;

import javax.swing.JOptionPane;

public class InvalidPWordException extends Exception {
	
	public InvalidPWordException() {
		JOptionPane.showMessageDialog(null, "Add password!", "Error", JOptionPane.ERROR_MESSAGE);
	}
}
