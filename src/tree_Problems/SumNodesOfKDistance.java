package tree_Problems;
import java.util.*;
/*
 * target = 9 
	k = 1
	Binary Tree = 
	            1
	           /  \
	          2    9
	        /     /  \
	       4     5    7
	      /  \       /  \
	     8    19    20   11
	    /   /   \
	  30   40   50
	
	Output: 22
	
	Explanation: 
	Nodes within distance 1 from 9 
	9 + 5 + 7 + 1 = 22
	
	He needs to find the sum of all nodes within
	a max distance k from target node such that the target node is included in sum.
 */
public class SumNodesOfKDistance {
	
	//The idea is to first to store the parent child pair in a map because we need to move
	//k distance above a node as well, thus we need to keep a track of the parent
	static int sum_at_distK(Node root, int tar, int k){
        // code here
        
		//for storing child parent pair
        Map<Node,Node> map = new HashMap<>();
        //for doing a BFS traversal
        Queue<Node> queue = new LinkedList<>();
        
        Node temp=root;
        
        queue.offer(temp);
        map.put(temp,null);
        
        Node target=null;
        //do a BFS and store the child and parent in the map
        while(!queue.isEmpty()){
            
            Node curr=queue.poll();
            
            //if we get our target node store it in a var
            if(curr.data==tar)
            target=curr;
            
            //store the child and parent in the map
            if(curr.left!=null){
                queue.offer(curr.left);
                map.put(curr.left,curr);
            }
            
            if(curr.right!=null){
                queue.offer(curr.right);
                map.put(curr.right,curr);
                
            }
                
        }
        
        //initialize the distance by 1 as we'll be starting from the nodes at distance 1
        int dis=1;
        Set<Node> visited=new HashSet<>();
        
        //we'll be adding the target node, it's parent, it's children in the queue
        //along with it we'll add them in a visited set so that we don't count duplicates
        
         if(target!=root)
        	queue.offer(map.get(target));
        	
        queue.offer(target);
        
        visited.add(map.get(target));
        visited.add(target);
        
        //check if the children are null or not
        if(target.left!=null){
            queue.offer(target.left);
            visited.add(target.left);
        }
        
        if(target.right!=null){
            queue.offer(target.right);
            visited.add(target.right);
        }
        
        //This null acts as a delimiter, it marks the end of the current lot
        queue.offer(null);
        int sum=0;
        
        while(dis!=k){
            
        	//end the loop if we finish the current lot
            while(queue.peek()!=null){
            	//from each node we'll try to add it's parent, children as long as it is within the k range
                Node curr=queue.poll();
                
                //add the current nodes value
                sum+=curr.data;
                
                //if the particular node is not null and not already visited then we can add that
                if(map.get(curr)!=null && !visited.contains(map.get(curr))){
                    queue.offer(map.get(curr));
                    visited.add(map.get(curr));
                }
                
                if(curr.left!=null && !visited.contains(curr.left)){
                    queue.offer(curr.left);
                    visited.add(curr.left);
                }
                    
                if(curr.right!=null && !visited.contains(curr.right)){
                    queue.offer(curr.right);
                    visited.add(curr.right);
                    
                }
                
            }
            //after the loop ends, we'll remove the delimiter(null)
            //and add again in this new lot created
            queue.poll();
            queue.offer(null);
            
            //increase distance as we are traversing further from the target node
            dis++;
            
        }
        
        //when the distance matches with k then we are k distance from the target node
        //and the all the nodes which are k distance are present in the queue
        //so add them too
        
        while(queue.peek()!=null)
            sum+=queue.poll().data;
        return sum;
    }

}
