import java.util.*;
public class MyDeque<T>{
    private int start,end,size;
    private T[] array;
    public MyDeque(){
	array=(T[]) new Object[32];
	start=0;
	end=0;
	size=0;
    }

    public boolean isEmpty(){
	return size==0;
    }
    public String toString() {
	String toReturn = "";
	toReturn += "Head: ";
	toReturn += ("" + head);
	toReturn += "\nTail: " + ("" + tail);
	toReturn += "\n[";
	for (Object i : data) {
	    toReturn += i + ", ";
	}
	toReturn += "]";
	return toReturn;
    }
    
	    
	
       
	  
	   
    



}
