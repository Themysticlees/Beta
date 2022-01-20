package linked_listProblems;

import java.util.Scanner;

public class ReverseLL {
	
	//iterative approach
	static Node reverseList(Node head)
    {
        //if there is only one node just return head
		//as there is no point in reversing
        if(head.next==null)
            return head;
        
        //take an extra pointer to change the next of every node
        Node curr=null;
        while(head!=null)
        {
        	//we keep the second node(next to head) in temp
        	//we point head to curr, in the 1st iteration
        	//curr is null thus head will point to null
            Node temp=head.next;
            head.next=curr;
            //we move the curr pointer to head
            //and head to it's next node
            curr=head;
            //we are not using head.next to move to the next node
            //since we have changed the head's next and it is pointing
            //in the opposite direction
            //thus we assign temp to head as we saved that pointer 
            //in the begining as the head's next
            head=temp;
        }
        //curr will reach to the end and all the nexts have been changed
        //thus return curr
        return curr;
    }
	
	//recursive approach
	static Node reverse(Node head, Node curr) {
		
		//base case, if head becomes null then return curr
		if(head==null)
			return curr;
		
		//we follow the same logic as the iterative approach
		Node temp=head.next;
		head.next=curr;
		curr=head;
		//after changing the next of this node, we move all the pointers
		return reverse(temp, curr);
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
		head=reverse(head,null);
		
		while(head!=null)
		{
			System.out.println(head.value);
			head=head.next;
		}
	}

}
