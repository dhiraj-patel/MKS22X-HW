import java.util.*;
public class RunningMedian{
    private MyHeap<Integer> max;
    private MyHeap<Integer> min;

    public RunningMedian(){
	max = new MyHeap<Integer>(true);
	min = new MyHeap<Integer>(false);
    }

    public double getMedian(){
	if(max.size()==0&&min.size()==0){
	    throw new NoSuchElementException();
	}
	else if (max.size() == 1 && min.size() == 0){
	    return max.peek();
	}
	else if(max.size() == min.size() - 1 || max.size() == min.size() + 1){
	    return min.peek();
	}
	else{
	    return (min.peek() + max.peek()) / 2;
	}
    }
    public void add(Integer x){
	try{
	    if(x>getMedian()){
		min.add(x);
	    }else{
		max.add(x);
	    }
	}
	catch(NoSuchElementException e){
	    max.add(x);
	}
	if (max.size() > min.size() + 1){
	    min.add(max.remove());
	}
	else if(min.size() > max.size() + 1){
	    max.add(min.remove());
	}
    }
}
