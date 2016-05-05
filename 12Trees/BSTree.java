import java.util.*;
public class BSTree<T extends Comparable<T>>{
    public class Node{
	private Node left, right;
	private T data;
	public void setLeft(Node newLeftVal) {
	    left = newLeftVal;
	}
	public void setRight(Node newRightVal) {
	    right = newRightVal;
	}
	public void setData(T newDataVal){
	    data = newDataVal;
	}
	private Node getLeft(){
	    return left;
	}
	private Node getRight(){
	    return right;
	}
	private T getData(){
	    return data;
	}
	public Node(T newDataVal){
	    setData(newDataVal);
	}
	public Node(T value, Node left, Node right){
	    data = value;
	    this.left = left;
	    this.right = right;
	}
	public int height(){
	    return height(root);
	}
	    
	private int height(Node check){
	    if(check!= null){
		return Math.max(height(check.getRight()),height(check.getLeft())) + 1;
	    }
	    else{
		return 0;
	    }
	}
	private void add(T value){
	    if(value.compareTo(getData())<0){
		if(getLeft()==null){
		    setLeft(new Node(value));
		}
		else{
		    getLeft().add(value);
		}
	    }
	    else{
		if(getRight()==null){
		    setRight(new Node(value));
		}
		else{
		    getRight().add(value);
		}
	    }
	}
	    
	public String toString(){
	    String ans = getData()+" ";
	    if(getLeft()!=null){
		ans+=getLeft().toString();
	    }
	    else{
		ans += "_ ";
	    }
	    if(getRight()!=null){
		ans += getRight().toString();
	    }
	    else{
		ans += "_ ";
	    }
	    return ans;
	}
	private boolean contains(T value){
	    if(getData()==(value)){
		return true;
	    }
	    if(getLeft()==null){
		return getRight().contains(value);
	    }
	    if((getLeft()==null)&&(getRight()==null)){
		return false;
	    }
	    if(getRight()==null){
		return getLeft().contains(value);
	    }
	    else{
		return ((getRight().contains(value))||(getLeft().contains(value)));
	    }
	}



	
    }

    private Node root;
    public BSTree(){
	root = null;
    }
    public void add(T value){
	if(root!=null){
	    root.add(value);
	}
	else{
	    root = new Node(value);
	}
    }
    public String toString(){
	if(root!=null){
	    return root.toString();
	}
	else{
	    return "";
	}
    }
    public int getHeight(){
	if(root!=null){
	    return root.height();
	}
	else{
	    return 0;
	}
    }
    public boolean contains(T value){
	if(root!=null){
	    return root.contains(value);
	}
	else{
	    return false;
	}
    }

}
