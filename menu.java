package myproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class menu extends JFrame implements ActionListener 
{
JMenuBar mb=new JMenuBar();
JMenu m1,m2,m3,m4,m5,m6;
JMenuItem i1,i2,i3,i4,i5,i6,i7;
JRadioButtonMenuItem r1,r2,r3,r4,r5,r6,r7,r8; 
JTextArea ta;
JFileChooser jf;
menu()
{
setSize(700,800);
m1=new JMenu("File");
m3=new JMenu("App");
m4=new JMenu("Help"); 
m2=new JMenu("Format");
m5=new JMenu("Font color");
m6=new JMenu("Back color");

r1= new JRadioButtonMenuItem("red");
r2= new JRadioButtonMenuItem("Blue");
r3= new JRadioButtonMenuItem("Green");
r4=new JRadioButtonMenuItem("Custom");
r5= new JRadioButtonMenuItem("red");
r6= new JRadioButtonMenuItem("Blue");
r7= new JRadioButtonMenuItem("Green");
r8= new JRadioButtonMenuItem("Custom");
ButtonGroup bg= new ButtonGroup();
ButtonGroup bg1=new ButtonGroup(); 

i1=new JMenuItem("New");
i2=new JMenuItem("Open");
i3=new JMenuItem("Save");
i4=new JMenuItem("Exit");
i5=new JMenuItem("login");
i6=new JMenuItem("Mspaint");
i7=new JMenuItem("About us");
ta=new JTextArea();
mb.add(m1);
mb.add(m2);
mb.add(m3);
mb.add(m4);
m5.add(r1);
m5.add(r2);
m5.add(r3);
m5.add(r4);
m6.add(r5);
m6.add(r6);
m6.add(r7);
m6.add(r8);
m1.add(i1);
m1.add(i2);
m1.add(i3);
m1.add(i4);
m4.add(i7);
m3.add(i5);
m3.add(i6);
m2.add(m5);
m2.add(m6);
add(ta);
bg.add(r1);
bg.add(r2);
bg.add(r3);
bg.add(r4);
bg1.add(r1);
bg1.add(r2);
bg1.add(r3);
bg1.add(r4);

i1.addActionListener(this);
i2.addActionListener(this);
i3.addActionListener(this);
i4.addActionListener(this);
i5.addActionListener(this);
i6.addActionListener(this);
r1.addActionListener(this);
r2.addActionListener(this);
r3.addActionListener(this);
r4.addActionListener(this);
r5.addActionListener(this);
r6.addActionListener(this);
r7.addActionListener(this);
r8.addActionListener(this);

setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setJMenuBar(mb);
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==r5)
	ta.setBackground(Color.red);
if(e.getSource()==r6)
	ta.setBackground(Color.green);
if(e.getSource()==r7)
	ta.setBackground(Color.blue);
if(e.getSource()==r1)
	ta.setForeground(Color.red);
if(e.getSource()==r2)
	ta.setForeground(Color.green);
if(e.getSource()==r3)
	ta.setForeground(Color.blue);
if(e.getSource()==r4)
{
	JColorChooser c=new JColorChooser();
	Color cl=c.showDialog(this,"Select Color", Color.red);
	ta.setForeground(cl);
}

if(e.getSource()==r8)
{
	JColorChooser c=new JColorChooser();
	Color cl=c.showDialog(this,"Select Color", Color.red);
	ta.setBackground(cl);
}
if(e.getSource()==i1)
ta.setText("  ");	
if(e.getSource()==i2)
{
 jf =new JFileChooser();
jf.showOpenDialog(this);
try

{
	String fname=jf.getSelectedFile().getPath();
	BufferedReader bf = new BufferedReader(new FileReader (fname));
	String s1="";
	while((s1=bf.readLine())!=null)
	{
		ta.append(s1+"\n");
	}
bf.close();
}
catch(Exception e2)
{}
}
if(e.getSource()==i3)
{
	JFileChooser jf=new JFileChooser();
			jf.showSaveDialog(this);
			try
			{
				String s=jf.getSelectedFile().getPath();
				FileWriter fw=new FileWriter(s);
				BufferedWriter bw=new BufferedWriter(fw);
				bw.write(ta.getText());
				bw.close();
				fw.close();
			}
			catch(Exception e3)
			{		
				
			}
}
	if(e.getSource()==i4)

	{
		System.exit(1);
	}
	if(e.getSource()==i5)
	{
	System.out.println("1111");
		new login();
	
	}
	if(e.getSource()==i6)
	{
	//	process p=Runtime 
		
		
		
		
	}
}



public static void main(String ar[])
{

new menu();
}
}


