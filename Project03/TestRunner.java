/**
 * @(#)Project03.java
 *
 * Project03 application
 *
 * @Vasu Jogan 
 * @6th period
 * @Project 3
 * @version 5.0.1 2015/11/9
 */
public class TestRunner
{
	public static void main(String args[])
	{
		MyLinkedList<Integer> a = new MyLinkedList<Integer>();
		System.out.println("Linked List");
		System.out.println("Add : " +testAdd(a,10000));
		System.out.println("Remove : " +testRemove(a, 10k0));
		System.out.println("Add with index: " +testAddIn(a,10000));
		System.out.println("Get : " + testGet(a,10000));
		System.out.println("Set : " + testSet(a,10000));
	//	System.out.println(a);
		System.out.println();
		
		MyDoubleLinkedList<Integer> b = new MyDoubleLinkedList<Integer>();
		
		System.out.println("DOUBLE LINKED LIST");
		System.out.println("Add : " +testAdd(b,10000));
		System.out.println("Remove : " +testRemove(b, 10000));
		System.out.println("Add with index: " +testAddIn(b,10000));
		System.out.println("Get : " + testGet(b,10000));
		System.out.println("Set : " + testSet(b,10000));
	//	System.out.println(b);
		System.out.println();
		
		MyArrayList<Integer> c = new MyArrayList<Integer>();
		System.out.println("ArrayList");
		System.out.println("Add : " +testAdd(c,10000));
		System.out.println("Remove : " +testRemove(c, 10000));
		System.out.println("Add with index: " +testAddIn(c,10000));
		System.out.println("Get : " + testGet(c,10000));
		System.out.println("Set : " + testSet(c,10000));
	//	System.out.println(c);
		System.out.println();
	}
		public static double testAdd(IList<Integer> list, int numElements)
		{
			long startTime = System.nanoTime(); 
			for(int i =0; i < numElements; i++) 
			{
				list.add(i);
			} 
			long endTime = System.nanoTime(); 
			double results = (endTime - startTime)/1000000000.0;
			return results;
		}
		public static double testRemove(IList<Integer> list, int numElements)
		{
			long startTime = System.nanoTime(); 
			for(int i =0; i < numElements; i++) 
			{
				list.remove(0);
			} 
			long endTime = System.nanoTime(); 
			double results = (endTime - startTime)/1000000000.0;
			return results;
		}
		public static double testAddIn(IList<Integer> list, int numElements)
		{
			long startTime = System.nanoTime(); 
			for(int i =0; i < numElements; i++) 
			{
				list.add(0,i);
			} 
			long endTime = System.nanoTime(); 
			double results = (endTime - startTime)/1000000000.0;
			return results;
		}
		public static double testGet(IList<Integer> list, int numElements)
		{
			long startTime = System.nanoTime(); 
			for(int i =0; i < numElements; i++) 
			{
				list.get(i);
			} 
			long endTime = System.nanoTime(); 
			double results = (endTime - startTime)/1000000000.0;
			return results;
		}
		public static double testSet(IList<Integer> list, int numElements)
		{
			long startTime = System.nanoTime(); 
			for(int i =0; i < numElements; i++) 
			{
				list.set(i,i);
			} 
			long endTime = System.nanoTime(); 
			double results = (endTime - startTime)/1000000000.0;
			return results;
		}
		
}