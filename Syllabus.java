package myproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Syllabus extends JFrame implements ItemListener,ActionListener{
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
JComboBox cb,cb1;
JTextField t1,t2,t4,t3,t5,t6,t7,t8,t9;
JButton b1;
JLabel lb[]=new JLabel[4];
JTextField tf[]=new JTextField[4];
Connection con;
Statement stmt;

Syllabus()
{
	
	setLayout(null);
	setSize(1000,1000);
cb=new JComboBox();
cb.addItem("Select");
cb.addItem("Computer Science");
cb.addItem("Electronics and communication");
cb.addItem("Information Technology");
cb.addItem("Mechanical");

cb1=new JComboBox();
cb1.addItem("Select");
cb1.addItem("1");
cb1.addItem("2");
cb1.addItem("3");
cb1.addItem("4");
cb1.addItem("5");
cb1.addItem("6");
cb1.addItem("7");
cb1.addItem("8");

l1=new JLabel("SYLLABUS");
l2=new JLabel("Department Name");
l3=new JLabel("Department Code");
l4=new JLabel("Semester");
l5=new JLabel("Subjects ");
t1=new JTextField();
b1=new JButton("Save");
add(l1);
add(l2);
add(l3);
add(l4);
add(t1);
add(cb);
add(cb1);
add(l5);
add(b1);
l1.setBounds(450,20,200,50);
l2.setBounds(200,100,200,30);
l3.setBounds(200,150,200,30);
l4.setBounds(200,200,200,30);
t1.setBounds(350,150,200,30);
cb.setBounds(350,100,200,30);
cb1.setBounds(350,200,200,30);
l5.setBounds(200,250,200,30);
cb1.addItemListener(this);
cb.addItemListener(this);
b1.setBounds(400,500,100,30);
b1.addActionListener(this);	

b1.setEnabled(false);
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","rupali");
stmt=con.createStatement();


}
catch(Exception ee)
{
System.out.println("exception");
}

setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);
}
public void itemStateChanged(ItemEvent i)
{	
	if(i.getSource()==cb)
{
if(cb.getSelectedIndex()==1)
t1.setText("CSE");
if(cb.getSelectedIndex()==2)
t1.setText("ECE");

if(cb.getSelectedIndex()==3)
t1.setText("IT");

if(cb.getSelectedIndex()==4)
t1.setText("MACT");


}
		if(i.getSource()==cb1)
		{	
			for(int i1=0;i1<4;i1++)
			{

			if(lb[i1]!=null && tf[i1]!=null)
			{
				remove(lb[i1]);
				remove(tf[i1]);
				
			}
			}
						
	int y=300;
	for(int i1=0;i1<4;i1++)
	{
	
				
				
				lb[i1]=new JLabel(t1.getText()+cb1.getSelectedItem()+"0"+(i1+1));
				tf[i1]=new JTextField();
				add(lb[i1]);
				add(tf[i1]);
tf[i1].setBounds(350,y,200,30);
lb[i1].setBounds(200,y,100,30);
			y=y+50;
			}
	b1.setEnabled(true);		
	}
		
		}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
{
	for(int i1=0;i1<4;i1++)
	{
	try
	{
String s1="insert into Syllabus values('"+cb.getSelectedItem()+"','"+t1.getText()+"',"+cb1.getSelectedItem()+",'"+lb[i1].getText()+"','"+tf[i1].getText()+"')";
JOptionPane.showMessageDialog(this,s1);
stmt.executeUpdate(s1);
}
catch(Exception e1)
	{
	System.out.println("Exception"+e1);
	}
	}
}
}
public static void main(String ar[])
{
new Syllabus();	

}
}