package com.game;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Main implements ActionListener{
	
	JTextField t1,t2,t3;
	JLabel l1,l2,l3;
	JButton b1,b2;
	Main(){
		JFrame f=new JFrame();
		f.setSize(500,500);
		f.setLayout(null);
		f.setVisible(true);
		f.setTitle("Number Guessing Game");
		Container c=new JPanel(); 
	    c.setLayout(null); 
	    c.setBounds(70, 30, 400, 500); 
	    f.add(c);

	      
		
		l1=new JLabel("Welcome");
		l1.setBounds(50,50,100,50);
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		
		l2=new JLabel("Enter the number between 1 to 100 ");
		l2.setBounds(50,100,300,50);
		
		t1=new JTextField();
		t1.setBounds(50, 150, 200, 30);
		
		t2=new JTextField();
		t2.setBounds(50,200,200,30);
		t2.setEditable(false);
		
		b1=new JButton("check");
		b1.setBounds(50, 250, 100,30);
		
		b2=new JButton("Restart");
		b2.setBounds(170, 250,100,30);
		
		l3=new JLabel("Remaining chances");
		l3.setBounds(50,300,150,50);
		
		t3=new JTextField("5");
		t3.setBounds(230,300,50,30);
		t3.setEditable(false);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		Font buttonFont = new Font("Arial", Font.BOLD, 16);
		l1.setFont(buttonFont);
		l2.setFont(buttonFont);
		l3.setFont(buttonFont);
		t1.setFont(buttonFont);
		t2.setFont(buttonFont);
		t3.setFont(buttonFont);
		b1.setFont(buttonFont);
		b2.setFont(buttonFont);
		
		c.add(t1);
		c.add(b1);c.add(b2);c.add(l2);c.add(l1);c.add(t2); c.add(l3);c.add(t3);
		
	}
	
	public void actionPerformed(ActionEvent e) {
	    String n = t1.getText();
	    int num = Integer.parseInt(n);
	  
	    String show = "";
	    int cChoice = (int)(Math.random() * 100);
	    if (e.getSource() == b1) {
	        int chance = Integer.parseInt(t3.getText());

	        if (num == cChoice) {
	            show = "Congratulations, you win!";
	        } else if (num > cChoice) {
	            show = "Number is too large";
	        } else {
	            show = "Number is too small";
	        }
	        
	        chance = chance - 1; 
	        
	        t3.setText(String.valueOf(chance)); 
	        
	        if (chance == 0) {
	            show = "You Lose";

	        }
	    }

	    if (e.getSource() == b2) {
	        cChoice = (int)(Math.random() * 100);
	        int chance = 5;
	        t2.setText("");
	        t1.setText("");
	        t3.setText(String.valueOf(chance)); // Reset the chance text field
	        t1.setEditable(true); // Enable input
	    }

	    t2.setText(show);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m=new Main();
	}

}
