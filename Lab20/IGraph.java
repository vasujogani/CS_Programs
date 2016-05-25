import java.util.List;

public interface IGraph<E>
{
	void addVertex(E data);
	void addEdge(int v1, int v2);
	void removeEdge(int v1, int v2);
	E getVertex(int index);
	List<E> getVerticies();
	int[] getNeighbors(int index);
	int size();
	void addEdge(int v1, int v2, int weight);
	int getWeight(int v1, int v2);
	int[] getNeighbors(int index, int maxWeight);
}