package HotelManagement;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

//import HotelManagement.signup.ValidPhone;

public class AddEmployee extends JFrame implements ActionListener {
	ValidPhone vp= new ValidPhone();
	ValidAadhar a = new ValidAadhar();
	
	JTextField t1,t2,t3,t4,t5,t6;
	JRadioButton r1,r2;
	JComboBox c1;
	JButton b1;
	AddEmployee(){
		JLabel name = new JLabel("NAME");
		name.setFont(new Font("Tahoma",Font.PLAIN,17));
		name.setBounds(60,30,120,30);
		add(name);
		
		t1 = new JTextField();
		t1.setBounds(200,30,150,30);
		add(t1);
		
		JLabel age = new JLabel("AGE");
		age.setFont(new Font("Tahoma",Font.PLAIN,17));
		age.setBounds(60,80,120,30);
		add(age);
		
		t2 = new JTextField();
		t2.setBounds(200,80,150,30);
		add(t2);
		
		JLabel gender = new JLabel("GENDER");
		gender.setFont(new Font("Tahoma",Font.PLAIN,17));
		gender.setBounds(60,130,120,30);
		add(gender);
		
		r1 = new JRadioButton("Male");
		r1.setBackground(Color.white);
		r1.setFont(new Font("Tahoma",Font.PLAIN,14));
		r1.setBounds(200,130,70,30);
		add(r1);
		
		r2 = new JRadioButton("Female");
		r2.setBackground(Color.white);
		r2.setFont(new Font("Tahoma",Font.PLAIN,14));
		r2.setBounds(280,130,70,30);
		add(r2);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		
		
		JLabel job = new JLabel("JOB");
		job.setFont(new Font("Tahoma",Font.PLAIN,17));
		job.setBounds(60,180,120,30);
		add(job);
		
		String str[]= {"Front Desk Clerks","Portes","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitrees","Manager","Accountant","Chef"};
		c1 = new JComboBox(str);
		c1.setBounds(200,180,150,30);
		c1.setBackground(Color.white);
		add(c1);
		
		JLabel salary = new JLabel("SALARY");
		salary.setFont(new Font("Tahoma",Font.PLAIN,17));
		salary.setBounds(60,230,120,30);
		add(salary);
		
		t3 = new JTextField();
		t3.setBounds(200,230,150,30);
		add(t3);
		
		JLabel mobile = new JLabel("MOBILE");
		mobile.setFont(new Font("Tahoma",Font.PLAIN,17));
		mobile.setBounds(60,280,120,30);
		add(mobile);
		
		t4 = new JTextField();
		t4.setBounds(200,280,150,30);
		add(t4);
		
		JLabel aadhar = new JLabel("AADHAR");
		aadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
		aadhar.setBounds(60,330,120,30);
		add(aadhar);
		
		t5 = new JTextField();
		t5.setBounds(200,330,150,30);
		add(t5);
		
		JLabel email = new JLabel("EMAIL");
		email.setFont(new Font("Tahoma",Font.PLAIN,17));
		email.setBounds(60,380,120,30);
		add(email);
		
		t6 = new JTextField();
		t6.setBounds(200,380,150,30);
		add(t6);
		
		b1 = new JButton("Submit");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(200,430,150,30);
		b1.addActionListener(this);
		add(b1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("HotelManagement/icons/staff.jpg"));
		JLabel l1 = new JLabel(i1);
		l1.setBounds(400,80,380,350);
		add(l1);
		
		JLabel l2= new JLabel("ADD EMPLOYEE DETAILS");
		l2.setForeground(Color.blue);
		l2.setBounds(400,30,400,30);
		l2.setFont(new Font("Tahoma",Font.PLAIN,30));
		add(l2);
		
		getContentPane().setBackground(Color.white);
		
		setLayout(null);
		setBounds(350,200,800,550);
		setVisible(true);
		
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		String name = t1.getText();
		String age = t2.getText();
		String salary = t3.getText();
		String mobile = t4.getText();
		String aadhar = t5.getText();
		String email = t6.getText();
		
		String gender = null;
		if(r1.isSelected()) {
			gender = "Male";
		}else if(r2.isSelected()) {
			gender = "Female";
		}
		String job = (String)c1.getSelectedItem();
		
		
		conn c = new conn();
		if(email.contains("@gmail.com")&&vp.Check( t4.getText().trim())==true){
		String str = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+mobile+"','"+aadhar+"','"+email+"')";		
		try {
			 c.s.executeUpdate(str);
			 JOptionPane.showMessageDialog(null,"New Employee Added");
//			 this.setVisible(false);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Email is invalid or Mobile number is invalid or Aadhar number is invalid");
		}
	}
	public class ValidPhone{
		 Boolean Check(String phone){
			      String regex = "\\d{10}";
			      //Creating a pattern object
			      Pattern pattern = Pattern.compile(regex);
			      //Creating a Matcher object
			      Matcher matcher = pattern.matcher(phone);
			      if(matcher.matches()) {
			          return true;
			       } 
			      else { 
			        return false;
			       }	 
			 }
		}
	class ValidAadhar {
		Boolean Check(String aadhar)
		{
			
			String regex
				= "\\\\d{12}";

			
			Pattern p = Pattern.compile(regex);

			Matcher m = p.matcher(aadhar);
			if(m.matches()) {
				return true;
			}
			else {
				return false;
			}
		}
	}

	
	public static void main(String[] args) {
		new AddEmployee().setVisible(true);
	}

}