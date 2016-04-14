import java.util.*;
import java.io.*;

public class BetterMaze{
    public BetterMaze(String f){
	animate=false;
	startRow = -1;
	startCol = -1;
	int maxRow = 0;
	int maxCol = 0;
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(f));
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxRow==0){
		    maxCol = line.length();
		}
		maxRow++;
		ans+=line;
	    }
	}
	catch(FileNotFoundException e){
	    System.out.println("file not found!");
	}
	maze = new char[maxRow][maxCol];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i / maxCol][i % maxCol] = c;
	    if(c == 'S'){
		startRow = i / maxCol;
		startCol = i % maxCol;
	    }
	}
    }
    // inner class idea from ely sandine
    private class Node{
	private int x,y;
	private Node prev;
	public Node(int x, int y, Node p){
	    setX(x);
	    setY(y);
	    setPrev(p);
	}
	public Node(){
	    this(0,0,null);
	}
	public int getX(){
	    return x;
	}
	public int getY(){
	    return y;
	}
	public Node getPrev(){
	    return prev;
	}
	public void setX(int _x){
	    x=_x;
	}
	public void setY(int _y){
	    y=_y;
	}
	public void setPrev(Node n){
	    prev = n;
	}
	
    }
    private char[][] maze;
    private int[] solution;
    private int startRow,startCol;
    private Frontier<Node> placesToGo; 
    private boolean  animate;//default to false


    /* old tostring
       private static final String CLEAR_SCREEN =  "\033[2J";
       private static final String HIDE_CURSOR =  "\033[?25l";
       private static final String SHOW_CURSOR =  "\033[?25h";
       private String go(int x,int y){
       return ("\033[" + x + ";" + y + "H");
       }
       private String color(int foreground,int background){
       return ("\033[0;" + foreground + ";" + background + "m");
       }

       public void clearTerminal(){
       System.out.println(CLEAR_SCREEN);
       }

       public void wait(int millis){
       try {
       Thread.sleep(millis);
       }
       catch (InterruptedException e) {
       }
       }
       public String toString(){
       int maxr = maze.length;
       int maxc = maze[0].length;
       String ans = "";
       if(animate){
       ans = "Solving a maze that is " + maxr + " by " + maxc + "\n";
       }
       for(int i = 0; i < maxc * maxr; i++){
       if(i % maxc == 0 && i != 0){
       ans += color(37,40) + "\n";
       }
       char c =  maze[i / maxc][i % maxc];
       if(c == '#'){
       ans += color(38,47)+c;
       }else{
       ans += color(33,40)+c;
       }
       }
       //nice animation string
       if(animate){
       return HIDE_CURSOR + go(0,0) + ans + color(37,40) +"\n"+ SHOW_CURSOR + color(37,40);
       }else{
       return ans + color(37,40) + "\n";
       }
       }
    */

   
    

    /**return a COPY of solution.
     *This should be : [x1,y1,x2,y2,x3,y3...]
     *the coordinates of the solution from start to end.
     *Precondition : one of the solveXXX methods has already been 
     * called (solveBFS OR solveDFS OR solveAStar)
     *(otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
     **/
    public int[] solutionCoordinates(){
        /** IMPLEMENT THIS **/     
	return solution;
    }    


    /**initialize the frontier as a queue and call solve
     **/
    public boolean solveBFS(){  
	placesToGo = new FrontierQueue<Node>();
	return solve();
    }  
    /**initialize the frontier as a stack and call solve
     **/ 
    public boolean solveDFS(){  
	placesToGo = new FrontierStack<Node>();
	return solve();
    }    

    /**Search for the end of the maze using the frontier. 
       Keep going until you find a solution or run out of elements on the frontier.
    **/
    public boolean solve(){  
	Node temp = new Node(startRow,startCol,null);
	placesToGo.add(temp);
	while(placesToGo.hasNext()){
	    Node current = placesToGo.next();
	    maze[current.getX()][current.getY()] = '.';
	    if(maze[current.getX()-1][current.getY()]=='E'){
		Node one = new Node(current.getX()-1,current.getY(),current);
		solution = getAns(one);
		debug("Solved");
		for(int i = 0;i+1<solution.length;i+=2){
		    maze[solution[i+1]][solution[i]]='@';
		}
		return true;
	    }
	    if(maze[current.getX()][current.getY()-1]=='E'){
		Node one = new Node(current.getX(),current.getY()-1,current);
		solution=getAns(one);
		debug("Solved");
		for(int i = 0;i+1<solution.length;i+=2){
                    maze[solution[i+1]][solution[i]]='@';
		}
		return true;
	    }
	    if(maze[current.getX()+1][current.getY()]=='E'){
		Node one = new Node(current.getX()+1,current.getY(),current);
		solution=getAns(one);
		debug("Solved");
		for(int i = 0;i+1<solution.length;i+=2){
                    maze[solution[i+1]][solution[i]]='@';
                }
		return true;
	    }
				     
	    if(maze[current.getX()][current.getY()+1]=='E'){
		Node one = new Node(current.getX(),current.getY()+1,current); 
		solution=getAns(one);
		debug("Solved");
		for(int i = 0;i+1<solution.length;i+=2){
                    maze[solution[i+1]][solution[i]]='@';
                }
		return true;
	    }
	    if(maze[current.getX()][current.getY()+1]==' '){
		Node tempq = new Node(current.getX(),current.getY()+1,current);
		placesToGo.add(tempq);
	    }
	    if(maze[current.getX()][current.getY()-1]==' '){
		Node tempw = new Node(current.getX(),current.getY()-1,current);
		placesToGo.add(tempw);
	    }
	    if(maze[current.getX()-1][current.getY()]==' '){
		Node tempe = new Node(current.getX()-1,current.getY(),current);
		placesToGo.add(tempe);
	    }
	    if((maze[current.getX()+1][current.getY()]==' ')){
		Node tempr = new Node(current.getX()+1,current.getY(),current);
		placesToGo.add(tempr);
	    }
	    wait(100);
	    if(animate){
		System.out.println(this);
	    }
	}
	return false;
    }
    
    private int[] getAns(Node n){
	Stack<Integer> solution =new Stack<Integer>();
	while(n.getPrev()!=null){
	    solution.push(n.getX());
	    solution.push(n.getY());
	    n=n.getPrev();
	}
	int[]temp=new int[solution.size()];
	int i = 0;
	while(solution.size()>0){
	    temp[i]=solution.pop();
	    i++;
	}
	return temp;
    }
	

    public void setAnimate(boolean b){  
	animate = b;
    }
    private boolean debug=true;
    private void debug(Object o){
	if(debug){
	    System.out.println(o);
	}
    }


    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }

    public void clearTerminal(){
	System.out.println(CLEAR_SCREEN);
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }


    public String toString(){
	int maxr = maze.length;
	int maxc = maze[0].length;
	String ans = "";
	if(animate){
	    ans = "Solving a maze that is " + maxr + " by " + maxc + "\n";
	}
	for(int i = 0; i < maxc * maxr; i++){
	    if(i % maxc == 0 && i != 0){
		ans += color(37,40) + "\n";
	    }
	    char c =  maze[i / maxc][i % maxc];
	    if(c == '#'){
		ans += color(38,47)+c;
	    }else{
		ans += color(33,40)+c;
	    }
	}
	//nice animation string
	if(animate){
	    return HIDE_CURSOR + go(0,0) + ans + color(37,40) +"\n"+ SHOW_CURSOR + color(37,40);
	}else{
	    return ans + color(37,40) + "\n";
	}
    }
    
    
}
