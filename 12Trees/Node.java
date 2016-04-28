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
    public int height(){
	return height(root);
    }
	    
    private int height(Node check){
	int height = 1;
	if(check.getLeft()!= null){
	    height+=getHeight(check.getLeft());
	}
	int heightR = 1;
	if(check.getRight()!=null){
	    heightR+=getHeight(check.getRight());
	}
	return Math.max(height,heightR);
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
	String ans = getData()=" ";
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
	if(getData()==value){
	    return true;
	}
	if(getLeft()==null){
	    return getRight().contains(value):
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
	
