import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HangManGame implements IGame
{
	File file;
	private int r;
	private int counter;
	private String word;
	private int word_length;
	private String[] s;
	private int guesses;
	private int first_try;
	private int num_try;
	private boolean getit;
	private String glet;
	
	public boolean init()
	{
		file = new File("words.txt");
		int r = (int)(Math.random() *126 ) +1;
		int counter = 0;
		word = "";
		glet = "";
		try
		{	
			Scanner reader = new Scanner(file);
			if(!file.exists()) 
				System.out.println("NO file found");
			while(reader.hasNextLine())
			{
				String line = reader.nextLine();
				if(counter==r)
				{	
					word = line;
					System.out.println("1:" + word);
					System.out.println(this);
					break;
				}
				counter++;
			}
				reader.close();
		}
		catch(Exception e)
		{
		 	System.out.println("An error occured!");
		   	e.printStackTrace();	
		}
		word= word.toLowerCase();
		System.out.println("2:" + word);
		System.out.println("The length of the word is " + word.length()+ " and the word is " + word);
		
		word_length = word.length();
		s = new String[word_length];
		for(int i = 0; i < word_length; i++)
			s[i] = "*";
		guesses = 6;
		first_try = 1;
		num_try = 0;
		getit = false;
	//	System.out.println("init 1" + word);
		return true;
	}
	
	public void printState()
	{
	//	getit = false;
		if(num_try>0)
		{
			
			/*for (int i = 0; i < word_length; i++)
			{
				if(glet.equals(word.toLowerCase().substring(i,i+1)))
				{
					s[i] = glet;
					getit=true;
				}
				else if (first_try==1 )
				{
					s[i] = "*";
				}
			}
			first_try++;*/

			if(!getit)
				guesses--;
			System.out.print("Word is ");
			for(String p: s)
				System.out.print(p);
			System.out.println();
			System.out.println("You have " + guesses + " tries left!");
		}
		System.out.println("Enter a letter!");
		for(String b : s)
			System.out.print(b);
		System.out.println();
	}
	
	public boolean check(String letter)
	{
		getit = false;
		glet = letter.toLowerCase();
		num_try++;
		for (int i = 0; i < word_length; i++)
			{
				if(glet.equals(word.toLowerCase().substring(i,i+1)))
				{
					s[i] = glet;
					getit=true;
				}
				else if (first_try==1 )
				{
					s[i] = "*";
				}
			}
			first_try++;
		if(gameOver(s, word) && guesses > 0)
			return true;
		return false;
	}
	
	public void printResults()
	{
		System.out.print("The word is: " );
		for(int i = 0; i < s.length; i++)
			System.out.print(s[i]);
		if(guesses>0 && !gameOver(s,word))
				System.out.println("YOU WON! It took you " + num_try + "tries");
		else 
		{
			System.out.println("YOU L0ST!!!!!!!!!!!!!!!");
			System.out.println("The correct word was " + word);
		}
	}
		
	public boolean gameOver(String[] answered, String answer)
	{
		for (int i = 0; i < answer.length(); i++)
		{
			if(!(answered[i].equals(answer.toLowerCase().substring(i,i+1))))
				return true;
		}
		return false;
	}
}