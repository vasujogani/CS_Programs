import java.util.Scanner;
public abstract class GameEngine
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		IGame game = null;
		boolean check = false;
		System.out.println("Which game do you want to play?");
		System.out.println("5:Connect Four");
		int a = input.nextInt();
		switch (a)
		{
	//		case 1: game = new GuessingGame(); break;
	//		case 2: game = new HotColdGame(); break;
	//		case 3: game = new HangManGame(); break;
	//		case 4: game = new TicTacToe(); break;
			case 5: game = new Connect4Game(); break;
	//		case 5: game = new kenyTic(); break;
		}
		String uinp="";
		String play = "yes";
		while(play.equals("yes")){
			if(game.init()){
				while(game.check(uinp)){
					game.printState();
					if(game.check(uinp))
					uinp = input.next();
				}
			game.printResults();
			System.out.println("Do you want to play again?");
			play = input.next();
			System.out.println("Which Game do you want to play?");
			System.out.println("1.GuessingGame");
			System.out.println("2.HotCold");
			System.out.println("3.HangMan");
			a = input.nextInt();
			switch (a)
			{
	//		case 1: game = new GuessingGame(); break;
	//		case 2: game = new HotColdGame(); break;
	//		case 3: game = new HangManGame(); break;
			}
		}
		}
	}
}
