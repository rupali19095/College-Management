package myproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.event.*;
class student extends JFrame implements ActionListener,ItemListener 
{
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
JTextField t1,t2,t3,t4,t5;
JComboBox cb,cb1;
JRadioButton r1,r2;
public JButton b1,b2,b3,b4;
Connection con;
Statement stmt;
int i=0;

student()
{
setLayout(null);
	setSize(1000,1000);
l1=new JLabel("Student");
l2=new JLabel("Roll no.");
l3=new JLabel("Name");
l4=new JLabel("Add");
l5=new JLabel("Phone");
l6=new JLabel("Age");
l7=new JLabel("Gender");
l8=new JLabel("City");
l9=new JLabel("Find");
cb1=new JComboBox();
t1=new JTextField();
t2=new JTextField();
t3=new JTextField();
t4=new JTextField();
t5=new JTextField();


cb=new JComboBox();
cb.addItem("Select");
cb.addItem("Hisar");
cb.addItem("Delhi");
cb.addItem("Fatehabad");
cb.addItem("Faridabad");
cb1.addItem("select");


r1=new JRadioButton("Male",true);
r2=new JRadioButton("Female");
ButtonGroup bg= new ButtonGroup();
bg.add(r1);
bg.add(r2);

b1=new JButton("Add New");
b2=new JButton("Save");
b3=new JButton("Modify");
b4=new JButton("Delete");

b1.setEnabled(true);
b2.setEnabled(false);
b3.setEnabled(false);
b4.setEnabled(false);
cb.addItemListener(this); 




add(l1);
add(l2);
add(l3);
add(l4);
add(l5);
add(l6);
add(l7);
add(l8);
add(l9);
add(cb);
add(r1);
add(r2);
add(b1);
add(b2);
add(b3);
add(b4);
add(cb);
add(cb1);
add(t1);
add(t2);
add(t3);
add(t4);
add(t5);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
cb1.addItemListener(this);

l1.setBounds(400,50,100,30);
l2.setBounds(100,100,100,30);
t1.setBounds(200,100,200,30);
l3.setBounds(100,150,100,30);
t2.setBounds(200,150,200,30);
l4.setBounds(100,200,100,30);
t3.setBounds(200,200,200,30);
l5.setBounds(100,250,100,30);
t4.setBounds(200,250,200,30);
l6.setBounds(100,300,100,30);
t5.setBounds(200,300,200,30);
l7.setBounds(100,350,100,30);
l8.setBounds(100,400,100,30);
l9.setBounds(100,550,100,30);
cb.setBounds(200,400,100,30);
cb1.setBounds(300,550,100,30);
r1.setBounds(200,350,100,30);
r2.setBounds(350,350,100,30);
b1.setBounds(100,450,100,30);
b2.setBounds(250,450,100,30);
b3.setBounds(400,450,100,30);
b4.setBounds(550,450,100,30);

try
{
	Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","rupali");
stmt=con.createStatement();
String s1="select * from student where status='y'";
ResultSet rs=stmt.executeQuery(s1);
while(rs.next())
{
cb1.addItem(rs.getString(1));

}

}
catch(Exception ee)
{
System.out.println("exception");
}
t1.setEditable(false);

setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);
}
public void actionPerformed(ActionEvent e)
{
try
{
if(e.getSource()==b1)
{
	String s1="select count(*) from student";
	ResultSet rs=stmt.executeQuery(s1);
	if(rs.next())
	{
i=rs.getInt(1);
	}
	i++;
t1.setText(String.valueOf(i));
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
cb.setSelectedIndex(0);
r1.setSelected(true);
t2.requestFocus();
}
if(e.getSource()==b2)
{
	
	
if(validation.checkstring(t2.getText()))	
{
	
	
String gen="";
if(r1.isSelected())
	gen="male";
else
	gen="female";

String s1="insert into student values("+t1.getText()+",'"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"',"+t5.getText()+",'"+gen+"','"+cb.getSelectedItem()+"','y')";
JOptionPane.showMessageDialog(this,s1);
cb1.addItem(t1.getText());
stmt.executeUpdate(s1);
JOptionPane.showMessageDialog(this,"Record inserted");

b2.setEnabled(false);
}
else
{
	JOptionPane.showMessageDialog(this,"Invalid name");	
}
}

if(e.getSource()==b3)
{

String gen="";
if(r1.isSelected())
	gen="male";
else
	gen="female";

String s1="update student set sname='"+t2.getText()+"', adr='"+t3.getText()+"',phone='"+t4.getText()+"',age="+t5.getText()+",gender='"+gen+"',city='"+cb.getSelectedItem()+"' where rollno="+t1.getText();
JOptionPane.showMessageDialog(this,s1);
stmt.executeUpdate(s1);
JOptionPane.showMessageDialog(this,"Record modified");
b3.setEnabled(false);	
b4.setEnabled(false);
}
if(e.getSource()==b4)
{
	String gen="";
String s1="update student set status='n' where rollno="+t1.getText();  	
JOptionPane.showMessageDialog(this,s1);
stmt.executeUpdate(s1);
JOptionPane.showMessageDialog(this,"Record Deleted");
cb1.removeItem(t1.getText());
cb1.setSelectedIndex(0);
b3.setEnabled(true);
b4.setEnabled(true);
}

}
catch(Exception e1)
{
System.out.println("exception");
}

}
public void itemStateChanged(ItemEvent i)
{
	if(i.getSource()==cb1 && i.getStateChange()==ItemEvent.SELECTED)
	{
		try
		{
		String s1="select * from student where rollno="+cb1.getSelectedItem();
		ResultSet rs=stmt.executeQuery(s1);
		String gen="";
		if(rs.next())
		{
			t1.setText(rs.getString(1));
			t2.setText(rs.getString(2));
			t3.setText(rs.getString(3));
			t4.setText(rs.getString(4));
			t5.setText(rs.getString(5));
			gen=rs.getString(6);
			cb.setSelectedItem(rs.getString(7));
			if(gen.equalsIgnoreCase("male"))
				r1.setSelected(true);
			else
				r2.setSelected(true);
			
		}
		
		else
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			r1.setSelected(true);
			t2.requestFocus();

		}
		}
		catch(Exception e)
		{}
b2.setEnabled(false);
b3.setEnabled(true);
b4.setEnabled(true);
	}
if(i.getSource()==cb)
{
if(cb.getSelectedIndex()>0)
{
b2.setEnabled(true);	
}
	
}	
	
}
public static void main(String ar[])
{
new student();
}

}

