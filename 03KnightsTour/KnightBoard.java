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
    
    public boolean solveH(int r, int c, int step){
	if(r<2||r>= board.length-2||c<2||c>=board[0].length-2){
	    return false;
	}
	if(step==board.length*board[0].length){
	    return true;
	}
	if(board[r][c]!=0){
	    return false;
	}
	for(int x=0;x<board.length;x++){
	    for(int y=0;y<board[0].length;y++){
		if(board[x][y]>=step){
		    board[x][y]=0;
		}
	    }
	}
	board[r][c]=step;
	return solveH(r-1,c+2,step+1)|| solveH(r+2,c-1,step+1)||
	    solveH(r-2,c+1,step+1)||
	    solveH(r+1,c+2,step+1)||
	    solveH(r+2,c+1,step+1)||
	    solveH(r-1,c-2,step+1)||
	    solveH(r-2,c-1,step+1)||
	    solveH(r+1,c-2,step+1);
	    }
    
    public boolean solve(){
	return solveH(2,2,1);
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
	KnightBoard kb = new KnightBoard(7);
	kb.solve();
	kb.printSolution();

    }


}
