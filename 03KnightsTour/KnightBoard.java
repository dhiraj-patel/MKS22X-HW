public class KnightBoard{
    private int[][] board;
    private int totalSize;
    public KnightBoard(int n){
	board = new int[n+4][n+4];
	totalSize = (n+4)*(n+4);
	setupBoard();	
    }
    public KnightBoard(int row,int col){
	board = new int[row+4][col+4];
	totalSize = (row+4)*(col+4);
	setupBoard();
    }
    public String name(){
	return "Patel,Dhiraj";
    }
    public void setupBoard(){
	for(int r = 0; r < board.length; r++){
	    for(int c =0;c<board[r].length;c++){
		if(r<2||r>board.length-2||c<2||c>board[0].length-2){
		    board[r][c] = -1;
		}
		else{
		    board[r][c] = 0;
		}
	    }
	}

    }
    public boolean addKnight(int r,int c, int num){
	if(board[r][c] == 0){
	    board[r][c] = num;
	    return true;
	}
	else{
	    return false;
	}

    }
    public boolean removeKnight(int r,int c,int num){
	if(board[r][c]>0){
	    board[r][c] = 0;
	    return true;
	}
	else{
	    return false;
	}
    }
    public boolean solve(){
	for(int r = 2;r<board.length-2;r++){
	    for(int c = 2; c< board[0].length - 2;c++){
		if(solveH(r,c,1)){
		    return true;
		}
	    }
	}
	
	return false;
    }
    


    public boolean solveH(int row,int col, int step){
	boolean works = false;
	// checks the borders
	if(row<2||row>= board.length-2||col<2||col>=board[0].length-2){
	    return false;
	}
	// checks the step border move
	if(step == ((board.length-4) * (board[0].length -4)+1)){
	    return true;
	}
	// past the basecases
	else{
	    if(addKnight(row,col,step)){
		works = false ||
		    solveH(row + 1,col+2,step+1) ||
		    solveH(row + 1,col-2,step+1) ||
		    solveH(row + 2,col+1,step+1) ||
		    solveH(row + 2,col-1,step+1) ||
		    solveH(row - 2,col+1,step+1) ||
		    solveH(row - 2,col-1,step+1) ||
		    solveH(row - 1,col+2,step+1) ||
		    solveH(row - 1,col+2,step+1);
		if(works){
		    return true;
		}else{
		    removeKnight(row,col,step);
		}
	    }else{
		return false;
	    }
	}
	return false;
    }

	
    
    public void printSolution(){
    String ans = "";	
    for(int r=2;r <board.length-2;r++){
	for(int c = 2;c<board[r].length-2;c++){
	    if(board[r][c] == 0){
		ans+=" _ ";
	    }
	    else{
		ans += " " + board[r][c] + " ";
		}
	}
	ans+="\n";
    }
    System.out.println(ans);
    }
    public static void main(String[]args){
	KnightBoard kb = new KnightBoard(5,6);
	kb.solve();
	kb.printSolution();
    }


}
