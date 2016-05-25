import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Lab04 
{

    public static void main(String[] args)
    {
    	//code to write data to a file    	
    	try
    	{
    		String[] data = {
	    		 "two ring to rule them all"
	    		,"three ring to fine them"
	    		,"one ring to bring them all"
	    		,"and in the darkness bind them"
	    	};
	    	
	    	// http://docs.oracle.com/javase/7/docs/api/java/io/PrintWriter.html
	    	// or search: java Print Writer
	    	PrintWriter writer = new PrintWriter("savefile.txt");
	    	
	    	for(String line : data)
	    	{
	    		writer.println(line);
	    	}
	    	
	    	writer.close();
    	}
    	catch(FileNotFoundException e)
    	{
    		System.out.println("An error occured!");
    		e.printStackTrace();
    	}
    	
    	//code to read data from a file
    	try
    	{
    		// http://docs.oracle.com/javase/7/docs/api/java/io/File.html
    		// or search: java File
	    	File file = new File("savefile.txt");
	    	
	    	// http://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html
	    	// or search: java Scanner
	    	Scanner reader = new Scanner(file);
	 
	    	System.out.println("-- START FILE --");
	    	while(reader.hasNextLine())
	    	{
	    		//Note: you can use any of the Scanner methods
	    		//		to read from a file! nextInt(), nextDouble(), etc
	    		String line = reader.nextLine();
	    		System.out.println(line);
	    	}
	  
	    	System.out.println("-- END FILE --");
	    	
	    	reader.close();
    	}
    	catch(FileNotFoundException e)
    	{
    		System.out.println("An error occured!");
    		e.printStackTrace();	
    	}
    }
}