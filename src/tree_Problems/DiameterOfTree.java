  package tree_Problems;

public class DiameterOfTree {
	//For Binary Tree
	int diameter(Node root) {
        //we are creating a single element array to store the max diameter
		//More efficient than global variable
        int[] diameter=new int[1];
        
        findDiameter(root,diameter);
        return diameter[0]+1;
    }
    
    int findDiameter(Node root, int[] diameter){
        
        if(root==null)
            return 0;
        
        //finding the left and right height from the current node
        int lheight=findDiameter(root.left,diameter);
        int rheight=findDiameter(root.right,diameter);
        
        //max diameter should be the addition of the both the heights
        //so for each node, we'll calculate the diameter and check with the max value
        diameter[0]=Math.max(diameter[0],lheight+rheight);
        
        //This is returning the height from the current node
        return 1+Math.max(lheight,rheight);
    }
    
}
