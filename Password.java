package myproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Password extends JFrame implements ActionListener{
JLabel l1,l2,l3,l4;
JButton b1,b2;
JTextField t1,t2,t3;
Connection con;
Statement stmt;

Password()
{
	setLayout(null);
	setSize(1000,1000);
l1=new JLabel("Change Password");	
l2=new JLabel("Old Password");
l3=new JLabel("New Password");
l4=new JLabel("Re-enter Password");

b1=new JButton("Change");
b2=new JButton("Cancel");

t1=new JTextField();
t2=new JTextField();
t3=new JTextField();

add(t1);
add(t2);
add(t3);
add(l3);
add(l1);
add(l2);
add(l4);
add(b1);
add(b2);
b1.addActionListener(this);
b2.addActionListener(this);
l1.setBounds(400,100,200,30);
l2.setBounds(100,200,200,30);
l3.setBounds(100,300,200,30);
l4.setBounds(100,400,200,30);
b1.setBounds(300,500,100,20);
b2.setBounds(500,500,100,20);
t1.setBounds(300,200,200,30);
t2.setBounds(300,300,200,30);
t3.setBounds(300,400,200,30);
setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","rupali");
stmt=con.createStatement();


}
catch(Exception ee)
{
System.out.println("exception"+ee);
}
}


public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
{
	String s1="select password from user ";
	
	
	
	}
if(e.getSource()==b2)
	System.exit(1);
}

public static void main(String ar[])
{
new Password();	
}
}