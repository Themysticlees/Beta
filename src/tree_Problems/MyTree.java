package tree_Problems;

import java.util.Scanner;

public class MyTree {
	
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//Node root = createTree();
		
		//creating a tree manually
		Node root=new Node(2);
		root.left=new Node(4);
		root.right=new Node(1);
		root.left.left=new Node(7);
		root.right.left=new Node(8);
		root.right.right=new Node(3);
	
		System.out.println("Inorder = ");
		Inorder(root);
		System.out.println("Preorder = ");
		Preorder(root);
		System.out.println("Postorder = ");
		Postorder(root);
		
		System.out.println("No.of Leaf Nodes = "+LeafNodes(root));
		
		System.out.println("Height of the tree = "+Height(root));
		
		int h=Height(root);
		
		LevelOrder(root, h);
		
		System.out.println(level(root, new Node(5)));
		
	}
	
	static boolean level(Node root,Node find){
        
        if(root==null)
            return false;
        if(root.data==find.data)
            return true;
        else
        {
            if(level(root.left,find) || level(root.right,find))
                return true;
        }
        return false;
        
    }
	
	//----------------------Creating a Tree---------------------------//
	
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
	
	//----------------------Inorder Traversal (Left-Root-Right)---------------------------//
	
	public static void Inorder(Node root) {
		
		if(root==null)
			return;
		
		Inorder(root.left);
		System.out.println(root.data);
		Inorder(root.right);
	}
	
	//----------------------Preorder Traversal (Root-Left-Right)---------------------------//

	
	public static void Preorder(Node root) {
	
		if(root==null)
			return;
		
		System.out.println(root.data);
		Preorder(root.left);
		Preorder(root.right);
	}
	
	//----------------------Postorder Traversal (Left-Right-Root)---------------------------//

	static void Postorder(Node root) {
		
		if(root==null)
			return;
		
		Postorder(root.left);
		Postorder(root.right);
		System.out.println(root.data);
	}
	
	//----------------------Calculate Leaf nodes---------------------------//
	
	static int LeafNodes(Node root) {
		if(root==null)
			return 0;
		
		// if it's left and right are null i.e it is a leaf node, return 1
		if(root.left==null && root.right==null)
			return 1;
		
		//check no.of leaf nodes in left sub tree and right sub tree and add them
		return LeafNodes(root.left)+LeafNodes(root.right);
	}
	
	//----------------------Calculate Height of a tree---------------------------//
	static int Height(Node root) {
		
		if(root==null)
			return 0;
		
		return 1+Math.max(Height(root.left), Height(root.right));
	}
	
	//----------------------Level Order Traversal of tree---------------------------//
	static void LevelOrder(Node root, int height){
		
		//We are traversing every level and printing all the nodes in that level
		for(int i=0;i<height;i++) {
			System.out.println("Nodes of level "+i);
			
			//This function is doing the work
			currentLevel(root,i);
			System.out.println();
		}
	}
	
	static void currentLevel(Node root, int level) {
		
		if(root==null)
			return;
		//if level becomes becomes zero that means we have reached our target level
		if(level==0)
		{
			System.out.print(root.data+" ");
			return;
		}
		//decreasing the level until we reach 0
		currentLevel(root.left, level-1);
		currentLevel(root.right, level-1);
	}
}

//----------------------Node class---------------------------//

class Node{
	int data;
	Node left;
	Node right;
	
	Node(int data){
		this.data=data;
		this.left=null;
		this.right=null;
	}
}




