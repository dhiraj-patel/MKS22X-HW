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
	size = array.length;
	data = (T[]) new Comparable[size+1];
	for(int i = 1; i <=size; i++){
	    data[i]=array[i-1];
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
	data = (T[])new Comparable[array.length+1];
	for(int i = 1;i<=(size);i++){
	    data[i]=array[i-1];
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
    private void pushDown(int pos){
	if(pos*2+1<=size){
	    if(compare(data[pos*2],data[pos*2+1])){
		T temp=data[pos*2];
		data[pos*2]=data[pos];
		data[pos]=temp;
		pushDown(pos*2);
	    }else{
		T temp=data[pos*2+1];
		data[pos*2+1]=data[pos];
		data[pos]=temp;
		pushDown(pos*2+1);
	    }
	}else{
	    if(pos*2<=size){
		T temp=data[pos*2];
		data[pos*2]=data[pos];
		data[pos]=temp;
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
	String temp="";
	for (int i=1;i<=size;i++){
	    temp+=data[i]+" ";
	}
	return temp;
	
    }
    public static void main(String[]args) {
	//MyHeap<Integer> a = new MyHeap<>();
	MyHeap<Integer> a = new MyHeap<>(false);
	a.add(56);
	System.out.println(a);
	a.add(40);
	a.add(35);
	a.add(87);
	a.add(7);
	a.add(27);
	a.add(18);
	System.out.println(a);
	a.remove();
	System.out.println(a);
	//Integer [] r = {7,18,27,35,40,56,87};
	Integer [] r= {10,15,9,2000,2,6,7,5000,60,3,15,100,20,3,1};
	MyHeap<Integer> b = new MyHeap<>(r);
	System.out.println(b);
    }
	
}
