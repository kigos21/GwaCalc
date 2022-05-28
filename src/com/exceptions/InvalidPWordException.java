package com.exceptions;

import java.awt.Color;

import javax.swing.JPanel;

import com.gui.CustomDialog;

public class InvalidPWordException extends Exception {
	
	public InvalidPWordException(JPanel parentPane, Color btnColor) {
		CustomDialog cd = new CustomDialog("Invalid Password!", "Please input a password.", parentPane,"OK", btnColor);
	}
}
