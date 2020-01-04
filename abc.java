package myproject;
public class abc {
	String name;
	int age;
abc(String n,int a)
{
	name=n;
	age=a;
}
void print()
{
	System.out.println("Name is :"+name);
	System.out.println("Age is :"+age);
	
}


	
	
	public static void main(String ar[]) {
	abc	obj=new abc("Ben",23);
	obj.print();
	abc obj1=new abc("steve",32);
		obj1.print();
	}

}
