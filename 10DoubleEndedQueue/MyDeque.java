import java.util.*;
public class MyDeque<T>{
    private T[]deque;
    private int start,end,size;
    @SuppressWarnings("unchecked");
    public MyDeque(int _size){
	deque=(T[])(new Object[_size]);
	start=0;
	end=_size-1;
	size=0;
    }
    public MyDeque(){
	this(10);
    }
    public int size(){
	return size;
    }
    @SuppressWarnings("unchecked")
    public void grow(){
	if(size==deque.length){
	    T[]temp=(T[])(new Object[size*2]);
	    for(int i = 0; i < size; i++){
		temp[i] = deque[(head+i)%size];
	    }
	    deque=temp;
	    start=0;
	    end=size-1;
	}
    }
    public void addFirst(T value){
	if(value == null){
	    throw new NullPointerException("Value is null");
	}
	grow();
	start--;
	if(start<0){
	    start+=deque.length;
	}
	deque[start]=value;
	size++;
    }
      public void addLast(T value){
	if(value == null){
	    throw new NullPointerException();
	}
	grow();
	end++;
	if(end>=deque.length){
	    if(end!=0){
		end-=deque.length;
	    }
	}
	deque[end]=value;
	size++;
    }
  public T removeFirst(){
	if(size==0){
	    throw new NoSuchElementException("size is 0");
	}
	T temp = deque[start];
	deque[start]=null;
	start++;
	if(start>=deque.length){
	    start-=deque.length;
	}
	size--;
	return temp;
    }
    public T removeLast(){
	if(size == 0){
	    throw new NoSuchElementException("size is zero");
	}
	T temp = deque[end];
	deque[end] = null;
	end--;
	if(end < 0){
	    end += deque.length;
	}
	size--;
	return temp;
    }
