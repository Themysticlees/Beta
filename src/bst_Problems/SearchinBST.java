package bst_Problems;

public class SearchinBST {
	
	//This is more like a binary search
	static boolean search(Node root,int val) {
		
		//as soon as we hit a null value 
		//i.e the node is not present in the tree
		if(root==null)
			return false;
		
		//if the node matches then return true
		if(root.data==val)
			return true;
		
		//check the val
		//if it is less than current node,
		//then it may be present in the left side
		//if it is bigger than current node, then it is in the right side
		
		if(val<root.data)
			return search(root.left,val);
		else
			return search(root.right,val);
	}

}
