public class FrontierQueue<T> extends MyQueue<T> implements Frontier<T>{
    public void add(T element){
	enqueue(element);
    }
    public T next(){
	return dequeue();
    }
    public boolean hasNext(){
	return size()!=0;
    }
}
			    
    
    