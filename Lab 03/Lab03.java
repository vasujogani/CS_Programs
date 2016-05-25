import java.util.Scanner;
import java.lang.Math.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Lab03 {

	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in); 
		String play = "Yes";
		while(play.equals("Yes"))
		{
	
			int r = (int)(Math.random() *100 ) +1; 
				
			System.out.println("random number is: " + r);
			 
			System.out.println("Enter your Guess");
			                                  
			int userInt, linenumber;
	
			int guessed=0;  
			
			int last_response = 99691;
		
			userInt = input.nextInt();
				
			guessed++;
			
			File file = new File("save.txt");
				if(!file.exists()) 
					    	try
							{
					    		
					    			
					    		int[] data = {last_response, userInt, guessed,r};
						    	
						    	PrintWriter writer = new PrintWriter("save.txt");
						    	for(int line : data)
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
					
	
			do
			{
				//writing
					 try
			    		{	
			    		int[] data = {last_response, userInt, guessed,r};
				    	
				    	// http://docs.oracle.com/javase/7/docs/api/java/io/PrintWriter.html
				    	// or search: java Print Writer
				    	PrintWriter writer = new PrintWriter("save.txt");
				    	for(int line : data)
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
			    			
					//reading part
							try
				    		{
				    		// http://docs.oracle.com/javase/7/docs/api/java/io/File.html
				    		// or search: java File
					    	
					    	if(!file.exists()) 
					    		System.out.println("Your file has been Hacked");
					    	
					    	// http://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html
					    	// or search: java Scanner
					    	Scanner reader = new Scanner(file);
					    	linenumber = 0;
					 		while(reader.hasNextLine())
					    	{
					    	
					    		if(linenumber==0)
								last_response = Integer.parseInt(reader.nextLine());
					    		if(linenumber==1)
					    			userInt = Integer.parseInt(reader.nextLine());
					    		if(linenumber==2)
					    			guessed = Integer.parseInt(reader.nextLine());
					    		if(linenumber==3)
					    			r = Integer.parseInt(reader.nextLine());
					    			linenumber++;
					    	}
					  
					    	
					    	reader.close();
					    	}
					    	catch(FileNotFoundException e)
				    		{
				    		System.out.println("An error occured!");
				    		e.printStackTrace();	
				    		}
				    	
				    	
				    	
				    	
				if(userInt==r) break;
				System.out.println(last_response + " " + userInt + " " + guessed+ " " + r);
				if(guessed==1){
					if(r - 10 <= userInt && userInt  <= r + 10){
							System.out.println("Hot");	
							last_response = userInt;
					}
					else{
						System.out.println("Cold");
						last_response = userInt;
					}
				}
				else if(guessed > 1)
				{
					if(Math.abs(last_response - r) > Math.abs(userInt - r))
						System.out.println("Warmer");
					else
						System.out.println("Colder");
				}
				last_response = userInt;
				userInt = input.nextInt();
				guessed++;	
				
				
			    			
			}while(userInt != r);
				
				
			if(userInt==r)
			{
				System.out.println("Correct! Number of you guesses you took: " + guessed);
			}
			file.delete();
		
			System.out.println("Do you want to play again?");
			play = input.next();	
		}	
		
	}

}