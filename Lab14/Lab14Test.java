public class Lab14Test
{	
	public static void main(String[] args)
	{
		Lab14Test tester = new Lab14Test();
		tester.testEmpty();
		tester.testAdd();
		tester.testAdd2();
		tester.testAdd3();
		tester.testAdd4();
		tester.testAdd5();
	}
	
	private void assertEquals(Object a, Object b, String label)
	{
		System.out.print(label+"...");
		if(!a.equals(b))
		{
			System.out.println("failed");
			System.out.println("\tExpected:\t"+a);
			System.out.println("\tFound:\t"+b);
			System.out.println();
		}
		else
		{
			System.out.println("passed!");
		}
	}
	
	public void testEmpty()
	{
		IBinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		assertEquals("[]", tree.toString(), "testEmpty");
	}
	
	public void testAdd()
	{
		IBinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.add(5);
		assertEquals("[5]", tree.toString(), "testAdd");
	}
	
	public void testAdd2()
	{
		IBinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.add(5);
		tree.add(8);
		assertEquals("[5, 8]", tree.toString(), "testAdd2");
	}
	
	public void testAdd3()
	{
		IBinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.add(5);
		tree.add(8);
		tree.add(3);
		assertEquals("[5, 3, 8]", tree.toString(), "testAdd3");
	}
	
	public void testAdd4()
	{
		IBinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.add(5);
		tree.add(8);
		tree.add(3);
		tree.add(6);
		assertEquals("[5, 3, 8, 6]", tree.toString(), "testAdd4");
	}
	
	public void testAdd5()
	{
		IBinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.add(5);
		tree.add(8);
		tree.add(3);
		tree.add(6);
		tree.add(1);
		assertEquals("[5, 3, 8, 1, 6]", tree.toString(), "testAdd5");
	}
}