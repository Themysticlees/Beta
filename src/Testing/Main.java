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
	
	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A)
    {
        return helper(A,"",0);
        
    }
	
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	
	public static ArrayList<ArrayList<Integer>> helper(ArrayList<Integer> A,String temp, int i)
    {
        //code here
        if(i==A.size()) {
        	ArrayList<Integer> tempList = new ArrayList<Integer>();
        	for(char j:temp.toCharArray())
        		tempList.add(j-'0');
        	
        	list.add(tempList);
        	return list;
        }
        
        helper(A,temp+A.get(i),i+1);
        helper(A,temp,i+1);
        
        return list;

    }
    
	public static int copy(int x, int y, int l, int r){
        
        for(int i=l;i<=r;i++){
            int temp=1;
            temp=temp<<(i-1);
            
            int ch=y&temp;
            if((y&temp)==temp)
            {
                x=x|temp;
            }
        }
        return x;
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
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		//System.out.println(subsets(list));
		
		System.out.println(copy(10,13,2,3));
	}
	
}


	
