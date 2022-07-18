package tree_Problems;
/*
 * Given a binary tree and two node values your task is to find the minimum distance between them.
 * 
 * Input:
	        1
	      /  \
	     2    3
	a = 2, b = 3
	Output: 2
	Explanation: The tree formed is:
	       1
	     /   \ 
	    2     3
	We need the distance between 2 and 3.
	Being at node 2, we need to take two
	steps ahead in order to reach node 3.
	The path followed will be:
	2 -> 1 -> 3. Hence, the result is 2. 
 */
public class DistanceBetweenTwoNodes {
	
	//The min distance between two nodes is 
	//level of 1st node + level of 2nd node - 2* level of the lowest common ancestor
	//we are subtracting 2*lca as we are adding the level of the lca twice which is not required.
	//(level of a node is the distance between the root and the node)
	int findDist(Node root, int a, int b) {
        // Your code here
        int[] level=new int[100001];
        LowestCommonAncestor ob=new LowestCommonAncestor();
        
        //find the lca of the nodes
        Node low=ob.lca(root,a,b);
        
        //calculate the level of each node
        levelOrder(root,level,0);
        
        //use the formulae
        int dist=level[a]+level[b]-2*level[low.data];
        
        return dist;
        
    }
    
    public void levelOrder(Node root,int[] level,int lvl){
        
        level[root.data]=lvl;
        
        if(root.left!=null)
            levelOrder(root.left,level,lvl+1);
            
        if(root.right!=null)
            levelOrder(root.right,level,lvl+1);
    }
    
    

}
