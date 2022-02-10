package tree_Problems;
import java.util.*;

public class ZigZagTraversal {
	
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    
	    int con;
		ArrayList<Integer> list= new ArrayList<>();
		//calculating the height of the tree
		int height=Height(root);
		
		//traversing each level and printing it in zig zag order
		//the even levels are printed from left to right
		//the odd levels are printed from right to left
		//Thus zig zag traversal is done
		for(int i=0;i<height;i++) {
			//here i represents each level
			if(i%2==0)
				con=0;
			else
				con=1;
			
			currentLevel(root,i,con,list);
			//System.out.println();
		}
		return list;   
	}
	
	static int Height(Node root) {
		
		if(root==null)
			return 0;
		
		return 1+Math.max(Height(root.left), Height(root.right));
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
		//the even levels are printed from left to right
		
		if(con==0) {
			currentLevel(root.left, level-1,con,list);
			currentLevel(root.right, level-1,con,list);
		}
		else
		{
			//the odd levels are printed from right to left
			currentLevel(root.right, level-1,con,list);
			currentLevel(root.left, level-1,con,list);
		}
		//Thus zig zag traversal is done
	}

}
