public class QuickFix{
    public static String name(){
	return "7,Patel,Dhiraj";
    }
    public static int quickselectOld(int[]data, int k) {
	return quickselectOld(data, 0, data.length -1, k);
    }
 
    private static int quickselectOld(int[]data, int first, int last, int k) {
	int i = partition(data,first,last);
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


}
