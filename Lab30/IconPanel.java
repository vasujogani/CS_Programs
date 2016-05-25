/**
 * @(#)IconPanel.java
 *
 *
 * @author 
 * @version 1.00 2016/3/18
 */
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Map;
import java.util.HashMap;

public class IconPanel extends JPanel 
{
	private int size;
	private String[][] image;
	private Map<String, Color> palette;
	
    public IconPanel(String[][] image, int size) 
    {
    	this.image = image;
    	this.size = size;
    	palette = new HashMap<String, Color>();
    	//TODO: change this to create a default palette that sets values for the keys "a", "b", and "c"
    	this.palette.put("a",Color.RED);
		this.palette.put("b",Color.BLUE);
		this.palette.put("c",Color.WHITE);
    }
    
    public void setPalette(Map<String, Color> palette)
    {
    	this.palette = palette;
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
    	super.paintComponent(g);
    	
    	if(image.length == 0 || image[0].length == 0) return;
    	
    	int w = image.length;
    	int h = image[0].length;
    	
    	for(int x = 0; x < w; x++)
    	{
    		for(int y = 0; y < h; y++)
    		{
    			//change the color based on the (x,y) value of image
    			//TODO: replace these if/else statements with *one line of code* that uses the palette
    			Color c = this.palette.get(image[x][y]);
    			//End of the portion of code you should be changing in this method

				//only draw a rectangle if a color was found in the palette    			
    			if(null != c)
    			{
	    			//set the color to draw with
	    			g.setColor(c);
	    			
	    			//draw a rectangle
	    			//Notice, x and y are reversed!
	    			g.fillRect(y * size, x * size, size, size);
	    		}
    		}
    	}
    	
    }
    
    
}