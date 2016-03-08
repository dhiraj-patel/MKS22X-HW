import java.util.*;
public class Sorts{
    public static String name(){
	return "7,Patel,Dhiraj";
    }
    public static void main(String[] args) {
        int[] list = {5,123,5,3,2,-1,23,12,-1000,-59,-29};
	if(list.length<1){
	    System.out.println("No elements in list!");
	}else{
	    mergeSort(list);
	    System.out.println("Abra-Cadabra: New Sorted Array:  " + Arrays.toString(list));
	}
    }
    public static void mergeSort(int[] array) {
        if (array.length > 1) {
	    int[] left = lefty(array);
            int[] right = righty(array);
	    mergeSort(left);
            mergeSort(right);
	    merge(array, left, right);
        }
    }
    public static int[] righty(int[] array) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        int[] right = new int[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = array[i + size1];
        }
        return right;
    }
    public static int[] lefty(int[] array) {
        int size1 = array.length / 2;
        int[] left = new int[size1];
        for (int i = 0; i < size1; i++) {
            left[i] = array[i];
        }
        return left;
    }

    public static void merge(int[] result,int[] left, int[] right) {
        int r = 0;  
        int c = 0;  
	for (int i = 0; i < result.length; i++) {
            if (c >= right.length || (r < left.length &&left[r] <= right[c])) {
                result[i] = left[r];    
                r++;
            } else {
                result[i] = right[c];   
                c++;
            }
        }
    }
}
