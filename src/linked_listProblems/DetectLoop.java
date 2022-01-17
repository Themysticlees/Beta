package linked_listProblems;

class Node
{
    int data;
    Node next;
    Node(int d) {
    	data = d; 
    	next = null; 
    	}
}
public class DetectLoop {
	
	public static boolean detectLoop(Node head){
        // Add code here
        
        Node temp=head;
        //since there can be 10^4 nodes max thus we keep a counter
        //and we traverse through the linked list. If the counter passes
        //10^4 then we can surely say that there exists a loop
        int count=0;
        while(temp.next!=null){
            if(count>100000)
                return true;
            
            temp=temp.next;
            count++;
        }
        return false;
    }
	
    //more time optimized
    public static boolean detectLoop2(Node head){
        Node slow=head;
        Node fast=head;
        //we keep two pointers, once jumps twice and another jumps once
        //If there exists a loop, once both the pointers will match
        //if it does then surely we ended up to a single node and thus loop exists
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            
            if(fast==slow)
                return true;
        }
        return false;
    }

}
