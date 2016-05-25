import java.util.List;
import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable<E>> implements IBinarySearchTree<E>
{
	private IBSTNode<E> root;
	
	public static void main(String[] args)
	{
		//Create an instance of a BST to test
		IBinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		//Note: you could make a BST that holds Strings or any other Object that implements the Comparable interface!
		
		//TODO: write code to add Integer objects to your tree to test if it's working correctly!
		tree.add(5);
		tree.add(7);
		tree.add(4);
		tree.add(10);
		tree.add(2);
		tree.add(12);
		tree.add(16);
		tree.add(2);
		tree.add(1);
		//output the value of the toString method of the tree
		System.out.println(tree);
	}
	
	public BinarySearchTree()
	{
		//initlize the root to null (this is an empty Tree!)
		root = null;
	}
	
	public void add(E data)
	{
		//wrap the data in an IBSTNode Object
		IBSTNode<E> node = new BSTNode<E>(data);
		
		//if there is no root, then set this node as the root!
		//otherwise, add this node to the root!
		if(root == null)
			root = node;
		else
			root.add(node);
	}
	
	public int size()
	{
		//TODO: Future Lab
		return -1;
	}
	
	public int height()
	{
		//TODO: Future Lab
		return -1;
	}
	
	public IBSTNode<E> root()
	{
		return root;
	}
	
	public String inOrder()
	{
		//TODO: Future Lab
		return "";
	}
	
	public String postOrder()
	{
		//TODO: Future Lab
		return "";	
	}
	
	public String preOrder()
	{
		//TODO: Future Lab
		return "";
	}
	
	public String toString()
	{
		//check if there are any nodes in the Tree
		if(root == null)
			return "[]";
		
		//Create a String to be returned at end of method
		String ret = "";
		
		//Create a List to hold nodes as we add them to the String
		List<IBSTNode<E>> nodes = new ArrayList<IBSTNode<E>>();
		
		//add the root node to the list of nodes
		nodes.add(root);	
			
		//loop as long as there are nodes in the list of nodes
		while(nodes.size() > 0)
		{
			//remove the first node from the list of nodes
			IBSTNode<E> node = nodes.remove(0);
			
			//add the data of this node to the return String
			ret += ", " + node.toString();
			
			//check if there is a left node, and add it to the list of nodes
			if(node.getLeft() != null)
				nodes.add(node.getLeft());
				
			//check if there is a right node and add it to the list of nodes
			if(node.getRight() != null)
				nodes.add(node.getRight());
		}
		
		//remove the ", " from the front of the String
		ret = ret.substring(2);
		
		//wrap the String in [] brackets
		return "["+ret+"]";
	}
}