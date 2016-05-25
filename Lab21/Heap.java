public interface Heap<E extends Comparable<E>>
{
	public void add(E data);
	public E remove();
	public E peek();
	public boolean isEmpty();
	public int size();
}