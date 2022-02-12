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
	
	static int maxEvents(int[] start, int[] end, int N) {
		
		int[][] arr=new int[N][2];
		
		for(int i=0;i<N;i++) {
			arr[i][0]=start[i];
			arr[i][1]=end[i];
		}
		
		Comparator<int[]> con = new Comparator<>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				
				if(o2[1]==o1[1] && o2[0]<o1[0])
					return 1;
				else if(o2[1]<o1[1])
					return 1;
				else
					return -1;
			}	
		};
		
		Arrays.sort(arr,con);
		
		int count=0;
		
		Set<Integer> set = new HashSet<>();
		
		for(int i=0;i<N;i++) {
			
			int j=arr[i][0];
			while(j<=arr[i][1])
			{
				if(!set.contains(j))
				{
					count++;
					set.add(j);
					break;
				}
				j++;
			}
		}
		return count;
		
	}
	
    public static void main(String[] args) {
    	
    	Node root=new Node(10);
		root.left=new Node(12);
		root.right=new Node(15);
		root.left.left=new Node(25);
		root.left.right=new Node(30);
		root.right.left=new Node(36);
		//root.right.right=new Node(7);
		//root.left.left.right=new Node(8);
		
		int start[] = {1, 2, 1, 3, 4};
		int end[] =   {1, 2, 2, 4, 4};
		System.out.println(maxEvents(start, end, start.length));
		
	}
	
}

	
