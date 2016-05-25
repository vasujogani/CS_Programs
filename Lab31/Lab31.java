public class Lab31
{
	public static void main(String[] args)
	{
		ISet<String> mySet = new ListSet<String>();
		
		System.out.println("size: " 		+ mySet.size() 			+ " should be 0");
		System.out.println("isEmpty: " 		+ mySet.isEmpty() 		+ " should be true");
		System.out.println("add ranma: " 	+ mySet.add("ranma") 	+ " should be true");
		System.out.println("isEmpty: " 		+ mySet.isEmpty() 		+ " should be false");
		System.out.println("add akane: " 	+ mySet.add("akane") 	+ " should be true");
		System.out.println("size: " 		+ mySet.size() 			+ " should be 2");
		System.out.println("add ranma: " 	+ mySet.add("ranma") 	+ " should be false");
		System.out.println("size: " 		+ mySet.size() 			+ " should be 2");
		System.out.println("remove ryoga: " + mySet.remove("ryoga") + " should be false");
		System.out.println("size: " 		+ mySet.size() 			+ " should be 2");
		System.out.println("remove ranma: " + mySet.remove("ranma") + " should be true");
		System.out.println("size: " 		+ mySet.size() 			+ " should be 1");
		System.out.println("isEmpty: " 		+ mySet.isEmpty() 		+ " should be false");
		System.out.println("add ranma: " 	+ mySet.add("ranma") 	+ " should be true");
		System.out.println("size: " 		+ mySet.size() 			+ " should be 2");
		
	}
}