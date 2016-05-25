public interface IBinarySearchTree<E extends Comparable<E>>
{
	void add(E data);
	int size();
	int height();
	IBSTNode<E> root();
	void inOrder();
	void postOrder();
	void preOrder();
	boolean contains(E data);
}