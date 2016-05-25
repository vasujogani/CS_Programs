/**
 * @(#)Lab02.java
 *
 *
 * @author 
 * @version 1.00 2015/8/28
 */

import java.util.Scanner;
import java.lang.Math.*;
public class Lab02 {

	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in); 
		 
		System.out.println("Enter your Guess");
		                                  
		int userInt = input.nextInt(); 
		
		double r = (int)(Math.random() *100 ) +1; 

		int guessed = 1;
		
		while(userInt != r)
		{
			System.out.println("Failed. Try Again!");
			if(userInt>r)
				System.out.println("Your Guess is too High");
			else 
				System.out.println("Your Guess is too Low");
			userInt = input.nextInt(); 
			guessed++;
		}
		
		if(userInt==r)
		{
			System.out.println("You won! You guessed " + guessed);
		}
		
		 
	}

}