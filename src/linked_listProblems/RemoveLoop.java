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
		removeLoop(head);
		System.out.println("Loop exists ?" +DetectLoop.detectLoop2(head));

	}
	
}
