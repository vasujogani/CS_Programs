import java.util.Scanner;
import java.io.File;

public class Lab_6
{
	public boolean gameOver(String[] answered, String word)
	{
		for (int i = 0; i < word.length(); i++)
		{
			if(!(answered[i].equals(word.toLowerCase().substring(i,i+1))))
				return true;
		}
		return false;
	}
	public static void main(String args[])
	{
		Lab_6 game = new Lab_6();
		Scanner input = new Scanner(System.in);
		File file = new File("words.txt");
		String play_again = "Yes";
		while(play_again.equals("Yes"))
		{
			
			int r = (int)(Math.random() *126 ) +1;
			System.out.println(r);
			int counter = 0;
			String word = "";
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
			System.out.println("The length of the word is " + word.length()+ " and the word is " + word);
			System.out.println("Guess one letter");
			int word_length = word.length();
			String[] s = new String[word_length];
			int guesses = 6;
			int first_try = 1;
			int num_try = 0;
			do
			{
				String letter = input.next();
				num_try++;
				
				while(letter.length()!=1)
				{
					System.out.println("Enter one letter");
					letter = input.next();
				}
				letter = letter.toLowerCase();
				boolean getit = false;
				for (int i = 0; i < word_length; i++)
				{
					if(letter.equals(word.toLowerCase().substring(i,i+1)))
					{
						s[i] = letter;
						getit=true;
					}
					else if (first_try==1 )
					{
						s[i] = "*";
					}
				}
				first_try++;
				if(!getit)
					guesses--;
				System.out.print("Word is ");
				for(String p: s)
					System.out.print(p);
				System.out.println();
				System.out.println("You have " + guesses + " tries left!");
			}while(game.gameOver(s, word) && guesses>0);
			
			if(guesses>0 && !game.gameOver(s,word))
				System.out.println("YOU WON! It took you " + num_try + "tries");
			else 
			{
				System.out.println("YOU L0ST!!!!!!!!!!!!!!!");
				System.out.println("The correct word was " + word);
			}
			
			System.out.println("Do you want to play again?");
			play_again = input.next();
		}
	}
}