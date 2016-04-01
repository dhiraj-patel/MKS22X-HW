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
    public T remove(int index){
	if((index>=size()||(index<0))){
	    throw new IndexOutOfBoundsException();
	}
	else if(index==0){
	    T ans = start.getValue();
	    start=start.getNext();
	    size-=1;
	    return ans;
	}
	LNode temp = start;
	T anstwo = temp.getValue();
	for(int i =0;i<index-1;i++){
	    temp=temp.getNext();
	}
	if(index==size-1){
	    end=temp;
	}
	anstwo = temp.getNext().getValue();
	temp.setNext(temp.getNext().getNext());
	size--;
	return anstwo;
    }
    public boolean add(T _value){
	if(start==null){
	    start=new LNode(_value);
	    end=start;
	}else{
	    LNode placeholder = new LNode(_value);
	    end.setNext(placeholder);
	    placeholder.setPrev(end);
	    end = placeholder;
	}
	size++;
	return true;
    }

    public boolean add(int index, T newValue){
	if(index>size||index<0){
	    throw new IndexOutOfBoundsException();
	}
	LNode temp = new LNode(newValue);
	if(index==0){
	    temp.setNext(start);
	    start.setPrev(temp);
	    start=temp;
	    return true;
	}
	else if(size==index){
	    return add(newValue);
	}
	LNode current=start;
	for(int i = 0;i<index-1;i++){
	    current=current.getNext();
	}
	temp.setNext(current.getNext());
	temp.setPrev(current);
	current.setNext(temp);
	temp.getNext().setPrev(temp);
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
