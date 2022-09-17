package tree_Problems;

/*
 * Problem link: https://leetcode.com/problems/binary-tree-pruning/
 * 
 * Given the root of a binary tree, return the same tree where every subtree (of the given tree)
 * not containing a 1 has been removed.
 * A subtree of a node node is node plus every node that is a descendant of node.
 */
public class PruneTree {
	
	/*
	 * So the idea is, if a subtree including the curr node doesn't contain 1, just remove it.
	 * so, if a leaf node is not 1 then it has to be removed.
	 * otherwise, check the left subtree, if no 1 is found in that left subtree, delete it,
	 * check for right subtree, if no 1 is found in that too, delete it.
	 * 
	 * if left subtree or right subtree contains at least a 1 or if the curr root is 1,
	 * then we'll return true signifying that though it's subtree may be deleted but the root will stay
	 */
	public Node pruneTree(Node root) {
        
        boolean valid=isValid(root);
        return valid?root:null;
    }
    
    public boolean isValid(Node root){
        
        boolean left=false,right=false;
        
        //leaf node condition
        if(root.left==null){
            if(root.data==1)
                left=true;
            else
                left=false;
        }
        else
            left=isValid(root.left);
        
        //if left subtree is invalid
        if(left==false)
            root.left=null;
        
        //leaf node condition
        if(root.right==null ){
            if(root.data==1)
                right=true;
            else
                right=false;
        }
        else
            right=isValid(root.right);
        
        //if right subtree is invalid
        if(right==false)
            root.right=null;
        
        //if anyone is true, return true
        if(left || right || root.data==1)
            return true;
        return false;
        
    }

}
