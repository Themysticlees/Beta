package tree_Problems;
import java.util.*;

public class BT2DoubleLL {
	//You have to find the inorder traversal of the tree
	//and create a double LL and store the nodes
	void InOrder(Node root, ArrayList<Node> list)
    {
		//Function to find the Inorder traversal
	    Stack<Node> stack = new Stack<>();
	    
	    Node curr=root;
	    
	    while(!stack.isEmpty() || curr!=null){
	        
	        if(curr!=null){
	            stack.push(curr);
	            curr=curr.left;
	        }
	        else
	        {
	            curr=stack.pop();
	            //storing the elements in list
	            list.add(curr);
	            curr=curr.right;
	        }
	    }
	   
    }
	
     Node bToDLL(Node root) {
		ArrayList<Node> list=new ArrayList<Node>();
		
		InOrder(root, list);
		
		if(list.size()==0)
			return root;
		
		//connecting the nodes to each order
		for(int i=1;i<list.size();i++) {
			list.get(i).left=list.get(i-1);
			list.get(i-1).right=list.get(i);
		}
		
		//for the edge nodes
		list.get(0).left=null;
		list.get(list.size()-1).right=null;
		
		return list.get(0);
	}

}
