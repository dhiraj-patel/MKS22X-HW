import java.util.*;
import java.io.*;

public class Maze{
    private char[][]maze;
    private int startx,starty;
    private boolean animate;

    public Maze(String filename, boolean ani){
        animate=ani;
        try{
            Scanner sc=new Scanner(new File(filename));
            int rows=0;
            int cols=0;
            String first;
            while(sc.hasNextLine()){
                rows+=1;
                first=sc.nextLine();
                cols=first.length();
            }
            maze=new char[rows][cols];
            Scanner sc2=new Scanner(new File(filename));
            for(int i=0;i<rows;i++){
                first=sc2.nextLine();
                for(int j=0;j<cols;j++){
                    maze[i][j]=first.charAt(j);
                    if(first.charAt(j)=='S'){
                        startx=i;
                        starty=j;
                    }
                }
            }
        }catch(FileNotFoundException e){
	    System.out.println("no file");
        }
    }

    public boolean solve(){
        if(startx < 0){
            System.out.println("No starting point 'S' found in maze.");
            return false;
        }else{
            maze[startx][starty] = ' ';
            return solve(startx,starty);
        }
    }

    private boolean solve(int x, int y){
        if(animate){
            System.out.println(this);
	    wait(20);
        }
        if(maze[x][y]=='E'){
            return true;
        }
        if(maze[x][y]!=' '){
            return false;
        }
        maze[x][y]='@';
        if(!(solve(x+1,y)||solve(x-1,y)||solve(x,y+1)||solve(x,y-1))){
            maze[x][y]='.';
            return false;
        }
        return true;
    }
    //FREE STUFF!!! *you should be aware of this*                                                                                                             

    public void clearTerminal(){
        System.out.println(CLEAR_SCREEN);
    }

    public String toString(){
        int maxx = maze.length;
        int maxy = maze[0].length;
        String ans = "";
        if(animate){
            ans = "Solving a maze that is " + maxy + " by " + maxx + "\n";
        }
        for(int i = 0; i < maxx; i++){
            for(int k = 0; k < maxy; k++){
                char c =  maze[i][k];
                if(c == '#'){
		    ans += color(38,47)+c;
		}else{
                    ans += color(33,40)+c;
                }
            }
            ans+='\n';
        }
        return HIDE_CURSOR + go(0,0) + ans + "\n" + SHOW_CURSOR + color(37,40);
    }



    //MORE FREE STUFF!!! *you can ignore all of this*                                                                                                         
    //Terminal keycodes to clear the terminal, or hide/show the cursor                                                                                        
    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    //terminal specific character to move the cursor                                                                                                          
    private String go(int x,int y){
        return ("\033[" + x + ";" + y + "H");
    }

    private String color(int foreground,int background){
        return ("\033[0;" + foreground + ";" + background + "m");
    }

    private void wait(int millis){
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }

}
    //END FREE STUFF                                                                                                                                          


