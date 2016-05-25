import java.util.List;
import java.util.ArrayList;

public class AdjacencyListGraph<E> implements IGraph<E>
{
	List<E> vertexData;
	List<ArrayList<Integer>> AdjacencyList;
	
	public AdjacencyListGraph()
	{
		vertexData = new ArrayList<E>();
		AdjacencyList = new ArrayList<ArrayList<Integer>>();
	}
	public void addVertex(E data) {
		vertexData.add(data);
		AdjacencyList.add(new ArrayList<Integer>());
	}
	public void addEdge(int v1, int v2) {
		if(!AdjacencyList.get(v1).contains(v2))
		{
			AdjacencyList.get(v1).add(v2);
			AdjacencyList.get(v2).add(v1);
		}
	}
	public E removeVertex(int index) {
		for(int i = 0; i < AdjacencyList.size(); i++)
		{
			if(AdjacencyList.get(i).contains(index))
				AdjacencyList.get(i).remove(new Integer(index));
		}
//		AdjacencyList.remove(index);
		return vertexData.remove(index);
	}
	public void removeEdge(int v1, int v2) {
		if(AdjacencyList.get(v1).contains(v2))
		{
			AdjacencyList.get(v1).remove(new Integer(v2));
			AdjacencyList.get(v2).remove(new Integer(v1));
		}
	}
	public E getVertex(int index) {
		return (index<vertexData.size()) ? vertexData.get(index) : null;
	}
	public List<E> getVerticies() {
		return vertexData;
	}
	public int[] getNeighbors(int index) {
		int[] a = new int[AdjacencyList.get(index).size()];
		for(int i = 0; i < AdjacencyList.get(index).size(); i++)
			a[i] = AdjacencyList.get(index).get(i);
		return a;
	}
}