package linked_listProblems;
/*
 * Given a linked list, the task is to complete the function maxPalindrome() which returns an 
 * integer denoting  the length of the longest palindrome list that exist in the given linked list.
 * 
 *  Input:
	2
	7
	2 3 7 3 2 12 24
	5
	12 4 4 3 14
	
	Output:
	5
	2
	
	Explanation:
	Testcase 1: 2 -> 3 -> 7 -> 3 -> 2 is the linked list whose nodes leads to a palindrome as 2 3 7 3 2.
 */

public class MaxPalindrome {

	//There will be two pointers :
	//prev and curr
	//from prev the LL will be reversed thus we can check the left elements
	//and from curr we can check the right elements
	//we'll keep on checking until we don't get a match or any of the pointers become null
	//count as we move apart and at the end take the max
	public static int maxPalindrome(Node head)
    {
      //For reversing the LL.
      Node prev=null;
      Node curr=head;
      
      //since atleast 1 number makes a palindrome
      int max=1;
      
      while(curr!=null){
          
    	  //for index 0, when there is no prev
          if(prev!=null){
              
        	  //checking twice as the palindrome may be odd or even length
        	  
        	  //odd length
              Node a=prev;
              Node b=curr.next;
              
              int count=1;
              while(a!=null && b!=null && a.value==b.value){
                  count+=2;
                  a=a.next;
                  b=b.next;
              }
              max=Math.max(max,count);
              
              //even length
              a=prev;
              b=curr;
              
              count=0;
              while(a!=null && b!=null && a.value==b.value){
                  count+=2;
                  a=a.next;
                  b=b.next;
              }
              //take the max
              max=Math.max(max,count);
              
          }
          
          //reverse that particular edge
          Node temp=curr.next;
          curr.next=prev;
          prev=curr;
          curr=temp;
      	}
      
      return max;
    }
	
	public static void main(String[] args) {
		
		Node head=new Node(5);
		head.next=new Node(3);
		head.next.next=new Node(2);
		head.next.next.next=new Node(2);
		head.next.next.next.next=new Node(3);
		head.next.next.next.next.next=new Node(5);
		
		System.out.println(maxPalindrome(head));
	}
  

}
