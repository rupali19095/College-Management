package myproject;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Feedetail extends JFrame implements ActionListener, FocusListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JButton b1,b2,b3;
	JTextField t1,t2,t3,t5,t4,t6,t7;
	JComboBox cb;
	Connection con;
	Statement stmt;

	Feedetail()
{
setSize(1000,1000);
setLayout(null);
l1=new JLabel("Fee Detail");
l2= new JLabel("Recept NO.");	
l3=new JLabel("Date");
l4=new JLabel("Roll no.");
l5=new JLabel("Name");
l6=new JLabel("Department");
l7=new JLabel("Semester");
l8=new JLabel("Sem Fee");

b1=new JButton("New");
b2=new JButton("Pay Fee");
b3=new JButton("Get Details");
t1=new JTextField();
t2=new JTextField();
t3=new JTextField();
t4=new JTextField();
t5=new JTextField();
t6=new JTextField();
t7=new JTextField();
t7.setText("50000");


t7.setEditable(false);
add(l1);
add(l2);
add(l3);
add(l4);
add(l5);
add(l6);
add(l7);
add(l8);
add(b1);
add(b2);
add(t1);
add(b3);
add(t2);
add(t3);
add(t4);
add(t6);
add(t7);
add(t5);
l1.setBounds(400,50,100,30);
l2.setBounds(200,100,100,20);
t1.setBounds(400,100,200,20);
l3.setBounds(200,150,100,20);
t2.setBounds(400,150,200,20);
l4.setBounds(200,200,100,20);
t3.setBounds(400,200,200,20);
l5.setBounds(200,250,100,20);
t4.setBounds(400,250,200,20);
l6.setBounds(200,300,100,20);
t5.setBounds(400,300,200,20);
l7.setBounds(200,350,100,20);
t6.setBounds(400,350,200,20);
l8.setBounds(200,400,100,20);
t7.setBounds(400,400,200,20);
b1.setBounds(200,450,100,20);
b3.setBounds(400,450,100,20);
b2.setBounds(600,450,100,20);
b1.addActionListener(this);
b2.addActionListener(this);
t3.addFocusListener(this);
SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yy");
Date d1=new Date();
t2.setText(sd.format(d1));
t2.setEditable(false);
t1.setEditable(false);
t4.setEditable(false);
t5.setEditable(false);

try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","rupali");
stmt=con.createStatement();
}
catch(Exception e1)
{}


setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);

}

public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==b1)
	{
		t3.requestFocus();
		try
	{
		int i1=1000;
		String s1="select count(*) from feedetail";
		ResultSet rs=stmt.executeQuery(s1);

		if(rs.next())
		{
		i1=rs.getInt(1);
		}

		i1++;
		t1.setText(String.valueOf(i1));
		}
	
		catch(Exception e4)
		{
		System.out.println("Exception "+e4);	
		}
		t5.setText("");
		t3.setText("");
		t4.setText("");
		t6.setText("");
		t7.setText("50000");
	}
		if(e.getSource()==b2)
	{
		try{
			
			String s2="select * from feedetail where rollno='"+t3.getText()+"' and sem="+t6.getText();
			ResultSet rs=stmt.executeQuery(s2);
			if(rs.next())
			{
			t6.requestFocus();
				JOptionPane.showMessageDialog(this, "FEES PAID");	
			
			}				
			else
			{
		String s1="insert into feedetail values('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t5.getText()+"',"+t6.getText()+","+t7.getText()+")";
	JOptionPane.showMessageDialog(this, "FEES PAID");	
	stmt.executeUpdate(s1);
	}}
		
	catch(Exception e2)
	{}
				
			}
		
	}
	
public static void main(String ar[])
{
new Feedetail();	
}
public void focusLost(FocusEvent e)
{
	if(e.getSource()==t3)
	{
	try
	{
		String s1="select sname,dep from admission where rollno='"+t3.getText()+"'";
		ResultSet rs=stmt.executeQuery(s1);
		if(rs.next())
		{
			t4.setText(rs.getString(1));
		    t5.setText(rs.getString(2));
			
		}
t6.requestFocus();
}
	catch(Exception ee)
		{
			System.out.println("Exception"+ee);
		}
	}
}
public void focusGaind(FocusEvent e)
{}



}




