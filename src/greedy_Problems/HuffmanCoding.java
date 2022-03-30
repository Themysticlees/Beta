package greedy_Problems;
import java.util.*;
/*
 * Given a string S of distinct character of size N and their corresponding frequency f[ ] 
 * i.e. character S[i] has f[i] frequency. Your task is to build the Huffman tree 
 * print all the huffman codes in preorder traversal of the tree.
	Note: While merging if two nodes have the same value, then the node 
	which occurs at first will be taken on the left of Binary Tree and the other one to the right, 
	otherwise Node with less value will be taken on the left of the subtree and other one to the right.
	
	S = "abcdef"
	f[] = {5, 9, 12, 13, 16, 45}
	Output: 
	0 100 101 1100 1101 111
	
	//the left branch is denoted by 0, the right branch is denoted by 1
			100
		   /   \
		 45	    55
		 	  /     \
			 25	 	30
			/ \	   /  \
		   12 13  14  16
		   		 /  \
		   		5    9
		   		
		This huffman tree is formed by adding the frequencies of the characters
		The lowest two frequencies are added first and their sum becomes their paren
		same process is followed.
		
		Huffman code for each character is the total string which is formed by traversing from 
		the root to the particular leaf node. if you move to left child add 0 to the string, if you move right
		add 1 to the string
 */
class Node {
	 
	int data;
	Node left;
	Node right;
	//Node next;
	char ch;
	    
	Node(int d) {
	    data = d; 
	    left=null;
	    right=null;
	    //next=null;
	}

}
public class HuffmanCoding {
	
	public ArrayList<String> huffmanCodes(String S, int f[], int n)
    {
        // Code here
		//For sorting the nodes in ascending order
        Comparator<Node> com = new Comparator<Node>() {
			
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if(o1.data == o2.data){
                    return 1;
                }
				return o1.data-o2.data;
			}
		};
		PriorityQueue<Node> pq=new PriorityQueue<>(com);
		
		//creating a node for each character with data as their frequency
		for(int i=0;i<n;i++) {
			Node temp=new Node(f[i]);
			temp.ch=S.charAt(i);
			pq.add(temp);
		}
		
		//until only 1 node is remaining
		while(pq.size()>1)
		{
			//removing the top two nodes
			Node l=pq.remove();
			Node r=pq.remove();
			int sum=l.data+r.data;
			//creating their parent and assigning them as their left and right child
			//left child is smaller than = to right child
			Node temp=new Node(sum);
			temp.left=l;
			temp.right=r;
			
			//add the parent to the queue
			pq.add(temp);
			//same process will be repeated until only 1 node is remaining
		}
		
		//now only the root of the tree is present in the queue
		
		//to store the codes for each character
		ArrayList<String> list = new ArrayList<String>();
		preorder(pq.remove(),list,"");
		return list;
    }
    
    void preorder(Node root,ArrayList<String> list,String s) {
		//if the node is a leaf node then it must be a character
    	//add the so formed string upto now to the list and return
		if(root.left==null && root.right==null)
		{
			list.add(s);
			return;
		}
		
		//otherwise go left and add 0 to the string
		//and go right and add 1 to the string
		preorder(root.left, list, s+"0");
		preorder(root.right, list, s+"1");
	}
    
    public static void main(String[] args) {
    	String S = "abcdef";
		int f[] = {5, 9, 12, 13, 16, 45};
		System.out.println(new HuffmanCoding().huffmanCodes(S, f, S.length()));
	}
}
