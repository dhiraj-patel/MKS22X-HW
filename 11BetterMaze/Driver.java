import java.util.*;
public class Driver{
    public static void main(String[]args){
	BetterMaze m1 = new BetterMaze("data1.dat");
	m1.setAnimate(true);
	if(args.length>0){
	    System.out.println(m1.solveBFS());
	}else{
	    System.out.println(m1.solveDFS());
	}
	System.out.println(Arrays.toString(m1.solutionCoordinates()));
	System.out.println(m1);
    }
}
