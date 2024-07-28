package employeemanagementsystem;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.security.*;
public class Login extends JFrame implements ActionListener
{
	JTextField tusername;
	
	JTextField tpassword;
	JButton login,back;

	 Login() 
	{
		JLabel username = new JLabel("Username");
		username.setBounds(40,20,100,30);
		add(username);
		
		tusername = new JTextField();
		tusername.setBounds(150, 20, 180, 30);
		add(tusername);
		
		JLabel password  = new JLabel("Password");
		password.setBounds(40,90,100,30);
		add(password);
		
		tpassword = new JTextField();
		tpassword.setBounds(150, 90, 180, 30);
		add(tpassword);
		
		login = new JButton("LOGIN");
		login.setBounds(150, 160, 180, 30);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.addActionListener(this);
		add(login);
		
		back = new JButton("BACK");
		back.setBounds(150, 200, 180, 30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i11= new ImageIcon("C:\\Users\\Kartik\\Desktop\\employeemanagementsystem\\icon\\second.jpg");
		Image i22 = i11.getImage().getScaledInstance(700, 400, Image.SCALE_DEFAULT);
		ImageIcon i33 = new ImageIcon(i22);
		JLabel images = new JLabel(i33);
		images.setBounds(350, 10, 700, 400);
		add(images);
		
		ImageIcon i1= new ImageIcon("C:\\Users\\Kartik\\Desktop\\employeemanagementsystem\\icon\\LoginB.jpg");
		Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 600, 300);
		add(image);
		
		setSize(600,300);
		setLocation(450,250);
		setLayout(null);
		setVisible(true);
	}
     @Override
	 public void actionPerformed(ActionEvent e)
	 {
		 if(e.getSource() == login)
		 {
			try {
				 String  username = tusername.getText();
				 String  password = tpassword.getText();
				 Conn con = new Conn();
				 String query = "select * from login where username = '"+ username +"' and password = '"+ password +"'";
				 ResultSet resultset = con.statement.executeQuery(query);
				 if(resultset.next())
				 {
					 setVisible(false);
					 new Main();
				 }
				 else {
					 JOptionPane.showMessageDialog(null, "Invalid username and password ");
				 }
			}
			catch(Exception E)
			{
				
			}
		 
		 }
		 else if(e.getSource()==back)
		 {
			 System.exit(100);
		 }
	 }

	public static void main(String[] args) 
	{
		new Login();

	}

}
