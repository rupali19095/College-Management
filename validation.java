package myproject;
import javax.swing.*;
public class validation {
	int a;
	
/*	s()
	{
	if(a>15&&a<25)
	{
	System.out.println("Invalid age");
	
	}*/
static boolean checkstring(String str)
	{
		int i;
		for(i=0;i<str.length();i++)
		{
			int ch=str.charAt(i);
			if(!((ch>=65&&ch<=90) || (ch>=97&&ch<=122) ||ch==32))
			{
	return false;
			}
			
//	return true;		
		
		
	}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

validation.checkstring("rupali");
	}

}
