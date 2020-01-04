package myproject;
import javax.swing.tree.*;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;

public class tree extends JFrame implements TreeSelectionListener

{

	JLabel l1,l2,l3,l4;
	JTextField t1,t2,t3,t4;
JTree jt;
	tree()
	{
		setSize(800,800);
		setLayout(null);
	l1=new JLabel("Parent name");
	l2=new JLabel("Node Name");
	l3=new JLabel("Type Node");
	l4=new JLabel("Number of child nodes");
	add(l1);
	add(l2);
	add(l3);
	add(l4);
	
	t1=new JTextField();
	t2=new JTextField();
	t3=new JTextField();
	t4=new JTextField();
	add(t1);
	add(t2);
	add(t3);
	add(t4);
		l1.setBounds(200,100,100,30);
		l2.setBounds(200,200,100,30);
		l3.setBounds(200,300,100,30);
		l4.setBounds(200,400,100,30);
		t1.setBounds(450,100,100,30);
		t2.setBounds(450,200,100,30);
		t3.setBounds(450,300,100,30);
		t4.setBounds(450,400,100,30);
		DefaultMutableTreeNode root=new DefaultMutableTreeNode("Root");
		DefaultMutableTreeNode parent=new DefaultMutableTreeNode("Books");
		root.add(parent);
	
		DefaultMutableTreeNode java=new DefaultMutableTreeNode("Java");
	parent.add(java);
		DefaultMutableTreeNode complete=new DefaultMutableTreeNode("Complete");
java.add(complete);
DefaultMutableTreeNode oracle=new DefaultMutableTreeNode("Oracle");
parent.add(oracle);
DefaultMutableTreeNode c=new DefaultMutableTreeNode("C#");
oracle.add(c);
jt=new JTree(root);
add(jt);
		jt.setBounds(10,10,150,600);
		jt.addTreeSelectionListener(this);
		
		setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void  valueChanged(TreeSelectionEvent e)
	{
		
		DefaultMutableTreeNode node=(DefaultMutableTreeNode)jt.getLastSelectedPathComponent();
		if(node.isRoot())
		{
			t1.setText("");
			t2.setText(node.toString());
		    t3.setText("Root");
			t4.setText(""+node.getChildCount());
		}
		else if(node.isLeaf())
		{
			t1.setText(node.getParent().toString());
			t2.setText(node.toString());
		    t3.setText("Leaf");
			t4.setText("");
		}
		else
		{
			t1.setText(node.getParent().toString());
			t2.setText(node.toString());
			t3.setText("Parent");
			t4.setText(""+node.getChildCount());
		    
		}
		
	}
public static void main(String ar[])
{
new tree();	
}
	
}
