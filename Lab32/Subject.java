/**
 *	Represents a subject being taught.
 *	A particular subject is taught by a specific teacher 
 *	during a specific period and it has some number of students.
 */
public class Subject 
{
	private String name;
	private int teacherId;
	private int numStudents;
	private int period;
	
	public Subject(String name, int period, int teacherId, int numStudents)
	{
		this.name = name;
		this.teacherId = teacherId;
		this.numStudents = numStudents;
		this.period = period;
	}
	
	public String getName() {return name;}
	public int getTeacherId() {return teacherId;}    
	public int getNumStudents() {return numStudents;}
	public int getPeriod() {return period;}
	
	public String toString()
	{
		return name + "(Period "+period+", "+numStudents+" students) taught by teacher #"+teacherId+" [hashCode: "+hashCode() + "]";
	}
	
	public int hashCode()
	{
		//TODO: implement this method!
		//Note: Strings have their own hashCode() method, so you can "change" a String, s, into an int by calling s.hashCode()
		//Remember: if two Subjects are .equal then they must have the same hashCode
		int p1 = 977;
		int p2 = 439;
		return (period*p1+name.length()+p2*numStudents/2*2);
	}
	
	/**
	 *	Two Subject objects are equal if they have the same name, are taught by the same teacher during the same period and 
	 *	they have the same number of students.
	 */
	public boolean equals(Object other)
	{
		if(other instanceof Subject)
		{
			Subject s = (Subject)other;
			
			//TODO: change this so that it only returns true if two Subject objects are actually equal!
			if(this.getName().equals(s.getName()))
				return true;
		}
		return false;
	}
}