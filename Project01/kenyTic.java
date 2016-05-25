import java.util.Scanner;
public class kenyTic implements IGame{
	TBoard gameBoard;
	Scanner input;
	boolean xTurn;
	boolean xWinner;
	public boolean init(){
		gameBoard = new TBoard();
		input = new Scanner(System.in);
		xTurn = true;
		xWinner = false;
		return true;
	}
	public void printState(){
		System.out.print(gameBoard);
		System.out.print((xTurn ? "X's" : "O's") + " turn: ");
	}
	public boolean check(String input){
		int r = (input.substring(0,1).equals("a") ? 0 : (input.substring(0,1).equals("b") ? 1 : 2));
		int c = Integer.parseInt(input.substring(1))-1;
		if(r >= 3 || c >= 3){
			System.out.print("Invalid Guess, [a,b,c][1-3]\r\n");
			return false;
		}
		gameBoard.board[r][c] = xTurn ? 1 : 2;
		xTurn = !xTurn;
		if(checkWin(0,0,0,1,0,2))//left to right
			return true;
		if(checkWin(1,0,1,1,1,2))
			return true;
		if(checkWin(2,0,2,1,2,2))
			return true;
		if(checkWin(0,0,1,0,2,0))//up and down
			return true;
		if(checkWin(0,1,1,1,2,1))
			return true;
		if(checkWin(0,2,1,2,2,2))
			return true;
		if(checkWin(0,0,1,1,2,2))//diagnols
			return true;
		if(checkWin(0,2,1,1,2,0))
			return true;
		return false;
	}
	public void printResult(){
		System.out.print(gameBoard);
		System.out.print((xWinner ? "X" : "O") + " Won, Play Again?(y/n): ");
	}
	public boolean checkWin(int r1, int c1, int r2, int c2, int r3, int c3){
		if(gameBoard.board[r1][c1] == 1 && gameBoard.board[r2][c2] == 1 && gameBoard.board[r3][c3] == 1){
			xWinner = true;
			return true;
		} else if(gameBoard.board[r1][c1] == 2 && gameBoard.board[r2][c2] == 2 && gameBoard.board[r3][c3] == 2)
			return true;
		return false;
	}
}
class TBoard{
	int[][] board;
	public TBoard(){
		board = new int[3][3];
	}
	
	@Override
	public String toString(){	
		return "       |       |       \r\n   " + (board[0][0] == 0 ? " " : board[0][0] == 1 ? "X" : "O") + "   |   " + (board[0][1] == 0 ? " " : board[0][1] == 1 ? "X" : "O") + "   |   " + (board[0][2] == 0 ? " " : board[0][2] == 1 ? "X" : "O") + "   \r\n       |       |       \r\n-------+-------+-------\r\n       |       |       \r\n   " + (board[1][0] == 0 ? " " : board[1][0] == 1 ? "X" : "O") + "   |   " + (board[1][1] == 0 ? " " : board[1][1] == 1 ? "X" : "O") + "   |   " + (board[1][2] == 0 ? " " : board[1][2] == 1 ? "X" : "O") + "   \r\n       |       |       \r\n-------+-------+-------\r\n       |       |       \r\n   " + (board[2][0] == 0 ? " " : board[2][0] == 1 ? "X" : "O") + "   |   " + (board[2][1] == 0 ? " " : board[2][1] == 1 ? "X" : "O") + "   |   " + (board[2][2] == 0 ? " " : board[2][2] == 1 ? "X" : "O") + "   \r\n       |       |       \r\n";
	}
}