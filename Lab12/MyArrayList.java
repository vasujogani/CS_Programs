public class MyArrayList<E> implements IList<E>
{
    private Object[] data;
    private int size;
    public MyArrayList()
    {
        data = new Object[100];
        size = 0;
    }
    
    public MyArrayList(int s)
    {
        data = new Object[s*2];
        size= 0;
    }
    public int size(){
    	return size;
    //    return data.length;
    }
    public boolean add(E obj){
    if(size>=data.length)
    {
        Object[] data2 = new Object[size*2];
        int last_index = data.length;
        for(int i = 0; i < data.length; i++)
        	data2[i] = data[i];
        data2[data.length] = obj;
        data = data2;
        size++;
        if(data2[last_index]!=null)
	        return true;
    	else 
    		return false;
    }
    else
    {
    	data[size] = obj;
    	size++;
    	return true;
    }
    }
    public void add(int index, E obj){
       if(index>size||index<0)
        	throw new IndexOutOfBoundsException("Index was out of bound");
       if(size>=data.length)
       {
	       Object[] data2 = new Object[data.length+1];
	       int x = 0;
	       for(int i = 0; i < data2.length; i++)
	       {
	       		if(i==index)
	       		{
	       			data2[i] = obj;
	       		}
	       		else
	       		{
	            	data2[i] = data[x];
	       			x++;
	       		}
	       }
	       data = data2;
	       size++;
       }
       else
       {
       	 	int x = 0;
       		for(int i = size; i > index;i--){
	       		data[i] = data[i-1];
       	  	}
			data[index] = obj; 	
       	
       		size++;
       }
    }
    public E set(int index, E obj){
    	if(index>=size||index<0)
        	throw new IndexOutOfBoundsException("Index was out of bound");
        Object temp = data[index];
        data[index] = (Object)obj;
        return (E)temp;
    }
    public E get(int index){
    	if(index>=size||index<0)
    		throw new IndexOutOfBoundsException("Index was out of bound");
	    return (E)data[index];
    }

    public E remove(int index){
    /*	if(index>size||index<0)
    		throw new IndexOutOfBoundsException("Index was out of bound");
		Object[] data2 = new Object[data.length-1];
		Object temp = data[index];
		int x = 0;
		for(int i = 0;i<data.length; i++){
			if(i==index)
				continue;
			data2[x] = data[i];
			x++;
		}
		data = data2;
        return (E)temp;*/
        if(index>=size||index<0||data[index]==null)
        	throw new IndexOutOfBoundsException("Index was out of bound");
        Object temp = data[index];
        
        for(int i = index; i < size-1; i++){
        	
        	data[i]=data[i+1];
		}
		size--;
		return (E)temp;
    }

    public String toString(){
        String s = "[";
        for(int i = 0; i < size-1; i++)
        {
        	s+=  this.get(i).toString()+", ";
        }
        if(size>0)
        s+= this.get(size-1).toString() + "]";
        else
        	s+="]";
        return s;
    }
}