public class BSTNode<E extends Comparable<E>> implements IBSTNode<E>
{
	private E data;
	private IBSTNode<E> left, right;
	
	public BSTNode(E data)
	{
		this.data = data;
		left = null;
		right = null;
	}
	
	public IBSTNode<E> getRight()
	{
		return right;
	}
	public IBSTNode<E> getLeft()
	{
		return left;
	}
	public E getData()
	{
		return data;
	}
	public void setLeft(IBSTNode<E> node)
	{
		left = node;
	}
	public void setRight(IBSTNode<E> node)
	{
		right = node;
	}
	public void add(IBSTNode<E> node)
	{
		if(this.compareTo(node)<=0)
		{
			if(right==null)
				setRight(node);
			else
				right.add(node);
		}
		else
		{
			if(left==null)
				setLeft(node);
			else
				left.add(node);
		}
	}
	public int compareTo(IBSTNode<E> other)
	{
		return data.compareTo(other.getData());
	}
	public String toString()
	{
		return data.toString();	
	}
}