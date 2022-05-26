package com.exc;

import javax.swing.JOptionPane;

public class InvalidConfirmException extends Exception {

	public InvalidConfirmException() {
		JOptionPane.showMessageDialog(null, "Confirm your password!", "Error", JOptionPane.ERROR_MESSAGE);
	}
}
