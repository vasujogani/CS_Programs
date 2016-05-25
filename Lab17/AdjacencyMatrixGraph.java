import java.util.List;
import java.util.ArrayList;

public class AdjacencyMatrixGraph<E> implements IGraph<E>
{
	boolean[][] matrix;
	List<E> vertexData;
	public AdjacencyMatrixGraph(){
		vertexData = new ArrayList<E>();
		matrix = new boolean[0][0];
	}
	public void addVertex(E data) {
		vertexData.add(data);
		boolean[][] temp;
		if(matrix.length==0)
			 temp = new boolean[1][1];
		else
			{
			temp = new boolean[matrix.length+1][matrix.length+1];
			for(int i = 0; i < temp.length-1; i++)
			{
				for(int j = 0; j < temp[0].length-1; j++)
				{
						temp[i][j] = matrix[i][j];
				}
			}
		}
		matrix = temp;
	}
	public void addEdge(int v1, int v2) {
		matrix[v1][v2] = true;
		matrix[v2][v1] = true;
	}
	public void removeEdge(int v1, int v2) {
		matrix[v1][v2] = false;
		matrix[v2][v1] = false;
	}
	public E getVertex(int index) {
		return vertexData.get(index);
	}
	public List<E> getVerticies() {
		return vertexData;
	}
	public int[] getNeighbors(int index) {
		int count = 0;
		for(int i = 0; i < matrix[index].length; i++)
		{
			if(matrix[index][i]==true)
				count++;
		}
		int[] a = new int[count];
		int c1 = 0;
		for(int i = 0; i < matrix[index].length; i++)
		{
			if(matrix[index][i]==true)
			{
				a[c1] = i;
				c1++;
			}
		}
		return a;
	}
}