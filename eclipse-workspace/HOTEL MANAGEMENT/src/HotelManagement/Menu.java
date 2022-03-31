package HotelManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

	private JPanel contentPane;
	JTable table;
	JScrollPane scrollPane;
	JButton b,b1,b2,b3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

 public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton b = new JButton("Book Food For Room");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Book().setVisible(true);
				setVisible(false);
				
			}
		});
		b.setForeground(Color.WHITE);
		b.setBackground(Color.BLACK);
		b.setFont(new Font("Tahoma", Font.PLAIN, 12));
		b.setBounds(23, 372, 150, 33);
		contentPane.add(b);
		
		JButton b1 = new JButton("Add/Remove Item");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Add_Remove_Item().setVisible(true);
				setVisible(false);
			}
		});
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
		b1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		b1.setBounds(207, 373, 150, 32);
		contentPane.add(b1);
		
		JButton b3 = new JButton("Back");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
				setVisible(false);
;			}
		});
		b3.setForeground(Color.WHITE);
		b3.setBackground(Color.BLACK);
		b3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		b3.setBounds(381, 372, 94, 33);
		contentPane.add(b3);
		
		scrollPane=new JScrollPane();
		scrollPane.setBounds(10, 0, 502, 337);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane);
		table =new JTable();
		scrollPane.setViewportView(table);
		scrollPane.setBorder(BorderFactory.createTitledBorder("Menu"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projecthms","root","vIJAY@5321");
			Statement stmt=con.createStatement();
			String sql="Select * from Food";
			ResultSet rs=stmt.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
 
	
		
	}