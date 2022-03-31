package HotelManagement;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class Rooms extends JFrame implements ActionListener {

	JTable t1;
	JButton b1,b2;
	
	
	Rooms(){
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("HotelManagement/icons/g3.jpg"));
		Image i2 = i1.getImage().getScaledInstance(680, 600, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel icon = new JLabel(i3);
		icon.setBounds(500,10,570,600);
		add(icon);
		
		JLabel l1 = new JLabel("Room Number");
		l1.setBounds(10,10,100,20);
		add(l1);
		
		JLabel l2 = new JLabel("Availability");
		l2.setBounds(120,10,100,20);
		add(l2);
		
		JLabel l3 = new JLabel("Status");
		l3.setBounds(220,10,100,20);
		add(l3);
		
		JLabel l4 = new JLabel("Price");
		l4.setBounds(320,10,100,20);
		add(l4);
		
		JLabel l5 = new JLabel("Bed Type");
		l5.setBounds(420,10,100,20);
		add(l5);
		
		t1 = new JTable();
		t1.setBounds(0,40,500,400);
		add(t1);
		
		b1 = new JButton("Load Data");
		b1.addActionListener(this);
		b1.setBounds(100,460,120,30);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBounds(250,460,120,30);
		b2.addActionListener(this);
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		add(b2);
		
		getContentPane().setBackground(Color.white);
		
		setLayout(null);
		setBounds(400,200,1100,600);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			try {
				conn c = new conn();
				String str = "select * from room";
				
				ResultSet rs = c.s.executeQuery(str);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
			}catch(Exception e) {
				
			}
			
		}else if(ae.getSource()==b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
		
	}
	
	public static void main(String[] args) {
		new Rooms().setVisible(true);
	}
	
}