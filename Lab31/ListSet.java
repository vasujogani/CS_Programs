import java.util.List;
import java.util.ArrayList;

public class ListSet<E> implements ISet<E>
{
	private List<E> list;
	
    public ListSet() 
    {
    	//TODO: implement this
    	list = new ArrayList<E>();
    }
    
    public boolean add(E obj)
    {
    	//TODO: implement this
    	if(this.contains(obj))
    		return list.add(obj);
    	else
	    	return false;	
    }
    
    public boolean contains(E obj)
    {
    	//TODO: implement this
    	if(!list.contains(obj))
	    	return true;
	    return false;
    }
    
    public boolean remove(Object obj)
    {
    	//TODO: implement this
    	if(!list.contains(obj))
    		return false;
    	list.remove(list.indexOf(obj));
    	return true;
    }
    
    public int size()
    {
    	//TODO: implement this
    	return list.size();
    }
    
    public boolean isEmpty()
    {
    	//TODO: implement this
    	return list.size()==0?true:false;
    }  
}