/**
 * @(#)Lab11.java
 *
 * Lab11 application
 *
 * @author 
 * @period 
 * @lab
 * @version 1.00 2015/11/11
 */
public class TestRunner
{
	public static void main(String args[])
	{
		CircularLinkedList<Integer> a = new CircularLinkedList<Integer>();
		for(int i = 0; i < 3; i++)
			a.add(i);
		System.out.println(a);
		a.add(0,15);
		System.out.println(a);
		a.add(1,11);
		System.out.println(a);
	//	System.out.println("WROKING " + r.check("[10, 0, 1, 15, 2, 3, 4, 5, 6, 7, 8, 9, 12]",b));
	}
	public boolean check(String should, String get)
	{
		if(should.compareTo(get)==0)
			return true;
		return false;
	}
}