import java.util.Scanner;
import java.lang.Math.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Stack;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class Runner 
{

    public static void main(String[] args)
	{		
		//Create a Graph
		Runner ab = new Runner();
		IGraph<IGraphable> graph = new AdjacencyMatrixGraph<IGraphable>();
		int[] a = new int[29];
		int[] b = new int[29];
		String[] c = new String[29];
		File file = new File("states.txt");
		if(file.exists())
			System.out.println("FILE DOES  EXIST");
		try
		{
			if(file.exists()) {
				Scanner reader = new Scanner(file);
				int count=0;
				while(reader.hasNextLine())
				{		    
					String line = reader.nextLine();	
					System.out.println(line);
		    		a[count] = Integer.parseInt(line.substring(0,line.indexOf(",")));
		    		b[count] = Integer.parseInt(line.substring(line.indexOf(",")+2,line.lastIndexOf(" ")));
		    		c[count] = line.substring(line.lastIndexOf(" ")+1, line.length());
		    		count++;
				}
					reader.close();										
			}
		}
		catch(FileNotFoundException e)
    	{
    		System.out.println("An error occured!");
    		e.printStackTrace();	
    	}			
		
		//Add Verticies and Edges to Graph (using Location Object as data)
/*		for(int i = 0; i < a.length; i++)
		{
			graph.addVertex(new Location(a[i],b[i], c[i]));
		}
		
		//Create the GraphArtist JFrame
		GraphArtist window = new GraphArtist(graph);
*/		
		//update the Graph using these commands:
/*		int rand;
		for(int i = 0; i < 29; i++)
		{
			rand = (int)(Math.random()*28);
			graph.addEdge(i, rand);
		}
*/		
	//	ab.dfs(window, 22,graph);
	//	ab.makeGrid(4,5,100,true);
		ab.makeMaze(25,25,13);
	

	}
	 public static int dfs(GraphArtist g, int v, IGraph gp)
	 {
	 	List<Integer> discovered = new ArrayList<Integer>();
	 	Stack<Integer> s = new Stack<Integer>();
	 	s.push(v);
	 	while(!s.isEmpty())
	 	{
	 		v = s.pop();
	 		if(!discovered.contains(v))
	 		{
	 			discovered.add(v);
	 			g.updateNode(v, Color.RED);
	 			g.update();
	 			int[] c = gp.getNeighbors(v);
	 			for(int i = 0; i < gp.getNeighbors(v).length; i++)
	 			{
	 				s.push(c[i]);
	 			}
	 		}
	 	}
	 	return -1;
	 	
	 }
	public static IGraph makeGrid(int row, int col, int distance, boolean connected)
	{
		
		IGraph<IGraphable> grid = new AdjacencyMatrixGraph<IGraphable>();
		GraphArtist window2 = new GraphArtist(grid);
		for(int i =0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
			{
				grid.addVertex(new Location(distance*i+20, distance*j+20));
			}
		}
		if(connected)
		{ 
			int count = 0;
		System.out.println("NUMBER OF ROWS ARE : " + row);
			for(int i =0; i < row*col; i+=col)
			{
				for(int j = 0; j < col-1; j++)
				{
					grid.addEdge(i+j,i+j+1);
				}
			}
			for(int j = 0; j<(row*col)-(col);j++)
			{
				grid.addEdge(j, j+col);
			}
		}
		return grid;
	}
	
	public static void makeMaze(int row, int col, int v)
	{
		
		IGraph<IGraphable> g = makeGrid(row,col,30,false);
		IGraph<IGraphable> grid = makeGrid(row,col,30,true);
		Stack<Integer> s = new Stack<Integer>();
		List<Integer> visited = new ArrayList<Integer>();
		GraphArtist window3 = new GraphArtist(g);
		visited.add(v);
		int current = v;
		boolean visit = true;
		while(visited.size()!=grid.getSize())
		{
			int[] c = grid.getNeighbors(current);
			int count = 0;
			visit = true;
			for(int i = 0; i < grid.getNeighbors(current).length; i++)
				if(!visited.contains(c[i]))
				{
					visit = false;
					count++;
				}
			System.out.println("The size of the visited is : " + visited.size() + " visit is : " + visit);
			if(!visit)
			{
				int[] unv = new int[count];
				count = 0;
				for(int i = 0; i < grid.getNeighbors(current).length; i++)
					if(!visited.contains(c[i]))
					{
						unv[count] = c[i];
						count++;
					}
				System.out.println("The size of the unvisisted list is : " + unv.length + "  count is : "+count); 
				int chosen = unv[(int)(Math.random()*count)];
				s.push(current);
				g.addEdge(current,chosen);
				window3.updateEdge(current, chosen, Color.RED);
				window3.update();
				current = chosen;
				visited.add(current);
			}
			else
				current = s.pop();
		}
		System.out.println("MAZE IS BUILT!");
		
	}
}