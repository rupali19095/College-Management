package myproject;
import javax.swing.*;
public class welcome extends JFrame {
JLabel l1;
JButton b1,b2,b3;
welcome()
{setLayout(null);
	setSize(1100,1100);
l1=new JLabel("WELCOME");
b1=new JButton("Admin login");
b2=new JButton("Faculty login");
b3=new JButton("Student login");
add(l1);
add(b1);
add(b2);
add(b3);
l1.setBounds(500, 100, 200, 100);
b1.setBounds(100,300,200,30);
b2.setBounds(400,300,200,30);
b3.setBounds(700,300,200,30);
setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);

}

public static void main(String ar[])
{
 new welcome();	
}
}
