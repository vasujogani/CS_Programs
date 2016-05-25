public class MyDoubleLinkedList<E> implements IList<E>
{
	Node<E> head;
	Node<E> tail;
	public MyDoubleLinkedList()
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
		Node<E> node = new Node(obj, null,null);
		if(this.size()==0)
		{
			tail = node;
			head = node;
		}
		else
		{
			tail.setNext(node);
			tail = node;
			tail.setPrev(node);
		}
		return true;
	}
	public void add(int index, E obj){
		if(index>this.size() || index < 0)
			throw new IndexOutOfBoundsException("Index was out of bound");
		Node<E> node = head;
		Node<E> a = new Node(obj, null,null);
		if(node==null)
		{
			head = a; 
			tail = a;
		}
		else if(index == 0)
		{
			a.setNext(node);
			head = a;
			node.setPrev(a);
		}
		else
		{
			for(int i = 0; node!=null && i < index-1; i++)
			{
				node = node.getNext();
			}
			if(node==null)
				System.out.println("AT LAST INDEX");
			a.setNext(node.getNext());
			tail = a.getNext();
			if(tail == null)
				System.out.println("Tail is null");
			node.setNext(a);
			a.setPrev(node);
			if(a.getNext() == null)
				System.out.println("Last index is null");
		}
	}
	public E set(int index, E obj){
		if(index>=this.size() || index < 0)
			throw new IndexOutOfBoundsException("Index was out of bound");
		Node<E> node = head;
		Node<E> temp;
		Node<E> a = new Node(obj, null,null);
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
		if(this.size()==1)
		{
			temp = head;
			head = null; 
			tail = null;
			return temp.getData();
		}
		if(index==0)
		{	
			temp = head;
			head = temp.getNext();
			head.setPrev(null);
			return temp.getData();
		}
		for(int i = 0; node!=null && i < index-1; i++)
		{
			node = node.getNext();
		}
		temp = node.getNext();
		if(temp.getNext()==null)
		{
			tail = node;
			tail.setNext(null);
			return temp.getData();
		}
		node.setNext(temp.getNext());
		(temp.getNext()).setPrev(temp.getPrev());
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
	class Node<E>
	{
		Object data;
		Node<E> next;	
		Node<E> prev;
		public Node(E d, Node<E> n, Node<E> p)
		{
			data = d;
			next = n;
			prev = p;
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
		public void setPrev(Node<E> n)
		{
			prev = n;
		}
		public Node<E> getPrev()
		{
			return prev;
		}
	}
}