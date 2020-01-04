package myproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class dropuser extends JFrame implements ActionListener,ItemListener{
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3;
JComboBox cb;
JButton b1;
Connection con;
Statement stmt;

	public dropuser() {
		
		setLayout(null);
		setSize(1000,1000);
		
l1=new JLabel("Drop User"); 		// TODO Auto-generated constructor stub
l2=new JLabel("User ID");
l3=new JLabel("Name :");
l4=new JLabel("Roll no.:");
l5=new JLabel("Department :");


cb=new JComboBox();
cb.addItem("Select");


t1=new JTextField();
t2=new JTextField();
t3=new JTextField();
b1=new JButton("Drop");
add(l1);
add(l2);
add(l3);
add(l4);
add(l5);
add(t1);
add(t2);
add(t3);
add(cb);
add(b1);
	
l1.setBounds(400,100,100,30);
l2.setBounds(100,200,100,30);
cb.setBounds(300,200,200,30);
l3.setBounds(100,300,100,30);
t1.setBounds(300,300,200,30);
l4.setBounds(100,400,100,30);
t2.setBounds(300,400,200,30);
l5.setBounds(100,500,100,30);
t3.setBounds(300,500,200,30);
b1.setBounds(400,600,200,20);

try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","rupali");
stmt=con.createStatement();


String s1="select userid from user ";
ResultSet rs=stmt.executeQuery(s1);
while(rs.next())
{
cb.addItem(rs.getString(1));

}
}
catch(Exception e1)
{ System.out.print(e1);}
cb.addItemListener(this);
b1.addActionListener(this);
t1.setEditable(false);
t2.setEditable(false);
t3.setEditable(false);
setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void itemStateChanged(ItemEvent i)
	{
		if(i.getSource()==cb && i.getStateChange()==ItemEvent.SELECTED)
		{
			try{
			String s1="select sname,rollno,dep from user where userid='"+cb.getSelectedItem()+"'";
			ResultSet rs=stmt.executeQuery(s1);
			if(rs.next())
			{
				t1.setText(rs.getString(1));
			    t2.setText(rs.getString(2));
				t3.setText(rs.getString(3));
			}
		
		}
		
		catch(Exception e2)
		{
			System.out.println("Exception "+e2);
			e2.printStackTrace();
		}
			
		}
	}
public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==b1)
	{
		try
		{
			
		String s1="delete from user where  userid='"+cb.getSelectedItem()+"'";
		JOptionPane.showMessageDialog(this,s1);
		stmt.executeUpdate(s1);
		JOptionPane.showMessageDialog(this,"Record Deleted");
	cb.removeItem(cb.getSelectedItem());
		}
		catch(Exception e1)
		{
			System.out.println("Exception "+e1);
			
			
		}
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new dropuser();
	}

}
