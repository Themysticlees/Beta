package tree_Problems;
import java.util.*;
/*
 * Given a Binary Tree, print the diagonal traversal of the binary tree.
 * Consider lines of slope -1 passing between nodes. Given a Binary Tree, print all diagonal 
 * elements in a binary tree belonging to same line.
 * 
 * Problem link : https://practice.geeksforgeeks.org/problems/diagonal-traversal-of-binary-tree/1
 */
public class DiagonalTraversal {
	//Check the picture for more clarity from the problem link
	//Print all the nodes in the right diagonal one by one
	//First add the root node
	//then check if it has a left node, if yes then add it in the queue
	//with that traverse the right nodes and print it
	//now after all the right nodes are printed, then go to the next element in queue
	//and follow the above steps
	public ArrayList<Integer> diagonal(Node root)
    {
         //add your code here.
         Queue<Node> queue = new LinkedList<>();
         ArrayList<Integer> list = new ArrayList<>();
         
         queue.offer(root);
         
         while(!queue.isEmpty()){
             
             Node curr=queue.poll();
             
             while(curr!=null){
                 list.add(curr.data);
                 
                 if(curr.left!=null)
                  queue.offer(curr.left);
                  
                  curr=curr.right;
             }
         }
         
         return list;
    }

}
