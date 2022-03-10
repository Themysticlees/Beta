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

	public static int[] nextSmaller (int[]arr, int n) {
		int[] res=new int[n];
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=n-1;i>=0;i--) {
			
			while(!stack.isEmpty() && stack.peek()>arr[i])
				stack.pop();
			
			if(stack.isEmpty())
				res[i]=-1;
			else
				res[i]=stack.peek();
			
			stack.push(arr[i]);
				
		}
		return res;
		
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
		
		int[] pre= {10,5,3,2,4,6,9,13,11,14};
		//int[] in = {2,3,4,5,6,9,10,11,13,14};
		
		int[][] arr= {{1,3},{8,10},{2,6},{15,18}};
		
		Comparator<int[]> com=new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				
				return o1[1]-o2[1];
			}
		};
		
		System.out.println(nextSmaller(pre, pre.length));
		
	}
	
}


	
