public class GraphTest
{
	public static void main(String[] args)
	{
		IGraph<String> g = new AdjacencyMatrixGraph<String>();
		
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("M");
		g.addVertex("N");
		g.addVertex("X");
		g.addVertex("Y");
		
		g.addEdge(2, 1);
		g.addEdge(5, 1);
		g.addEdge(2, 5);
		g.addEdge(0, 2);
		g.addEdge(3, 1);
		g.addEdge(0, 4);
		g.addEdge(4, 3);
		g.addEdge(0, 5);
		
		compare(new int[] {4, 2, 5}, g.getNeighbors(0));
		compare(new int[] {3, 2, 5}, g.getNeighbors(1));
		compare(new int[] {0, 5, 1}, g.getNeighbors(2));
		compare(new int[] {4, 1}, g.getNeighbors(3));
		compare(new int[] {0, 3}, g.getNeighbors(4));
		compare(new int[] {0, 2, 1}, g.getNeighbors(5));
		
		g.removeEdge(0, 5);
		
		compare(new int[] {4, 2}, g.getNeighbors(0));
		compare(new int[] {3, 2, 5}, g.getNeighbors(1));
		compare(new int[] {0, 5, 1}, g.getNeighbors(2));
		compare(new int[] {4, 1}, g.getNeighbors(3));
		compare(new int[] {0, 3}, g.getNeighbors(4));
		compare(new int[] {2, 1}, g.getNeighbors(5));
		
	}
	
	public static void compare(int[] expected, int[] found)
	{
		boolean pass = true;
		if(expected.length != found.length)
			pass = false;
		else
			for(int i=0; i<expected.length; i++)
				if(!contains(found, expected[i]))
				{
					pass = false;
					break;
				}
		if(pass)
			System.out.println("Test Passed!");
		else
		{
			System.out.println("Test Failed...");
			System.out.print("Expected:\t");
			for(int x : expected)
				System.out.print(x + " ");
			System.out.println();
			System.out.print("Found:\t");
			for(int x : found)
				System.out.print(x + " ");
			System.out.println();
		}
	}
	
	public static boolean contains(int[] list, int x)
	{
		for(int a : list)
			if(a == x) return true;
		return false;
	}
}