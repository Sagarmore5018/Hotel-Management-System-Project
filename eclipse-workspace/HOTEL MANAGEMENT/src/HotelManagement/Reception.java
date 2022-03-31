package HotelManagement;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class Reception extends JFrame implements ActionListener{

	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14;
	
	Reception(){
		b1 = new JButton("New Customer Form");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(10,30,200,30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Room");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(10,70,200,30);
		b2.addActionListener(this);
		add(b2);
		
		b3 = new JButton("Department");
		b3.setBackground(Color.black);
		b3.setForeground(Color.white);
		b3.setBounds(10,110,200,30);
		b3.addActionListener(this);
		add(b3);
		
		b4 = new JButton("All Employee Info");
		b4.setBackground(Color.black);
		b4.setForeground(Color.white);
		b4.setBounds(10,150,200,30);
		b4.addActionListener(this);
		add(b4);
		
		b5 = new JButton("Customer Info");
		b5.setBackground(Color.black);
		b5.setForeground(Color.white);
		b5.setBounds(10,190,200,30);
		b5.addActionListener(this);
		add(b5);
		
		b6 = new JButton("Manager Info");
		b6.setBackground(Color.black);
		b6.setForeground(Color.white);
		b6.setBounds(10,230,200,30);
		b6.addActionListener(this);
		add(b6);
		
		b7 = new JButton("Check Out");
		b7.setBackground(Color.black);
		b7.setForeground(Color.white);
		b7.setBounds(10,270,200,30);
		b7.addActionListener(this);
		add(b7);
		
		b8 = new JButton("Update Check Status");
		b8.setBackground(Color.black);
		b8.setForeground(Color.white);
		b8.setBounds(10,310,200,30);
		b8.addActionListener(this);
		add(b8);
		
		b9 = new JButton("Update Room Status");
		b9.setBackground(Color.black);
		b9.setForeground(Color.white);
		b9.setBounds(10,350,200,30);
		b9.addActionListener(this);
		add(b9);
		
		b10 = new JButton("Pick up Service");
		b10.setBackground(Color.black);
		b10.setForeground(Color.white);
		b10.setBounds(10,390,200,30);
		b10.addActionListener(this);
		add(b10);
		
		b11 = new JButton("Search Room");
		b11.setBackground(Color.black);
		b11.setForeground(Color.white);
		b11.setBounds(10,430,200,30);
		b11.addActionListener(this);
		add(b11);
		
		b13 = new JButton("Bill");
		b13.setBackground(Color.black);
		b13.setForeground(Color.white);
		b13.setBounds(10,470,200,30);
		b13.addActionListener(this);
		add(b13);
		
		b12 = new JButton("Log Out");
		b12.setBackground(Color.black);
		b12.setForeground(Color.white);
		b12.setBounds(10,550,200,30);
		b12.addActionListener(this);
		add(b12);
		
		b14 = new JButton("Food");
		b14.setBackground(Color.black);
		b14.setForeground(Color.white);
		b14.setBounds(10,510,200,30);
		b14.addActionListener(this);
		add(b14);
		
	    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("HotelManagement/icons/Reception.jpg"));
	    JLabel l1 = new JLabel(i1);
	    l1.setBounds(260,30,500,600);
	    add(l1);
		getContentPane().setBackground(Color.white);
		
		setLayout(null);
		setBounds(330,150,800,650);
		setVisible(true);
	}
	
	public  void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==b1) {
			
			try {
				new NewCustomer().setVisible(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setVisible(false);
			
		}else if(ae.getSource()==b2) {
			
			new Rooms().setVisible(true);
			this.setVisible(false);
			
		}else if(ae.getSource()==b3){
			try {
				new Department().setVisible(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setVisible(false);
		}else if(ae.getSource()==b4) {
			new EmployeeInfo().setVisible(true);
			this.setVisible(false);
		}else if(ae.getSource()==b5){
			new CustomerInfo().setVisible(true);
			this.setVisible(false);
			
		}else if(ae.getSource()==b6){
			
			new ManagerInfo().setVisible(true);
			this.setVisible(false);
			
		}else if(ae.getSource()==b7){
			try {
				new CheckOut().setVisible(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		this.setVisible(false);			
		}else if(ae.getSource()==b8){
			try {
				new UpdateCheck().setVisible(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setVisible(false);
			
		}else if(ae.getSource()==b9){
			
			try {
				new UpdateRoom().setVisible(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setVisible(false);
			
		}else if(ae.getSource()==b10){
			try {
				new PickUp().setVisible(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setVisible(false);
			
		}else if(ae.getSource()==b11){
			try {
				new SearchRoom().setVisible(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setVisible(false);
			
		}else if(ae.getSource()==b12){
			setVisible(false);
		}
		else if(ae.getSource()==b13) {
			new Payment().setVisible(true);
			this.setVisible(false);
		}else if(ae.getSource()==b14) {
			new Menu().setVisible(true);
			this.setVisible(false);
		}
			
	}
	
	public static void main(String[] args) {
		new Reception().setVisible(true);
	}
}