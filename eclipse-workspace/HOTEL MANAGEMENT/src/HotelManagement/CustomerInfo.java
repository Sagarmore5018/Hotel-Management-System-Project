package HotelManagement;

import java.awt.Color;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener {

	JTable t1;
	JButton b1,b2;
	
	
	CustomerInfo(){
		
		t1 = new JTable();
		t1.setBounds(0,40,1000,500);
		add(t1);
		
		JLabel l1 = new JLabel("Document Type");
		l1.setBounds(20,10,100,20);
		add(l1);
		
		JLabel l2 = new JLabel("Number");
		l2.setBounds(180,10,70,20);
		add(l2);
		
		JLabel l3 = new JLabel("Name");
		l3.setBounds(340,10,70,20);
		add(l3);
		
		JLabel l4 = new JLabel("Gender");
		l4.setBounds(480,10,70,20);
		add(l4);
		
		JLabel l5 = new JLabel("Checked In");
		l5.setBounds(580,10,100,20);
		add(l5);
		
		JLabel l6 = new JLabel("Room Number");
		l6.setBounds(750,10,100,20);
		add(l6);
		
		JLabel l7 = new JLabel("Deposit");
		l7.setBounds(900,10,70,20);
		add(l7);
		
		
		b1 = new JButton("Load Data");
		b1.setBounds(350,560,120,30);
		b1.addActionListener(this);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBounds(530,560,120,30);
		b2.addActionListener(this);
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		add(b2);
		
		getContentPane().setBackground(Color.white);
		
		
		setLayout(null);
		setBounds(380,150,1000,650);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==b1) {
			try {
				conn c = new conn();
				String str = "select * from customer";
				ResultSet rs = c.s.executeQuery(str);
				
				t1.setModel(DbUtils.resultSetToTableModel(rs));
			}catch(Exception e) {
				System.out.println(e);
			}
			
		}else if(ae.getSource()==b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new CustomerInfo().setVisible(true);
	}
}