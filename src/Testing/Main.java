package Testing;
import java.util.*;


class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
    

class Main{
	
	static Node parent=null;
    static ArrayList<Integer> list=new ArrayList<>();
    
    public static ArrayList<Integer> printCousins(Node root, Node node_to_find)
    {
        //code here
        int level=-1;
        for(int i=0;i<1000;i++){
            if(Level(root,node_to_find,null,i))
            {
                level=i;
                break;
            }
        }
        
        find(root,null,level);
        return list;
    }
    
    
    static boolean Level(Node root,Node find, Node prev,int level){
        
        if(root==null)
            return false;
        if(level==0 && root.data==find.data)
        {
            parent=prev;
            return true;
        }
        else
        {
            if(Level(root.left,find,root,level-1) || Level(root.right,find,root,level-1))
                return true;
        }
        return false;
        
    }
    public static void find(Node root,Node p,int level){
        
        if(root==null)
            return;
            
        if(level==0 && parent.data!=p.data){
            list.add(root.data);
            return;
        }
        else
        {
            find(root.left,root,level-1);
            find(root.right,root,level-1);
        }
        
    }
    
    public static void main(String[] args) {
		
    	Node root=new Node(2);
		root.left=new Node(4);
		root.right=new Node(1);
		root.left.left=new Node(7);
		root.right.left=new Node(8);
		root.right.right=new Node(3);
		
		Node findNode=new Node(3);
		printCousins(root,findNode );
		
		System.out.println(list);
	}
	
}

	
