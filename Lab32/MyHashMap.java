import java.util.List;
import java.util.ArrayList;

public class MyHashMap<K, V> implements IMap<K, V>
{
	//Instance Variables
	List<node>[] list;
	static int counts;
	//Constructor
    public MyHashMap()
    {
    	//initialize instance variables here
    	list = new ArrayList[10];
    	for(int i = 0; i < 10; i++)
    		list[i] = new ArrayList<node>();	
    	//Your array should be size 10
    }
    
    //Methods
    public V get(Object key)
    {
    	int hash = key.hashCode();
    	List temp = list[hash%list.length];
    	for(int i = 0; i < temp.size(); i++)
    	{
    		if(((node)temp.get(i)).getKey().equals(key))
    			return (V)(((node)temp.get(i)).getValue());
    	}
    	return null;
    }
	
	public V put(K key, V value)
	{
	
		int hash = key.hashCode();
		list[hash%list.length].add(new node (key, value));
		this.count();
		return null;
	}
	
	public V remove(Object key) 
	{
		int hash = key.hashCode();
		V temp1 = null;
		for(int i = 0; i < list[hash%list.length].size(); i++)
		{
	//		System.out.println("LOOKING AT: " + ((K)(list[hash%list.length].get(i).getKey())).toString());
	//		System.out.println("FINDING FOR: " + key);
			if(((K)(list[hash%list.length].get(i).getKey())).equals(key))
			{
				temp1 = (V)((list[hash%list.length].get(i)).getValue());
		//		System.out.println("removing : "+temp1);
				list[hash%list.length].remove(i);
			}
		}
		counts = counts-1;
		return temp1;
	}
	
	public static void count()
	{
		counts = counts+ 1;
	}
	
	public int size()
	{
		return counts;
	}
	public boolean isEmpty()
	{
		if(counts==0)
			return true;
		return false;
	}
    
}