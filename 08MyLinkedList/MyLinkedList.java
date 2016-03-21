public class MyLinkedList {
    private LNode start;
    private int size;
    private LNode end;
    private class LNode<T>{
	private T thing;
	private LNode next;
	public LNode(T object, LNode nextL){
	    thing = object;
	    next = nextL;
	}
	public LNode(){};
	public LNode(T object) {
	    thing = object;
	}
	// need the get and set stuff

    }
    public int size(){
	return size;
    }
    
    public boolean add(int value){
	if(start == null){
	    start = new LNode(value,null);
	    end = start;
	    size++;
	    return true;
	}
	else{
	    LNode test = new LNode(value);
	    end.setNext(test);
	    end=end.getNext();
	    return true;
	}
    }
    public String toString(){
	if(start == null){
	    return "[]";
	}
	else{
	    String end = "[";
	    LNode temp = start;
	    while(temp!=null){
		end += temp.getValue()+",";
		temp=temp.getNext();
	    }
	    end = end.substring(0,end.length()-1);
	    end += "]";
	    return end;
	}	
    }/*
    public MyLinkedList(){
	start = new LNode(0,null);
	size = 0;
	}*/
    public int get(int index){
       	LNode temp = start;
	int i =0 ;
	while(i<index){
	    temp =temp.getNext();
	    i++;
	}
	return temp.getValue();
    }
    public int set(int index,int value){
	LNode l = start;
	int i = 0;
	while(i<index){
	    l = l.getNext();
	    i++;
	}
	int temp = l.getValue();
	l.setValue(value);
	return temp;
    }
    public int indexOf(int value){
	LNode temp = start;
	int i = 0;
	while(i<size){
	    if(temp.getValue()==value){
		return i;
	    }
	    else{
		temp=temp.getNext();
	    }
	    i++;
	}
	return -1;
    }
    public boolean clear(){
	start = null;
	size=0;
	return true;
    }
    public int remove(int index){
	int old = get(index);
	if(index>size){
	    throw(new IndexOutOfBoundsException("out of bounds"));
	}
	else if(index == 0){
	    start=start.getNext();
	    
	}
	else{
	    LNode temp = start;
	    for(int i =0 ; i<index-1;i++){
		temp=temp.getNext();
	    }
	    temp.setNext(temp.getNext().getNext());
	    size--;
	}
	return old;
    }
    public boolean add(int index,int value){
	if(index>size||index<0){
	    throw(new IndexOutOfBoundsException("out of bounds"));
	}
	if(index == 0){
	    LNode current = new LNode(value,start);
	    start = current;
	    size++;
	    return true;
	}
	LNode temp = start;
	for(int i = 0;i<index-1;i++){
	    temp=temp.getNext();
	}
	LNode temp2 = new LNode(value,temp.getNext());
	temp.setNext(temp2);
	size++;
	return true;
    }
	
}
