package linked_listProblems;

import java.util.HashSet;

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
	
	
}
