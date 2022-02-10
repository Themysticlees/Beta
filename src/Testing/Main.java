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
	
	static int Height(Node root) {
		
		if(root==null)
			return 0;
		
		return 1+Math.max(Height(root.left), Height(root.right));
	}
	
	static ArrayList<Integer> LevelOrder(Node root, int height){
		
		//We are traversing every level and printing all the nodes in that level
		int con;
		ArrayList<Integer> list= new ArrayList<>();
		for(int i=0;i<height;i++) {
			//System.out.println("Nodes of level "+i);
			
			//This function is doing the work
			if(i%2==0)
				con=0;
			else
				con=1;
			
			currentLevel(root,i,con,list);
			//System.out.println();
		}
		return list;
	}
	
	static void currentLevel(Node root, int level, int con, ArrayList<Integer> list) {
		
		if(root==null)
			return;
		//if level becomes becomes zero that means we have reached our target level
		if(level==0)
		{
			list.add(root.data);
			return;
		}
		//decreasing the level until we reach 0
		if(con==0) {
		currentLevel(root.left, level-1,con,list);
		currentLevel(root.right, level-1,con,list);
		}
		else
		{
			currentLevel(root.right, level-1,con,list);
			currentLevel(root.left, level-1,con,list);
		}
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
		
		System.out.println(LevelOrder(root,Height(root)));
		
	}
	
}

	
