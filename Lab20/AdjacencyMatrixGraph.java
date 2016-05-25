import java.util.List;
import java.util.ArrayList;

public class AdjacencyMatrixGraph<E> implements IGraph<E>
{
	boolean[][] matrix;
	List<E> vertexData;
	Integer[][] b;
	public AdjacencyMatrixGraph(){
		vertexData = new ArrayList<E>();
		matrix = new boolean[0][0];
		b = new Integer[0][0];
	}
	public int size()
	{
		return vertexData.size();
	}
	public void addVertex(E data) {
		vertexData.add(data);
		boolean[][] temp;
		Integer[][] temp1;
		if(matrix.length==0){
			 temp = new boolean[1][1];
			 temp1 = new Integer[1][1];
		}
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
	public void addEdge(int v1, int v2, boolean directed){
		matrix[v1][v2] = directed;
	}
	public int getWeight(int v1, int v2){
		return b[v1][v2];	
	}
    public void addEdge(int v1, int v2, int weight){
    	b[v1][v2] = weight;
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
	public int[] getNeighbors(int index, int max){
		return new int[2];
	}
}