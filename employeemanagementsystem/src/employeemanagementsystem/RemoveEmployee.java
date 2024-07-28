package employeemanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;

import javax.swing.*;

import com.mysql.cj.jdbc.admin.MiniAdmin;

public class RemoveEmployee extends JFrame implements ActionListener {

	Choice ChoiceEMPID;
	JButton delete , back;
	
	
	 RemoveEmployee()
	{
		 
		 JLabel label = new JLabel("Employee ID");
		 label.setBounds(50,50,100,30);
		 label.setFont(new Font ("Tahoma", Font.BOLD,15));
		 add (label);

		 ChoiceEMPID = new Choice();
		 ChoiceEMPID.setBounds(200,50,150,30);
		 add(ChoiceEMPID);
		 
		 try
		 { 
			 Conn c = new Conn();
		     ResultSet rs = c.statement.executeQuery("select * from employe ");
		     while(rs.next())
		     {
		    	 ChoiceEMPID.add(rs.getString("empID"));
		     }
		 
			 
		 }
		 catch(Exception E)
		 {
			 E.printStackTrace();
		 }
		 
		 
		 JLabel labelName = new JLabel("Name");
		 labelName.setBounds(50,100,100,30);
		 labelName.setFont(new Font ("Tahoma" , Font.BOLD,15));
		 add(labelName);
		 
		 JLabel textName = new JLabel();
		 textName.setBounds(200,100,100,30);
		 add(textName);
		 
		 JLabel labelPhone = new JLabel("Phone");
		 labelPhone.setBounds(50,150,100,30);
		 labelPhone.setFont(new Font ("Tahoma" , Font.BOLD,15));
		 add(labelPhone);
		 
		 JLabel textPhone = new JLabel();
		 textPhone.setBounds(200,150,100,30);
		 add(textPhone);
		 
		 JLabel labelEmail = new JLabel("Email");
		 labelEmail.setBounds(50,200,100,30);
		 labelEmail.setFont(new Font ("Tahoma" , Font.BOLD,15));
		 add(labelEmail);
		 
		 JLabel textEmail = new JLabel();
		 textEmail.setBounds(200,200,100,30);
		 add(textEmail);
		 
		 try
		 {
			 
			 Conn con = new Conn();
			 ResultSet resultset = con.statement.executeQuery("select * from employe where empId = '"+ ChoiceEMPID.getSelectedItem()+"'");
			 while(resultset.next())
			 {
				  textName.setText(resultset.getString("name"));
				  textPhone.setText(resultset.getString("phone"));
				  textEmail.setText(resultset.getString("email"));
			 }
		 }
		 catch( Exception e)
		 {
			 e.printStackTrace();
		 }
	
		 
		 
		 ChoiceEMPID.addItemListener( new  ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				try
				{
					
					Conn con = new Conn();
					 ResultSet resultset = con.statement.executeQuery("select * from employe where empId = '"+ ChoiceEMPID.getSelectedItem()+"'");
					 while(resultset.next())
					 {
						  textName.setText(resultset.getString("name"));
						  textPhone.setText(resultset.getString("phone"));
						  textEmail.setText(resultset.getString("email"));
					 }
				}
				catch(Exception E)
				{
					E.printStackTrace();
				}
			}
		});
		 
		 delete = new JButton("Delete");
		 delete.setBounds(80,300,100,30);
		 delete.setBackground(Color.black);
		 delete.setForeground(Color.white);
		 delete.addActionListener(this);
		 add(delete);
		 
		 back = new JButton("Back");
		 back.setBounds(220,300,100,30);
		 back.setBackground(Color.black);
		 back.setForeground(Color.white);
		 back.addActionListener(this);
		 add(back);
		 
		 ImageIcon i1 = new ImageIcon("C:\\Users\\Kartik\\Desktop\\employeemanagementsystem\\icon\\delete.png");
		 Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 JLabel img = new JLabel(i3);
		 img.setBounds(700,80,200,200);
		 add(img);
		 
		 ImageIcon i11 = new ImageIcon("C:\\Users\\Kartik\\Desktop\\employeemanagementsystem\\icon\\rback.png");
		 Image i22 = i11.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
		 ImageIcon i33 = new ImageIcon(i22);
		 JLabel imges = new JLabel(i33);
		 imges.setBounds(0,0,1120,630);
		 add(imges);
		
		 
		setSize(1000,400);
		setLayout(null);
		setLocation(300,150);
		setVisible(true);
	}
	 @Override
	 public void actionPerformed (ActionEvent e)
	 {
		 if(e.getSource() == delete)
		 {
			 try
			 {
				  Conn  c = new Conn();
				  String query = "delete from employe where empId = '"+ChoiceEMPID.getSelectedItem()+"'";
				  c.statement.executeUpdate(query);
				  JOptionPane.showMessageDialog(null, "Employee Deleted Successfully");
				  setVisible(false);
				  new Main();
			 }
			 catch(Exception ee)
			 {
				 ee.printStackTrace();
			 }
		 }
		 else
		 {
			 setVisible(false);
			 new Main();
		 }
		 
	 }

	public static void main(String[] args) 
	{
		new RemoveEmployee();

	}

}
