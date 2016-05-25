public class Saver
{
	int linenumber;
	File file = new File("save.txt");
	public void writer(int fr, int cr, int ng, int rn)
	{
		PrintWriter writer = new PrintWriter("save.txt");
			try
			{	
			    int[] data = {fr, cr, ng, rn};
				for(int line : data)
				{
				    writer.println(line);
				}
			}
			catch(FileNotFoundException e)
			{
			   	System.out.println("An error occured!");
			   	e.printStackTrace();
			}	
		writer.close();
	}
	public int[] reading()
	{
		int[] saved;
		try
		{	
			if(!file.exists()) 
			System.out.println("Your file has been Hacked");
			Scanner reader = new Scanner(file);
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
		}
		catch(FileNotFoundException e)
			{
			  	System.out.println("An error occured!");
			   	e.printStackTrace();	
			}
			reader.close();
			return saved;
	}
}