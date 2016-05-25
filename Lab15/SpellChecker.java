import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class SpellChecker
{
	IBinarySearchTree dictionary;
	File file;
	int count;
	public SpellChecker()
	{
		//Create an instance of a IBinarySearchTree
		dictionary = new BinarySearchTree<String>();
		//Load the words from the scrabble.cvs file and store them in a BinarySearchTree
		try{
			file =  new File("scrabble.csv");
			Scanner reader =  new Scanner(file);
			System.out.println("-==start--");
			while(reader.hasNextLine()&&count<100)
			{
				String line = reader.nextLine();
				dictionary.add(line);
				count++;
			}
			reader.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}
	
	public boolean isSpelledCorrectly(String word)
	{
		//Use the IBinarySearchTree to check if word is a correectly spelled word
		return dictionary.contains(word);
	}
	
	public static void main(String[] args)
	{
		//Test code goes here
		SpellChecker checker = new SpellChecker();
		boolean a = checker.isSpelledCorrectly("aa");
		boolean b = checker.isSpelledCorrectly("skoll ");
		
		System.out.println("aa is spelled " + (a ? "Correctly" : "Incorrectly"));
		System.out.println("Skool is spelled " +  (b ? "Correctly" : "Incorrectly"));
	}
}