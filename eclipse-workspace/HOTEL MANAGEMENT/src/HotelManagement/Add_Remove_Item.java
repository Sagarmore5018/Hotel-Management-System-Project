package HotelManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Add_Remove_Item extends JFrame implements ActionListener {
	
	JButton b1,b2,b3;
	JTextField t1,t2,t3;
	JLabel l1,l2,l3;
	Add_Remove_Item(){
		
		l1 = new JLabel("Item Number");
		l1.setFont(new Font("Tahoma", Font.BOLD, 12));
		l1.setBounds(61, 45, 83, 15);
		add(l1);
		
		t1 = new JTextField();
		t1.setBounds(178, 44, 143, 19);
		t1.setColumns(10);
		add(t1);
		
		l2 = new JLabel("Item Name");
		l2.setBounds(63, 93, 81, 15);
		l2.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(l2);
		
		t2 = new JTextField();
		t2.setBounds(178, 92, 143, 19);
		t2.setColumns(10);
		add(t2);
		
		l3 = new JLabel("Price");
		l3.setBounds(69, 144, 75, 13);
		l3.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(l3);
		
		t3 = new JTextField();
		t3.setBounds(178, 142, 143, 19);
		t3.setColumns(10);
		add(t3);
		
		b1 = new JButton("Add Item");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.addActionListener(this);
		b1.setBounds(33, 204, 111, 34);
		add(b1);
		
		b2 = new JButton("Remove Item");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.addActionListener(this);
		b2.setBounds(167, 204, 125, 29);
		add(b2);
		
		b3=new JButton("Cancel");
		b3.setBackground(Color.black);
		b3.setForeground(Color.white);
		b3.addActionListener(this);
		b3.setBounds(319, 204, 85, 29);
		add(b3);
		
        getContentPane().setBackground(Color.pink);
		
		setLayout(null);
		setBounds(100, 100, 450, 300);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			String number = t1.getText();
			String name = t2.getText();
			String price = t3.getText();
		
			conn c = new conn();
		
			String str = "insert into food values ('"+number+"','"+name+"','"+price+"')";
			
		
			try {
				c.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null,"Item Added Successfully");
				new Menu().setVisible(true);
				this.setVisible(false);
			
			}catch(Exception e) {
				System.out.println(e);
			}
			}else if(ae.getSource()==b2) {
				String number = t1.getText();
				String name = t2.getText();
				String price = t3.getText();
			
				conn c = new conn();
			
				String str = "delete from food where item_name= '"+name+"'";
				
			
				try {
					c.s.executeUpdate(str);
					JOptionPane.showMessageDialog(null,"Item Removed Successfully");
					new Menu().setVisible(true);
					this.setVisible(false);
				
				}catch(Exception e) {
					System.out.println(e);
				}
			}else if(ae.getSource()==b3) {
					new Menu().setVisible(true);
					this.setVisible(false);
				}
	}
	
	
	
	public static void main(String[] args) {
		new Add_Remove_Item();
	}
}