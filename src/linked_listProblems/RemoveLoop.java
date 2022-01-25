package linked_listProblems;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveLoop {
	
	public static void removeLoop(Node head){
        
		//we'll store the nodes in the hash set,
		//when a duplicate is found, break the link
        HashSet<Node> set = new HashSet<>();
        
        Node temp=head;
        Node prev=temp;
        
        while(temp.next!=null){
            if(set.contains(temp))
            {
            	//loop found, prev node linked to null
            	//thus we removed the loop
                prev.next=null;
                break;
            }
            else
            {
            	//we'll keep a prev pointer to the prev node
            	//as soon as we find a loop, we'll change the prev node's link to null
                set.add(temp);
                prev=temp;
                temp=temp.next;
            }
        }
    }
	
	public static void removeLoop2(Node head) {
		
		Node fast=head;
		Node slow=head;
		
		while(fast!=null && fast.next!=null) {
			if(fast==slow)
				break;
			fast=fast.next.next;
			slow=slow.next;
		}
		/*
		 * Using Floyd's loop detection algo
		 *  1. If a loop is found, initialize a slow pointer to head, let fast pointer be at its position. 
			2. Move both slow and fast pointers one node at a time. 
			3. The point at which they meet is the start of the loop.
		 */
		
		//we are keeping prev as the previous pointer to the slow pointer
		//as we find a match, we'll change the previous nodes link to null
		slow=head;
		Node prev=head;
		if(fast!=null && fast.next!=null) {
			while(fast!=slow) {
				prev=slow;
				fast=fast.next;
				slow=slow.next;
			}
			prev.next=null;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter no.of nodes : ");
		int n=sc.nextInt();
		
		Node head=new Node(sc.nextInt());
		Node tail=head;
		n--;
		
		while(n-->0) {
			tail.next=new Node(sc.nextInt());
			tail=tail.next;
		}
		
		Node temp=head;
		
		int loop=2;
		while(loop-->1) {
			temp=temp.next;
		}
		tail.next=temp;
		//checking if loop exists
		System.out.println("Loop exists ?" + DetectLoop.detectLoop2(head));
		
		//removing the loop and checking again
		removeLoop2(head);
		System.out.println("Loop exists ?" +DetectLoop.detectLoop2(head));

	}
	
}
