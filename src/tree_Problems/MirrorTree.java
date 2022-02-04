package tree_Problems;


public class MirrorTree {
	
	//we need to find the mirror of a tree
	/*
	 *  5
       / \
      3   6
     / \
    2   4
    
    After mirroring :
      5
 	 / \
	6   3
   	   / \
  	  4   2
    
	 */
	static Node mirrorTree(Node root) {
		
		if(root==null)
			return null;
		
		//We just need to swap the child of the current node
		//We reach the leaf node and start swaping
		Node temp=mirrorTree(root.left);
		root.left=mirrorTree(root.right);
		root.right=temp;
		
		return root;
		
	}
	  
    public static void main(String[] args) {
    	
    	Node root=new Node(2);
		root.left=new Node(1);
		root.right=new Node(8);
		root.left.left=new Node(12);
		root.right.right=new Node(9);
		
		MyTree.Inorder(root);
		root=mirrorTree(root);
		System.out.println();
		MyTree.Inorder(root);

	}

}
