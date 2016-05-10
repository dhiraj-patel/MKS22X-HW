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
    public MyHeap(T[]array, boolean isMax){
	this(isMax);
	data = array;
	heapify();
    }
    // END OF CONSTRUCTORS

    // HELPER FUNCTIONS
    private boolean compare(T a, T b){
	if(isMax){
	    return a.compareTo(b)>0;
	}
	else{
	    return b.compareTo(a)>0;
	}
    }
    private void swap(int a, int b){
	T temp = data[a];
	data[a]=data[b];
	data[b]=temp;
    }
    
    private void heapify(){
	size = data.length;
	doubleSize();
	data[size]=data[0];
	for(int i = size/2;i>0;i--){
	    pushDown(i);
	}
    }
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
    
    private void pushUp(int i){
	while(i>1 && compare(data[i],data[i/2])){
	    swap(i/2,i);
	    i=i/2;
	    pushUp(i/2);
	}
    }
 
     private void pushDown(int k) {
	 while (k < size/2 && !(compare(data[k],data[2*k]) && (compare(data[k],data[2*k+1])))){
	     if(compare(data[2*k],data[2*k+1])){
		swap(2*k,k);
		pushDown(2*k);
	    }else{
		swap(2*k+1,k);
		pushDown(2*k+1);
	    }
	}
     }

    public T peek(){
	if(size==0){
	    throw new NoSuchElementException("size is zero");
	}
	return data[1];
    }
    public String toString(){
	String ans = "[";
	for(int i = 1; i<size;i++){
	    ans +=data[i]+", ";
	}
	return ans+data[size]+"]";
    }
    public int size(){
	return size;
    }
    public static void main(String[]args){
	Integer[]data={3,2,4,5,7,8,3};
	MyHeap<Integer> m1 = new MyHeap<Integer>(data,true);
	System.out.println(m1);
	    
    }
}
