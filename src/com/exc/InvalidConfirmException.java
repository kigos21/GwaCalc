package com.exc;

import javax.swing.*;
import java.awt.*;

import com.gui.CustomDialog;

public class InvalidConfirmException extends Exception {

	public InvalidConfirmException(JPanel parentPane, Color btnColor) {
		CustomDialog cd = new CustomDialog("Confirm Password!", "Please confirm your password.", parentPane,"OK", btnColor);
	}
}
