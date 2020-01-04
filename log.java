package myproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class log extends JFrame implements ActionListener{
JButton b1,b2;
JLabel l1,l2,l3;
JTextField t1,t2;
log()
{
setLayout(null);	
setSize(800,700);

t1=new JTextField();
t2=new JTextField();

l1=new JLabel("Login");
l2=new JLabel("User ID");
l3=new JLabel("Password");

b1=new JButton("Login");
b2=new JButton("Cancel");

add(t1);
add(t2);
add(l1);
add(l2);
add(l3);
add(b1);
add(b2);

l1.setBounds(400,100,300,30);
l2.setBounds(100,150,200,30);
t1.setBounds(330,150,200,30);
l3.setBounds(100,200,200,30);
t2.setBounds(330,200,200,30);
b1.setBounds(250,250,100,30);
b2.setBounds(450,250,100,30);

b1.addActionListener(this);
b2.addActionListener(this);
setVisible(true); 
setDefaultCloseOperation(EXIT_ON_CLOSE);
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
{
if(validation.checkstring(t1.getText()))
{
	JOptionPane.showMessageDialog(this,"login succesful");
}
else
	JOptionPane.showMessageDialog(this,"user name should contains only alphabets");
}
else
	System.exit(1);
}
public static void main(String ar[])
{
new log();	

}
}
