package com.main;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.gui.UsrLogin;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class GwaCalc extends JFrame{
	// variables
	private UsrLogin usrlog;
	
	// title bar variables
	Font gothamBook;	
	JPanel titleBar;
	JLabel lTitleLogo, lTitle;
	JButton bClose;
	
	public GwaCalc(){
		// custom font loader
		try {
			InputStream isgotham = getClass().getResourceAsStream("/res/fonts/GothamBook.ttf");
			gothamBook = Font.createFont(Font.TRUETYPE_FONT, isgotham);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(gothamBook); 
		}
		catch(IOException ie){
			ie.printStackTrace();
		}
		catch(FontFormatException ffe){
			ffe.printStackTrace();
		}
		
		setTitle("GENERAL WEIGHTED AVERAGE CALCULATOR");
		setLayout(null);
		setPreferredSize(new Dimension(1280, 720));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			Image myImage = ImageIO.read(getClass().getResourceAsStream("/res/images/gwasmol.png"));
			ImageIcon img = new ImageIcon(myImage);
			setIconImage(img.getImage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		usrlog = new UsrLogin();
		usrlog.setPreferredSize(new Dimension(1280, 720));
		usrlog.setBounds(0, 0, 1280, 720);
		add(usrlog);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		GwaCalc gwa = new GwaCalc();
	}
}
