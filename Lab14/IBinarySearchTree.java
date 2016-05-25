public interface IBinarySearchTree<E extends Comparable<E>>
{
	void add(E data);
	int size();
	int height();
	IBSTNode<E> root();
	String inOrder();
	String postOrder();
	String preOrder();
}