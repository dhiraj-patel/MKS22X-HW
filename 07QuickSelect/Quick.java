import java.util.*;
public class Quick{
    public static String name(){
	return "7,Patel,Dhiraj";
    }
    public static int quickselectOld(int[]data, int k) {
	return quickselectOld(data, 0, data.length -1, k);
    }
 
    private static int quickselectOld(int[]data, int first, int last, int k) {
	int i = partitionOld(data,first,last);
	if(i==k){
	    return data[k];
	}else if(i>k){
	    return quickselectOld(data,first,i-1,k);
	}else{
	    return quickselectOld(data,i+1,last,k);
	}
    }
 
    private static int partitionOld(int[] data, int first, int last) {
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
    public static void quickSortOld(int[]data){
	quickSortOld(data, 0, data.length -1);
    }
    private static void quickSortOld(int[]data,int l, int r){
	if(l<r){
	    int index = partitionOld(data,l,r);
	    quickSortOld(data,l,index-1); // quicksort hte left
	    quickSortOld(data,index+1,r); // quicksort hte right
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
    public static int partition(int data[], int left, int right){
	int i = left;
	int j = right;
	int temp;
	int pivot = data[(left + right) / 2];
     	while (i <= j) {
            while (data[i] < pivot)
		i++;
            while (data[j] > pivot)
		j--;
            if (i <= j) {
		temp = data[i];
		data[i] = data[j];
		data[j] = temp;
		i++;
		j--;
            }
	};
     
	return i;
    }
 
    public static void quickSort(int data[], int left, int right) {
	int index = partition(data, left, right);
	if (left < index - 1)
            quickSort(data, left, index - 1);
	if (index < right)
            quickSort(data, index, right);
    }

    public static void main(String[]args){
	int[] b=new int[4000000];
	for(int i=0;i<b.length;i++){
	    b[i]=(int)(Math.pow(-1,(int)(Math.random()*2)))*Integer.MAX_VALUE;
	}
	quickSort(b,0,b.length-1);
	
    }
}
