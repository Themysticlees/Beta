package bst_Problems;

//For every Node in the tree, we'll maintain the min node and max node from it's entire subtree 
//and all the nodes upto that current node

class NodeValue{
    
    int minval;
    int maxval;
    int size;
    
    NodeValue(int minval, int maxval, int size){
        this.minval=minval;
        this.maxval=maxval;
        this.size=size;
    }
}

public class LongestBSTinaBT {
	
	static int largestBst(Node root)
    {
        // Write your code here
        return helper(root).size;
    }
    
    static NodeValue helper(Node root){
        
    	//if root is null, then we send a dummy value so that it is easily comparable
        if(root==null)
            return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        
        //We find the values of the left node and the right node
        NodeValue left=helper(root.left);
        NodeValue right=helper(root.right);
        
        //checking the cond of BST
        //so we take the max node from the left subtree and compare it with the root node
        //if the root node is bigger, then the condition satisfies
        //and we take the min node from the right subtree and compare it,
        //if the root is smaller, then that subtree is a BST
        //so we measure the no.of nodes by adding 1 + no.of nodes of left subtree+ no.of nodes of right subtree
        //and we assign the min value of the root node as the min of root and minval of left child
        //max value of the root node as the max of root and maxval of the right child
        
        //we keep both the values because our current maybe a left or the child, thus may require comparing
        if(root.data>left.maxval && root.data<right.minval)
            return new NodeValue(Math.min(root.data,left.minval),Math.max(root.data,right.maxval),1+left.size+right.size);
        
        //if the BST condition fails, then we update the min and max value of that particular node
        //as extremes so that even if we compare it, it never satisfies.
        //and for the no.of nodes take the max of the nodes from left and right subtree
        //to keep a note of the largest BST found untill now.
        return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.size,right.size));
        
    } 
	
}
