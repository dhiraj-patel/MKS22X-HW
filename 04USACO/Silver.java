import java.util.*;
import java.io.*;

public class Silver{
    int[][]pasture;
    int[][]pastureCopy;
    int startx,starty,endx,endy,step;
    public Silver(){
	try{
	    Scanner in = new Scanner(new File("ctravel.in"));
	    int row = in.nextInt();
	    int col = in.nextInt();
	    step = in.nextInt();
	   
	    pasture= new int[row][col];
	    pastureCopy = new int[row][col];
	    for(int r = 0; r < row; r++){
		String line = in.next();
		for(int c = 0; c < col; c++){
		    if(line.charAt(c)=='.'){
			pasture[r][c] = 0;
		    }
		    else{
			pasture[r][c] = -1;
		    }
		}
	    }
	    startx = in.nextInt()- 1;
	    starty = in.nextInt()- 1;
	    endx = in.nextInt()- 1;
	    endy = in.nextInt()- 1;
	}
	catch(FileNotFoundException e){
	    System.out.println("File not Found. please fix!");
	}
    }

    public int solve(){
	pasture[startx][starty] = 1;
	for(int x=0;x<step;x++){
	    for(int i = 0; i < pasture.length; i++){
		for(int j = 0; j < pasture[i].length; j++){
		    int ans = 0;
		    if(i-1 >= 0 && pasture[i-1][j]!=-1){
			ans += pasture[i-1][j];
		    }
		    if(j-1 >= 0 && pasture[i][j-1]!=-1){
			ans += pasture[i][j-1];
		    }
		    if(i+1 < pasture.length && pasture[i+1][j]!=-1){
			ans += pasture[i+1][j];
		    }
		    if(j+1 < pasture[i].length && pasture[i][j+1]!=-1){
			ans += pasture[i][j+1];
		    }
		
		    if(pasture[i][j]!=-1){
			pastureCopy[i][j] = ans;
		    }else{
			pastureCopy[i][j] = -1;
		    }
		
		}
	    }
	    loopForConversion();
	
	}
	return pasture[endx][endy];
    }

    public void loopForConversion(){
	for(int a = 0; a < pasture.length; a ++){
	    for(int b = 0; b < pastureCopy[a].length; b++){
		pasture[a][b] = pastureCopy[a][b];
	    }
	}
    }
  
    public static void main(String[]args){
	Silver t = new Silver();
	System.out.println(t.solve()+",7,Patel,Dhiraj");
    }

    
}
