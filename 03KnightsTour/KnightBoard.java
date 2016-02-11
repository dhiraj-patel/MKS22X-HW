public class KnightBoard{
    private int[][]board;
    private int size;
    private int sizeWithBorder;
    public KnightBoard(int n){
	board = new int[n+4][n+4]; // make a new board with borders
	for(int r=2;r<board.length-2;r++){
	    for(int c=2;c<board[r].length-2;c++){
		board[r][c]=0;
	    }
	} // block above initializes all the inner ones to 0
	for(int r = 0; r<board.length;r++){
	    for(int c = 0;c<board[r].length;c++){
		if(board[r][c]!=0){
		    board[r][c]=-1;
		}
	    }
	} // block above initializes all the border ones to -1
	size = n;
	sizeWithBorder = n + 4;
    }
    
     public void printSolution(){
        String unFilteredSolution = "";
        for(int r = 0;r < sizeWithBorder;r++){
            for(int c=0;c<sizeWithBorder;c++){
		if(board[r][c]<= 0){
                    unFilteredSolution+="b ";
		}
                else{
                    unFilteredSolution+="0 ";
		}
            }
            unFilteredSolution+="\n";
        }
        System.out.println(unFilteredSolution);
    }

    
   
      	
    
