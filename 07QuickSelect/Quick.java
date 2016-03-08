import java.util.*;
public class Quick{
    public static void partition(int[] array, int start, int end) {
	int[] l = new int[array.length];
	for (int i = 0; i < array.length; i++) {
	    if (i < start || i > end) {
		l[i] = array[i];
	    }
	}
	int pivot = start + (int) (Math.random() * (end - start + 1));
	int value = array[pivot];
	int ei = end;
	System.out.println("Pivot: " + value);
	for (int i = start; i <= ei; i++) {
	    printArray(l);
	    if (i != pivot) {
		if (array[i] < value) {
		    l[start++] = array[i];
		}
		else {
		    l[end--] = array[i];
		}
	    }
	}
	l[start] = value;
	printArray(l);
    }

    public static String printArray(int[]array){
	String ans = "";
	for(int i = 0; i < array.length; i++){
	    ans+=array[i]+" ";
	}
	ans = ans.substring(0,ans.length()-1);
	return ans;
    }
    
    public static void main(String[]args){
	int[]test = {1,2,3,4,5,5};
	System.out.println(printArray(test));
    }


}
