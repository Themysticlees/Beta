package array_Problems;
import java.util.*;

public class StockSpan {
	
	public static int[] calculateSpan(int price[], int n)
    {
        
        int[] span=new int[n];
        //since we need to find the nearest largest number which came before
        Stack<Integer> stack = new Stack<>();
        
        //we are initializing the first element of both stack and array
        //by 0 and 1 as the first element cannot be compared with any other element
        stack.push(0);
        span[0]=1;
        
        for(int i=1;i<n;i++){
            //if the stack is not empty and the current element is bigger than its 
        	//previous element then pop those elements 
            while(stack.isEmpty()==false && price[i]>=price[stack.peek()])
                stack.pop();
            //if we keep on popping i.e all the elements are smaller than the current 
            //element then span = current index+1
            if(stack.isEmpty())
                span[i]=i+1;
            //if we get a larger number then span = current index-large element index
            else
                span[i]=i-stack.peek();
            
            //and we push the current element
            stack.push(i);
            
            //for the next element we wont check the values which were less than the 
            //previous element because if the next element is bigger than the previous 
            //element then it should be bigger than the popped out elements thus reducing
            //the time complexity
        }
        return span;
    }
	
	public static void main(String[] args) {
		
		int[] price= {100, 80, 60, 70, 60, 75, 85};
		price=calculateSpan(price, price.length);
		
		for(int i:price)
			System.out.print(i+" ");
	}

}
