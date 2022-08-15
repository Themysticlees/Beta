package tree_Problems;
/*
 * Problem link: https://practice.geeksforgeeks.org/problems/number-of-turns-in-binary-tree/1
 * 
 * Given a binary tree and data value of two of its nodes. 
 * Find the number of turns needed to reach from one node to another in the given binary tree.
 * 
 * Turn means when you change your direction you take a turn
 * For eg: from left to right or from right to left
 */
public class NoOfTurns {
	/*
	 * The idea is to calculate the no.of turns taken to reach from one node to the other
	 * The first step is to find out the shortest path between them, for that we need to find their LCA
	 * From the LCA, calculate the no.of turns taken to reach each node and add them.
	 */
	static int NumberOfTurns(Node root, int first, int second)
    {
        
        //0 -> left
        //1 -> right
		
		//Find the LCA of the two nodes
        Node LCA=findLCA(root,first,second);
        
        //Calculate the amount of turns required to reach the both nodes
        int left=findTurns(LCA.left,first,second,0,0);
        int right=findTurns(LCA.right,first,second,1,0);
            
        int res=left+right;
        
        //if one of the node is the LCA itself, then just ignore the next line
        //if not, then add one as we need to go through the LCA as well which we have not considered.
        if(LCA.data!=first && LCA.data!=second)
            res+=1;
        return res;
        
    }
    
    //0 -> left
    //1 -> right
    static int findTurns(Node root,int a, int b, int prevTurn, int turns){
        
    	//if root becomes null, then we have not found the nodes, just return 0 (denoting no turns were necessary)
        if(root==null)
            return 0;
            
        //if the root is any of the two nodes, just return the turns calculated so far
        //If any one node is found, then also we'll return as for the other node we have made another function
        //call in the main function. Thus in left subtree of the LCA any one of the node will be present
        //Thus no need to check for more if you get any one of the node
        if(root.data==a || root.data==b)
            return turns;
            
        int leftTurn=0, rightTurn=0;
        //if prev turn is left(0) then if we turn right we make a turn thus right turn becomes 1
        //otherwise if prev turn is right(1) then if we turn left we make a turn
        if(prevTurn==0)
            rightTurn=1;
        else
            leftTurn=1;
            
        //now we make a turn to the left tree and the right tree 
        int leftTree=findTurns(root.left,a,b,0,turns+leftTurn);
        int rightTree=findTurns(root.right,a,b,1,turns+rightTurn);
        
        //return the total turns made (however any 1 will be positive other will be zero)
        return leftTree+rightTree;
            
    }
    
    //Finding LCA code
    static Node findLCA(Node root, int a, int b){
        
        if(root==null)
            return null;
            
        if(root.data==a || root.data==b)
            return root;
            
        Node left=findLCA(root.left,a,b);
        Node right=findLCA(root.right,a,b);
        
        if(left!=null && right!=null)
            return root;
            
        if(left!=null)
            return left;
        else
            return right;
        
    }

}
