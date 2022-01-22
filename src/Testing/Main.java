package Testing;
import java.util.*;


class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class Main {
	
	static Node head=null;
    static Node prev=null;
	public static Node convertToDLL(Node root)
    {
        // Code here
        
        
        return modify(root);
    }
    
    public static Node modify(Node root){
        
        if(root==null)
            return null;
            
        if(root.left==null && root.right==null){
            
            if(head==null){
                head=root;
                prev=head;
            }
            else
            {
                prev.right=root;
                root.left=prev;
                prev=root;
            }
            return null;
        }
        
        root.left=modify(root.left);
        root.right=modify(root.right);
        
        return head;
    }
    
    static Node createTree()
	{
    	Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter data : (Enter -1 if data is null) ");
		int data=sc.nextInt();
		
		//If no node is present 
		if(data==-1)
			return null;
		
		Node root = new Node(data);
		
		System.out.println("Enter left of "+data);
		root.left=createTree();
		//Create the left node of the current node
		
		System.out.println("Enter right of "+data);
		root.right=createTree();
		//create the right node of the current node
		
		return root;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		Node head=createTree();
		
		head=convertToDLL(head);
		
		while(head.right!=null)
		{
			System.out.print(head.data+"->");
			head=head.right;
		}
		System.out.print(head.data);
	}

}


