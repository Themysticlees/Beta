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
	
	public static Node successor(Node root, int key, Node successor, Node predecessor) {
		
		Node curr=root;
		while(root!=null)
		{
			if(root.data>key)
			{
				if(successor!=null && root.data<successor.data)
					successor=root;
				else if(successor==null)	
					successor=root;
				
				root=root.left;
				
			}
			else
				root=root.right;
		}
		
		root=curr;
		
		while(root!=null) {
			if(root.data<key)
			{
				if(predecessor==null)
					predecessor=root;
				else if(root.data>predecessor.data)
					predecessor=root;
				
				root=root.right;
			}
			else
				root=root.left;
		}
		return predecessor;
		
	}

	public static void main(String[] args) {
    	
    	Node root=new Node(10);
		root.left=new Node(5);
		root.right=new Node(13);
		root.left.left=new Node(3);
		root.left.right=new Node(6);
		root.right.left=new Node(11);
		root.right.right=new Node(14);
		root.left.left.left=new Node(2);
		root.left.left.right=new Node(4);
		root.left.right.right=new Node(9);
		//root.right.right.right=new Node(5);
		//root.right.right.right.right=new Node(6);
		//root.left.right.left=new Node(6);
		//root.right.right.left=new Node(13);
		
		//System.out.println(findFloor(root,8));
		
		System.out.println(successor(root, 14, null,null).data);
		
	}
	
}

	
