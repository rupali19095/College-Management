package myproject;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class about extends JFrame implements ActionListener {
	JLabel l1,l2;
	JButton b1;
	about()
	{
		setSize(800,800);
		setLayout(null);
		l1=new JLabel("Aptech");
		l2=new JLabel("menu");
		b1=new JButton("ok");
		add(l1);
		add(l2);
		add(b1);
		l1.setBounds(100,100,100,30);
		l2.setBounds(100,200,100,30);
		b1.setBounds(100,300,100,30);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
public	void actionPerformed(ActionEvent e)
{
//	if(e.getSource()
}
	
	public static void main(String ar[])
	{
		new about();
		
	}
	
}
