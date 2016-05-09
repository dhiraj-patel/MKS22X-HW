import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{
    private int size;
    private T[] data;
    private boolean isMax;
    public MyHeap(){
	this(true);
    }
    public MyHeap(T[]array){
	isMax = true;
	data = (T[]) new Comparable[10];
	for(int i = 1; i < size-1; i++){
	    data[i]=array[i];
	}
	size = data.length;
    }
    public MyHeap(boolean isMax){
	data = (T[]) new Comparable[10];
	size=0;
	this.isMax = isMax;
    }
    public MyHeap(T[]array, boolean isMax_){
	this(isMax_);
	data=array;
	heapify();
    }
    private boolean compare(T a, T b){
	if(!isMax){
	    return a.compareTo(b)<=0;	    
	}
	else{
	    return a.compareTo(b)>=0;	    
	}
    }
    private void pushDown(int k){
	// need to include a different if here m8
	    if(compare(data[2*k],data[2*k+1])){
		swap(2*k,k);
		pushDown(2*k);
	    }else{
		swap(2*k+1,k);
		pushDown(2*k+1);
	    }
	    
	}
    }
    
    private void swap(int a, int b){
	T temp = data[a];
	data[a]=data[b];
	data[b]=temp;
    }
// push up is good
    private void pushUp(int k){
	if((k>1)&&(compare(data[k],data[k/2]))){
	    swap(k/2,k);
	    pushUp(k/2);
	}
    }
    
    private void heapify(){
	size = data.length;
	doubleSize();
	data[size] = data[0];
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
	if(size==data.length){
	    doubleSize();
	}
	data[size+1] = x;
	size++;
	int index = size;
	while(index!=1 && x.compareTo(data[index/2])>0){
	    pushUp(index);
	    index = index/2;
	}
    }
    private void doubleSize(){
	T[] current = (T[])new Comparable[2*data.length];
	for(int i = 0;i<data.length;i++){
	    current[i]=data[i];
	}
	data = current;
    }

    public String toString(){
	String retStr = "[";
	for(int i = 1; i<size;i++){
	    retStr+=data[i]+", ";
	}

	return retStr+data[size]+"]";

    }

}
