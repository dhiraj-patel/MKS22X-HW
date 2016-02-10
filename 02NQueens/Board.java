public class Board{
    int[][]board;
    public Board(int n){
	board = new int[n][n];
	for(int r = 0;r < board.length;r++){
	    for(int c = 0;c<board[r].length;c++){
		board[r][c] = 0;
	    }
	}
	// initiallize them all to zeroes
    }

    /**
     *precondition: board is filled with 0's only.
     *postcondition: 
     *-return false, and board is still filled
     *with 0's for a board that cannot be solved.
     *-return true, and board is filled with the 
     *final configuration of the board after adding 
     *all n queens.
     */
    public boolean solve()
    {
	return false;
    }

    /**
     *Helper method fr solve. 
     */
    private boolean solveH(int col){
	return false;
    }
    
    public void printSolution(){
	String unFilteredSolution = board.toString();
	for(int i = 0; i<unFilteredSolution.length();i++){
	    if(Integer.parseInt(i) <= 0){
		i = '-';
	    }
	    else{
		i = 'Q';
	    }
	}
	System.out.println(unFilteredSolution);
	
    }
    
    




    //  ADDING AND REMOVING METHODS

    private boolean addQueen(int row, int col){
	if(board[row][col] != 0){
	    return false;
	}
	board[row][col] = 1;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]--;
	    if(row - offset >= 0){
		board[row-offset][col+offset]--;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]--;
	    }
	    offset++;
	}
	return true;
    }

    private boolean removeQueen(int row, int col){
	if(board[row][col] != 1){
	    return false;
	}
	board[row][col] = 0;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]++;
	    if(row - offset >= 0){
		board[row-offset][col+offset]++;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }


    
    /* MY ADD QUEEN AND REMOVE QUEEN; just to show that I did the work but Mr. K had much better code. :( 


       public void addQueen(int row, int col){
       board[row][col] = 1; // creates a queen at the paramterized spot
       for(int i = col+1; i<board[row].length;i++){
       board[row][i]-=1;
       }// decrements the horizontal nubmers to the right

       int rowToCheck = row +1;
       for(int i = col+1; i < board[row].length && rowToCheck < board.length; i++){
       board[rowToCheck][i]--;
       rowToCheck+=1;
       }
       rowToCheck = row -1; // decrement row to get back to the queens place
       for(int i = col + 1; i < board[row].length&&rowToCheck>= 0;i++){
       board[rowToCheck][i]-=1;
       rowToCheck-=1;
       }
       }

       public void removeQueen(int r, int c){
       board[r][c] = 0;// makes parameterized spot unqueened
       for(int i = c+1; i<board[r].length;i++){
       board[r][i]++;
       }
       int rowToCheck = r+1;
       for(int x = c+1; rowToCheck<board.length&&x<board[r].length;x++){
       board[rowToCheck][x]++;
       rowToCheck+=1;
       }
       rowToCheck = r -1;
       for(int d =c+1;d <board[r].length&&rowToCheck >=0;d++){
       board[rowToCheck][d]++;
       rowToCheck--;
       }

       }

    */


    public String toString(){
	String ans = "";
	for(int r = 0;r<board.length;r++){
	    for(int c = 0; c<board[r].length;c++){
		ans+=(board[r][c]+" ");
	    }
	    ans+=("\n");
	}
	return ans; 
    }

    public static void main(String[]args){
	Board b = new Board(5);
        System.out.println(b);
	b.addQueen(3,0);
	b.addQueen(0,1);
        System.out.println(b);
	b.removeQueen(3,0);
        System.out.println(b);
    }

}





	
  
