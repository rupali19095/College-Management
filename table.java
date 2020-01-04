package myproject;
import javax.swing.*;
import java.awt.*;
public class table extends JFrame {
	table()
	{
		setLayout(new FlowLayout());
		setSize(400,400);
	 String str[]={"Rollno","Name","Marks"};
	Object obj[][]={{"1","Aman","70"},{"2","Rohit","80"},{"3","Anubhav","100"}};
JTable jt=new JTable(obj,str);
JScrollPane js =new JScrollPane(jt);
//js.setBounds(0,200,200,30);
add(js);
//add(jt);
setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String ar[])
	{
		
		new table();
	}
	}
