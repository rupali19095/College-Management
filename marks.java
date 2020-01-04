package myproject;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.*;
import  java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class marks extends JFrame implements ItemListener,ActionListener{
	JLabel l1,l2,l3,l4;
	JComboBox cb1,cb2,cb3;
	Connection con;
	Statement stmt;
JTable jt;
JScrollPane js;
	JButton b1,b2;
	public marks() {
try
{
		setLayout(null);
		setSize(1000,1000);

		// TODO Auto-generated constructor stub
	b1=new JButton("Display Student List");
	l1=new JLabel("Marks Entry");
	l2=new JLabel("Deparment");
	l3=new JLabel("Semester");
	l4=new JLabel("Subject");
	cb1=new JComboBox();
	cb2=new JComboBox();
	cb3=new JComboBox();
	b2=new JButton("Save");
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
add(b1);
add(l1);
add(l2);
add(l3);
add(l4);
add(cb1);
add(cb2);
add(cb3);
add(b2);
l1.setBounds(400,100,100,30);
l2.setBounds(100,150,100,20);
cb1.setBounds(300,150,200,20);
l3.setBounds(100,200,100,20);
cb2.setBounds(300,200,200,20);
l4.setBounds(100,250,100,20);
cb3.setBounds(300,250,200,20);
b1.setBounds(300,300,300,20);
b1.addActionListener(this);
b2.addActionListener(this);
b2.setBounds(400,600,100,20);
b2.setEnabled(false);
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
catch(NullPointerException e1)
{
System.out.println("NUll   exception "+e1);
e1.printStackTrace();
}

cb2.addItemListener(this);
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
	//String s2="insert into marks values('"+cb1.getSelectedItem()+"',"+cb2.getSelectedItem()+",'"+cb3.getSelectedItem()+"')";
}	
catch(Exception e)
{
	System.out.println("Exception"+e);}
}

}

int n=0;

public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==b1)
	{
		try
		{
		String str[]={"Rollno","Name","Marks"};
	
		//String s1="select count(*) from feedetail where feedetail.dep='"+cb1.getSelectedItem()+"' and  sem="+cb2.getSelectedItem()+" and dep='"+cb1.getSelectedItem()+"'";
		String s1="select count(*) from stud1 where dep='"+cb1.getSelectedItem()+"' and sem="+cb2.getSelectedItem()+" and rollno not in(select rollno from marksentry where sem="+cb2.getSelectedItem()+" and sub='"+cb3.getSelectedItem()+"')";
		ResultSet rs=stmt.executeQuery(s1);
	
		if(rs.next())
			n=rs.getInt(1);
	
		
		
		if(jt!=null)
		{
			remove(js);
		}
		
		
		Object obj[][]=new Object[n][3];
		//String s2="select feedetail.rollno,sname from admission,feedetail where feedetail.dep='"+cb1.getSelectedItem()+"' and sem="+cb2.getSelectedItem()+" and feedetail.rollno=admission.rollno";
		String s2="select * from stud1 where dep='"+cb1.getSelectedItem()+"' and sem="+cb2.getSelectedItem()+" and rollno not in(select rollno from marksentry where  sub='"+cb3.getSelectedItem()+"')";
	System.out.println(s2);
		ResultSet rs1=stmt.executeQuery(s2);
		int i=0;
		
		while(rs1.next())
		{
			obj[i][0]=rs1.getString(1);
			obj[i][1]=rs1.getString(2);
			i++;
		}	
		//System.out.println("i="+i);
		DefaultTableModel model=new DefaultTableModel(obj,str);
		 jt=new JTable(model){
			 public boolean isCellEditable(int row,int col)
			 {
				 if(col==1 || col==0)
					 return false;
				 else
					 return true;
			 }
			 
			 
		 };
		 
		 js=new JScrollPane(jt);
		add(js);
		js.setBounds(100,350,500,200);
		b2.setEnabled(true);
		}
		catch(Exception e1)
		{
			System.out.println("Exception"+e1);}
		}

		if(e.getSource()==b2)
		{
			TableModel model=jt.getModel();
			
			for(int p=0;p<=n;p++)
			{
				try
				{
				String roll=model.getValueAt(p, 0).toString();
				String mk=model.getValueAt(p, 2).toString();
				String s1="insert into marksentry values('"+roll+"','"+cb1.getSelectedItem()+"',"+cb2.getSelectedItem()+",'"+cb3.getSelectedItem()+"',"+mk+")";
				System.out.println(s1);
				stmt.executeUpdate(s1);
				}
				catch(Exception e4)
				{}
			}
			
			
		}
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
new marks();
	}

}
