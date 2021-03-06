public class Recursion implements hw01{
    public String name(){
	return "Patel,Dhiraj";
    }

    //1.2;
    public double sqrt(double n){
	if ( n < 0 ){
	    throw new IllegalArgumentException();
	}
	if(n == 0){
	    return n;
	}
	if(n == 1){
	    return n;
	}

	return sqrtHelp(n,(n/2));
      
    }

    public double sqrtHelp(double n, double guessNum){
	if(Math.abs((((guessNum * guessNum) - n) / n)) < .00001){
	    return guessNum;
	}
	else{
	    guessNum = (n/guessNum+guessNum)/2;
	    return sqrtHelp(n,guessNum);
	}
    }



}