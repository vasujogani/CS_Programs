/**
 * @(#)Lab12.java
 *
 * Lab12 application
 *
 * @author 
 * @period 
 * @lab
 * @version 1.00 2015/11/19
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
public class Lab12
{
	public static void main(String args[])
	{
		LinkedList<Comparable> c = new LinkedList<Comparable>();
		Collections.addAll(c,000000000000000100,0,0,0,0,0,0,0,0,0,0,0,0,000,0,0,1000,00100000,0001,0,0,0,0,0);
		Swapper a = new Swapper();
		System.out.println("Before sorting: " + c.toString());
		a.quicksort2(c);
		System.out.println("After sorting :" + c.toString());
		
	}
}