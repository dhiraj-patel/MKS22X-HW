public class QuickSelect{
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
	    printArr(l);
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
	printArr(l);
    }
    
}
