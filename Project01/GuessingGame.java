public class GuessingGame implements IGame
{
	private double r; 
	private int guessed;
	private boolean lost;
	private int guess = 0;
	
	public boolean init()
	{
		r = (int)(Math.random() *100 ) +1;
		guessed = 0;
		lost = true;
		System.out.println("Game Starting...");                               
		return true;
	}

	
	public void printState()
	{
		if(guess > r)
		{
			System.out.println("Your Guess is too High");
			guessed++;
		}
		else if(guess < r && guessed!=0)
		{
			System.out.println("Your Guess is too Low");
			guessed++;
		}
		System.out.println("Take a guess!");	
	}
	
	public boolean check(String s)
	{
		guess = Integer.parseInt(s);
		if(guess == r)
			lost = false;
		else
			lost = true;
		return lost;
	}
	
	public void printResults()
	{
		System.out.println("You got it right! You took " + guessed + " tries!");
	}
}
