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
	
	public static int mostBalloons(int N, int arr[][]) {
        // Code here
        int ans=0;
        for(int i=0;i<arr.length;i++){
            
            Map<Double,Integer> map = new HashMap<>();
            int max=0,same=1;
            double slope=0;
            for(int j=i+1;j<arr.length;j++){
                
                if(arr[i][0]==arr[j][0] || arr[i][1]==arr[j][1])
                {
                    same++;
                    continue;
                }
                
                if(arr[j][1]-arr[i][1]==0)
                    slope=999;
                else
                    slope=(double)Math.abs(arr[j][0]-arr[i][0])/(double)Math.abs(arr[j][1]-arr[i][1]);
                
                if(map.containsKey(slope))
                    map.put(slope,map.get(slope)+1);
                else
                    map.put(slope,2);
                    
                max=Math.max(max,map.get(slope));
            }
            ans=Math.max(ans,Math.max(max,same));
        }
        return ans;
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
		
		
		
		int arr[][] = {{1, 2}, {2, 3}, {3, 4}, {3,3},{4,3},{5,3}};
		System.out.println(mostBalloons(arr.length, arr));
		
	}
	
}

	
