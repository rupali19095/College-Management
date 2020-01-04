package myproject;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
public class admission extends JFrame implements ItemListener,ActionListener{
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
JComboBox cb;
JButton b1,b2,b3,b4;
Connection con;
Statement stmt;
JRadioButton r1,r2;

Calendar cal=Calendar.getInstance();
admission()
{
	setLayout(null);
	setSize(1000,1000);

l1=new JLabel("Admission Form");	
l2=new JLabel("Admission NO.");
l3=new JLabel("Admission Date");
l4=new JLabel("Student's Name");
l5=new JLabel("Father's Name");
l6=new JLabel("Mother's Name");
l7=new JLabel("Address");
l8=new JLabel("Phone");
l9=new JLabel("Email");
l10=new JLabel("Gender");
l11=new JLabel("Age");
l12=new JLabel("Department");
l13=new JLabel("Department Code");
l14=new JLabel("Roll No.");

t1=new JTextField();
t2=new JTextField();
t3=new JTextField();
t4=new JTextField();
t5=new JTextField();
t6=new JTextField();
t7=new JTextField();
t8=new JTextField();
//t9=new JTextField();
t10=new JTextField();
t11=new JTextField();
t12=new JTextField();
t13=new JTextField();

r1=new JRadioButton("Male");
r2=new JRadioButton("Female");
ButtonGroup bg=new ButtonGroup();
bg.add(r1);
bg.add(r2);
cb=new JComboBox();
cb.addItem("Select");
cb.addItem("Computer Science");
cb.addItem("Electronics and communication");
cb.addItem("Information Technology");
cb.addItem("Mechanical");
cb.addItemListener(this);

b1=new JButton("New");
b2=new JButton("Save");
b3=new JButton("Modify");
b4=new JButton("Find");

add(l1);
add(l2);
add(l3);
add(l4);
add(l5);
add(l6);
add(l7);
add(l8);
add(l9);
add(l10);
add(l11);
add(l12);
add(l13);
add(l14);
add(t1);
add(t2);
add(t3);
add(t4);
add(t5);
add(t6);
add(t7);
add(t8);
add(r1);
add(r2);
add(t10);
add(t11);
add(t12);
add(t13);
add(b1);
add(b2);
add(b3);
add(b4);
add(cb);

l1.setBounds(450,20,100,30);
l2.setBounds(100,50,100,20);
t1.setBounds(250,50,200,20);
l3.setBounds(100,80,100,20);
t2.setBounds(250,80,200,20);
l4.setBounds(100,110,100,20);
t3.setBounds(250,110,200,20);
l5.setBounds(100,140,100,20);
t4.setBounds(250,140,200,20);
l6.setBounds(100,170,100,20);
t5.setBounds(250,170,200,20);
l7.setBounds(100,200,100,20);
t6.setBounds(250,200,200,20);
l8.setBounds(100,230,100,20);
t7.setBounds(250,230,200,20);
l9.setBounds(100,270,100,20);
t8.setBounds(250,270,200,20);
l10.setBounds(100,300,100,20);
r1.setBounds(250,300,100,20);
r2.setBounds(350,300,100,20);
l11.setBounds(100,330,100,20);
t10.setBounds(250,330,200,20);
l12.setBounds(100,360,100,20);
cb.setBounds(250,360,200,20);
l13.setBounds(100,400,100,20);
t11.setBounds(250,400,200,20);
l14.setBounds(100,430,100,20);
t12.setBounds(250,430,200,20);
b1.setBounds(200,500,150,30);
b2.setBounds(400,500,150,30);
b3.setBounds(600,500,150,30);
b4.setBounds(200,550,150,30);
t13.setBounds(400,550,200,30);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
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
t2.setEditable(false);
t11.setEditable(false);
t12.setEditable(false);
SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yy");
Date d1=new Date();
t2.setText(sd.format(d1));
t1.setEditable(false);

}
public void itemStateChanged(ItemEvent i)
{
if(cb.getSelectedIndex()==1)	
t11.setText("CSE");
if(cb.getSelectedIndex()==2)	
t11.setText("ECE");
if(cb.getSelectedIndex()==3)	
t11.setText("IT");
if(cb.getSelectedIndex()==4)	
t11.setText("MACT");
try{
int i1=0;

String s1="select count(*) from admission where dep='"+cb.getSelectedItem()+"'";
ResultSet rs=stmt.executeQuery(s1);

if(rs.next())
{
i1=rs.getInt(1);
}

i1++;

	t12.setText((cal.get(Calendar.YEAR))%100+"_"+t11.getText()+"_"+String.valueOf(i1));	
}
catch(Exception e1)
{}
}

public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
{
	t3.setText("");
t1.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");
t8.setText("");
r1.setSelected(true);
//t9.setText("");
t10.setText("");
t11.setText("");
cb.setSelectedIndex(0);
t12.setText("");
try{
int i2=100;

String s1="select count(*) from admission";
ResultSet rs=stmt.executeQuery(s1);

if(rs.next())
{
i2=rs.getInt(1);
}

i2++;
t1.setText(String.valueOf(i2));
}

catch(Exception e4)
{
System.out.println("Exception "+e4);	
}

}
	if(e.getSource()==b2)
	{
		String gen="";
		if(r1.isSelected())
			gen="male";
		else
			gen="female";


try{		
int age=Integer.parseInt(t10.getText());	
		if(age>=15&&age<=20)
		{
		
String s1="insert into admission values("+t1.getText()+",'"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"+t5.getText()+"','"+t6.getText()+"','"+t7.getText()+"','"+t8.getText()+"','"+gen+"',"+t10.getText()+",'"+cb.getSelectedItem()+"','"+t11.getText()+"','"+t12.getText()+"')";	

JOptionPane.showMessageDialog(this,s1);
stmt.executeUpdate(s1);

		
	}

	else
		JOptionPane.showMessageDialog(this,"Invalid age limit");
}
		catch(Exception e1)
		{
		JOptionPane.showMessageDialog(this,e1);	
		}
}
if(e.getSource()==b3)
{
	String gen="";
	if(r1.isSelected())
		gen="male";
	else
		gen="female";

	try{
String s1="update admission set sname='"+t3.getText()+"',fname='"+t4.getText()+"',mname='"+t5.getText()+"',adr='"+t6.getText()+"',phone='"+t7.getText()+"',email='"+t8.getText()+"',gender='"+gen+"',age="+t10.getText()+",dep='"+cb.getSelectedItem()+"'where admno='"+t1.getText()+"'";
	JOptionPane.showMessageDialog(this,s1);
	stmt.executeUpdate(s1);
	JOptionPane.showMessageDialog(this,"Record modified");

}

catch(Exception e3)
	{
	JOptionPane.showMessageDialog(this, e3);
	
	}
}
if(e.getSource()==b4)
{
	String gen="";
	if(r1.isSelected())
		gen="male";
	else
		gen="female";

		try
		{
		String s1="select * from admission where admno="+t13.getText();
		JOptionPane.showMessageDialog(this, s1);
		
		ResultSet rs=stmt.executeQuery(s1);
		if(rs.next())
		{
			t1.setText(rs.getString(1));
			t2.setText(rs.getString(2));
			t3.setText(rs.getString(3));
			t4.setText(rs.getString(4));
			t5.setText(rs.getString(5));
			t6.setText(rs.getString(6));
			t7.setText(rs.getString(7));
			t8.setText(rs.getString(8));
			gen=rs.getString(9);
			t10.setText(rs.getString(10));
			cb.setSelectedItem(rs.getString(11));
			t11.setText(rs.getString(12));
			t12.setText(rs.getString(13));
}
		}

catch(Exception ee)
		{
	System.out.println("Excepiton"+ee);
		}
		}
}
public static void main(String ar[])
{
new admission();	

}
}