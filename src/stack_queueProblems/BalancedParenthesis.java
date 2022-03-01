package stack_queueProblems;
import java.util.*;
public class BalancedParenthesis {
	
	//Return true if every parathesis has it's other pair
	
	//func for returning the other pair
	static char reverse(char ch){
        if(ch==']')
            return '[';
        else if(ch=='}')
            return '{';
        else
            return '(';
    }
    static boolean ispar(String x)
    {
        // add your code here
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<x.length();i++){
            char ch=x.charAt(i);
            
            //if the brackets are not closing
            if(ch!=']' && ch!='}' && ch!=')')
                stack.push(ch);
            else
            {
            	//if we get a closing bracket
            	//first check if the stack is empty or not
                if(stack.isEmpty())
                    return false;
                //we take the other pair of the closing bracket, then match it with
                //the top element of the stack, if it doesnt match return false
                if(stack.peek()!=reverse(ch))
                    return false;
                
                stack.pop();
            }
        }
        
        //if the stack is not empty return false
        return stack.isEmpty();
    }
}
