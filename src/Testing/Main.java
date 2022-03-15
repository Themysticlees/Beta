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
	
	//if all the oranges are rotten, then this fun will return true
	public boolean checkIfRotten(int[][] matrix, int n, int m) {
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++) {
				
				if(matrix[i][j]==1)
					return false;
			}
		}
		return true;
	}
	
	public static int rotten(int[][] matrix, int n, int m) {
		
		//boolean cond=false;
		
		Queue<List<Integer>> queue= new LinkedList<>();
		
		int fresh=0;
		//Putting all the rotten oranges in queue
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++) {
				
				if(matrix[i][j]==2)
				{
					List<Integer> list = new LinkedList<>();
					
					list.add(i);
					list.add(j);
					
					queue.offer(list);
				}
				else if(matrix[i][j]==1)
					fresh++;
					
			}
		}
		
		queue.offer(null);
		
		int turns=0;
		while(!queue.isEmpty()) {
			
			while(queue.peek()!=null) {
			
			int i=queue.peek().get(0);
			int j=queue.peek().get(1);
			queue.poll();
			
			if(i-1>=0 && matrix[i-1][j]==1)
			{
				matrix[i-1][j]=2;
				List<Integer> list = new LinkedList<>();
				
				list.add(i-1);
				list.add(j);
				
				fresh--;
				queue.offer(list);
			}
					
			if(i+1<n && matrix[i+1][j]==1)
			{
				matrix[i+1][j]=2;
				List<Integer> list = new LinkedList<>();
				
				list.add(i+1);
				list.add(j);
				
				fresh--;
				
				queue.offer(list);
			}
			
			if(j-1>=0 && matrix[i][j-1]==1)
			{
				matrix[i][j-1]=2;
				List<Integer> list = new LinkedList<>();
				
				list.add(i);
				list.add(j-1);
				
				fresh--;
				
				queue.offer(list);
			}
					
			if(j+1<m && matrix[i][j+1]==1)
			{
				matrix[i][j+1]=2;
				List<Integer> list = new LinkedList<>();
				
				list.add(i);
				list.add(j+1);
				
				fresh--;
				
				queue.offer(list);
			}		
			
			
					
			}
			queue.poll();
			if(!queue.isEmpty())
			{
				queue.offer(null);
				turns++;
			}
			
			if(fresh==0)
				return turns;
		}
		if(fresh==0)
			return turns;
		return -1;
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
		int[][] arr= {{1, 2, 0 ,2, 2},{2, 1, 2, 1, 2},{1, 2, 2, 1, 2},{2, 1, 1, 2, 2},{2 ,1 ,2, 1, 1},{0, 1, 1, 0, 1}};
		System.out.println(rotten(arr,arr.length,arr[0].length));
		
	}
	
}


	
