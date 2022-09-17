package tree_Problems;
/*
 * Given a binary tree where node values are digits from 1 to 9. A path in the binary tree 
 * is said to be pseudo-palindromic if at least one permutation of the node values in the 
 * path is a palindrome.
 * Return the number of pseudo-palindromic paths going from the root node to leaf nodes.
 */
public class Pseudo_PalindromicPaths {
	
	/*
	 * The idea is to go down each path to leaf node and check if we can form a palindrome out of the nodes
	 * In a palindrome atmost 1 number can have odd frequency.
	 * So check the frequencies, if less than or 1 number has odd frequency then we can include that path.
	 */
	
	public int pseudoPalindromicPaths (Node root) {
        
        int[] nodes=new int[10];
        int[] ans={0};
        
        dfs(root,nodes,ans);
        
        return ans[0];
    }
    
    public void dfs(Node root, int[] nodes, int[] ans){
    	
    	//if we reach leaf node
        if(root.left==null && root.right==null){
        	
        	//increase frequency
        	nodes[root.data]++;
        	
        	//check for odd frequencies
            int count=0;
            for(int i=0;i<nodes.length;i++){
                if((nodes[i]&1)!= 0)
                    count++;
                if(count>1)
                    break;
            }
            
            if(count==1)
                ans[0]++;
            
            nodes[root.data]--;
            
            return;
                
        }
        
        //increase frequency of the curr node
        nodes[root.data]++;
        if(root.left!=null)
        	dfs(root.left,nodes,ans);
        if(root.right!=null)
        	dfs(root.right,nodes,ans);
        
        //once we are finished with the node, decrease by 1
        nodes[root.data]--;
    }

}
