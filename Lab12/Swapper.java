import java.util.List;
import java.util.LinkedList;

public class Swapper
{
	public static void quicksort(List<Comparable> A)
	{
		quicksort(A, 0 , A.size()-1);
	}
	public static void quicksort(List<Comparable> B, int lo, int hi)
	{
		int p = 0;
		if(lo<hi)
		{
			p = partition(B,lo,hi);
			quicksort(B, lo, p-1);
			quicksort(B, p+1, hi);
		}
	}
	public static int partition(List<Comparable> x, int lo, int hi)
	{
		Object pv = x.get(hi);
		int pi = lo;
		for(int j = lo; j < hi; j++)
		{
			if(x.get(j).compareTo(pv)<=0)
			{
				swap(x,pi,j);
				pi+=1;
			}
		}
		swap(x, pi, hi);
		return pi;
	}
	public static void quicksort2(List<Comparable> A)
	{
		quicksort(A, 0 , A.size()-1);
	}
	public static void quicksort2(List<Comparable> B, int lo, int hi)
	{
		int p = 0;
		if(lo<hi)
		{
			p = partition2(B, lo, hi);
			quicksort2(B, lo, p);
			quicksort2(B, p+1, hi);
		}
	}

	public static int partition2(List<Comparable> B, int lo, int hi)
	{
		Object pivot = B.get(lo);
		int i = lo-1;
		int j = hi+1;
		while(true)
		{
			do
			{
				j = j -1;
			}while(B.get(j).compareTo(pivot)>0);
			do
			{
				i = i + 1;
			}while(B.get(i).compareTo(pivot)<0);
			if(i<j)
				swap(B,i,j);
			else
				return j;
		}
	}
	
	public static void swap(List x, int a, int b)
	{
		Object temp = x.get(a);
		x.set(a, x.get(b));
		x.set(b,temp);
	}
}
