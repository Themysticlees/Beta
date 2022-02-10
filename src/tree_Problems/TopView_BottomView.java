package tree_Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//We are using a pair class to store the level(column) of each node together
class Pair{
	
	Node val;
	int level;
	public Pair(Node val, int level) {
		super();
		this.val = val;
		this.level = level;
	}
	
}

public class TopView_BottomView {
	
	static ArrayList<Integer> topView(Node root){
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		//We'll be applying level order traversal and store all the nodes of each level along with it's 
		//column height level
		Queue<Pair> queue = new LinkedList<>();
		
		//We'll store the final nodes which needs to returned
		Map<Integer,Integer> map = new HashMap<>();
		
		queue.offer(new Pair(root,0));
		//taking two pointers to sort the view in an order
		//since we are storing the final nodes in an hashmap thus there is no order
		//for this reason we'll calculate the min column level and the max column level
		int min=9999,max=-9999;
		
		while(!queue.isEmpty()) {
			
			Pair curr=queue.poll();
			
			//Calculating max and min of the curr node column level
			min=Math.min(min, curr.level);
			max=Math.max(max,curr.level);
			
			//if map already contains an element of that element then no need to assign
			//since this is top view of the tree thus elements which are inserted first
			//of a particular level will be seen from the top
			
			if(!map.containsKey(curr.level)) // in case of bottom view just remove this cond as we'll store
				map.put(curr.level, curr.val.data);//the last node of a particular level. 
			
			//inserting the children into queue
			if(curr.val.left!=null)
			queue.offer(new Pair(curr.val.left,curr.level-1));
			if(curr.val.right!=null)
			queue.offer(new Pair(curr.val.right,curr.level+1));
		}
		
		//since we have the min and max column height, we can traverse the map using them
		for(int i=min;i<=max;i++)
			list.add(map.get(i));
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
		
		System.out.println(topView(root));
		
	}

}
