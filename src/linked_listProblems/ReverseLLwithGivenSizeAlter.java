package linked_listProblems;

import java.util.Scanner;

//Similar to Reverse LL with Given size
//Only difference is we have reverse every alternate partition.

public class ReverseLLwithGivenSizeAlter {
	
	public static Node solve(Node A, int B) {

        Node head=A;
        
        //for counting till the given size
        int count=0;
       
        Node temphead=null;
        while(head!=null){

            Node prev=null;
            Node curr=head;
            if(count==0){
                while(count<B)
                {
                    Node temp=head.next;
                    head.next=prev;
                    prev=head;
                    head=temp;
                    count++;
                    //increasing count till it is less than B
                }
                //after the loop connect the partitions
                if(temphead==null){
                    A=prev;
                }
                else
                    temphead.next=prev;
                
                temphead=curr;
                
                count=B;
            }
            else{
            	//we skip the next B nodes as it is an alternative reverse
                temphead.next=head;
                temphead=head;
                head=head.next;
                count--;
                //again when count becomes 0, we start reversing again
            }

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
		head=solve(head,3);
		
		while(head.next!=null)
		{
			System.out.print(head.value+"->");
			head=head.next;
		}
		System.out.println(head.value);
					
	}

}
