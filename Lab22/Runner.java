import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Stack;

public class Runner 
{
    public static void main(String[] args)
	{		
		// 0 = open tile
		// 1 = blocked tile
		int[][] map = {
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
			{1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1},
			{1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
			{1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
		};
		
		
		
		//Create a Graph
		IGraph<IGraphable> graph = arrayToGraph(map, 16, 16);
		
		int start = 79;
		int goal = 24;
		
		//dfs(graph, start, goal);
		//bfs(graph, start, goal);
		aStar(graph, start, goal, map[0].length);
	}
	
	public static void aStar(IGraph<IGraphable> graph, int start, int goal, int numCols)
	{
		GraphArtist window = new GraphArtist(graph);
		window.setDelay(100);
		window.setMessage("Using A*");
		
		//Mark the start and goal vertexes
		window.updateNode(start, Color.YELLOW);
		window.updateNode(goal, Color.RED);
		window.update();
		
		int[] parent = new int[graph.size()];
		for(int i=0; i< parent.length; i++)
		{
			parent[i] = -1;
		}
		int[] gScore = new int[graph.size()];
		for(int i=0; i< parent.length; i++)
		{
			gScore[i] = Integer.MAX_VALUE;
		}
		int[] fScore = new int[graph.size()];
		for(int i=0; i< parent.length; i++)
		{
			fScore[i] = Integer.MAX_VALUE;
		}
		//find the columns in the graph
		gScore[start] = 0;
		fScore[start] = aStarHeuristic(start, goal, numCols);
		List<Integer> open = new ArrayList<Integer>();
		List<Integer> closed = new ArrayList<Integer>();
		open.add(start);
		int current=-1;
		//TODO: use A* Algorithm to find shortest path from Start to Goal
		List<PriorityIndex> p = new ArrayList<PriorityIndex>();
		while(open.size()>0)
		{
	//		current = getSmallest(open, fScore);
			for(int i = 0; i < fScore.length; i++)
			{
				p.add(new PriorityIndex(i,fScore[i]));
			}
			System.out.println("current is  : " + getSmallest(p, open));
			current = getSmallest(p, open);		
		
			if(current==goal) break;
		
			open.remove(open.indexOf(current));
			closed.add(current);
			window.updateNode(current, Color.BLACK);
			
			int[] neighbor = graph.getNeighbors(current);
			for(int i = 0; i < neighbor.length; i++)
			{
//				System.out.println("INTO STEP 2");
				if(!closed.contains(neighbor[i]))	
				{
			//		System.out.println("INTO STEP 2");
					int newG = gScore[neighbor[i]] + 1;
					if(!open.contains(neighbor[i]))
					{
						open.add(neighbor[i]);
						window.updateNode(neighbor[i], Color.BLACK);
					}
					else if(newG<gScore[neighbor[i]]){
						parent[neighbor[i]] = current;
						gScore[neighbor[i]] = newG;
						fScore[neighbor[i]] = newG + aStarHeuristic(neighbor[i], goal, numCols); 
					}
					window.update();
				}
			}
		}
		
		//End A* Algorithm
		backtrace(window, parent, goal);
	}

	public static int getSmallest(List<PriorityIndex> list, List<Integer> o)
	{
	//	System.out.println("PI IS : ");
	//	for(int i = 0; i < list.size(); i++)
	//		System.out.println(i+ " : "+list.get(i).getFScore());
		System.out.println("o is: " + o);
		PriorityIndex smallest = list.get(o.get(0));
		for(int i = 0; i < list.size(); i++)
		{
			if(o.contains(i))
				if(smallest.getFScore()>list.get(i).getFScore())
					smallest = list.get(i);
		}
		//System.out.println("smallest index in open is : " )
		return smallest.getIndex();
	}
	
	//@return 	the number of steps on the path between from and to
	public static int distanceBetween(int from, int to, int[] parent, IGraph<IGraphable> graph)
	{
		//start distance at 0
		int distance = 0;
		
		//copy the to-index into a generic index variable
		int index = to;
		
		//keep looping until index has backtraced all the way to the from-index or until the parent is unknown
		while(index != from && index != -1)
		{
			//the distance between two vertexes is the weight of the edge between them
			distance += graph.getWeight(index, parent[index]);
			
			//backtrace from this index to the index of its parent
			index = parent[index];
		}
		//return the length of the path between from and to
		return distance;
	}
	
	//@return a heuristic between from and to that "guesses" at the distance between them
	public static int aStarHeuristic(int from, int to, int numCols)
	{
		//Use the distance formula to find "as the bird flys" distance between from and to
		
		//Calculate (R, C) given that: index = R * numCols + C
		
		//get (x, y) from index
		int r1 = from/numCols;
		int c1 = from - r1*numCols;
		
		//get (x, y) from index
		int r2 = to/numCols;
		int c2 = to - r2*numCols;
		
		int dx = r2 - r1;
		int dy = c2 - c1;
		
		//distance formula (x100 so that it includes some decimal places)
		return (int)(Math.sqrt( dx * dx + dy * dy ) * 100);
	}
	
	public static void backtrace(GraphArtist window, int[] parent, int index)
	{
		window.setMessage("Backtracing");
		window.setDelay(250);
		window.update();
		List<Integer> path = new LinkedList<Integer>();
		
		//add goal to path
		path.add(index);
				
		while(parent[index] != -1)
		{
			//get parent
			index = parent[index];
			
			//add parent to beginning of path	
			path.add(0, index);
		}
		
		//color the path (ignoring the first vertex
		for(int i=1; i<path.size(); i++)
		{
			index = path.get(i);
			window.updateNode(index, Color.YELLOW);
			window.update();
		}
		
		window.setMessage("Done!");
		window.update();
	}
	
	public static void dfs(IGraph<IGraphable> graph, int start, int goal)
	{
		GraphArtist window = new GraphArtist(graph);
		window.setDelay(500);
		window.setMessage("Using DFS");
		
		//Mark the start and goal vertexes
		window.updateNode(start, Color.YELLOW);
		window.updateNode(goal, Color.RED);
		window.update();
		
		List<Integer> discovered = new ArrayList<Integer>();
		Stack<Integer> s = new Stack<Integer>();
		
		//create parent array for backtrace and initialize it to -1
		int[] parent = new int[graph.size()];
		for(int i=0; i< parent.length; i++)
		{
			parent[i] = -1;
		}
		
		s.push(start);
		while(!s.isEmpty())
		{
			int v = s.pop();
			
			//if this vertex is the goal, stop searching for it!
			if(v == goal)
				break;
			
			if(!discovered.contains(v))
			{
				discovered.add(v);
				
				if(v != start && v != goal)
					window.updateNode(v, Color.BLUE);
					
				int[] neighbors = graph.getNeighbors(v);
				for(int neighbor : neighbors)
				{
					if(!discovered.contains(neighbor))
					{
						s.push(neighbor);
						
						//set the parent of this neighbor to this vertex
						parent[neighbor] = v;
						
						if(neighbor != start && neighbor != goal)
							window.updateNode(neighbor, Color.CYAN);
					}
				}
				
				window.update();
			}
		}
		
		backtrace(window, parent, goal);
	}
	
	public static void bfs(IGraph<IGraphable> graph, int start, int goal)
	{
		GraphArtist window = new GraphArtist(graph);
		window.setDelay(500);
		window.setMessage("Using BFS");
		
		//Mark the start and goal vertexes
		window.updateNode(start, Color.YELLOW);
		window.updateNode(goal, Color.RED);
		window.update();
		
		//Use BFS to find the Shortest Path from Start to Goal
		List<Integer> visited = new ArrayList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		
		//create parent array for backtrace and initialize it to -1
		int[] parent = new int[graph.size()];
		for(int i=0; i< parent.length; i++)
		{
			parent[i] = -1;
		}

		//BFS algorithm!		
		q.add(start);
		while(!q.isEmpty())
		{
			int current = q.remove();
			
			//if current is the goal, stop searching for it!
			if(current == goal)
				break;

			if(!visited.contains(current))
			{
				visited.add(current);
				
				//change color of current (unless it is the start or goal)
				if(current != start && current != goal)
					window.updateNode(current, Color.BLUE);
					
				int[] neighbors = graph.getNeighbors(current);
				for(int neighbor : neighbors)
				{
					if(!visited.contains(neighbor))
					{
						q.add(neighbor);
						parent[neighbor] = current;
						
						//change color of neighbor (unless it is the start or goal)
						if(neighbor != start && neighbor != goal)
							window.updateNode(neighbor, Color.CYAN);
					}
				}
				
				//update the colors
				window.update();
			}
		}
		
		backtrace(window, parent, goal);
	}
	
	public static IGraph<IGraphable> arrayToGraph(int[][] map, int w, int h)
	{
		IGraph<IGraphable> graph = new TestGraph<IGraphable>();
		
		//create verticies
		for(int r = 0; r < map.length; r++)
		{
			for(int c = 0; c < map[r].length; c++)
			{
				IGraphable tile = (map[r][c] == 0)
									? new OpenTile(r, c, w, h)
									: new BlockedTile(r, c, w, h);
				graph.addVertex(tile);
			}
		}
		
		//create edges
		int numRows = map.length;
		for(int r = 0; r < map.length; r++)
		{
			int numCols = map[r].length;
			for(int c = 0; c < map[r].length; c++)
			{
				
				//get index of Vertex at (r, c)
				int index = r * numCols + c;
				IGraphable vertex = graph.getVertex(index);

				//if this vertex is not "open", then ignore it				
				if(!"open".equals(vertex.getLabel())) continue;
				
				//create list to hold all neighbors
				ArrayList<Integer> neighbors = new ArrayList<Integer>();
				
				//Get index of each possible neighbor
				//Use math to convert (r, c) to an index
				if(r < numRows - 1)
					neighbors.add( (r+1) * numCols + (c) );
				if(r > 0)
					neighbors.add( (r-1) * numCols + (c) );
				if(c < numCols - 1)
					neighbors.add( (r) * numCols + (c+1) );
				if(c > 0)
					neighbors.add( (r) * numCols + (c-1) );
				
				//Loop through all neighbors
				for(Integer nIndex : neighbors)
				{
					//get Vertex of neighbor
					IGraphable neighbor = graph.getVertex(nIndex);
					
					//check if neighbor is "open". If so, add edge to it
					if(neighbor != null && "open".equals(neighbor.getLabel()))
					{
						graph.addEdge(index, nIndex);
					}
				}
			}
		}
		
		return graph;
	}
}