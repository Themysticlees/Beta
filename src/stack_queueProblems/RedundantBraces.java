package stack_queueProblems;

import java.util.Stack;
//Redundant braces means excess or unnecessary brackets
//There are two ways to detect that:
//1. If we find a closing bracket, then if the immediate poped element is the opening bracket then 
//	 redundant braces found
//2. If within two opening or closing brackets there are no operators then also redundant braces found

public class RedundantBraces {
	
	public static int braces(String A) {

        Stack<Character> stack = new Stack<>();

        for(int i=0;i<A.length();i++){

            char ch=A.charAt(i);
            
            //if we get a closing bracket then pop the top element and check
            //otherwise push the element into the stack
            if(ch==')'){

                char top=stack.pop();
                
                //1 means the expression contains redundant bits
                int cond=1;
                
                //we keep poping elements until we find a opening bracket
                while(top!='(')
                {
                	//while poping if we get any operator then there are no redudant braces within the brackets
                	//so put cond=0
                    if(top=='+' || top=='-' || top=='*' || top=='/')
                        cond=0;
                    top=stack.pop();
                }
                
                //if no operators are found i.e cond must still be 1, that is true condition
                //thus return cond.
                //if cond =0, i.e operators found, we dont return because we still need to check the rest 
                //of the String
                if(cond==1)
                	return cond;
            }
            else
                stack.push(ch);
        }
        //ultimately if no redundant bits are found, then return 0.
        //This statement will only be executed if we never encounter a excess braces
        return 0;
    }
	
	public static void main(String[] args) {
		System.out.println(braces("((a+b))"));
	}

}
