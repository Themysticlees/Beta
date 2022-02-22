package Testing;
import java.util.*;


class Node {
	 
	int data;
	Node left;
	Node right;
	    
	Node(int d) {
	    data = d; 
	    left=null;
	    right=null;
	 }

}

class Pair{
	
	Node val;
	int level;
	public Pair(Node val, int level) {
		super();
		this.val = val;
		this.level = level;
	}
	
}

public class Main{
	
	public static Node construct(int[] pre, int[] in, Map<Integer,Integer> map,int prestart, int preend, int instart, int inend) {
		
		if(prestart>preend || instart>inend)
			return null;
		
		Node root=new Node(pre[prestart]);
		int pos=map.get(pre[prestart]);
		int leftElements=pos-instart;
		
		root.left=construct(pre, in, map, prestart+1, prestart+ leftElements, instart, pos-1);
		root.right=construct(pre, in, map, prestart+ leftElements+1, preend, pos+1, inend);
		
		return root;
		
	}
	
	public static void Preorder(Node root) {
		
		if(root==null)
			return;
		
		System.out.println(root.data);
		Preorder(root.left);
		Preorder(root.right);
	}
	
	public static void Inorder(Node root) {
		
		if(root==null)
			return;
		
		Inorder(root.left);
		System.out.println(root.data);
		Inorder(root.right);
	}
	
	public static void Postorder(Node root) {
		
		if(root==null)
			return;
		
		Postorder(root.left);
		Postorder(root.right);
		System.out.println(root.data);
	}
	
	
	
	public static void main(String[] args) {
    	
    	Node root=new Node(10);
		root.left=new Node(5);
		root.right=new Node(13);
		root.left.left=new Node(3);
		root.left.right=new Node(6);
		root.right.left=new Node(11);
		root.right.right=new Node(14);
		root.left.left.left=new Node(2);
		root.left.left.right=new Node(4);
		root.left.right.right=new Node(9);
		//root.right.right.right=new Node(5);
		//root.right.right.right.right=new Node(6);
		//root.left.right.left=new Node(6);
		//root.right.right.left=new Node(13);
		
		int[] pre= {10,5,3,2,4,6,9,13,11,14};
		int[] in = {2,3,4,5,6,9,10,11,13,14};
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0;i<in.length;i++)
			map.put(in[i],i);
		
		root=construct(pre, in, map, 0, pre.length-1, 0, in.length-1);
		
		Postorder(root);
		
		
	}
	
}

	
