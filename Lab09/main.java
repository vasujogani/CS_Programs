public class main
{
	public static void main(String args[])
	{
		MyArrayList<String> myarr = new MyArrayList<String>(2);
		myarr.add("a");
		myarr.add("s");
		myarr.add("d");
		myarr.add("f");
		myarr.add("g");
		myarr.add(0,"h");
		myarr.remove(0);
		System.out.println(myarr.get(2));
		System.out.println(myarr);
	}
}