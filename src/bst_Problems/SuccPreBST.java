package bst_Problems;


public class SuccPreBST {
	
	//successor is the node which is just bigger than the key
	//predecessor is the node which is just smaller than the key
	public static Node successor(Node root, int key, Node successor, Node predecessor) {
		//we have taken two nodes successor and predecessor to store 
		
		Node curr=root;
		while(root!=null)
		{
			//if the current node is bigger than the key
			//then store it and check for something smaller than that
			//but bigger than key
			if(root.data>key)
			{
				//if successor is already there then check if the
				//current node is smaller 
				if(successor!=null && root.data<successor.data)
					successor=root;
				//if successor is null, then store it and move to /
				//the left to find a smaller value
				else if(successor==null)	
					successor=root;
				
				root=root.left;
				
			}
			//if current node is smaller than key then move to the right
			else
				root=root.right;
		}
		
		root=curr;
		//similarly for predecessor, 
		while(root!=null) {
			if(root.data<key)
			{
				//if we find a node which is less than key then store it and move to it's right
				//to find a bigger node than it but less than key
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
		//return successor;
		
	}

}
