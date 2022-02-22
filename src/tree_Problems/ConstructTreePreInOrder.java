package tree_Problems;
import java.util.*;

public class ConstructTreePreInOrder {
	
	//The intuition is, we'll find take an element from the preorder, since we print the root first
	//in preorder, we'll consider that as the root. Now we'll find the element in the inorder array.
	//When we locate the position, automatically all the element to it's left will belong to the left subtree
	//and all the elements to the right will belong the right subtee.
	//now we'll do a recursive call for the both the children
	//and when we get an empty array, we'll put null
	public static Node buildTree(int inorder[], int preorder[], int n)
    {
        //we'll store the inorder elements with their positions in the hashmap
		//so that we can easily search for and element and it's position
        Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0;i<inorder.length;i++)
			map.put(inorder[i],i);
		
		return construct(preorder, inorder, map, 0, preorder.length-1, 0, inorder.length-1);
    }
    
    public static Node construct(int[] pre, int[] in, Map<Integer,Integer> map,int prestart, int preend, int instart, int inend) {
		
    	//prestart and preend are the starting points of the preorder array
    	//instart and inend are the starting points of inorder array
    	//we'll update them as we construct the tree, since we'll do recursive call, we'll change the values 
    	//to change the array
    	
    	//if the starting points moves ahead of the ending pointer
    	//that means we have an empty array
		if(prestart>preend || instart>inend)
			return null;
		
		//we'll take the first element of the array as our root
		Node root=new Node(pre[prestart]);
		//calculate the position of the element in inorder array
		int pos=map.get(pre[prestart]);
		//calculate the no.of children to it's left
		int leftElements=pos-instart;
		
		//now do a recursive call and update the array for the children
		//incase of preorder, the from start+1 to no.of leftElements will belong to left subtree 
		//the right subtree will have elements from start+leftElements to the end
		root.left=construct(pre, in, map, prestart+1, prestart+ leftElements, instart, pos-1);
		root.right=construct(pre, in, map, prestart+ leftElements+1, preend, pos+1, inend);
		
		return root;
		
	}
}
