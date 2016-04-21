import java.util.*;
import java.io.*;
/*public class BSTree<T extends Comparable>{
  private class TreeNode{
  //Instance Variables
  TreeNode Left,Right;
  T data;
  //Mutators
  private void setLeft(TreeNode n){
  Left=n;
  }
  private void setRight(TreeNode n){
  Right=n;
  }
  private void setData(T n){
  data=n;
  }
  private TreeNode getLeft(){
  return Left;
  }
  private TreeNode getRight(){
  return Right;
  }
  private T getData(){
  return data;
  }
  private boolean hasData(){
  return data!=null;
  }
  public TreeNode(T value){
  setData(value);
  }
  private TreeNode<T> root;
  public BSTree(){
  root = null;
  }
  public int getHeight(){
  return getHeight(root);
  }
  private int getHeight(TreeNode<T> check) {
  int heightLeft = 1;
  if (check.getLeft() != null) {
  heightLeft = heightLeft + getHeight(check.getLeft());
  }
  int heightRight = 1;
  if (check.getRight() != null) {
  heightRight = heightRight + getHeight(check.getRight());
  }
  if (heightLeft > heightRight) {
  return heightLeft;
  }
  else{
  return heightRight;
  }
  }

  private boolean contains(T value){
  if(root.getData()==value){
  return true;
  }
  }
  private void add(T value){
  if(!hasData()){
  setData(value);
  }
  else{
  if(this



  }
*/
public class BSTree<T extends comparable<T>>{
    private class Node{
	T data;
	Node left;
	Node right;
	// set/get: data/left/right


	//real methods here
	public int height(){ 
	    return 0;
	}
	public void add(T value){
	}
	public String toString(){
	    return "";
	}
	public boolean contains(T value){
	    return false;
	}
     
    }

    private Node root;

    //OUTER methods here are wrapper methods for the root
    public getHeight(){
	//call the root's methods
	//check for empty first!
	return root.height();
    }

    public void add(T value){
	//check for empty before you do things with root.
    }
    public String toString(){
	String ans = "";
	ans = getData()+" ";
	if(getLeft()!=null){
	    ans+= getLeft().toString();
	}
	else{
	    ans+="_ ";
	}
	if(getRight()!=null){
	    ans+=getRight().toString();
	}
	else{
	    ans+="_ ";
	}
	return ans;
    }
    public boolean contains(T value){
	//check for empty before you do things with root.
	return(getData()==value);
    }
}
