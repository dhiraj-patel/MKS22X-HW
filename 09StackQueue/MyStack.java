import java.util.*;
public class MyStack<T> extends MyLinkedList<T>{
    private MyLinkedList<T> data;
    public MyStack(){
	data = new MyLinkedList<T>();
    }
    public void push(T item){
	data.add(0,item);
    }
    public T pop(){
	if(isEmpty()){
	    throw new NoSuchElementException("FIX POP FUNCTION");
	}
	return data.remove(data.size()-1);
    }
    public T peek(){
	if(isEmpty()){
	    throw new NoSuchElementException();
	}
	return data.get(0);
    }
    public int size(){
	return data.size();
    }
    public boolean isEmpty(){
	return(data.size()==0);
    }
    //testing the stack
    public static void main(String[]args){
	MyStack<String> s1 = new MyStack<String>();
	//	s1.push("test1");
	System.out.println(s1.pop());
    }
   
}
