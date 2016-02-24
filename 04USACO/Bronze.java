import java.util.*;
import java.io.*;

public class Bronze{
    int[][]pasture;
    int[][]stompDepth;
    int lakeElev;
    
    public Bronze(){
	File f = new File("makelake.in");
	try{
	    Scanner scan = new Scanner(f);
	    pasture = new int[scan.nextInt()][scan.nextInt()];     
	    lakeElev = scan.nextInt();
	    int depthToStomp = scan.nextInt();

	    for(int r=0; r<pasture.length; r++){
		for(int c=0; c<pasture[r].length; c++){
		    pasture[r][c]=scan.nextInt();
		}
	    }
	    stompDepth = new int[depthToStomp][3];
	    for(int x=0; x<depthToStomp; x++){
		for(int n=0; n<3; n++){
		    stompDepth[x][n]=scan.nextInt();
		}
	    }

	    scan.close();
	}catch(FileNotFoundException e){
	    System.out.println("No such file");
	}

	stomp();
	dig();
	getVolume();
    }

    
    public void dig(){
	for(int r=0; r<pasture.length; r++){
	    for(int c=0; c<pasture[r].length; c++){
		pasture[r][c]=lakeElev-pasture[r][c];
		if(pasture[r][c]<0){
		    pasture[r][c]=0;
		}
	    }
	}
    }
    
    // utilizin the max vlues to stomp()
    public void stomp(){
	int count = 0;
	while(count < stompDepth.length){
	    int DChange = stompDepth[count][2];
	    int RChange = stompDepth[count][0]-1;
	    int CChange = stompDepth[count][1]-1;
	    
	    int max=0;
	    for(int row=RChange; row<RChange+3; row++){
		for(int col=CChange; col<CChange+3; col++){
		    if((pasture[row][col]>=max)){
			max=pasture[row][col];
		    }
		}
	    }
	    max = max - DChange;
	    for(int row=RChange; row<RChange+3; row++){
		for(int col=CChange; col<CChange+3; col++){
		    if(pasture[row][col]>=max){
			pasture[row][col]=max;
		    }
		}
	    }
	    count++;
	}
    }

    
    public void getVolume(){
	int ans = 0;
	for (int i = 0; i < pasture.length; i++) {
	    for (int j = 0; j < pasture[i].length; j++) {
		ans+=pasture[i][j];
	    }
	}
	ans = 72*72*ans;
	System.out.println(ans+" ,7,Patel,Dhiraj");
    }

    public static void main(String[]args){
	Bronze board = new Bronze();
    }
}
