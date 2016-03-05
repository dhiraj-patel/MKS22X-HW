public class Sorts {
    private int[] array;
    private int[] tempMergArr;
    private int length;

    
    
    public static void main(String[]args){
	int[] arrayToSort = {3, 4, 6, 2, 4, 8, 4,12,34,12,123, 6, 5, 3};
	arrayToSort = sort(arrayToSort);
	String ans = "";
	for (int i = 0; i < arrayToSort.length-1; i++) {
	    ans+=(" " + arrayToSort[i] + ", ");
	}
	System.out.println(ans.substring(0,ans.length()-2));
    }
     
    public static int[] sort(int[]inputArr) {
	int[] array = inputArr;
        int length = inputArr.length;
        int[] tempMergArr = new int[length];
        mergeSort(array, length, tempMergArr, 0, length - 1);
	return array;
    }
    
    
    private static int[] mergeSort(int[] array, int length, int[] tempMergArr, int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2; // finds the splitting point
            mergeSort(array, length, tempMergArr, lowerIndex, middle);// merge of the first half
            mergeSort(array, length, tempMergArr, middle + 1, higherIndex); // merge the second half
            mergeParts(array, length, tempMergArr, lowerIndex, middle, higherIndex);
        }
	return array;
    }
 
    private static int[] mergeParts(int[] array, int length, int[] tempMergArr, int lowerIndex, int middle, int higherIndex) {
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
	return array;
    }
}
