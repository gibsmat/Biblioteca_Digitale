package presentation;

import java.awt.*;
import java.sql.Timestamp;

import javax.swing.*;
import java.util.Calendar;
import java.util.Date;

public class Biblio extends JFrame {
	
	public Biblio(String time){
    	super ("test"); // costruzione finestra 
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setTitle (time);
        setSize (550, 550); 
        setLocation (200, 100);
        
        JPanel pan = new JPanel();
    	add(pan,BorderLayout.CENTER);
    	pan.setLayout (null);
    	
    	setVisible (true);
	}

	public static void main(String[] args) {
		String time;
		Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
		time=currentTimestamp.toString();
		Biblio b1 = new Biblio(time);
		
	}
		
}
