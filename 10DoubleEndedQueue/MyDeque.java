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
