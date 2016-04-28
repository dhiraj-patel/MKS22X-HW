public class BSTree<T extends Comparable<T>>{
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