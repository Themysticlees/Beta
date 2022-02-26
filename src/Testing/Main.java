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
	
    public static int LCS(String s1, String s2) {
    	
    	if(s1.equals(" ") || s2.equals(" "))
    		return 0;
    	
    	if(s1.charAt(0) == s2.charAt(0))
    	{
    		
    		return 1+LCS(s1.substring(1),s2.substring(1));
    	}
    	
    	return Math.max(LCS(s1.substring(1),s2), LCS(s1,s2.substring(1)));
    }
    
    public static int LCS(String s1, String s2, int[][] arr) {
    	
    	for(int i=1;i<arr.length;i++) {
    		
    		for(int j=1;j<arr[0].length;j++) {
    			
    			if(s1.charAt(i)==s2.charAt(j))
    				arr[i][j]=1+arr[i-1][j-1];
    			else
    				arr[i][j]=Math.max(arr[i][j-1], arr[i-1][j]);
    		}
    	}
    	
    	return arr[arr.length-1][arr.length-1];
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
		
		//int[] pre= {10,5,3,2,4,6,9,13,11,14};
		//int[] in = {2,3,4,5,6,9,10,11,13,14};
		
		
		
		String s1=" abcdgh";
		String s2=" aedfhr";
		
		int[][] arr=new int[s1.length()][s2.length()];
		
		for(int i=0;i<s2.length();i++)
			arr[0][i]=0;
		for(int i=0;i<s1.length();i++)
			arr[i][0]=0;
		
		
		System.out.println(LCS("abcdgh ","aedfhr ",arr));
		
	}
	
}

	
