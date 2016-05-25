public class Location implements IGraphable
{
	private int x, y;
	private int w, h;
	private String label;

	public Location(int x, int y, int w, int h)
	{
		this(x, y, w, h, "");
	}
	
    public Location(int x, int y, int w, int h, String label)
    {
    	//x and y are reversed on purpose!
    	//this reflects the graph of tiles over the line x = y
    	this.x = y;
    	this.y = x;
    	this.w = w;
    	this.h = h;
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
 	
 	public int getW()
 	{
 		return w;
 	}
 	
 	public int getH()
 	{
 		return h;
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