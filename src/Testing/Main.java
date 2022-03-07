package Testing;
import java.util.*;


class Node {
	 
	int data;
	//Node left;
	//Node right;
	Node next;
	    
	Node(int d) {
	    data = d; 
	    //left=null;
	    //right=null;
	    next=null;
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
	
	public static void reverseStack(Stack<Integer> stack) {
		// write your code here
        
        if(stack.isEmpty())
            return;
        
        int top = stack.pop();
        reverseStack(stack);
        
        insertBottom(stack,top);
		
	}
	
	public static void insertBottom(Stack<Integer> stack, int n) {
		
		if(stack.isEmpty())
			stack.push(n);
		else
		{
			int top=stack.pop();
			insertBottom(stack, n);
			stack.push(top);
		}
	}
	
	
	public static void main(String[] args) {
    	
		/*
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
		
		*/
		//root.right.right.right=new Node(5);
		//root.right.right.right.right=new Node(6);
		//root.left.right.left=new Node(6);
		//root.right.right.left=new Node(13);
		
		//int[] pre= {10,5,3,2,4,6,9,13,11,14};
		//int[] in = {2,3,4,5,6,9,10,11,13,14};
		
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		reverseStack(stack);
		System.out.println(stack);
		
	}
	
}


	
