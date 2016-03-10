import java.util.*;
public class QuickSort{
    public static String name(){
	return "7,Patel,Dhiraj";
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
	int[]array = {3,4,-5,6,5,89,0,23,5,55,87,-15};
	System.out.println("Array to be sorted:");
	printArray(array);
	quickSort(array);
	System.out.println("New Sorted Array:");
	printArray(array);
    }
}
