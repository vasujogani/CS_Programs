import java.util.*;

public class Runner {

    public static void main(String[] args) 
    {
    	//Create an IGraph
    	IGraph<String> g = makeGraph();
    	
    	List<Integer> path;
    	
    	//Test DFS and BFS
    	path = bfs(g, 2, 6);
    	System.out.println("BFS 2 -> 6");
    	System.out.println(path);

		path = dfs(g, 4, 3);    	
    	System.out.println("DFS 4 -> 3");
    	System.out.println(path);
		
		path = bfs(g, 2, 0);    		
   		System.out.println("BFS 2 -> 0");
    	System.out.println(path);

		path = dfs(g, 2, 0);    	
    	System.out.println("DFS 2 -> 0");
    	System.out.println(path);

		path = bfs(g, 2, 2);    	
    	System.out.println("BFS 2 -> 2");
    	System.out.println(path);

		path = dfs(g, 2, 2);    	
    	System.out.println("DFS 2 -> 2");
    	System.out.println(path);

		path = bfs(g, 3, 7);    	
    	System.out.println("BFS 3 -> 7");
    	System.out.println(path);

		path = dfs(g, 3, 7);    	
    	System.out.println("DFS 3 -> 7");
    	System.out.println(path);
    }
    
    public static IGraph<String> makeGraph()
    {
    	// Change AdjacencyMatrixGraph to use a Graph that you immplemented!
    	IGraph<String> graph = new AdjacencyMatrixGraph<String>();
    	
    	graph.addVertex("A");
    	graph.addVertex("B");
    	graph.addVertex("C");
    	graph.addVertex("D");
    	graph.addVertex("E");
    	graph.addVertex("F");
    	graph.addVertex("G");
    	graph.addVertex("H");
    	graph.addVertex("I");
    //	graph.addVertex("J");
    	
    	graph.addEdge(0, 1);
    	graph.addEdge(0, 5);
    	graph.addEdge(6, 5);
    	graph.addEdge(1, 6);
    	graph.addEdge(4, 0);
    	graph.addEdge(4, 1);
    	graph.addEdge(4, 5);
    	graph.addEdge(4, 6);
    	graph.addEdge(1, 2);
    	graph.addEdge(2, 7);
    	graph.addEdge(7, 3);
    	graph.addEdge(7, 8);
    	graph.addEdge(2, 3);
    	
    	return graph;
    }
    
    public static List<Integer> backtrace(int[] parent, int start, int end)
    {
    	List<Integer> ret = new ArrayList<Integer>();
    	int current = end;
    	ret.add(end);
    	while(current!=start)
    	{
    		current = parent[current];
    		ret.add(0,current);
    	}
    	return ret;
    }
    
    public static List<Integer> bfs(IGraph graph, int start, int end)
    {
		int[] parent = new int[graph.size()];
		for(int i = 0; i < parent.length; i++)
			parent[i] = -1;
		List<Integer> visited = new ArrayList<Integer>();
		Queue<Integer> Q = new LinkedList<Integer>();	
		Q.add(start);
		while(!(Q.isEmpty()))
		{
			int current = Q.poll();
			visited.add(current);
			for(int i = 0; i < graph.getNeighbors(current).length; i++)
			{
				int[] n = graph.getNeighbors(current);
				if(!(visited.contains(n[i])))
					if(parent[n[i]]==-1)
					{
						Q.add(n[i]);
						parent[n[i]]=current;
					}
			}	
		}
		System.out.println("BFS parent");	
		for(int i  = 0; i < parent.length; i++)
			System.out.println("INDEX: " + i + " VALUE: " + parent[i]);
    	return backtrace(parent, start, end);
    }
    
    public static List<Integer> dfs(IGraph graph, int start, int end)
    {
    	int[] parent = new int[graph.size()];
    	for(int i = 0; i < parent.length; i++)
			parent[i] = -1;
    	List<Integer> discovered = new ArrayList<Integer>();
	 	Stack<Integer> s = new Stack<Integer>();
	 	s.push(start);
	 	int current=-1;
	 	int temp = -1;
	 	while(!s.isEmpty())
	 	{
	 		temp = current;
	 //		System.out.println("Temp is : " + temp  + " current is : " + current);
	 		current = s.pop();
	 		System.out.println("Temp is : " + temp  + " current is : " + current);
	 		if(parent[current]==-1)
	 			parent[current] = temp;
	 		discovered.add(current);
	 		int[] c = graph.getNeighbors(current);
	 		for(int i = 0; i < graph.getNeighbors(current).length; i++)
	 		{
	 			if(!(discovered.contains(c[i])))
	 				if(parent[c[i]]==-1)
	 				{	
		 				s.push(c[i]);
	 				}
	 		}
	 	}
	 	System.out.println("DFS parent");
	 	for(int i  = 0; i < parent.length; i++)
			System.out.println("INDEX: " + i + " VALUE: " + parent[i]);
	 	return backtrace(parent, start, end);
    }
    
    
}