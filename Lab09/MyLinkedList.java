public class MyLinkedList<E> implements IList<E>
{
	Node<E> head;
	Node<E> tail;
	public MyLinkedList()
	{
		head = null;
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
		tail.setNext(node);
		tail = node;
		return true;
	}
	public void add(int index, E obj){
		Node<E> node = head;
		Node<E> a = new Node(obj, null);
		for(int i = 0; node!=null && i < index; i++)
		{
			node.getNext();
		}
		a.setNext(node);
		node = head;
		for(int i = 0; node!=null && i < index - 1; i++)
		{
			node.getNext();
		}
		node.setNext(a);
	}
	public E set(int index, E obj){
		Node<E> node = head;
		Node<E> temp;
		Node<E> a = new Node(obj, null);
		for(int i = 0; node!=null && i < index; i++)
		{
			node.getNext();
		}
		temp = node;
		node = node.getNext();
		a.setNext(node);
		node = head;
		for(int i = 0; node!=null && i < index - 1; i++)
		{
			node.getNext();
		}
		node.setNext(a);
		return temp.getData();
	}
	
	public E get(int index){
	Node<E> node = head;
	for(int i = 0; node != null && i < index; i++)
		node = node.getNext();
	return node == null ? null : node.getData();
	}
	public E remove(int index){
		Node<E> node = head;
		Node<E> temp;
		for(int i = 0; node!=null && i < index - 1; i++)
		{
			node.getNext();
		}
		temp = node.getNext();
		node.setNext(temp.getNext());
		return temp.getData();
	}
	public String toString(){
		return "MY PROGRAM IS BAD";
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