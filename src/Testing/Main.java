package Testing;
import java.util.*;


class Node {
	 
	int data;
	Node left;
	Node right;
	    
	Node(int d) {
	    data = d; 
	    left=null;
	    right=null;
	 }

}

class Pair{
	
	Node val;
	int level;
	public Pair(Node val, int level) {
		super();
		this.val = val;
		this.level = level;
	}
	
}

public class Main{
	
	static boolean search(Node root,int val) {
		
		if(root==null)
			return false;
		
		if(root.data==val)
			return true;
		
		//int temp=root.data;
		
		if(val<root.data)
			return search(root.left,val);
		else
			return search(root.right,val);
	}
	
    public static void main(String[] args) {
    	
    	Node root=new Node(10);
		root.left=new Node(5);
		root.right=new Node(12);
		root.left.left=new Node(4);
		root.left.right=new Node(7);
		root.right.left=new Node(10);
		root.right.right=new Node(14);
		root.left.right.left=new Node(6);
		root.right.right.left=new Node(13);
		
		System.out.println(search(root, 15));
		
	}
	
}

	
