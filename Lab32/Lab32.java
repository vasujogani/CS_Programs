import java.util.List;
import java.util.LinkedList;
import java.util.Random;

public class Lab32
{
	public static void main(String[] args)
	{
		int mrMayId = 123;
		int notMrMayId = 456;
		
		//String name, int period, int teacherId, int numStudents
		Subject s1 = new Subject("Subject 1", 1, mrMayId, 25); 
		Subject s2 = new Subject("Subject 2", 2, mrMayId, 22);
		Subject s3 = new Subject("Subject 3", 3, mrMayId, 31);
		Subject s4 = new Subject("Subject 4", 1, notMrMayId, 15);
		Subject s5 = new Subject("Subject 5", 3, notMrMayId, 24);
		
		System.out.println("Subject objects created:");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s5);
		
		System.out.println("\nCreate Subject->Name Mapping");
		IMap<Subject, String> map = new MyHashMap<Subject, String>();
		
		System.out.println("Size should be 0, it is: "+map.size());
		System.out.println("isEmpty should be true, it is: "+map.isEmpty());
		
		System.out.println("\nAdd several elements");
		map.put(s1, s1.getName());
		map.put(s2, s2.getName());
		map.put(s3, s3.getName());
		map.put(s4, s4.getName());
		map.put(s5, s5.getName());
		
		System.out.println("Size should be 5, it is: "+map.size());
		System.out.println("isEmpty should be false, it is: "+map.isEmpty());
		
		System.out.println("\nRemove an element");
		String str = map.remove(s3);
		
		System.out.println("Size should be 4, it is: "+map.size());
		System.out.println("isEmpty should be false, it is: "+map.isEmpty());
		System.out.println("Removed element should be 'Subject 3', it is: " +str);
		
		System.out.println("\nRemove all elements");
		map.remove(s1);
		map.remove(s2);
		map.remove(s4);
		map.remove(s5);
		
		System.out.println("Size should be 0, it is: "+map.size());
		System.out.println("isEmpty should be true, it is: "+map.isEmpty());
		
		System.out.println("\nCreate a whole bunch of elements to force a hash collision");
		
		Random r = new Random();
		List<Subject> subjects = new LinkedList<Subject>();
		int n = 10000;
		for(int i=0; i<n; i++)
		{
			String name = "Subject " + i;
			int period = i % 8 + 1;
			int teacherId = i % 15 + 1;
			int numStudents = 15 + r.nextInt(15);
			Subject s = new Subject(name, period, teacherId, numStudents);
			map.put(s, s.getName());
		}
		
		System.out.println("Size should be "+n+", it is: "+map.size());
		System.out.println("isEmpty should be false, it is: "+map.isEmpty());
	}
}