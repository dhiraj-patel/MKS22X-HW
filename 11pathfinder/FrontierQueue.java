import java.util.*;
public class FrontierQueue<T> implements Frontier<T>{
    private ArrayDeque<T> frontier;
    public void add(T element){
	frontier.add(element);
    }
    public T next(){
	return frontier.getFirst();
    }
    public boolean hasNext(){
	return !frontier.isEmpty();
    }
}
			    
    
    