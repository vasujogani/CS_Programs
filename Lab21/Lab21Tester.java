public class Lab21Tester
{
	public static void main(String[] args)
	{
		System.out.println("Creating a Priority Queue");
		PQueue<Integer> q = new PQueue<Integer>();
		
		System.out.println("Size should be 0: "+q.size());
		System.out.println("empty should be true: "+q.isEmpty());
		System.out.println("Peek should be null: " + q.peek());
		
		System.out.println("\nAdding 6, 4, 1, 3 to Priority Queue");
		q.add(6);
		q.add(4);
		q.add(1);
		q.add(3);
		
		System.out.println("Size should be 4: "+q.size());
		System.out.println("empty should be false: "+q.isEmpty());
		
		System.out.println("Peek should be 1: " + q.peek());
		
		System.out.println("\nRemoving head of Priority Queue");
		Integer a = q.remove();
		System.out.println("Should be 1: " + a);
		System.out.println("Size should be 3: "+q.size());
		System.out.println("empty should be false: "+q.isEmpty());
		
		System.out.println("Peek should be 3: " + q.peek());
		
		System.out.println("\nAdding 10 to Priority Queue");
		q.add(10);
		System.out.println("Size should be 4: "+q.size());
		System.out.println("Peek should be 3: " + q.peek());
		
		System.out.println("\nAdding 5 to Priority Queue");
		q.add(5);
		System.out.println("Size should be 5: "+q.size());
		System.out.println("Peek should be 3: " + q.peek());
		
		System.out.println("\nAdding -5 to Priority Queue");
		q.add(-5);
		System.out.println("Size should be 6: "+q.size());
		System.out.println("Peek should be -5: " + q.peek());
		
		System.out.println("\nRemoving all elements from Priority Queue");
		while(!q.isEmpty())
		{
			System.out.print(q.remove() + "...");
		}
		System.out.println();
		
		System.out.println("Size should be 0: "+q.size());
		System.out.println("Peek should be null: " + q.peek());
		
	}
}