import java.util.Scanner;
import java.lang.Math.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class lab05 {

	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in); 
		String play = "Yes";
		while(play.equals("Yes"))
		{
			int linenumber;
			int last_response;
			int userInt;
			int r;
			int guessed;
			int[] reads;
			File file = new File("save.txt");
			Saver saver = new Saver();
			if(file.exists()) 
			{
					reads = saver.reading();
					for(int i = 0; i < reads.length; i++)
						System.out.println(reads[i]);
					guessed=reads[2];
					userInt = reads[1];
					r = reads[3];
					last_response = reads[0];
			}
			else
			{
				//deleting old file, 
				file.delete();
				r = (int)(Math.random() *100 ) +1;
				guessed=0;
				System.out.println("Enter your guess?");
				userInt = input.nextInt();
				guessed++;
				last_response = -1;
				
			    saver.writer(last_response,userInt,guessed,r);
			 }
			do
			{
				//reading
				reads = saver.reading();
				guessed=reads[2];
				userInt = reads[1];
				r = reads[3];
				last_response = reads[0];	
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
 				//writing
 				saver.writer(last_response,userInt,guessed,r);
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