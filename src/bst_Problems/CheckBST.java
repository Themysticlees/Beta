package bst_Problems;

//we have to check whether a tree is a BST or not
//we'll be maintaining a range and we'll check if a particular node exists within that range
public class CheckBST {
	
	boolean isBST(Node root)
    {
		//for checking the root, there is no range, thus we took the extreme points
        return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    
    boolean isBST(Node root, int min, int max ){
        
    	//if a particular node is not present then we dont need to check for that
    	//thus return true
        if(root==null)
            return true;
        
        //if the current node lies beyond the range then return false
        if(root.data<=min || root.data>=max)
            return false;
        
        //now we check the same for the left subtree and the right subtree
        //if both returns true then it is BST
        //we have updated the range for the left and right subtree
        if(isBST(root.left,min,root.data) && isBST(root.right,root.data,max))
            return true;
        return false;
    }

}
