package com.gui;

import com.user.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class UsrCreate extends guiCustoms {
	
	Font gothamBook, gothamBookBold;
	JPanel usrCreate;
	JLabel lLogo;
	JLabel lCreateTtl;
	
	public UsrCreate() {
		try {
			gothamBook = Font.createFont(Font.TRUETYPE_FONT, new File("res\\fonts\\GothamBook.ttf"));
			gothamBookBold = Font.createFont(Font.TRUETYPE_FONT, new File("res\\fonts\\GothamBold.ttf"));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(gothamBook); 
			ge.registerFont(gothamBookBold); 
		}
		catch(IOException ie){
			ie.printStackTrace();
		}
		catch(FontFormatException ffe){
			ffe.printStackTrace();
		}
		
		usrCreate = new JPanel(null);
		usrCreate.setPreferredSize(new Dimension(1280, 720));
		usrCreate.setBackground(bgColor);
		usrCreate.setBounds(0, 0, 1280, 720);
		
		lLogo = new JLabel();
		lLogo.setIcon(new ImageIcon("res\\gwalogo2medium.png"));
		lLogo.setBounds(525, 120, 218, 113);
		usrCreate.add(lLogo);
		
		lCreateTtl = new JLabel("CREATE YOUR ACCOUNT");
		lCreateTtl.setFont(gothamBookBold.deriveFont(Font.PLAIN, 13f));
		lCreateTtl.setBounds(559, 263, 163, 15);
		lCreateTtl.setForeground(Color.WHITE);
		usrCreate.add(lCreateTtl);
		
		
		
	}
}
