package Testing;
import java.util.*;
import java.util.regex.Pattern;

import searching_Problems.BinarySearch;

class ListNode {
	    public int val;
	    public ListNode next;
	    ListNode(int x) { val = x; next = null; }
}

public class Main {
	
	public static int lPalin(ListNode A) {

        ListNode head=A;
        int nodes=0;
        while(head!=null){
            nodes++;
            head=head.next;
        }
        int mid=nodes/2+1,temp=1;

        head =A;
        while(temp!=mid)
        {
            temp++;
            head=head.next;
        }

        ListNode midNode=head;

        ListNode prev=null;

        while(midNode!=null){
            ListNode temp1=midNode.next;
            midNode.next=prev;
            prev=midNode;
            midNode=temp1;
        }

        midNode=prev;
        prev=null;
        //head.next=midNode;
        head=A;

        while(midNode!=null && head!=null){
            if(midNode.val!=head.val)
                return 0;
            midNode=midNode.next;
            head=head.next;
        }
        return 1;
    }
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter no.of nodes 1st list : ");
		int n=sc.nextInt();
		
		ListNode head=new ListNode(sc.nextInt());
		ListNode tail=head;
		n--;
		
		while(n-->0) {
			tail.next=new ListNode(sc.nextInt());
			tail=tail.next;
		}
		
		/*
		System.out.println("Enter no.of nodes 2nd list : ");
		int n2=sc.nextInt();
		
		ListNode head2=new ListNode(sc.nextInt());
		ListNode tail2=head2;
		n2--;
		
		while(n2-->0) {
			tail2.next=new ListNode(sc.nextInt());
			tail2=tail2.next;
		}
		*/
		
		//head=addTwoNumbers(head,head2);
		System.out.println(lPalin(head));
		
		while(head.next!=null)
		{
			System.out.print(head.val+"->");
			head=head.next;
		}
		System.out.print(head.val);
	}

}


