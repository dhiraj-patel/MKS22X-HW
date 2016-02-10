public class Board{
    int[][]board;
    public Board(int n){
	board = new int[n][n];
	for(int r = 0;r < board.length;r++){
	    for(int c = 0;c<board[r].length;c++){
		board[r][c] = 0;
	    }
	}
	// initiallize them all to zerooes

    }
    

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
    
    public void printBoard(){
	for(int r = 0;r<board.length;r++){
	    for(int c = 0; c<board[r].length;c++){
		System.out.print(board[r][c]+" ");
	    }
	    System.out.println("\n");
	}
    }



}





	
  