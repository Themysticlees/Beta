package stack_queueProblems;

import java.util.Stack;

public class ReverseStackRecursion {
	
	//Get to the last element and then insert all the elements at the bottom
	//Thats how the stack will be reversed
	public static void reverseStack(Stack<Integer> stack) {
		// write your code here
        
        if(stack.isEmpty())
            return;
        
        //we are storing the current element in top
        //and calling the function until the stack becomes empty
        int top = stack.pop();
        reverseStack(stack);
        //once the stack is empty
        //insert the elements one by one at the bottom
        insertBottom(stack,top);
		
	}
	
	public static void insertBottom(Stack<Integer> stack, int n) {
		
		//if the stack is already empty
		//just push the element
		if(stack.isEmpty())
			stack.push(n);
		else
		{
			//if not empty the stack
			//keep references of all the elements
			//when the stack becomes empty, push the current element and then insert all the rem elements
			int top=stack.pop();
			insertBottom(stack, n);
			stack.push(top);
		}
	}

}
