package com.exc;

import javax.swing.JOptionPane;

public class PasswordMismatchException extends Exception {

	public PasswordMismatchException() {
		JOptionPane.showMessageDialog(null, "Password mismatch, try again!", "Error", JOptionPane.ERROR_MESSAGE);
	}
}
