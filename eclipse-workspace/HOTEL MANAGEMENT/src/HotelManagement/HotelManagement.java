package HotelManagement;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class HotelManagement extends JFrame implements ActionListener {
	HotelManagement(){
		setBounds(300,200,800,398);
//		setSize(400,400);
		
//		setLocation(300,300);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("HotelManagement/icons/g1.jpg"));
		JLabel l1 = new JLabel(i1);
		l1.setBounds(0,0,800,398);
		add(l1);
		
		
		
		JLabel l2=new JLabel("Hotel Management");
		l2.setBounds(20,250,1000,70);
		l2.setForeground(Color.white);
		l2.setFont(new Font("Serif",Font.PLAIN, 60));
		l1.add(l2);
		
		JButton b1=new JButton("Next");
		b1.setBackground(Color.white);
		b1.setForeground(Color.black);
		b1.setBounds(650,300,100,30);
		b1.addActionListener(this);
		l1.add(b1);
		
		
		setLayout(null);
		setVisible(true);
		
		while(true) {
			l2.setVisible(false);
			try {
				Thread.sleep(500);
			}catch(Exception e) {
				
			}
			l2.setVisible(true);
			try {
				Thread.sleep(500);
			}catch(Exception e) {}
			
		}
		

	}
	
	public void actionPerformed(ActionEvent ae) {
		new Login().setVisible(true);
		this.setVisible(false);
	}
	
	public static void main(String[] args) {
		new HotelManagement();
	}

}