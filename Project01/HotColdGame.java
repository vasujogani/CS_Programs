import java.lang.Math.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class HotColdGame implements IGame
{
	private int r; 
	private int guessed;
	private boolean lost;
	private int guess = 0;
	private int last_response = 0;
	File file;
	private boolean exist = false;
	Saver saver = new Saver();
	private int[] reads;
	
	public boolean init(){
		r = (int)(Math.random() *100 ) +1;
		guessed = 0;
		lost = true;
		System.out.println("Game Starting..."); 
		file = new File("save.txt");   
		if(file.exists())
		{
			reads = saver.reading();
			for(int i = 0; i < reads.length; i++)
				System.out.println(reads[i]);
			guessed=reads[2];
			guess = reads[1];
			r = reads[3];
			last_response = reads[0];
		}
		else
		{	//deleting old file, 
			r = (int)(Math.random() *100 ) +1;
			guessed=0;
			guess = 0;
			last_response = -1;	
			saver.writer(last_response,guess,guessed,r);
		}                           
		return true;
	}
		
	public void printState(){
		reads = saver.reading();
		r = reads[3];
		last_response = reads[0];	
//		System.out.println(last_response + " " + guess + " " + guessed+ " " + r);
		if(guessed==1){
			if(r - 10 <= guess && guess  <= r + 10){
				System.out.println("Hot");	
				last_response = guess;
			}
			else{
				System.out.println("Cold");
				last_response = guess;
			}
		}
		else if(guessed > 1){
			if(Math.abs(last_response - r) > Math.abs(guess - r)){
				System.out.println("Warmer");
				last_response = guess;	
			}
			else{
				System.out.println("Colder");
				last_response = guess;
			}
		}	
 		//writing
 		saver.writer(last_response,guess,guessed,r);
 		System.out.println("Enter your guess!");	
	}
	
	public boolean check(String s){
		guess = Integer.parseInt(s);
		if(guess == r)
			lost = false;
		else
			lost = true;
		guessed++;
		return lost;
	}
	
	public void printResults()
	{
		file.delete();
		System.out.println("Correct! Number of you guesses you took: " + guessed);
	}
}