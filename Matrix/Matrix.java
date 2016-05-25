/*
 *@(#)Matrix.java
 *
 *@Vasu Jogani
 *@6th period
 *@Matrix
 *@version 1.00 2015/10/8
 */
public class Matrix
{
	public static void main(String args[]){
		Matrix a = new Matrix(2,3);
		Matrix b = new Matrix(3,2);
		for(int r = 0; r < 2; r++)
			for(int c = 0; c < 3; c++)
			{
				int x = 3*r+c+1;
				a.set(r,c,x);
			}	
		for(int r = 0; r < 3; r++)
			for(int c = 0; c < 2; c++)
			{
				int x = 2*r+c+7;
		//		int x = 3*r+c+1;
				b.set(r,c,x);
			}
			System.out.println(a);
			System.out.println();
			System.out.println(b);
			boolean same = a.equals(b);
			Matrix c = a.multiply(b);
			System.out.println(c);
		
	}
	
	private int[][] data;
	public Matrix(int rows, int cols){
		data = new int[rows][cols];			
	}
	
	public int set(int row, int col, int val){
		if(row>this.numRows() || row < 0 || col > this.numCols() || col < 0)
			throw new IndexOutOfBoundsException("Row/Col is out of bound");
		int old_val = data[row][col];
		data[row][col] = val;
		return old_val;
	}
	
	public int numRows(){
		return data.length;
	}
	
	public int numCols(){
		return data[0].length;
	}
	
	public Matrix multiply(Matrix m){
		Matrix a = new Matrix(this.numRows(), m.numCols());
		
		if(this.numCols()==m.numRows())
		{
			int answer = 0;
			for(int r = 0; r < a.numRows(); r++)
			{
				for(int c = 0; c < a.numCols(); c++)
				{
				answer = 0;
				for(int i = 0; i < this.numCols(); i++)
				{
					answer = (this.get(r,i) * m.get(i,c))+answer;
				
				}
					a.set(r,c,answer);
				}
			}
		}
		else
		throw new ArithmeticException("matrices can't be multiplied");
		return a;
	}
	
	public Matrix add(Matrix m){
		boolean same = false;
		if(m.numRows()==this.numRows()&& m.numCols()==this.numCols())
			same = true;
		else 
			throw new ArithmeticException("Matrices aren't the same size");
		Matrix a;
		if(same){
			a = new Matrix(this.numRows(), this.numCols());
			for(int r = 0; r < m.numRows(); r++)
				for(int c = 0; c < m.numCols(); c++){
					int sum = this.get(r,c) + m.get(r,c);
						a.set(r,c,sum);
				}
		}
		else{
			a = new Matrix(this.numRows(), this.numCols());
				for(int r = 0; r < a.numRows(); r++)
					for(int c = 0; c < a.numCols(); c++)
						a.set(r,c,-1);
		}
		return a;
	}
	
	public Matrix subtract(Matrix m){
		boolean same = false;
		if(m.numRows()==this.numRows()&& m.numCols()==this.numCols())
			same = true;
		else 
			throw new ArithmeticException("Matrices aren't the same size");
		Matrix a;
		if(same){
			a = new Matrix(this.numRows(), this.numCols());
			for(int r = 0; r < m.numRows(); r++)
				for(int c = 0; c < m.numCols(); c++){
					int sum = this.get(r,c) - m.get(r,c);
						a.set(r,c,sum);
				}
		}
		else{
			a = new Matrix(this.numRows(), this.numCols());
				for(int r = 0; r < a.numRows(); r++)
					for(int c = 0; c < a.numCols(); c++)
						a.set(r,c,-1);
		}
		return a;
	}
	
	public Matrix scale(int s){
		Matrix a = new Matrix(this.numRows(), this.numCols());
		for(int r = 0; r < this.numRows(); r++)
			for(int c = 0; c < this.numCols(); c++)
				a.set(r,c,this.get(r,c)*s);
		return a;
	}
	
	public boolean equals(Matrix m){
		boolean same = true;
		if(m.numRows()==this.numRows()&& m.numCols()==this.numCols())
		{
			for(int r = 0; r < m.numRows(); r++)
				for(int c = 0; c < m.numCols(); c++)
					if(this.get(r,c)!=m.get(r,c))
						same = false;
		}
		else 
			return false;
		return same;
	}
	
	public boolean equals(Object o)
	{
 		 if(o instanceof Matrix) return equals((Matrix)o);
 		 return false;
	}
	public int get(int row, int col)
	{
		if(row>this.numRows() || row < 0 || col > this.numCols() || col < 0)
			throw new IndexOutOfBoundsException("Row/Col is out of bound");
		return data[row][col];
	}
	
	public String toString()
	{
		String matrix  = "";
		for(int r = 0; r < this.numRows(); r++){
			for(int c = 0; c < this.numCols(); c++){
				matrix = matrix + this.get(r,c) ;
				if(c!=this.numCols()-1)
					matrix = matrix + "\t";
			}
			matrix = matrix + "\n";
		}
		return matrix;
	}
	
}