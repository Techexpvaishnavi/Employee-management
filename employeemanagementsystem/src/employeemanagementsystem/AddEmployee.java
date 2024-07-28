package employeemanagementsystem;

import java.awt.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class AddEmployee extends JFrame implements ActionListener {
     
	Random ran = new Random();
	int number = ran.nextInt(999999);
	
	JTextField tname,tfname,taddress,tphone,taadhar, temail,tsalary, tdesigation;
	JLabel tempid;
	JDateChooser tdob;
	JComboBox boxeducation;
	JButton add, back;
	 AddEmployee() 
	 {
	
		getContentPane().setBackground(new Color(163,255,188));
		
		JLabel heading =  new JLabel("Add Employee Detail"); 
		heading.setBounds(320, 30, 500, 50);
		heading.setFont(new Font ("sarif" , Font.BOLD,25));
		add(heading);
		
		JLabel name = new JLabel("Name ");
		name.setBounds(50, 150, 150, 30);
		name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(name);
		
		tname =new JTextField();
		tname.setBounds(200,150,150,30);
		tname.setBackground(new Color(177,252,197));
		add(tname);
		
		JLabel fname = new JLabel(" Father's Name ");
		fname.setBounds(400, 150, 150, 30);
		fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(fname);
		
		tfname =new JTextField();
		tfname.setBounds(600,150,150,30);
		tfname.setBackground(new Color(177,252,197));
		add(tfname);
		
		JLabel dob = new JLabel(" Date OF Birth ");
		dob.setBounds(50, 200, 150, 30);
		dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(dob);
		
		tdob =new JDateChooser();
		tdob.setBounds(200,200,150,30);
		tdob.setBackground(new Color(177,252,197));
		add(tdob);
		
		JLabel salary = new JLabel("Salary ");
		salary.setBounds(400, 200, 150, 30);
		salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(salary);
		
		tsalary =new JTextField();
		tsalary.setBounds(600,200,150,30);
		tsalary.setBackground(new Color(177,252,197));
		add(tsalary);
		
		JLabel address = new JLabel("Address ");
		address.setBounds(50,250,150,30);
		address.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(address);
		
		taddress = new JTextField();
		taddress.setBounds(200,250,150,30);
		taddress.setBackground(new Color(177,252,197));
		add(taddress);
		
		JLabel phone = new JLabel("Phone No.  ");
		phone.setBounds(400,250,150,30);
		phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(phone);
		
		tphone = new JTextField();
		tphone.setBounds(600,250,150,30);
		tphone.setBackground(new Color(177,252,197));
		add(tphone);
		
		JLabel email = new JLabel("Email  ");
		email.setBounds(50,300,150,30);
		email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(email);
		
		temail = new JTextField();
		temail.setBounds(200,300,150,30);
		temail.setBackground(new Color(177,252,197));
		add(temail);
		
		JLabel education = new JLabel("Highest Education");
		education.setBounds(400,300,150,30);
		education.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(education);
		
		String item[] = {"BBA" , "B.Tech", "BCA", "BSC", "B.Com", "MBA", "MCA", "MA","M.Tech","MSC", "PHD"
		};
		boxeducation = new JComboBox(item);
		boxeducation.setBounds(600,300,150,30);
		boxeducation.setBackground(new Color(177,252,197));
		add(boxeducation);
		
		JLabel adhar = new JLabel("Aadhar No.  ");
		adhar.setBounds(400,350,150,30);
		adhar.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(adhar);
		
		taadhar = new JTextField();
		taadhar.setBounds(600,350,150,30);
		taadhar.setBackground(new Color(177,252,197));
		add(taadhar);
		
		JLabel empid = new JLabel("Employee ID  ");
		empid.setBounds(50,400,150,30);
		empid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(empid);
		
		tempid = new JLabel("" +number);
		tempid.setBounds(200,400,150,30);
		tempid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		tempid.setForeground(Color.red);
		add(tempid);
		
		JLabel desigation = new JLabel("Desigation  ");
		desigation.setBounds(50,350,150,30);
		desigation.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(desigation);
		
		tdesigation = new JTextField();
		tdesigation.setBounds(200,350,150,30);
		tdesigation.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		add(tdesigation);
		
		add = new JButton("ADD");
		add.setBounds(250,550,150,40);
		add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("BACK");
		back.setBounds(450,550,150,40);
		back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
		
		
		
		setSize(900,700); 
		setLayout(null);
		setLocation(300,50);
		setVisible(true);
	}
	 
	 @Override
	 public void actionPerformed(ActionEvent e)
	 {
		 if(e.getSource() == add)
		 {
			 String name = tname.getText();
			 String fname = tfname.getText();
			 String dob= ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
			 String salary = tsalary.getText();
			 String address = taddress.getText();
			 String phone = tphone.getText();
			 String email = temail.getText();
			 String education = (String) boxeducation.getSelectedItem();
			 String desigation = tdesigation.getText();
			 String aadhar = taadhar.getText();
			 String empID = tempid.getText();
			 
			 try {
				   Conn con = new Conn();
				   String query = "insert into employe values('"+ name+"','"+ fname+"', '"+ dob+"', '"+ salary+"', '"+ address+"', '"+ phone+"', '"+ email+"', '"+ education+"', '"+ desigation+"','"+aadhar+"', '"+empID+"')";
			       con.statement.executeUpdate(query);
			       JOptionPane.showMessageDialog(null, "Details added successfully");
			       setVisible(false);
			       new Main();
			 
			 }
			 catch(Exception E)
			 {
				 E.printStackTrace();
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
		
       new AddEmployee();
	}

}
