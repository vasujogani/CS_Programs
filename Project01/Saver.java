import java.util.Scanner;
import java.lang.Math.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Saver
{
	int linenumber;
	File file = new File("save.txt");
	public void writer(int fr, int cr, int ng, int rn)
	{
	
			try
			{	
				PrintWriter writer = new PrintWriter("save.txt");
			    int[] data = {fr, cr, ng, rn};
				for(int line : data)
				{
				    writer.println(line);
				}
				writer.close();
			}
			catch(Exception e)
			{
			   	System.out.println("An error occured!");
			   	e.printStackTrace();
			}	
		
	}
	public int[] reading()
	{
		int[] saved = new int[4];
		try
		{	
			Scanner reader = new Scanner(file);
			if(!file.exists()) 
			System.out.println("Your file has been Hacked");
			linenumber = 0;
			while(reader.hasNextLine())
			{
				if(linenumber==0)
					saved[0] = Integer.parseInt(reader.nextLine());
				if(linenumber==1)
			    	saved[1] = Integer.parseInt(reader.nextLine());
				if(linenumber==2)
					saved[2] = Integer.parseInt(reader.nextLine());
				if(linenumber==3)
					saved[3] = Integer.parseInt(reader.nextLine());
				linenumber++;
			}
				reader.close();
		}
		catch(Exception e)
			{
			  	System.out.println("An error occured!");
			   	e.printStackTrace();	
			}
		
			return saved;
	}
}