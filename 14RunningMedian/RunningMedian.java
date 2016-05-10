import java.util.*;
public class RunningMedian{
    private MyHeap<Integer>min;
    private MyHeap<Integer>max;
    //Create an empty running median set.
    public RunningMedian(){
	min = new MyHeap<Integer>(true);
	max = new MyHeap<Integer>(false);
    }
    //  When empty: throws new NoSuchElementException()
    //  Returns the median value
    public double getMedian(){
	if(min.size() == 0 || max.size() == 0){
	    throw new NoSuchElementException();
	}
	if(min.size()>max.size()){
	    return min.peek();
	}
	else if(min.size()<max.size()){
	    return max.peek();
	}
	else{
	    return((min.peek()+max.peek())/2);
	}
    }
    //  add to the "SmallValue" heap if  x < median, 
    //  add to the "BigValue" heap otherwise. 
    //  balance the two heaps so that their size differ by no more than 1. 
    public void add(Integer x){
	if(min.size()+max.size()==0){
	    min.add(x);
	}
	else if(x<getMedian()){
	    min.add(x);
	    if(min.size()-max.size()>1){
		max.add(min.remove());
	    }
	}else{
	    max.add(x);
	    if(max.size()-min.size()>1){
		min.add(max.remove());
	    }
	}
    }
	    
    




}
