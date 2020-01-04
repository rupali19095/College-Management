package myproject;
import javax.swing.*;

public class login extends JFrame
{
JLabel l1,l2;
JButton l3;
JTextField t1,t2;
login()
{
	setLayout(null);
	setSize(800,800);
l1=new JLabel("USER ID");
l2=new JLabel("Password");
l3=new JButton("Log in");
t1=new JTextField();
t2=new JTextField();

add(t1);
add(t2);
add(l1);
add(l3);
add(l2);

l1.setBounds(100,100,100,30);
t1.setBounds(200,100,100,30);
l2.setBounds(100,200,100,30);
t2.setBounds(200,200,100,30);
l3.setBounds(400,300,100,30);

setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);
}

public static void main(String ar[])
{
new login();	

}


}
