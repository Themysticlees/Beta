package linked_listProblems;
import java.util.*;


/*
 * Given a linked list and positions m and n. Reverse the linked list from position m to n.
 *  Input :
	N = 10
	Linked List = 1->7->5->3->9->8->10
	                      ->2->2->5->NULL
	m = 1, n = 8
	Output : 2 10 8 9 3 5 7 1 2 5 
	Explanation :
	The nodes from position 1 to 8 
	are reversed, resulting in 
	2 10 8 9 3 5 7 1 2 5.
 */
public class ReverseSublist {
	
	//First we'll find the starting point of the sub list
	//Then we'll start reversing the list until we reach the end point
	//Then we just connect the ends and reconstruct it
	public static Node reverseBetween(Node head, int m, int n)
    {
        //code here
        Node curr=head;
        
        //for keeping a count on the index no.
        int count=1;
        
        //until we reach just before the starting point, we keep increasing the count
        while(count<m-1 && curr!=null){
            curr=curr.next;
            count++;
        }
        
        //intialize start and prev with null
        //start is the pointer which is needed to connect the sublist after it has been reversed
        //prev pointer is required for reversing
        //These conditions are when the sublist starts from the first index
        Node start=null;
        Node prev=null;
        
        //if the sublist doenst start from the first index
        //then initialize start with curr and move curr to the next node
        if(m!=1){
            start=curr;
            curr=curr.next;
            
        }
        //head2 is the head of the sublist, it will later be the tail after the list is reversed
        Node head2=curr;
        
        //if sublist doesnt start from index 0 then increase counter since we have shifted curr
        if(m!=1)
            count++;
        //Now reverse the list
        while(count<n+1 && curr!=null){
            Node temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
            count++;
        }
        //now link the next of start to the new head of the sublist 
        //if the sublist starts from index 0, then just put head=prev, as no other node will be 
        //before the sublist
        if(m!=1)
            start.next=prev;
        else
        	head=prev;
        //finally connect the sublist's old head(which has become tail now) to the nodes after the sublist
        head2.next=curr;
        
        return head;
        
    }
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Node ll=new Node(0);
		Node curr=ll;
		int i=0;
		while(i!=3) {
			//System.out.println("Enter Node : ");
			int data=sc.nextInt();
			Node temp=new Node(data);
			curr.next=temp;
			curr=curr.next;
			i++;
		}
		
		System.out.println(reverseBetween(ll.next, 1, 2));
	}

}
