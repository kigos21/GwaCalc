package com.gui;

import java.awt.Dimension;

import javax.swing.JPanel;

public class CoursePicker extends guiCustoms{
	public CoursePicker() {
		setLayout(null);
		setPreferredSize(new Dimension(1280, 720));
		
		JPanel coursePicker = new JPanel();
		coursePicker.setBackground(bgColor);
		coursePicker.setPreferredSize(new Dimension(1280, 720));
		coursePicker.setBounds(0, 0, 1280, 720);
		coursePicker.setLayout(null);
		
		add(coursePicker);
		setVisible(true);
	}
}
