/**
 * @(#)Location.java
 *
 *
 * @author 
 * @version 1.00 2016/1/24
 */


public class Location implements IGraphable
{
	private int x, y;
	private String label;

	public Location(int x, int y)
	{
		this(x, y, "");
	}
	
    public Location(int x, int y, String label)
    {
    	this.x = x;
    	this.y = y;
    	this.label = label;
    }
    
 	public int getX()
 	{
 		return x;
 	}   
 		
 	public int getY()
 	{
 		return y;
 	}
 	
 	public String getLabel()
 	{
 		return label;
 	}
 	
 	public String toString()
 	{
 		return "("+x+", "+y+")";
 	}
}