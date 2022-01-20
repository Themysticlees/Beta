package Testing;
import java.util.*;
import java.util.regex.Pattern;

import searching_Problems.BinarySearch;

class Node {
    int value;
    Node next;
    Node(int value) {
        this.value = value;
        this.next=null;
    }
}

public class Main {
	
	public static Node solve(Node A) {

        Node tail = A;

        while(tail.next!=null)
            tail=tail.next;
        
        Node head=A;

        while(head!=null){
            if(head.value==1)
            {
                Node temp=head.next;
                head.next=null;
                tail.next=head;
                tail=head;
                head=temp;
            }
            else
            	head=head.next;
        }
        return A;
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
		
		//head=reverseList(head);
		head=solve(head);
		
		while(head!=null)
		{
			System.out.println(head.value);
			head=head.next;
		}
	}

}


