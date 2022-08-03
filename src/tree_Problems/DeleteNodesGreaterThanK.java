package tree_Problems;
/*
 * Given a BST and a value k, the task is to delete the nodes having values greater than or equal to k.
 * Input:
	    4   
	   / \  
	  1   9 
	k = 2 
	Output:
	1
 */
public class DeleteNodesGreaterThanK {
	//We'll start checking from the leaf nodes (Post order), thus we'll check the child nodes first before
	//moving to the parent node.
	//We would have already removed the child nodes which are greater than k before coming to the parent node
	//thus we don't to think about the child nodes again
	
	//if the curr root is greater than or equal to k,
	//just return root.left as left of root will be less than k ( the reason being we have already checked
	//the child nodes before moving to the parent node thus no need to check again)
	//if the curr root is less than k then return the whole root
	public Node deleteNode(Node root,int k)
    {
    //add code here.
    
       if(root==null)
           return null;
           
       root.left=deleteNode(root.left,k);
       root.right=deleteNode(root.right,k);
       
       if(root.data>=k)
           return root.left;
       else
           return root;
    }

}
