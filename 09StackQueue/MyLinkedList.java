import java.util.*;
public class MyLinkedList<T> implements Iterable<T>{
    private LNode start, end;
    private int size;
    public String name(){
	return "Patel,Dhiraj";
    }
    public MyLinkedList(){
	start = null;
	size=0;
	end = start;
    }
    public MyLinkedList(LNode _start){
	start=_start;
	end=start;
	size=1;
    }
    public int size(){
	return size;
    }
    public String toString() {
	LNode current = start;
	if(current == null) {
	    return "[]" ;
	}
	String ans = "[";
	while(current.getNext()!=null){ 
	    ans += current.getValue() + ", ";
	    current = current.getNext();
	}
	ans+=current.getValue() + "]";
	return ans;
    }
    public T get(int index){
	if(index<0||index>=size){
	    throw new IndexOutOfBoundsException();
	}
	LNode test = start;
	for(int i = 0;i<index;i++){
	    test=test.getNext();
	}
	return test.getValue();
    }
    public T set(int index,T _value){
	T oldval = get(index);
	if(index<0||index>=size){
	    throw new IndexOutOfBoundsException();
	}
	LNode test = start;
	for(int i = 0;i<index;i++){
	    test=test.getNext();
	}
	test.setValue(_value);
	return oldval;
    }
    private LNode getNth(int index){
	LNode temp = start;
	while(index > 0){
	    temp = temp.getNext();
	    index --;
	}
	return temp;
    }
    
    public T remove(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size());
	}
	LNode temp;
	if(index == 0){
	    temp = start;
	    start = start.getNext();
	    size--;
	    if(start == null){
		end = null;
	    }
	    return temp.getValue();
	}else{
	    LNode p = getNth(index-1);
	    temp = p.getNext();
	    if(end == temp){
		end = p;
	    }
	    p.setNext(p.getNext().getNext());
	    size --;
	    return temp.getValue();
	}
    }
    public boolean add(T value){
	if(start == null){
	    start = new LNode(value);
	    end = start;
	}else{
	    LNode add = new LNode(value);
	    end.setNext(add);
	    add.setPrev(end);
	    add.setNext(end.getNext().getNext());
	    end = end.getNext();
	}
	size++;
	return true;
    }
    
    public boolean add(int index, T value){
	if(index < 0 || index > size()){
	    throw new IndexOutOfBoundsException("Index "+index+", Size: "+size());
	}
	LNode temp = new LNode(value); 
	if(index == 0){
	    temp.setNext(start);
	    start = temp;
	    if(size==0){
		end = start;
	    }
	}else{ 
	    LNode p = getNth(index-1);
	    temp.setNext(p.getNext());
	    p.setNext(temp);
	    if(end.getNext() != null){
		end=end.getNext();
	    }
	}
	size++;
	return true;
    }
    public int indexOf(T _value) {
	LNode current = start;
	for(int i = 0;current.getNext()!=null;i++){
	    if(current.getValue().equals(_value)){
		return i;
	    }
	    current = current.getNext();
	}
	return -1;
    }
    private class LNode{
	private T data;
	private LNode next,previous;
	public LNode(T v){
	    data = v;
	    next = null;
	}
	public LNode(T val, LNode nextnode){
	    next = nextnode;
	    data = val;
	}
	    
	public T getValue(){
	    return data;
	}
	public LNode getNext(){
	    return next;
	}
	public void setValue(T obj){
	    data = obj;
	}
	public void setNext(LNode nextN){
	    next = nextN;
	}
	public void setPrev(LNode _prev){
	    previous = _prev;
	}
	public LNode getPrev(){
	    return previous;
	}
    }
    private class iteratedViewer implements Iterator<T>{
	private LNode current;
	public iteratedViewer(){
	    current = start;
	}
	public boolean hasNext(){
	    return current!=null;
	}
	public T next(){
	    if(!hasNext()){
		throw new NoSuchElementException();
	    }
	    T returnValue = current.getValue();
	    current=current.getNext();
	    return returnValue;
	}
	public void remove(){
	    throw new UnsupportedOperationException();
	}
	
    }

    public Iterator<T> iterator(){
	return new iteratedViewer();
    }
	   

}
