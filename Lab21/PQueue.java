public class PQueue<E extends Comparable<E>>
{
	private Heap<E> heap;
	
	//Initialize the instance variable
	public PQueue()
	{
		heap  = new MinHeap<E>();	
	}
	
	//Add the specified data to this Priority Queue
	public void add(E data)
	{
		heap.add(data);
	}
	
	//Remove and return the head of the Priority Queue
	public E remove()
	{
		return heap.remove();
	}
	
	//Return, but do not remove, the head of the Priority Queue
	public E peek()
	{
		return heap.peek();
	}
	
	//Return whether this Priority Queue is empty or not
	public boolean isEmpty()
	{
		return heap.isEmpty();
	}
	
	//Return the number of elements in this Priority Queue
	public int size()
	{
		return heap.size();
	}
}