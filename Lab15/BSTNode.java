public class BSTNode<E extends Comparable<E>> implements IBSTNode<E>
{
	private E data;
	private IBSTNode<E> left, right;
	private String a;
	
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
		if(node.compareTo(this)>0)
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
	public void inOrder()
	{
		if(this.getLeft()!=null){
			left.inOrder();
		}
		System.out.print(this.getData());
		if(this.getRight()!=null){
			right.inOrder();
		}
	}
	public void preOrder()
	{
		System.out.print( this.getData());
		if(this.getLeft()!=null){
			left.inOrder();
		}
		if(this.getRight()!=null){
			right.inOrder();
		}
	}
	public void postOrder()
	{
		if(this.getLeft()!=null){
			left.inOrder();
		}
		if(this.getRight()!=null){
			right.inOrder();
		}
		System.out.print( this.getData());
	}
	public boolean contains(E data)
	{
		if(this.getData().compareTo(data)==0)
		{
			return true;
		}
		if(data.compareTo(this.getData())>0)
			return (this.getRight()==null)?false:this.getRight().contains(data);
		return (this.getLeft()==null)?false:this.getLeft().contains(data);
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