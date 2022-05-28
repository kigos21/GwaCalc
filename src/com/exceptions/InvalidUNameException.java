package com.exceptions;

import java.awt.Color;

import javax.swing.JPanel;

import com.gui.CustomDialog;

public class InvalidUNameException extends Exception {
	
	public InvalidUNameException(JPanel parentPane, Color btnColor) {
		CustomDialog cd = new CustomDialog("Invalid Username!", "Please input a username.", parentPane,"OK", btnColor);
	}
}
