package tree_Problems;

public class InsertBST {
	
	//we'll keep on traversing until we reach a leaf node
	//when we reach a leaf node just add it to it's children
	public static Node insertNode(Node root, int key) {
		
		//if the tree is null, create a node and return
		if(root==null)
			return new Node(key);
		
		Node curr=root;
		
		while(curr!=null)
		{
			//if key is greater, move to it's right
			if(key>curr.data)
			{
				if(curr.right==null)
				{
					//when we get the leaf node such that it's right is null
					//add it to it's right child
					curr.right=new Node(key);
					break;
				}
				curr=curr.right;
				
			}
			else
			{
				//else to its left
				if(curr.left==null)
				{
					curr.left=new Node(key);
					break;
				}
				curr=curr.left;
			}
		}
		return root;
		
	}

}
