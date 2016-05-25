public class main
{
	public static void main(String args[])
	{
		MyLinkedList<String> a = new MyLinkedList<String>();
		a.add("hellO");
		a.add("HI");
		a.add("I");
		a.add("S");
		System.out.println(a);
		System.out.println(a);
		System.out.println(a.set(1, "asdf"));
		System.out.println(a + " SIZE IS : " + a.size());
	//	a.remove(9);
		a.add(0,"hey");
		System.out.println("added: " + a);
		a.remove(0);
		System.out.println("remove: " + a);
		a.remove(3);
		System.out.println("REMOVING LAST THING : " + a);
		a.add(0,"new hey");
		System.out.println("added1111: " + a);
		a.add("SOMETHING");
		System.out.println("NEW" + a);
		a.set(0,"chekced");
		System.out.println("setting at 0: " + a);
		a.set(4,"not chekced");
		System.out.println("setting at last position: " + a);
		
	}
}