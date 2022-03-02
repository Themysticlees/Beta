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
	
	public static String moveRobots(String s1, String s2){
        //code here
        
        int i=0,j=0;
        String ans="Yes";
        int maxB=-1,minA=9999;
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i)=='#')
            {
                i++;
                continue;
            }
            
            if(s2.charAt(j)=='#')
            {
                j++;
                continue;
            }
                
            if(s1.charAt(i)!=s2.charAt(j))
            {
                ans="No";
                break;
            }
            
            if(s1.charAt(i)=='A')
            {
                if(i<j || i>maxB){
                    ans="No";
                    break;
                }
                else
                {
                    minA=Math.min(minA,j);
                    i++;
                    j++;
                }
            }
            
            
            else if(s1.charAt(i)=='B' )
            {
                if(i>j || i<minA ){
                    ans="No";
                    break;
                }
                else
                {
                    maxB=j;
                    i++;
                    j++;
                }
            }
            
            
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
		
		System.out.println(moveRobots("AABBBAAA##A","AABBBAAA#A#"));
		
	}
	
}

	
