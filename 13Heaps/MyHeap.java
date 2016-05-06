import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{
    private int size;
    private T[] data;
    private boolean isMax;
    public MyHeap(){
	isMax=true;
	data = (T[]) new Comparable[10];
	size = 0;
    }
    public MyHeap(T[]array){
	isMax = true;
	data = (T[]) new Comparable[10];
	for(int i = 1; i < size-1; i++){
	    data[i]=array[i];
	}
	size = data.length;
    }
    // i am bigger than children thats all that matters
    private void pushDown(int k){
	//check maxHeap or minHeap
	if(data[k].compareTo(data[k*2])>0){
	    swap(k,k*2);
	}else if(data[k].compareTo(data[k*2+1])<0){
	    swap(k,k*2+1);
	}
    }






    private void swap(int a, int b){
	T hold = data[a];
	data[a]=data[b];
	data[b]=hold;
    }

    private void pushUp(int k){
	//check maxHeap or minHeap
	if(data[k].compareTo(data[k/2])>0){
	    swap(k,k/2);
	}
    }

    private void heapify(){
	
    }

    public T delete(){}

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
	String s = "[";
	for(int i = 1; i < size; i++){
	    s+=data[i];
	    if(i < size-1){
		s+=", ";
	    }
	}
	return s;
    }

	//do this last
    public MyHeap(boolean isMax){}
    public MyHeap(T[] array, boolean isMax){}

	}
