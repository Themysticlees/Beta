package tree_Problems;

/*
 * Return true if, for every node X in the tree other than the leaves, 
 * its value is equal to the sum of its left subtree's value 
 * and its right subtree's value. Else return false.
 */
public class SumTree {
	
	boolean isSumTree(Node root)
	{
		//if the fun returns a -ve number then for any node
		//the condition must have failed thus return false
        if(checkSum(root)==-10)
            return false;
        return true;
	}
	
	int checkSum(Node root){
	    
		//if the tree is empty the return 0
		//or if one of the children is null 
	    if(root==null)
	        return 0;
	    
	    //if the current node is a leaf node
	    //then return it's value
	    if(root.left==null && root.right==null)
	        return root.data;
	    
	    //compute if the current node is equal to the sum of it's children, 
	    //if yes then return it's twice value ( we have to return the sum of the 
	    //left or right subtree so adding all the nodes and it's children = 2*node
	    //because the condition must be true )
	    if(checkSum(root.left)+checkSum(root.right)==root.data)
	        return 2*root.data;
	    //if the condition fails then return any negative number
	    //so that it fails for all the checks and finally it returns a -ve number
	    //for any node if the sum tree cond fails then it is not a sum tree.
	    //thus we return a -ve number
	    else
	        return -10;
	}
	
}
