package stack_queueProblems;
import java.util.*;
public class Infix2Postfix {
	
	static char reverse(char ch){
        if(ch==']')
            return '[';
        else if(ch=='}')
            return '{';
        else
            return '(';
    }
	
    //Function to convert an infix expression to a postfix expression.
	public static String infixToPostfix(String str) 
	{
		// Your code here
		Stack<Character> stack = new Stack<>();
		
		String res="";
		Map<Character,Integer> map = new HashMap<Character, Integer>();
		
		//map for storing the precedence number
		map.put('^', 3);
		map.put('*', 2);
		map.put('/', 2);
		map.put('+', 1);
		map.put('-', 1);
		
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			
			//If you encounter an alphabet or number, add it to the resultant string

			if(Character.isLetterOrDigit(ch))
				res+=ch;
			
			//If you encounter a bracket, push it into a stack

			else if(ch=='(' || ch=='{' || ch=='[')
				stack.push(ch);
			
			//If you encounter a closing bracket, push all the operators that there are between the opening and closing
			//brackets in the stack
			else if(ch==')' || ch=='}' || ch==']')
			{
				ch=reverse(ch);
				//stack.pop();
				while(stack.peek()!=ch)
					res+=stack.pop();
				stack.pop();
			}
			//If you encounter an operator, 
			//	if the stack is empty, push it
			//	if the top element is a bracket, push it
			//	if the top elemenet is an operator, then check it's precedence, if is lower than the current element, push the current element into the stack
			else
			{
				if(stack.isEmpty())stack.push(ch);
				else if(stack.peek()=='(' || stack.peek()=='{' || stack.peek()=='[')
					stack.push(ch);
				else
				{
					while(ch!='^' && !stack.isEmpty() && stack.peek()!='(' && stack.peek()!='{' && stack.peek()!='[' &&  map.get(stack.peek())>=map.get(ch))
						res+=stack.pop();
					stack.push(ch);
					
				}
			}
		}
		
		//at the end if there are any operators left in the stack, pop them and add to res

		while(!stack.isEmpty())
			res+=stack.pop();
		return res;
	} 
	
	//evaluate a Postfix expression
	public static int evaluate(String str) {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0;i<str.length();i++) {
			
			char ch= str.charAt(i);
			
			//whenever you encounter a digit, push in the stack
			if(Character.isDigit(ch))
				stack.push((int)ch-'0');
			else
			{
				//if you get an operator
				//pop the front two elements of the stack
				//and perform the operation of the specified operator
				//and then push it back again
				int a2=stack.pop();
				int a1=stack.pop();
				
				if(ch=='^')
					stack.push((int)Math.pow(a1, a2));
				else if(ch=='+')
					stack.push(a1+a2);
				else if(ch=='-')
					stack.push(a1-a2);
				else if(ch=='*')
					stack.push(a1*a2);
				else
					stack.push(a1/a2);
			}
		}
		//finally the answer should only be there in the stack
		return stack.peek();
	}
	
	public static void main(String[] args) {
		
		System.out.println(evaluate("231*+9-"));
	}
}
