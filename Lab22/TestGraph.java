import java.util.*;

public class TestGraph<E> implements IGraph<E>
{
	List<List<Integer>> adjList;
	List<E> verticies;
	
    public TestGraph() 
    {
    	verticies = new ArrayList<E>();
    	adjList = new ArrayList<List<Integer>>();
    }
    
    public int size()
    {
    	return verticies.size();
    }
    
    public int getWeight(int v1, int v2)
    {
    	return 1;
    }
    
    public void addVertex(E data)
    {
    	verticies.add(data);
    	adjList.add(new ArrayList<Integer>());
    }
    
	public void addEdge(int v1, int v2)
	{
		adjList.get(v1).add(v2);
		adjList.get(v2).add(v1);
	}
	
	public void removeEdge(int v1, int v2)
	{
		
	}
	
	public E getVertex(int index) 
	{
		if(index < 0 || index >= verticies.size())
		{
			return null;
		}
		
		return verticies.get(index);
	}
	
	public List<E> getVerticies()
	{
		return verticies;	
	}
	
	public int[] getNeighbors(int index)
	{
		List<Integer> neighbors = adjList.get(index);
		int[] ret = new int[neighbors.size()];
		for(int i=0; i<neighbors.size(); i++)
			ret[i] = neighbors.get(i);
		return ret;
	}
}