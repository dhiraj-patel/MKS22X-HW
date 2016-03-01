public class Sorts{
    public static void printArray(int[]data){
	String res = "[";
	for (int i = 0; i < data.length; i++){
	    res += " " + data[i];
	    if (i != (data.length - 1)){
		res += ",";
	    }
	}
	System.out.println(res + "]");
    }

    //INSERTION SORT
    
    public static void insertionSort(int[]data){
	for (int i = 1; i < data.length; i++){
	    int old = data[i];
	    int j = i;
	    while(j > 0  && data[j-1] > old){
		data[j] = data [j - 1];
		j--;
	    }
	    data[j] = old;
	}
    }
    
    // SELECTION SORT


    // look for the lowerst put in box 1
    // look for lowest from index 1 to end put that in index 1
    
    public static void selectionSort(int[]data){
	int lowestValue = data[0];
	for(int i = 0;i < data.length; i++){  
	    if (data[i] < lowestValue){
		lowestValue = data[i];
		
	    }
	}
	System.out.print(lowestValue);
	int x = data[0];
	data[0] = lowestValue;
	


}

    
    