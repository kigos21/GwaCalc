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
	//variables
	private UsrLogin usrlog;
	
	//titlebar variables
	Font gothamBook;	
	JPanel titleBar;
	JLabel lTitleLogo, lTitle;
	JButton bClose;
	
	public GwaCalc(){
		//customfont loader
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
		//setUndecorated(true);
		
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
		
//		custom title bar
//		titleBar = new JPanel();
//		titleBar.setLayout(null);
//		titleBar.setPreferredSize(new Dimension(1280, 26));
//		titleBar.setBounds(0,0,1280,40);
//		titleBar.setBackground(new Color(16,21,30));
//		
//		lTitleLogo = new JLabel();
//		Icon icoTitle = new ImageIcon("res\\gwasmol.png");
//		lTitleLogo.setIcon(icoTitle);
//		lTitleLogo.setBounds(10, 10, 40, 17);
//		titleBar.add(lTitleLogo);
//		
//		lTitle = new JLabel("GENERAL WEIGHTED AVERAGE CALCULATOR");
//		lTitle.setFont(gothamBook.deriveFont(Font.PLAIN,16));
//		lTitle.setBounds(56, 8, 400, 20);
//		lTitle.setForeground(Color.WHITE);
//		titleBar.add(lTitle);
//		
//		bClose = new JButton("X");
//		bClose.setFont(gothamBook.deriveFont(Font.PLAIN,16));
//		bClose.setBounds(1230, 0, 50, 30);
//		bClose.setBackground(new Color(16,21,30));
//		bClose.setBorderPainted(false);
//		bClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
//		bClose.setForeground(Color.WHITE);
//		titleBar.add(bClose);
//		
//		bClose.addMouseListener(new java.awt.event.MouseAdapter() {
//		    public void mouseEntered(java.awt.event.MouseEvent evt) {
//		    	bClose.setBackground(new Color(114,27,12));
//		    }
//
//		    public void mouseExited(java.awt.event.MouseEvent evt) {
//		    	bClose.setBackground(new Color(16,21,30));
//		    }
//		});
//		
//		bClose.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			dispose();
//			}
//		});
//		end of custom titlebar
//		add(titleBar);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		GwaCalc gwa = new GwaCalc();
	}
}
