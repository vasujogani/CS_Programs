import java.util.Scanner;
public class Connect4Game implements IGame
{
	private String[][] board;
	boolean gameNotOver;
	boolean player1;
	private int i;
	private boolean column_full, column_full2;
	private boolean board_full;
	private int x_num, o_num;
	private boolean x_wins, o_wins;
	private String other_ply;
	private int rand;
	private boolean one_player;
	private boolean comp_wins;
	
	public boolean init()
	{
		Scanner input = new Scanner(System.in);
		board = new String[6][7];
		for(int r=0; r < board.length; r++)
		{
			System.out.print("|");
			for(int c=0; c < board[r].length; c++)
				System.out.print(" ");
			System.out.print("|");
			System.out.println();
		}
		System.out.print("---------");
		System.out.println();
		System.out.print(" 1234567");
		i=-1;
		player1 = true;
		System.out.println("Do you want to player with another player?");
		other_ply = input.next();
		one_player = false;
		if(other_ply.toLowerCase().equals("yes"))
			System.out.println("Player1: Enter the column");
		else{
			System.out.println("You go first");
			one_player = true;
		}
		return true;
	}
	
	public void printState(){
	if(i>=0&&one_player)
	{
		for(int r = board.length-1; r>=0; r--)
			if(board[r][i]==null){
					board[r][i]="X";
					break;
			}
		rand  = (int)(Math.random()*6);
		column_full2 = true;
		for(int r = 0; r < board.length; r++)
			if(board[r][rand]==null){
				column_full2 = false;
			}
		if(!column_full2)
			rand  = (int)(Math.random()*6);
		if(!column_full2)
			for(int r = board.length-1; r>=0; r--)
			if(board[r][rand]==null){
					board[r][rand]="O";
					break;
			}
		//horizontal check
		for(int r = 0; r < board.length; r++)
		{
			for (int c = 0; c < 4; c++)
			{
			if(board[r][c]!=null&&board[r][c+1]!=null&&board[r][c+2]!=null&&board[r][c+3]!=null&&board[r][c].equals(board[r][c])&&board[r][c].equals(board[r][c+1])&&board[r][c].equals(board[r][c+2])&&board[r][c].equals(board[r][c+3]))
				if(board[r][c].equals("X"))
					x_wins = true;
			if(board[r][c]!=null&&board[r][c+1]!=null&&board[r][c+2]!=null&&board[r][c+3]!=null&&board[r][c].equals(board[r][c])&&board[r][c].equals(board[r][c+1])&&board[r][c].equals(board[r][c+2])&&board[r][c].equals(board[r][c+3]))
				if(board[r][c].equals("O"))
					comp_wins = true;
			}
			
		}
		//vertical check
		for(int c = 0; c < 7; c++){
			for(int r = 0; r < 3; r++){
				if(board[r][c]!=null&&board[r+1][c]!=null&&board[r+2][c]!=null&&board[r+3][c]!=null&&board[r][c].equals(board[r+1][c])&&board[r][c].equals(board[r+2][c])&&board[r][c].equals(board[r+3][c]))
					if(board[r][c].equals("X"))
					x_wins = true;
				if(board[r][c]!=null&&board[r+1][c]!=null&&board[r+2][c]!=null&&board[r+3][c]!=null&&board[r][c].equals(board[r][c])&&board[r][c].equals(board[r+1][c])&&board[r][c].equals(board[r+2][c])&&board[r][c].equals(board[r+3][c]))
					if(board[r][c].equals("O"))
					o_wins = true;
				
			}
		}
		//diagonal check
		for(int r = board.length - 1; r >= 3; r--){
			for(int c = 0; c < 4; c++){
				if(board[r][c]!=null&&board[r-1][c+1]!=null&&board[r-2][c+2]!=null&&board[r-3][c+3]!=null&&board[r][c].equals(board[r-1][c+1])&&board[r][c].equals(board[r-2][c+2])&&board[r][c].equals(board[r-3][c+3]))
					if(board[r][c].equals("X"))
						x_wins = true;
				if(board[r][c]!=null&&board[r-1][c+1]!=null&&board[r-2][c+2]!=null&&board[r-3][c+3]!=null&&board[r][c].equals(board[r-1][c+1])&&board[r][c].equals(board[r-2][c+2])&&board[r][c].equals(board[r-3][c+3]))
					if(board[r][c].equals("O"))
						comp_wins = true;
			}
		}
		for(int r = 0; r < 3; r++)
			for(int c = 0; c < 4; c++){
				if(board[r][c]!=null&&board[r+1][c+1]!=null&&board[r+2][c+2]!=null&&board[r+3][c+3]!=null&&board[r][c].equals(board[r+1][c+1])&&board[r][c].equals(board[r+2][c+2])&&board[r][c].equals(board[r+3][c+3]))
					if(board[r][c].equals("X"))
						x_wins = true;
				if(board[r][c]!=null&&board[r+1][c+1]!=null&&board[r+2][c+2]!=null&&board[r+3][c+3]!=null&&board[r][c].equals(board[r+1][c+1])&&board[r][c].equals(board[r+2][c+2])&&board[r][c].equals(board[r+3][c+3]))
					if(board[r][c].equals("O"))
						o_wins = true;
			}
		for(int r=0; r < board.length; r++)
		{
			System.out.print("|");
			for(int c=0; c < board[r].length; c++)
				if(board[r][c]==null)
					System.out.print(" ");
				else
					System.out.print(board[r][c]);
			System.out.print("|");
			System.out.println();
		}
		System.out.print(" ");
		for(int a = 1; a < 8; a++){
		 	if(this.col_full(a-1)){
		 		System.out.print(" ");
		 		continue;
		 	}
			System.out.print(a);
		 }
		
	}
	if(i>=0&&!column_full&&!board_full&&!one_player)
	{	
			if(player1){
				for(int r = board.length-1; r>=0; r--)
				if(board[r][i]==null){
					board[r][i]="X";
			//		System.out.println("Value of i going on  is " + i);
					player1=false;
					break;
				}
			}
			else
				{
				for(int row = board.length-1; row>=0; row--)
				if(board[row][i]==null){
		//			System.out.println("Going to input 0");
					board[row][i]="O";
					player1 = true;
					break;
				}
			}
		
		for(int r=0; r < board.length; r++)
		{
			System.out.print("|");
			for(int c=0; c < board[r].length; c++)
				if(board[r][c]==null)
					System.out.print(" ");
				else
					System.out.print(board[r][c]);
			System.out.print("|");
			System.out.println();
			//change this later;
		}
		System.out.print(" ");
		 for(int a = 1; a < 8; a++){
		 	if(this.col_full(a-1)){
		 		System.out.print(" ");
		 		continue;
		 	}
			System.out.print(a);
		 }
		x_wins = false;
		o_wins = false;
		//horizontal check
		for(int r = 0; r < board.length; r++)
		{
			for (int c = 0; c < 4; c++)
			{
			if(board[r][c]!=null&&board[r][c+1]!=null&&board[r][c+2]!=null&&board[r][c+3]!=null&&board[r][c].equals(board[r][c])&&board[r][c].equals(board[r][c+1])&&board[r][c].equals(board[r][c+2])&&board[r][c].equals(board[r][c+3]))
				if(board[r][c].equals("X"))
					x_wins = true;
			if(board[r][c]!=null&&board[r][c+1]!=null&&board[r][c+2]!=null&&board[r][c+3]!=null&&board[r][c].equals(board[r][c])&&board[r][c].equals(board[r][c+1])&&board[r][c].equals(board[r][c+2])&&board[r][c].equals(board[r][c+3]))
				if(board[r][c].equals("O"))
					o_wins = true;
			}
			
		}
		
		//vertical check

		for(int c = 0; c < 7; c++){
			for(int r = 0; r < 3; r++){
				if(board[r][c]!=null&&board[r+1][c]!=null&&board[r+2][c]!=null&&board[r+3][c]!=null&&board[r][c].equals(board[r+1][c])&&board[r][c].equals(board[r+2][c])&&board[r][c].equals(board[r+3][c]))
					if(board[r][c].equals("X"))
					x_wins = true;
				if(board[r][c]!=null&&board[r+1][c]!=null&&board[r+2][c]!=null&&board[r+3][c]!=null&&board[r][c].equals(board[r][c])&&board[r][c].equals(board[r+1][c])&&board[r][c].equals(board[r+2][c])&&board[r][c].equals(board[r+3][c]))
					if(board[r][c].equals("O"))
					o_wins = true;
				
			}
		}
		
		//diagonal check
		for(int r = board.length - 1; r >= 3; r--){
			for(int c = 0; c < 4; c++){
				if(board[r][c]!=null&&board[r-1][c+1]!=null&&board[r-2][c+2]!=null&&board[r-3][c+3]!=null&&board[r][c].equals(board[r-1][c+1])&&board[r][c].equals(board[r-2][c+2])&&board[r][c].equals(board[r-3][c+3]))
					if(board[r][c].equals("X"))
						x_wins = true;
				if(board[r][c]!=null&&board[r-1][c+1]!=null&&board[r-2][c+2]!=null&&board[r-3][c+3]!=null&&board[r][c].equals(board[r-1][c+1])&&board[r][c].equals(board[r-2][c+2])&&board[r][c].equals(board[r-3][c+3]))
					if(board[r][c].equals("O"))
						comp_wins = true;
			}
		}
		for(int r = 0; r < 3; r++)
			for(int c = 0; c < 4; c++){
				if(board[r][c]!=null&&board[r+1][c+1]!=null&&board[r+2][c+2]!=null&&board[r+3][c+3]!=null&&board[r][c].equals(board[r+1][c+1])&&board[r][c].equals(board[r+2][c+2])&&board[r][c].equals(board[r+3][c+3]))
					if(board[r][c].equals("X"))
						x_wins = true;
				if(board[r][c]!=null&&board[r+1][c+1]!=null&&board[r+2][c+2]!=null&&board[r+3][c+3]!=null&&board[r][c].equals(board[r+1][c+1])&&board[r][c].equals(board[r+2][c+2])&&board[r][c].equals(board[r+3][c+3]))
					if(board[r][c].equals("O"))
						o_wins = true;
		}
		if(!x_wins&&!o_wins){
			if(player1)
				System.out.println("Player 1: Make Your move!");
			else
				System.out.println("Player 2: Make Your Move!");
		}
	}	
	}
	
	public boolean check(String s)
	{
		if(!s.equals(""))
		{
		i = Integer.parseInt(s) -1;
//		System.out.println("Value of i is " + i);
		}
		if(x_wins)
			return false;
		else if(o_wins)
			return false;
		else if(comp_wins)
			return false;
		//full board check
		for(int r = 0; r < board.length; r++)
			for(int c = 0; c < board[r].length; c++)
				if(board[r][c]==null)
				{
					board_full = false;
					return true;
				}
		//column
		for(int r = 0; r < board.length; r++)
			if(board[r][i]==null){
				column_full = false;
				return true;
			}
			board_full = true;
		return false;
		
	}
	
	public void printResults()
	{
		if(x_wins)
			System.out.println("X WON");
		if(o_wins)
			System.out.println("O WON");
		if(comp_wins)
			System.out.println("COMPUTER WON");
	}
	public boolean col_full(int col)
	{
		for(int r = 0; r < board.length; r++)
			if(board[r][col]==null){
				return false;
			}	
		return true;
	}
}