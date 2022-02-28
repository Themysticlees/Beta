package bst_Problems;

//You can solve this problem by creating the Inorder traversal
//and then doing it like the a normal BT
//That will take O(NlogN)
//This is a more optimized approach

public class ConstructTreePreInOrder {
	
	//for traversing the preorder array
	static int i=0;
	public static Node post_order(int pre[], int size) 
	{
	    //Your code here
	    return helper(pre,size,Integer.MAX_VALUE);
	}
	
	//we'll pass the upper bound, if the particular element at ith index is less than
	//the upper bound, then insert it otherwise return null
	public static Node helper(int[] pre, int size, int upper){
	    
		//if the current element is more than the upper bound, return null
	    if(i>=size || pre[i]>=upper)
	        return null;
	    
	    //create a node
	    Node root=new Node(pre[i]);
	    i++;
	    //set the upper limit of the left child be the value of the current root
	    //and upper limit of the right child be the upper limit of the current root
	    //we'll only increase i if we successfully insert the node, till then we'll check for 
	    //it's correct position.
	    root.left=helper(pre,size,root.data);
	    root.right=helper(pre,size,upper);
	    
	    return root;
	}

}
