package tree_Problems;

/*
 * Given a BST and a number X, find Ceil of X.
 * Note: Ceil(X) is a number that is either equal to X or is immediately greater than X.
 * 
 *  Example 1:
	
	Input:
	      5
	    /   \
	   1     7
	    \
	     2 
	      \
	       3
	X = 3
	Output: 3
	Explanation: We find 3 in BST, so ceil
	of 3 is 3.
	Example 2:
	
	Input:
	     10
	    /  \
	   5    11
	  / \ 
	 4   7
	      \
	       8
	X = 6
	Output: 7
	Explanation: We find 7 in BST, so ceil
	of 6 is 7.
 */
public class CeilBST {
	
	public int findCeil(Node root, int key) {
        
        if (root == null) return -1;
        // Code here
        
        //if we get the key in the tree, then return it
        if(key==root.data)
            return key;
            
        //if key is bigger than the current root, then go to the right
        if(key> root.data)
            return findCeil(root.right,key);
        
        //if key is smaller than current root, then it can be a potential ans
        //however we need to check as we need to find the key or it's immedidate ceil
        else{
        	//calculate the ans
            int a=findCeil(root.left,key);
            //if we couldnt find an ans i.e we traversed the entire BST
            //then just return the curr root as it is larger than than the key
            //and it is just the immediate
            if(a==-1)
                return root.data;
            return a;
        }
    }

}
