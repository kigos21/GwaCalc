package com.exc;

import java.awt.Color;

import javax.swing.JPanel;

import com.gui.CustomDialog;

public class PasswordMismatchException extends Exception {

	public PasswordMismatchException(JPanel parentPane, Color btnColor) {
		CustomDialog cd = new CustomDialog("Password Mismatch!", "Password and confirm must match.", parentPane,"OK", btnColor);
	}
}
