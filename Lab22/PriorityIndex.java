public class PriorityIndex implements Comparable<PriorityIndex>
{
	private int index;
	private int fScore;
	
    public PriorityIndex(int index, int fScore) 
    {
    	this.index = index;
    	this.fScore = fScore;
    }
    
    public int getIndex()
    {
    	return index;
    }
    
    public int getFScore()
    {
    	return fScore;
    }
    
    public int compareTo(PriorityIndex other)
    {
    	return fScore - other.getFScore();
    }
    
    public boolean equals(PriorityIndex other)
    {
    	return index == other.index;
    }
}