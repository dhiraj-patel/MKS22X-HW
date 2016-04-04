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
    
