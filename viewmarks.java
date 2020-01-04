package myproject;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class viewmarks extends JFrame implements ItemListener,ActionListener {
JLabel l1,l2,l3,l4;
JComboBox cb1,cb2,cb3;
JButton b1;
Connection con;
Statement stmt;
JTable jt;
JScrollPane js;

	public viewmarks() {

		setLayout(null);
		setSize(1000,1000);
		
		l1=new JLabel("View Marks");
l2=new JLabel ("Departemnt");
l3=new JLabel("Semester");
l4=new JLabel("Subject");
cb1=new JComboBox();
cb2=new JComboBox();
cb3=new JComboBox();
b1=new JButton("Show");
// TODO Auto-generated constructor stub
cb1.addItem("Select");
cb1.addItem("Computer Science");
cb1.addItem("Electronics and Communication");
cb1.addItem("Information technology");
cb1.addItem("Mechanical");
cb2.addItem("Select");
cb2.addItem("1");
cb2.addItem("2");
cb2.addItem("3");
cb2.addItem("4");
cb2.addItem("5");
cb2.addItem("6");
cb2.addItem("7");
cb2.addItem("8");
cb3.addItem("Select");

add(l1);
add(l2);
add(l3);
add(l4);
add(cb1);
add(cb2);
add(cb3);
add(b1);
cb2.addItemListener(this);
b1.addActionListener(this);
l1.setBounds(400,100,100,30);
l2.setBounds(100,150,100,20);
cb1.setBounds(300,150,200,20);
l3.setBounds(100,200,100,20);
cb2.setBounds(300,200,200,20);
l4.setBounds(100,250,100,20);
cb3.setBounds(300,250,200,20);
b1.setBounds(400,300,200,20);
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
	public void itemStateChanged(ItemEvent i)
	{
	if(i.getSource()==cb2 && i.getStateChange()==ItemEvent.SELECTED)
	{
	
		
try{
	String s1="select sub from syllabus where dep='"+cb1.getSelectedItem()+"' and sem="+cb2.getSelectedItem();
	ResultSet rs=stmt.executeQuery(s1);
	cb3.removeAllItems();
	cb3.addItem("Select Subject");
	while(rs.next())
	{
	
		
		cb3.addItem(rs.getString(1));
	}
	
}	
catch(Exception e)
{
	System.out.println("Exception"+e);
	}
}
	}
	int n;
public void actionPerformed(ActionEvent e)
{
	
if(e.getSource()==b1)
{
	
	try
	{
	String str[]={"Rollno","Name","Marks"};

	String s1="select count(*) from stud1 where dep='"+cb1.getSelectedItem()+"' and sem="+cb2.getSelectedItem()+" and rollno not in(select rollno from marksentry where sem="+cb2.getSelectedItem()+" and sub='"+cb3.getSelectedItem()+"')";
	ResultSet rs=stmt.executeQuery(s1);

	if(rs.next())
		n=rs.getInt(1);

	
	
	if(jt!=null)
	{
		remove(js);
	}
	
	
	Object obj[][]=new Object[n][3];
	
	String s2="select rollno,sname,marks from marksentry,stud1 where dep='"+cb1.getSelectedItem()+"' and sem="+cb2.getSelectedItem()+" and sub='"+cb3.getSelectedItem()+"'";
System.out.println(s2);
	ResultSet rs1=stmt.executeQuery(s2);
	int i=0;
	
	while(rs1.next())
	{
		obj[i][0]=rs1.getString(1);
		obj[i][1]=rs1.getString(2);
		obj[i][2]=rs1.getString(3);
		i++;
	}	
	
	DefaultTableModel model=new DefaultTableModel(obj,str);
	 jt=new JTable(model){
		 public boolean isCellEditable(int row,int col)
		 {
			 
				 return false;
			 
		 }
		 
		 
	 };
	 
	 js=new JScrollPane(jt);
	add(js);
	js.setBounds(100,350,500,200);
	
	}
	catch(Exception e1)
	{
		System.out.println("Exception"+e1);}
	}

	
}

	
	
	public static void main(String ar[])
{
new viewmarks();	
}
}
