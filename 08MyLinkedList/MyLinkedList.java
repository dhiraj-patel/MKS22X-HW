public class MyLinkedList<T>{
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
	    end.setNext(new LNode(_value));
	    end=end.getNext();
	}
	size++;
	return true;
    }

    public boolean add(int index, T _value){
	if(index>size||index<0){
	    throw new IndexOutOfBoundsException();
	}
	LNode temp = new LNode(_value);
	LNode current = start;
	if(current==null){
	    start=temp; end = temp;
	    size++;
	    return true;
	}else if(index == 0){
	    temp.setNext(current);
	    start=temp;
	    size++;
	    return true;
	}else if(index == size){
	    add(_value);
	    return true;
	}
	int i = index;
	while(i>1){
	    current=current.getNext();
	    i--;
	}
	temp.setNext(current.getNext());
	current.setNext(temp);
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
	private LNode next;
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
	
    }

}
