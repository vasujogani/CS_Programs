public class TicTacToe implements IGame{
    private int inp;
    private int comp_move;
    private boolean game_over;
    private boolean computer_wins;
    private boolean human_wins;
    private String[][] board;
    private boolean human_turn;
    private int num_tries;
    private int r_x, r_y;
    private int oMatch, xMatch;
    private boolean repeatnumb;
    
    public boolean init()
    {
    	board = new String[3][3];
    	for(int r = 0; r < 3 ; r++)
    	{
    		for (int c = 0; c < 3; c++)
    			board[r][c] = " ";
    	}
		for(int r = 0; r < 3 ; r++)
    	{
    		System.out.print("|");
    		for (int c = 0; c < 3; c++)
    			System.out.print(3*r+c+ "|");
    		System.out.println();
			System.out.println("--+-+--");    	
    	}
    	
    	return true;
    }   
    
    public  void printState()
    {
    	if(!repeatnumb)
    	{
	    	r_x = (int)(Math.random() *3);
    		r_y = (int)(Math.random() *3);
    		while(!board[r_x][r_y].equals(" "))
    		{
    			r_x = (int)(Math.random() *3);
	    		r_y = (int)(Math.random() *3);
    		}		
    		board[r_x][r_y] = "X";
    	}
    	for(int r = 0; r < 3 ; r++)
    	{
    		System.out.print("|");
    		for (int c = 0; c < 3; c++)
    			System.out.print(board[r][c]+ "|");
    		System.out.println();
			System.out.println("--+-+--");    	
    	}
    	
    }
    
    public boolean check(String s)
    {
    	inp = Integer.parseInt(s); 
    	int inpx = inp/3;
    	int inpy = inp%3;
    	if(board[inpx][inpy].equals(" "))
    		board[inpx][inpy] = "O";
    	else 
    		repeatnumb = true;
    	human_wins = false;
    	computer_wins= false;
    	if(board[inpx][inpy].equals("O"))
    		System.out.println("Input registered at:"+ board[inpx][inpy]);
    	//horizontal check
    	for(int r = 0; r < 3; r++)
    	{
    		oMatch = 0;
    		for(int c = 0; c < 3; c++)
    		{
    			if(board[r][c].equals("O"))
    				oMatch++;
    		}
    		if(oMatch==3){
    			human_wins = true;
    			return false;
    		}
    	}
    	for(int r = 0; r < 3; r++)
    	{
    		xMatch = 0;
    		for(int c = 0; c < 3; c++)
    		{
    			if(board[r][c].equals("X"))
    				xMatch++;
    		}
    		if(xMatch==3){
    			computer_wins = true;
    			return false;
    		}
    	}
    	//vertical check
    	for(int c = 0; c < 3; c++)
    	{
    		xMatch = 0;
    		for(int r = 0; r < 3; r++)
    		{
    			if(board[r][c].equals("X"))
    				xMatch++;
    		}
    		if(xMatch==3){
    			human_wins = true;
    			return false;
    		}
    	}
    	for(int c = 0; c < 3; c++)
    	{
    		oMatch = 0;
    		for(int r = 0; r < 3; r++)
    		{
    			if(board[r][c].equals("X"))
    				oMatch++;
    		}
    		if(oMatch==3){
    			computer_wins = true;
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    public void printResults()
    {
	if(computer_wins)
		System.out.println("Computer wins");
	else if(human_wins)
		System.out.println("Human Wins");
 	 	for(int r = 0; r < 3 ; r++)
   		{
    		System.out.print("|");
    		for (int c = 0; c < 3; c++)
    			System.out.print(board[r][c]+ "|");
    		System.out.println();
			System.out.println("--+-+--");    	
  	 	}
    }
    
}