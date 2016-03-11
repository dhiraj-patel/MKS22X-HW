import java.util.*;
public class Quick{
    public static String name(){
	return "7,Patel,Dhiraj";
    }
    public static int quickselect(int[]data, int k) {
	return quickselect(data, 0, data.length -1, k);
    }
 
    private static int quickselect(int[]data, int first, int last, int k) {
	int i = partition(data,first,last);
	if(i==k){
	    return data[k];
	}else if(i>k){
	    return quickselect(data,first,i-1,k);
	}else{
	    return quickselect(data,i+1,last,k);
	}
    }
 
    private static int partition(int[] data, int first, int last) {
	int pivot = first + new Random().nextInt(last - first + 1);
	swap(data, last, pivot);
	for (int i = first; i < last; i++) {
	    if (data[i] < data[last]) {
		swap(data, i, first);
		first++;
	    }
	}
	swap(data, first, last);
	return first;
    }
    private static void swap(int[]data, int i, int j) {
	int temp = data[i];
	data[i] = data[j];
	data[j] = temp;
    }
    public static void quickSort(int[]data){
	quickSort(data, 0, data.length -1);
    }
    private static void quickSort(int[]data,int l, int r){
	if(l<r){
	    int index = partition(data,l,r);
	    quickSort(data,l,index-1); // quicksort hte left
	    quickSort(data,index+1,r); // quicksort hte right
	}
    }
    public static void printArray(int[]data){
	String ans = "{ ";
	for(int i = 0 ; i < data.length-1; i++){
	    ans += data[i] + ", ";
	}
	ans += data[data.length-1]+" }";
	System.out.println(ans);
    }


    public static void main(String[]args){
	int[]array = {-96, -91, -88, -87, -81, -74, -69, -63, -60, -56, -48, -46, -44, -41, -38, -29, -28, -25, -24, -21, -20, -13, -9, -8, -7, -4, 6, 11, 13, 17, 20, 26, 29, 30, 33, 39, 49, 55, 56, 65, 66, 67, 70, 78, 84, 85, 86, 88, 89, 91};
	System.out.println(quickselect(array,0));
	

	System.out.println("HERE IS THE RESULTS FOR THE QUICKSORT");
	int[] d = new int [4000000];
	int[] c = new int [d.length];

	for(int i = 0; i < d.length; i++){
	    d[i]= (int)(Math.random()*Integer.MAX_VALUE);
	    c[i]= d[i];
	}
	quickSort(d); //or even your old quicksort!!!
	Arrays.sort(c);
	System.out.println("Done: Sorted="+Arrays.equals(d,c));

    }
}
