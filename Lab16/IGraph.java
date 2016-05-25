import java.util.List;

public interface IGraph<E>
{
	void addVertex(E data);
	void addEdge(int v1, int v2);
	E removeVertex(int index);
	void removeEdge(int v1, int v2);
	E getVertex(int index);
	List<E> getVerticies();
	int[] getNeighbors(int index);
}