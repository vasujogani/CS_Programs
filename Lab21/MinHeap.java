import java.util.List;
import java.util.ArrayList;

public class MinHeap<E extends Comparable<E>> implements Heap<E>
{
	private List<E> nodes; //Keep track of the nodes in the Heap
	
	//Initialize the instance variable
	public MinHeap()
	{
		nodes = new ArrayList<E>();	
	}
	
	//Add the specified data to the heap
	//Make sure the Heap still meets all of the requirements of being a Heap
	@Override
	public void add(E data)
	{

			nodes.add(data);
			int node = nodes.size()-1;
			int temp;
			while((this.getParent(node))>=0 && nodes.get(node).compareTo(nodes.get(this.getParent(node)))<0)
			{
				temp = this.getParent(node);
				this.swapParent(node);
				node = temp;
			}		
	}
	
	//Return whether there are any nodes in this heap
	@Override
	public boolean isEmpty()
	{
		return (nodes.size()>0)?false: true;
	}
	
	//Return the number of nodes in this Heap
	@Override
	public int size()
	{
		return nodes.size();
	}
	
	//Remove the head of the heap, make sure the heap still meets the requirements of being a heap:
	//	1. All nodes are smaller than their children
	//	2. Heap is built top to bottom, left to right
	//Return the data that was removed from the head.
	//Return null if the Heap is empty
	@Override
	public E remove()
	{
	//	System.out.println("Removing from nodes: " + nodes);
		if(this.size()==0)
			return null;
		else
		{
			E temp1 = nodes.get(0);
		//	System.out.println("temp1 is : " +temp1+ " nodes size : " + nodes.size());
			nodes.set(0, nodes.get(nodes.size()-1));
			nodes.remove(nodes.size()-1);
		//	System.out.println("Nodes after setting: " + nodes);
			int track = 0;
			int temp = 0;
			while(this.getSmallestChild(track)>-1&&(nodes.get(track).compareTo(nodes.get(this.getSmallestChild(track))))>0)
			{
		//		System.out.println("track is: " + track+ " nodes' size is :" + nodes.size() + "this.getSmallestChild(track) is : " + this.getSmallestChild(track));
				temp = this.getSmallestChild(track);
				this.swapParent(this.getSmallestChild(track));
				track = temp;

			}
			return temp1;	
		}
	}
	
	//Return, but do not remove, the head of the heap
	//If the heap is empty, return null
	@Override
	public E peek()
	{
		return (nodes.size()>0)?nodes.get(0):null;
	}
	public int root()
	{
		int low = 0;
		for (int i = 0; i < nodes.size()-1; i++)
		{
			if(nodes.get(i).compareTo(nodes.get(i+1))<0)
				low = i;
		}
		return low;
	}
	
	//Return the value stored at the specified index of the heap
	//Return null if the index is out of bounds
	public E getValue(int index)
	{
		return (index<nodes.size()&&index>=0)?nodes.get(index): null;
	}
	
	//return the index of the parent of the specified node
	//Use the formula i -> floor((i-1)/2)
	//Return -1 if there is no parent.
	public int getParent(int index)
	{
		if(index==0)
			return -1;
		return (index-1)/2;
	}
	
	//swap the values of the node at the specified index and its parent
	public void swapParent(int index)
	{
		E temp = nodes.get(index);
		int parentInt  =this.getParent(index);
		nodes.set(index, nodes.get(this.getParent(index)));
		nodes.set(parentInt,temp);
		
	}
	
	//return the index of the smallest child of the node at the specified index
	//Use the formula i -> 2i+1, 2i+2
	//Return -1 if there is no qualifying "smallest child"
	//If both children are equal, return the left child
	public int getSmallestChild(int index)
	{
		if((index*2+1)>(nodes.size()-1))
			return -1;
		boolean present = true;
		if((index*2+2)>(nodes.size()-1))
			present = false;	
		E left = nodes.get(index*2+1);
		E right;
		if(present)
		{
			right = nodes.get(index*2+2);
		}
		else 
			return index*2+1;
		if(right.compareTo(left)<0)
			return index*2+2;
		else
			return index*2+1;
	}
}