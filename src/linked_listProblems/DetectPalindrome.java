package linked_listProblems;

import java.util.Scanner;

/*
 	List 1-->2-->1 is a palindrome.
	List 1-->2-->3 is not a palindrome.
 */
public class DetectPalindrome {
	
	public static int lPalin(Node A) {
		
		//divide the list into two and reverse the second partition
		//now check both the partitions using two pointers, if all the nodes match
		//then it is a palindrome
		
        Node head=A;
        int nodes=0;
        //count the no.of nodes
        while(head!=null){
            nodes++;
            head=head.next;
        }
        //finding mid point of the list
        int mid=nodes/2+1,temp=1;

        head = A;
        while(temp!=mid)
        {
            temp++;
            head=head.next;
        }
        
        //pointer to the middle node
        Node midNode=head;

        //reverse algo for linked list
        Node prev=null;

        while(midNode!=null){
            Node temp1=midNode.next;
            midNode.next=prev;
            prev=midNode;
            midNode=temp1;
        }
        
        //two pointers
        //midNode pointing at the first node of the second partition after reversing
        //since midNode has become null and its previous node is stored in prev
        //thus assigning prev in midNode
        
        midNode=prev;
        //head pointing at the 1st node of 1st partition
        head=A;
        
        //checking if the elements are equal
        while(midNode!=null && head!=null){
            if(midNode.value!=head.value)
                return 0;
            midNode=midNode.next;
            head=head.next;
        }
        //if the loop doesnt break abrupty then return 1
        return 1;
    }
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter no.of nodes 1st list : ");
		int n=sc.nextInt();
		
		Node head=new Node(sc.nextInt());
		Node tail=head;
		n--;
		
		while(n-->0) {
			tail.next=new Node(sc.nextInt());
			tail=tail.next;
		}
		
		System.out.println(lPalin(head));
	}

}
