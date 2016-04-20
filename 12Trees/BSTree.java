import java.util.*;
import java.io.*;
public class BSTree<T extends Comparable>{
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
