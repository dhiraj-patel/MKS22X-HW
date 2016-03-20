/// testing on ely sandine's driver
import java.util.*;
public class Driver{
    public static void main(String[]args){
	System.out.println("Linked List Driver");
	MyLinkedList l1 = new MyLinkedList();
	ArrayList<Integer> l2 = new ArrayList<Integer>();
	long start = 0;
	long end = 0;
	//Adding to the end
	System.out.println("Adding to the end");
	start = System.currentTimeMillis();
	for (int i = 0 ;i < 1000000;i++){
	    l1.add((int) (Math.random()*Integer.MAX_VALUE));
	}
	end = System.currentTimeMillis();
	System.out.println("Time for Linked List"+((end-start)/1000.0));
	start = System.currentTimeMillis();
	for (int i = 0 ;i < 1000000;i++){
	    l2.add((int) (Math.random()*Integer.MAX_VALUE));
	}
	end = System.currentTimeMillis();
	System.out.println("Time for ArrayList"+((end-start)/1000.0));       
	l1.clear();
	l2.clear();
	//Adding to the beginning
	System.out.println("Adding to the beginning");
	start = System.currentTimeMillis();
	for (int i = 0 ;i < 10000;i++){
	    l1.add(0,(int) (Math.random()*Integer.MAX_VALUE));
	}
	end = System.currentTimeMillis();
	System.out.println("Time for Linked List"+((end-start)/1000.0));
	start = System.currentTimeMillis();
	for (int i = 0 ;i < 10000;i++){
	    l2.add(0,(int) (Math.random()*Integer.MAX_VALUE));
	}
	end = System.currentTimeMillis();
	System.out.println("Time for ArrayList"+((end-start)/1000.0));       
	l1.clear();
	l2.clear();
	//ADding to a random spot
	System.out.println("Adding to a random spot");
	start = System.currentTimeMillis();
	for (int i = 0 ;i < 10000;i++){
	    l1.add((int)(Math.random()*l1.size()),(int) (Math.random()*Integer.MAX_VALUE));
	}
	end = System.currentTimeMillis();
	System.out.println("Time for Linked List"+((end-start)/1000.0));
	start = System.currentTimeMillis();
	for (int i = 0 ;i < 10000;i++){
	    l2.add((int)(Math.random()*l2.size()),(int) (Math.random()*Integer.MAX_VALUE));
	}
	end = System.currentTimeMillis();
	System.out.println("Time for ArrayList"+((end-start)/1000.0));       
    }
}
