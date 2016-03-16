public class MyLinkedList {
    private LNode start;
    private int size;

    private class LNode{
	private int value;
	private LNode next;
	
	private LNode(int val,int n){
	    setValue(val);
	    setNext(n);
	}
	private int getNext(){
	    return next;
	}
	private int getValue(){
	    return value;
	}
	private void setNext(int i){
	    next = i;
	}
	private void setValue(int i){
	    value = i;
	}

    }
    public boolean add(int value){
	if(start == null){
	    start = new LNode(value);
	    size++;
	    return true;
	}else{
	    LNode temp = start;
	    while(temp.getNext()!=null){
		temp = temp.getNext();
	    }
	    temp.setNext(new LNode(value));
	    size++;
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
    }
    public MyLinkedList(){
	start = new LNode(0,null);
	size = 0;
    }

}

