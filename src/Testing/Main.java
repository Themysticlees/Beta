package Testing;
import java.util.*;



class Node {
	 
	int value;
	Node left;
	Node right;
	    
	Node(int d) {
	    value = d; 
	    left=null;
	    right=null;
	 }

}

public class Main{
	
	static ArrayList<Integer> inOrder(Node root) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<Node> stack=new Stack<Node>();
		
		Node curr=root;
		
		while(!stack.isEmpty() || curr!=null) {
			
			if(curr!=null) {
				stack.push(curr);
				curr=curr.left;
			}
			else
			{
				curr=stack.pop();
				list.add(curr.value);
				curr=curr.right;
			}
		}
		return list;
		
	}
    
    public static void main(String[] args) {
    	
    	Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right.left=new Node(6);
		root.right.right=new Node(7);
		root.left.left.right=new Node(8);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] max= {-1};
		list=inOrder(root);
		System.out.println(list);
		
	}
	
}

	
