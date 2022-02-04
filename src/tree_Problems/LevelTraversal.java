package tree_Problems;
import java.util.*;
public class LevelTraversal {
	
	
	static ArrayList <Integer> levelOrder(Node node) 
    {
		
        ArrayList <Integer> list = new ArrayList<>();
        
        Queue<Node> que = new LinkedList<>();
        
        que.offer(node);
        while(!que.isEmpty()){
        	//elements will be removed according to their insertion
        	//thus all the elements of each level will be printed
            Node curr=que.poll();
            
            list.add(curr.data);
            //we are adding all the children of the current node to queue
            if(curr.left!=null)
                que.offer(curr.left);
            
            if(curr.right!=null)
                que.offer(curr.right);
        }
        
        return list;
    }
	
	//Reverse level order traversal
	public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        
        //Storing the result in a stack
        Stack<Integer> stack=new Stack<>();
        Queue<Node> que = new LinkedList<>();
        
        que.offer(node);
        while(!que.isEmpty()){
            Node curr=que.poll();
            
            stack.push(curr.data);
            //for printing the reverse we need the store the right child first 
            //then the left child
            //because at the last we'll be storing the reverse so automatically left child will come before
            if(curr.right!=null)
                que.offer(curr.right);
            
            if(curr.left!=null)
                que.offer(curr.left);
            
        }
        
        //extracting the elements from the end and storing in the list
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        
        return list;
        
    }

}
