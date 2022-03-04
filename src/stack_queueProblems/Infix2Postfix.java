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
	
	//The rules are
	//If you encounter an alphabet or number, add it to the resultant string
	//If you encounter a bracket, push it into a stack
	//If you encounter a closing bracket, push all the operators that there are between the opening and closing
	//brackets in the stack
	//If you encounter an operator, 
	//	if the stack is empty, push it
	//	if the top element is a bracket, push it
	//	if the top elemenet is an operator, then check it's precedence, if is lower than the current element, push the current element into the stack
	//	if the top element has higher precedence, then pop it and add it to res, and push the current operator
	//at the end if there are any operators left in the stack, pop them and add to res
	
	public static void main(String[] args) {
		
		Stack<Character> stack = new Stack<>();
		
		String str="(A-B)*[C/(D+E)+F]";
		
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

			if(ch>='A' && ch<='Z')
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
					if(map.get(stack.peek())<map.get(ch))
						stack.push(ch);
					else
					{
						res+=stack.pop();
						stack.push(ch);
					}
				}
			}
		}
		
		//at the end if there are any operators left in the stack, pop them and add to res

		while(!stack.isEmpty())
			res+=stack.pop();
		
		System.out.println(res);
	}
}
