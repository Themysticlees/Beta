package tree_Problems;

import java.util.Scanner;

public class MyTree {
	
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Node root = createTree();
	
		System.out.println("Inorder = ");
		Inorder(root);
		System.out.println("Preorder = ");
		Preorder(root);
		System.out.println("Postorder = ");
		Postorder(root);
		
		System.out.println("No.of Leaf Nodes = "+LeafNodes(root));
		
		
	}
	
	static Node createTree()
	{
		
		
		System.out.println("Enter data : (Enter -1 if data is null) ");
		int data=sc.nextInt();
		
		//If no node is present 
		if(data==-1)
			return null;
		
		Node root = new Node(data);
		
		System.out.println("Enter left of "+data);
		root.left=createTree();
		//Create the left node of the current node
		
		System.out.println("Enter right of "+data);
		root.right=createTree();
		//create the right node of the current node
		
		return root;
	}
	
	static void Inorder(Node root) {
		
		if(root==null)
			return;
		
		Inorder(root.left);
		System.out.println(root.data);
		Inorder(root.right);
	}
	
	static void Preorder(Node root) {
	
		if(root==null)
			return;
		
		System.out.println(root.data);
		Preorder(root.left);
		Preorder(root.right);
	}
	
	static void Postorder(Node root) {
		
		if(root==null)
			return;
		
		Postorder(root.left);
		Postorder(root.right);
		System.out.println(root.data);
	}
	
	
	static int LeafNodes(Node root) {
		if(root==null)
			return 0;
		
		// if it's left and right are null i.e it is a leaf node, return 1
		if(root.left==null && root.right==null)
			return 1;
		
		//check no.of leaf nodes in left sub tree and right sub tree and add them
		return LeafNodes(root.left)+LeafNodes(root.right);
	}
}

class Node{
	int data;
	Node left;
	Node right;
	
	Node(int data){
		this.data=data;
	}
}




