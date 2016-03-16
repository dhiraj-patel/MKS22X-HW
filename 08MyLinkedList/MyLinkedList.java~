public class MyLinkedList {
    private LNode start;
    private int size;

    private class LNode{
	private int value;
	private LNode next;
	
	private LNode(int n){
	    setValue(n);
	}
	private getNext(){
	}
	private getValue(){
	}
	private setNext(){
	}
	private setValue(){
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
    

}

