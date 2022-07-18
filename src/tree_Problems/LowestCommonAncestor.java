package tree_Problems;

/*
 * Given a Binary Tree with all unique values and two nodes value, n1 and n2. 
 * The task is to find the lowest common ancestor of the given two nodes. 
 * We may assume that either both n1 and n2 are present in the tree or none of them are present.
 * LCA: It is the first common ancestor of both the nodes n1 and n2 from bottom of tree.

	Input:
	n1 = 3 , n2 = 4
	           5    
	          /    
	         2  
	        / \  
	       3   4
	Output: 2
	Explanation:
	LCA of 3 and 4 is 2. 
 */
public class LowestCommonAncestor {
	//The logic is:
	//We need to check the left subtree and right subtree
	//If we get any of the numbers in either left subtree or right subtree then return 
	//the root of that subtree
	//If any of the subtree returns null i.e. none of the nodes are present then return the root of 
	//the subtree which returns a not null value and keep on checking
	//if both the subtrees return null then the nodes are not present hence return null
	
	Node lca(Node root, int n1,int n2)
	{
		// Your code here
		if(root==null){
            return root;
        }
        
		//if we get any of the nodes in the root, then return root as it the lca of both the nodes
        if(root.data==n1 || root.data==n2){
            return root;
        }
        
        //otherwise search in left subtree and right subtree
        Node ltree  =lca(root.left,n1,n2);
        Node rtree =lca(root.right,n1,n2);
        
        //if both the subtrees return a non-null value, then the nodes must be present in them
        //in that case, the curr root is the lca so just return it
        if(ltree!=null && rtree!=null){
            return root;
        } 
        
        //if right subtree returns null, then maybe both the nodes are in the left subtree 
        //so return left subtree but we keep on checking as we move up the tree
        else if(ltree!=null){
            return ltree;
        }
        
        //similarly if the left tree returns null
        else{
            return rtree;
        }
	}

}
