package tree_Problems;
import java.util.*;

public class LeftViewTree {
	
	//If you see a tree from it's left side, the nodes which we can see needs to be printed
	ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer> list = new ArrayList<>();
    
	    int[] max=new int[1];
	    //instead of taking max as static
	    //we create a 1 element array as it is mutable
	    max[0]=-1;
        preorder(root,0,list,max);
        return list;
        
      
    }
	//we'll follow the preorder traversal (root,left,right)
	//since we print the root and move left first thus we use this traversal
	//we won't be printing the right if left node is already printed, to make sure 
	//we will using a level var and compare it with max level reached.
	//Thus if we reach a level and print it's left node then we wont be printing the right node of that level
    
	// 			4
    //		   / \
    //		  5   2
    //		     / \
    //			3	1
    // Ans will be 4 5 3
	
	void preorder(Node root, int lvl,ArrayList<Integer> list, int[] max){
        
        if(root==null){
            return;
        }
        
        //we maintain the level of each node
        //if we have already printed a node in that level, no need to print any node again
        //since all the nodes of the left may not be connected thus we need to keep track of level
        
        if(lvl>max[0])
        {
        	//if level is more than max level reached then add the element and update max
            list.add(root.data);
            max[0]=lvl;
        }
        
        preorder(root.left,lvl+1,list,max);
        preorder(root.right,lvl+1,list,max);
                
    }

}
