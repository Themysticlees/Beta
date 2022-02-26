package bst_Problems;
import java.util.*;

//Merge two BST and return all the nodes in sorted order
//From the sorted list you can create a new BST

public class MergeTwoBST {
	
	//since we know that the inorder of a BST is sorted
	//Thus we find the inorder traversal of both the trees
	public void inorder(Node root, List<Integer> list){
        
        if(root==null)
            return;
            
        inorder(root.left,list);
        list.add(root.data);
        inorder(root.right,list);
    }
	
	public Node merge(Node root1,Node root2)
    {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        
        inorder(root1,list);
        inorder(root2,list);
        
        //After getting both the inorder traversals we sort them
        //thus we get the inorder traversal of the new tree
        Collections.sort(list);
        
        return build(list, 0, list.size()-1);
    }
	
	//This fun will build the tree
	Node build(List<Integer> list,int start, int end){
        
		//if we return an empty array, thus we return null
		//i.e there are no children for a particular node
        if(start>end)
            return null;
        
        //We take the middle node, make it the root
        //and send the left part to the left child of the root
        //and right part to the right child
        //we do a recursive call, thus this process continues
        int mid=start+(end-start)/2;
        Node root=new Node(list.get(mid));
        
        root.left=build(list,start,mid-1);
        root.right=build(list,mid+1,end);
        
        return root;
    }

}
