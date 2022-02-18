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
	
	public static Node deleteNode(Node root, int key) {
		
		Node curr=root;
		Node parent=null;
		
		if(root.data==key) {
			
			
			if(curr.left==null)
				return curr.right;
			
			else if(curr.right==null)
				return curr.left;
			
			else
			{
				curr=curr.left;
				parent=curr;
				while(parent.right!=null)
					parent=parent.right;
				
				parent.right=root.right;
			}
			return curr;
		}
		
		while(curr!=null) {
			
			if(key==curr.data)
				break;
			
			parent=curr;
			
			if(key<curr.data)
				curr=curr.left;
			else
				curr=curr.right;
		}
		
		if(curr==null)
			return root;
		
		if(curr.left==null)
			parent.left=curr.right;
		
		else if(curr.right==null)
			parent.left=curr.left;
		else
		{
			parent.left=curr.left;
			
			parent=parent.left;
			
			while(parent.right!=null)
				parent=parent.right;
			
			parent.right=curr.right;
		}
		
		return root;
		
	}
	
	public static void Preorder(Node root) {
		
		if(root==null)
			return;
		
		System.out.print(root.data+" ");
		Preorder(root.left);
		Preorder(root.right);
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
		
		Preorder(root);
		root=deleteNode(root, 1);
		System.out.println();
		Preorder(root);
		
	}
	
}

	
