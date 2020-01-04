package myproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.*;
import javax.swing.*;
public class user extends JFrame implements ActionListener,ItemListener {
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
JButton b1,b2,b3;
JComboBox cb;
JTextField t1,t2,t3,t4,t5,t6;
JRadioButton r1,r2;
Connection con;
Statement stmt;


user()
{
	setLayout(null);
	setSize(1000,1000);
	l1=new JLabel("Create User");
	l2=new JLabel("User Type");
	l3=new JLabel("Full Name ");
	l4=new JLabel("User id");
	l5=new JLabel("Password");
	l6=new JLabel("Re-Enter Password");
	l7=new JLabel("Department");
	l8=new JLabel("Roll no.");
	l9=new JLabel("Phone No.");
	
	b1=new JButton("Add New");
	b2=new JButton("Create");
	b3=new JButton("Cancel");
	
	cb=new JComboBox();
	cb.addItem("Select");
	cb.addItem("Computer Science");
	cb.addItem("Electronics and Communication");
	cb.addItem("Information technology");
	cb.addItem("Mechanical");

	t1=new JTextField();
	t2=new JTextField();
	t3=new JTextField();
	t4=new JTextField();
	t5=new JTextField();
	t6=new JTextField();
	
	r1=new JRadioButton("Faculty");
	r2=new JRadioButton("Student");
ButtonGroup bg=new ButtonGroup();
bg.add(r1);
bg.add(r2);


add(b1);
add(b2);
add(b3);
add(l1);
add(l2);
add(l3);
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
add(t1);
add(t2);
add(t3);
add(t4);
add(t5);
add(t6);

l1.setBounds(400,50,200,30);
l2.setBounds(100,150,200,20);
r1.setBounds(300,150,200,20);
r2.setBounds(500,150,200,20);
l3.setBounds(100,200,200,20);
t1.setBounds(300,200,200,20);
l4.setBounds(100,250,200,20);
t2.setBounds(300,250,200,20);
l5.setBounds(100,300,200,20);
t3.setBounds(300,300,200,20);
l6.setBounds(100,350,200,20);
t4.setBounds(300,350,200,20);
l7.setBounds(100,400,200,20);
cb.setBounds(300,400,200,20);
l8.setBounds(100,450,200,20);
t5.setBounds(300,450,200,20);
l9.setBounds(100,500,200,20);
t6.setBounds(300,500,200,20);
b1.setBounds(100,550,200,20);
b2.setBounds(400,550,200,20);
b3.setBounds(700,550,200,20);

try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","rupali");
stmt=con.createStatement();
}
catch(Exception e1)
{}
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
r1.addItemListener(this);
setVisible (true);
setDefaultCloseOperation(EXIT_ON_CLOSE);


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
	t2.setText("");
	cb.setSelectedIndex(0);
	r2.setSelected(true);
}
if(e.getSource()==b2)
{
	try{
	String type="";
	if(r1.isSelected())
		type="Faculty";
	else
		type="Student";
	String s1="insert into user values('"+type+"','"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+cb.getSelectedItem()+"','"+t5.getText()+"','"+t6.getText()+"')";
	JOptionPane.showMessageDialog(this,s1);
	stmt.executeUpdate(s1);
	}
catch(Exception e1)
	{
	System.out.println("Exception :"+e1);
	
	}
}
if(e.getSource()==b3)
{
System.exit(1);	

}

}
public void itemStateChanged(ItemEvent i)
{
	if(i.getSource()==r1)
	{
		t5.setVisible(false);
	}
	if(i.getSource()==r2)
	{
		t5.setVisible(true);
}
}
public static void main(String ar[])
{
new user();	

}




}



