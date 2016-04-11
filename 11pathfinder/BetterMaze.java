import java.util.*;
import java.io.*;

public class BetterMaze{
    // put in node class here
    private char[][] maze;
    private int[]    solution;
    private int      startRow,startCol;
    private Frontier<???> placesToGo; 
    private boolean  animate;//default to false

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
    }    


    /**initialize the frontier as a queue and call solve
    **/
    public boolean solveBFS(){  
	return false;
    }   


   /**initialize the frontier as a stack and call solve
    **/ 
    public boolean solveDFS(){  
	return false;
    }    

   /**Search for the end of the maze using the frontier. 
      Keep going until you find a solution or run out of elements on the frontier.
    **/
    public boolean solve(){  
        /** IMPLEMENT THIS **/  
	return false;
    }    
     
   /**mutator for the animate variable  **/
    public void setAnimate(boolean b){  /** IMPLEMENT THIS **/ }    



}
