package tree_Problems;

//for every tree the diff of left height and right height should be <=1

public class BalancedTree {
	
	int height(Node root){
        
        if(root==null)
            return 0;
        
        //calculate the left height of the particular node
        int lheight=height(root.left);
        if(lheight==-1)
            return -1;
            
	    int rheight=height(root.right);
	    if(rheight==-1)
	        return -1;
	    
	    //for each node calculate the diff,
	    //if the diff is more than 1 then return -1 i.e the tree is not balanced
	    if(Math.abs(rheight-lheight)>1)
	        return -1;
        
	    //return height
        return 1+Math.max(lheight,rheight);
    }
	
    boolean isBalanced(Node root)
    {
    	//if the function returns -1 then tree is not balanced thus return false
	    if(height(root)==-1)
	        return false;
	       return true;
	
    }

}
