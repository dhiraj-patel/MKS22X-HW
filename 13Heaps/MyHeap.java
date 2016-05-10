import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{
    private int size;
    private T[] data;
    private boolean isMax;
    
    //CONSTRUCTORS ARE GOOD
    public MyHeap(){
	this(true);
    }
    public MyHeap(T[]array){
	isMax = true;
	size = array.length-1;
	data = (T[]) new Comparable[10];
	for(int i = 1; i < data.length; i++){
	    data[i]=array[i];
	}
	heapify();
    }
    public MyHeap(boolean isMax){
	data = (T[]) new Comparable[10];
	size=0;
	this.isMax = isMax;
    }
    public MyHeap(T[]array, boolean isMax_){
	isMax = isMax_;
	size = array.length;
	data = (T[])new Comparable[10];
	for(int i = 1;i < data.length ;i++){
	    data[i]=array[i];
	}
	heapify();
    }

    // END OF CONSTRUCTORS
    
    private void swap(int a, int b){
	T temp = data[a];
	data[a]=data[b];
	data[b]=temp;
    }
   
    // HEAPIFY IS GOOD!
    private void heapify(){
	size = data.length;
	for(int i = size/2;i>0;i--){
	    pushDown(i);
	}
    }
    // remove is good
    public T remove(){
	if(size==0){
	    throw new NoSuchElementException("size is zero");
	}
	T ans = data[1];
	data[1] = data[size];
	size-=1;
	pushDown(1);
	return ans;
    }

    public void add(T x){
	if(size+1>=data.length){
	    doubleSize();
	}
	size+=1;
	data[size]=x;
	pushUp(size);
    }
    private void doubleSize(){ 
	T[] current = (T[])new Comparable[2*data.length];
	for(int i = 0;i<data.length;i++){
	    current[i]=data[i];
	}
	data = current;
    }
    private boolean compare(T a, T b){
	if(isMax){
	    return a.compareTo(b)>0;	    
	}
	else{
	    return b.compareTo(a)>0;	    
	}
    }
    private void pushUp(int i){
	while(i>1 && compare(data[i],data[i/2])){
	    swap(i/2,i);
	    i=i/2;
	}
    }
    private void pushDown(int k){
	if(k*2+1<=size){
	    if(compare(data[k*2],data[k*2+1])){
		swap(k*2,k);
		pushDown(k*2);
	    }else{
		swap(k*2+1,k);
		pushDown(k*2+1);
	    }
	}else{
	    if(k*2<size){
		swap(k*2,k);
	    }
	}
    }

	    
    public T peek(){
	if(size==0){
	    throw new NoSuchElementException("size is zero");
	}
	return data[1];
    }

    public String toString() {
	String ret = "[";
	for (int i = 1; i < size; i++) {
	    ret += data[i] + ", ";
	}
	if (size > 0){
	    ret += data[size];
	}
	ret += "]";
	return ret;
    }

    public static void main(String[] args) {
	MyHeap a = new MyHeap<Integer>();
	//System.out.println(a);
	a.add(2);
	a.add(5);
	a.add(-1);
	a.add(7);
	a.add(9);
	//System.out.println(a);
	a.remove();
	Integer[] bA = {-1, -2, 4, 11, 7, 0, 3};
	System.out.println("Start: "+Arrays.toString(bA));
	MyHeap b = new MyHeap<Integer>(bA);
	System.out.println("End: "+b);
    }
	
}
