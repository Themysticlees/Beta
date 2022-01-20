package tree_Problems;

import java.util.*;

public class MaxSumNonAdjacentNodes {
	
	static Map<Node,Integer> map = new HashMap<>();
    static int getMaxSum(Node root)
    {
        //base cond, if root is null then return 0
        if(root==null)
            return 0;
        
        //if the max of that current root already exists
        //i.e we have already calculated it, why calculate it again
        //return the value
        if(map.containsKey(root))
            return map.get(root);
        
        //We'll be taking two cases
        //once when we include the node, then we cant include its child
        //so we proceed to its grandchild
        int inc=root.data;
        if(root.left!=null){
            inc+=getMaxSum(root.left.left);
            inc+=getMaxSum(root.left.right);
        }
        
        if(root.right!=null){
            inc+=getMaxSum(root.right.left);
            inc+=getMaxSum(root.right.right);
        }
        
        //2nd case we'll exclude the node and move to its child
        //we'll find the max for both the cases and return which one has the 
        //maximum value
        int exc=getMaxSum(root.left)+getMaxSum(root.right);
        
        //we'll store the max value untill now in the current node
        //i.e max value from it's children nodes
        map.put(root,Math.max(inc,exc));
        
        //at the end when we reach back to root node, just return the max value found
        return map.get(root);
    }
    
    static Node createTree()
	{
    	Scanner sc=new Scanner(System.in);
		System.out.println("Enter data : (Enter -1 if data is null) ");
		int data=sc.nextInt();
		
		//If no node is present 
		if(data==-1)
			return null;
		
		Node root = new Node(data);
		
		System.out.println("Enter left of "+data);
		root.left=createTree();
		//Create the left node of the current node
		
		System.out.println("Enter right of "+data);
		root.right=createTree();
		//create the right node of the current node
		
		return root;
	}

	static class Node
	{
	    int data;
	    Node left, right;
	    
	    Node(int data)
	    {
	        this.data = data;
	        this.left = null;
	        this.right = null;
	    }
	}
    
    public static void main(String[] args) {
		
    	Node root = createTree();
    	System.out.println(getMaxSum(root));
	}

}

