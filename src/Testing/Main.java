package Testing;
import java.util.*;


class Node {
	 
	int value;
	Node left;
	Node right;
	    
	Node(int d) {
	    value = d; 
	    left=null;
	    right=null;
	 }

}

public class Main{
	
	static Node mirrorTree(Node root, int[] arr, int k) {
		
		if(root==null)
			return null;
		
		Node temp=mirrorTree(root.left,arr,k++);
		root.left=mirrorTree(root.right,arr,k++);
		root.right=temp;
		
		arr[k]=root.value;
		return root;
		
	}
	
	static void Inorder(Node root) {
		
		if(root==null)
			return;
			
		Inorder(root.left);
		System.out.print(root.value+" ");
		Inorder(root.right);
	}
    
    public static void main(String[] args) {
    	
    	Node root=new Node(2);
		root.left=new Node(1);
		root.right=new Node(8);
		root.left.left=new Node(12);
		root.right.right=new Node(9);
		
		int[] arr=new int[1000];
		
		Inorder(root);
		root=mirrorTree(root,arr,0);
		System.out.println();
		Inorder(root);

	}
	
}

	
