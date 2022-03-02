package stack_queueProblems;
import java.util.*;
/*
 * 
 * You need to find the next greater number of the particular index
 * Input: 
	N = 4, arr[] = [1 3 2 4]
	Output:
	3 4 4 -1
 */
public class NextGreaterElement {
	
	public static long[] nextLargerElement(long[] arr, int n)
    { 
        // Your code here
        Stack<Long> stack = new Stack<>();
        long[] res= new long[n];
        
        //we'll start traversing from the end, since the greater element
        //will lie to an elements right side
        //first we'll keep poping elements from the stack if the top element is less or equal
        //to the current array element.
        //if the stack becomes empty that means there are no elemets which are greater thus store -1
        //otherwise store the top element or the element where our first check stopped
        //then push the current array element to the stack.
        //since stack uses LIFO mechanism, thus though we traverse from the end, stack allows us to check 
        //from left to right and as we find an element bigger we stop our search and store that element to 
        //stack.
        for(int i=n-1;i>=0;i--){
            
        	//keep removing untill the top element is less
            while(!stack.isEmpty() && stack.peek()<=arr[i])
                stack.pop();
              
            //if stack is empty then store -1 or the top element
            if(stack.isEmpty())
                res[i]=-1;
            else
                res[i]=stack.peek();
            
            //lastly store the current array element
            stack.push(arr[i]);
        }
        
        return res;
    } 
	
	public static void main(String[] args) {
		
		long[] ans= {1, 3, 2, 4};
		
		ans=nextLargerElement(ans, ans.length);
		for(long i:ans)
			System.out.print(i+" ");
	}

}
