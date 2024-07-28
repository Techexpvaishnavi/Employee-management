package employeemanagementsystem;


import java.awt.Image;

import javax.swing.*;

public class SplashScreen extends JFrame
{

	SplashScreen()
	{
		
		ImageIcon i1 = new ImageIcon("C:\\Users\\Kartik\\Desktop\\employeemanagementsystem\\icon\\front.gif");
		Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,800,700);
		add(image);
	
		setSize(800,700);
		setLocation(350,70);
		setLayout(null);
		setVisible(true);
		
		try
		{
			Thread.sleep(5000);
			setVisible(false);
			new Login();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args)
	{
		new SplashScreen();
		

	}

}
