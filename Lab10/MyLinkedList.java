public class MyLinkedList<E> implements IList<E>
{
	Node<E> head;
	Node<E> tail;
	public MyLinkedList()
	{
		head = null;;
		tail = null;
	}
	public int size(){
	int count = 0;
		Node<E> node = head;
		while(node != null)
		{
			count++;
			node = node.getNext();
		}
	return count;	
	}
	public boolean add(E obj){
		Node<E> node = new Node(obj, null);
		if(this.size()==0)
		{
			tail = node;
			head = node;
		}
		else
		{
			tail.setNext(node);
			tail = node;
		}
		return true;
	}
	public void add(int index, E obj){
		Node<E> node = head;
		Node<E> a = new Node(obj, null);
		if(index>this.size() || index < 0)
			throw new IndexOutOfBoundsException("Index was out of bound");
		
		for(int i = 0; node!=null && i < index; i++)
		{
			node = node.getNext();
		}
		a.setNext(node);
		if(index == 0)
			head = a;
		else{
			node = head;
			for(int i = 0; node!=null && i < index - 1; i++)
			{
				node=node.getNext();
			}
			node.setNext(a);
		}
	}
	public E set(int index, E obj){
		if(index>=this.size() || index < 0)
			throw new IndexOutOfBoundsException("Index was out of bound");
		Node<E> node = head;
		Node<E> temp;
		Node<E> a = new Node(obj, null);
		if(index==0)
		{
			node = node.getNext();
			temp = head;
			head = a;
			head.setNext(node);
			return temp.getData();
		}
		for(int i = 0; node!=null && i < index; i++)
		{
			node = node.getNext();
		}
		temp = node;
		node.setData(obj);
		return temp.getData();
	}
	
	public E get(int index){
	if(index>=this.size() || index < 0)
			throw new IndexOutOfBoundsException("Index was out of bound");
	Node<E> node = head;
	for(int i = 0; node != null && i < index; i++)
		node = node.getNext();
	return node == null ? null : node.getData();
	}
	public E remove(int index){
		if(index>=this.size() || index < 0)
			throw new IndexOutOfBoundsException("Index was out of bound");
		Node<E> node = head;
		Node<E> temp;
		for(int i = 0; node!=null && i < index - 1; i++)
		{
			node = node.getNext();
		}
		if(index==0)
		{	
			temp = head;
			head = temp.getNext();
			return temp.getData();
		}
		temp = node.getNext();
		if(temp.getNext() == null)
		{
			tail = node;
		}
		node.setNext(temp.getNext());
		
		return temp.getData();
	}
	public String toString(){
		String s = "[";
		if(head!=null){
			Node<E> node = head;
			while (node.getNext()!=null)
			{
				s += node.getData()+", ";
				node = node.getNext();
			}
			s+=node.getData()+ "]";
		}
		else
			s+="]";
		return s;
	}
}
class Node<E>
{
	Object data;
	Node<E> next;	
	public Node(E d, Node<E> n)
	{
		data = d;
		next = n;
	}
	public void setData(E obj)
	{
		data = obj;
	}
	public E getData()
	{
		return (E)data;
	}
	public void setNext(Node<E> n)
	{
		next = n;
	}
	public Node<E> getNext()
	{
		return next;
	}
}