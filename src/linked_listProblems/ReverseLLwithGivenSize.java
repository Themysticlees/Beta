package linked_listProblems;

import java.util.Scanner;

//Reverse a Linked List in groups of given size.
/*
 	LinkedList: 1->2->2->4->5->6->7->8
	K = 4
	Output: 4 2 2 1 8 7 6 5
	
	 If the last partition has less than K nodes, the reverse 
	 the remaining nodes that are present.
 */

public class ReverseLLwithGivenSize {
	
	public static Node reverse(Node node, int k)
    {
       
        //prev and curr are used for reversing the list
        Node prev=null;
        Node curr=node;
        //it will be last node of the previous partition
        Node head=null;
        
        while(curr!=null){
            
        	prev=null;
        	//we are storing the starting node in tempcurr because we have 
        	//to link it to the head of the next partition
            Node tempcurr=curr;
            //for reversing in groups
            int tempcount=0;
            
            //the loop runs until we have reversed k bits or our curr node becomes null
            //the 2nd condition is for the last partition if it has less than k nodes
            while(tempcount!=k && curr!=null){
                //using the reverse algo
            	tempcount++;
                Node temp=curr.next;
                curr.next=prev;
                prev=curr;
                curr=temp;
            }
            //if head is null i.e we are reversing the first partion
            //after reversing, the last node of the first partition will be starting node
            //of our new modified list, thus store that in node
            if(head==null)
                node=prev;
            else
                head.next=prev;
            //if head is not null, then link it to it the prev of the current partition
            //prev is the last element but after reversing it will be the first so it will be linked
            
            //tempcurr stored the starting node of the current partition but after reversing it has become 
            //the last node thus update head with it because last node will link with the next partition
            head=tempcurr;
       }
       //since we have stored the head of the modified list in node, return it
       return node;
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
		head=reverse(head,4);
		
		while(head.next!=null)
		{
			System.out.print(head.value+"->");
			head=head.next;
		}
		System.out.println(head.value);
	}

}
