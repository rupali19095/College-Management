package myproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
public class attend extends JFrame implements ActionListener ,ItemListener{	JLabel l1,l2,l3,l4,l5;
JComboBox cb1,cb2,cb3;
Connection con;
Statement stmt;
JTable jt;
JScrollPane js;
JButton b1,b2;
JCheckBox c;
JTextField t1;
public attend() {
try
{
	setLayout(null);
	setSize(1000,1000);
c=new JCheckBox();
	// TODO Auto-generated constructor stub
b1=new JButton("Show");
l1=new JLabel("Attendence Entry");
l2=new JLabel("Deparment");
l3=new JLabel("Semester");
l4=new JLabel("Subject");
l5=new JLabel("Date");
t1= new JTextField();
cb1=new JComboBox();
cb2=new JComboBox();
cb3=new JComboBox();
b2=new JButton("Submit");
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
add(l5);
add(t1);
l1.setBounds(400,100,100,30);
l2.setBounds(100,150,100,20);
cb1.setBounds(300,150,200,20);
l3.setBounds(100,200,100,20);
cb2.setBounds(300,200,200,20);
l4.setBounds(100,250,100,20);
cb3.setBounds(300,250,200,20);
b1.setBounds(300,350,300,20);
b1.addActionListener(this);
b2.addActionListener(this);
b2.setBounds(400,600,100,20);
b2.setEnabled(false);
l5.setBounds(100,300,100,20);
t1.setBounds(300,300,200,20);
SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yy");
Date d1=new Date();
t1.setText(sd.format(d1));

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
		String str[]={"Rollno","Name","Attendence"};
	
		//String s1="select count(*) from feedetail where feedetail.dep='"+cb1.getSelectedItem()+"' and  sem="+cb2.getSelectedItem()+" and dep='"+cb1.getSelectedItem()+"'";
		String s1="select count(*) from stud1 where dep='"+cb1.getSelectedItem()+"' and sem="+cb2.getSelectedItem()+" and rollno  in(select rollno from admission)";
		ResultSet rs=stmt.executeQuery(s1);
	
		if(rs.next())
			n=rs.getInt(1);
	
		
		
		if(jt!=null)
		{
			remove(js);
		}
		
		
		Object obj[][]=new Object[n][3];
				String s2="select * from stud1 where dep='"+cb1.getSelectedItem()+"' and sem="+cb2.getSelectedItem()+" and rollno  in(select rollno from admission )";
	System.out.println(s2);
		ResultSet rs1=stmt.executeQuery(s2);
		int i=0;
		
		while(rs1.next())
		{
			obj[i][0]=rs1.getString(1);
			obj[i][1]=rs1.getString(2);
			obj[i][2]=true;
			i++;
		}	
	
		DefaultTableModel model=new DefaultTableModel(obj,str);
		 jt=new JTable(model){
			
			 public Class getColumnClass(int col)
			 { if(col==2)
					 return Boolean.class;
				 else
					 return String.class;
					
			 }
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
		js.setBounds(100,400,600,200);
		b2.setEnabled(true);
		}
		catch(Exception e1)
		{
			System.out.println("Exception"+e1);}
		}

		if(e.getSource()==b2)
		{
			TableModel model=jt.getModel();
			
			for(int p=0;p<n;p++)
			{
				try
				{
				String roll=model.getValueAt(p, 0).toString();
				boolean at=(boolean)model.getValueAt(p, 2);
				String att="";
				if(at)
				att="P";
				else
					att="A";
				String s1="insert into attend values('"+roll+"','"+t1.getText()+"','"+cb3.getSelectedItem()+"','"+att+"')";
				System.out.println(s1);
				stmt.executeUpdate(s1);
				}
				catch(Exception e4)
				{
					System.out.println("Exception"+e4);}
					
					
				}
			}
			
			
		}
		
		
		
	

private Object JCheckBox() {
	// TODO Auto-generated method stub
	return null;
}
public static void main(String ar[])
{
new attend();	

}
}