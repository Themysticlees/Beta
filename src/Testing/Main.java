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

    
	public int FindWays(int n, int m, int[][] blocked)
    {
        // Code here
        n++;
        m++;
        int[][] arr = new int[n][m];
        	
        for(int i=0;i<blocked.length;i++){
            arr[blocked[i][0]][blocked[i][1]]=1;
        }
        
        if(arr[1][1]==1 || arr[n-1][m-1]==1)
            return 0;
        
        findways(arr,n,m,1,1);
        return count;
        
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
		
		//int[][] arr= {{1,3},{8,10},{2,6},{15,18}};
		
		/*Comparator<int[]> com=new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				
				return o1[1]-o2[1];
			}
		};
		*/
		
		//int[][] blocked={{2,4},{4,5},{4,6},{4,4},{3,6},{2,2},{4,2},{1,3}};
		
		long A[] = {-8, 2, 3, -6, 10};
		printFirstNegativeInteger(A, A.length, 2);
	}
	
}


	
