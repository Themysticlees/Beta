package Testing;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
	
	public static void swap(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void printArray(int[] arr, int n) {
		
		for(int i=0;i<n;i++)
			System.out.println(arr[i]);
	}
	
	static boolean patternMatch(String A, String B) {
		
		int n=B.length();
		long hashcode=0;
		for(int i=0;i<n;i++) {
			int ch=B.charAt(i)-'a'+1;
			hashcode+=ch*(int)Math.pow(26, n-i-1);
		}
		
		long check=0;
		int i=0;
		for(i=0;i<n;i++) {
			int ch=A.charAt(i)-'a'+1;
			check+=ch*(int)Math.pow(26, n-i-1);
		}
		
		int j=0;
		while(i<A.length()) {
			
			int ch=A.charAt(j)-'a'+1;
			j++;
			check=(check-ch*(int)Math.pow(26, n-1))*26;
			check=check+((int)A.charAt(i)-'a'+1);
			i++;
			if(check==hashcode && B.equals(A.substring(j, i)))
				return true;
			
			
		}
		
		
		return false;
	}
	
	static Node swapkthnode(Node head, int num, int k)
    {
        // your code here
        int n=num;
        
        if(k>n)
            return head;
          
        if(k>1){ 
            
        	Node temp=head;
            Node prevLeft=null;
            Node prevRight=null;
            Node left=null;
            Node right=null;
            int c=0;
            
            while(temp!=null)
            {
                c++;
                
                if(c==k-1)
                    prevLeft=temp;
                if(c==k)
                    left=temp;
                if(c==n-k)
                    prevRight=temp;
                if(c==n-k+1)
                    right=temp;
                    
                temp=temp.next;
            }
            
            
            prevLeft.next=right;
                
            temp=right.next;
            right.next=left.next;
            
            if(prevRight!=null)
                prevRight.next=left;
            left.next=temp;
            
        }
        else
        {
            Node prevRight=head;
            Node left=head;
            while(prevRight.next.next!=null)
                prevRight=prevRight.next;
                
            Node right=prevRight.next;
            right.next=head.next;
            
            prevRight.next=left;
            left.next=null;
            
            head=right;
        }
        
        return head;
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
		
		Node head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(3);
		head.next.next.next=new Node(4);
		head.next.next.next.next=new Node(5);
		head.next.next.next.next.next=new Node(6);
		
		swapkthnode(head, 6, 6);
	}
	
}


	
