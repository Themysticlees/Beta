package linked_listProblems;

//There are k LinkedList in an array
//The heads of the particular linked list are given
//You have to merge all the linkedList into one

public class MergeKLinkedList {
	
	Node mergeKList(Node[]arr,int K)
    {
		//This will be our final linked list
    	//we'll take each linkedlist and merge with root
		//and the same process is continued untill we reach the end of array
        Node root=null;
        for(int i=0;i<K;i++){
        	Node temp=arr[i];
            root=merge(root,temp);
        }
        return root;
    }
    
	//This function will merge two linked list into a sorted order
    Node merge(Node a1, Node a2){
        
        Node root=new Node(0);
        Node res=root;
        while(a1!=null && a2!=null){
            
            if(a1.value<a2.value)
            {
                res.next=a1;
                a1=a1.next;
                res=res.next;
            }
            else
            {
                res.next=a2;
                a2=a2.next;
                res=res.next;
            }
        }
        
        while(a1!=null){
            res.next=a1;
            a1=a1.next;
            res=res.next;
        }
        
        while(a2!=null){
            res.next=a2;
            a2=a2.next;
            res=res.next;
        }
        
        return root.next;
    }
    
    public static void main(String[] args) {
		
    	Node a1=new Node(1);
		a1.next=new Node(3);
		
		Node a2=new Node(4);
		a2.next=new Node(5);
		a2.next.next=new Node(6);
		
		Node a3=new Node(8);
		Node[] value = {a1,a2,a3};
		
		new MergeKLinkedList().mergeKList(value, 3);
		
	}

}
