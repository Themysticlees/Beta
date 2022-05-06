package string_Problems;

import java.util.Stack;

public class RemoveAdjacentK {
	
/*
 * You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent
 * and equal letters from s and removing them, causing the left and the right side of the deleted
 * substring to concatenate together.
 * We repeatedly make k duplicate removals on s until we no longer can.
 * Return the final string after all such duplicate removals have been made.
 * It is guaranteed that the answer is unique.
 * 
 *  Example 1:

	Input: s = "abcd", k = 2
	Output: "abcd"
	Explanation: There's nothing to delete.
	
	Example 2:
	
	Input: s = "deeedbbcccbdaa", k = 3
	Output: "aa"
	Explanation: 
	First delete "eee" and "ccc", get "ddbbbdaa"
	Then delete "bbb", get "dddaa"
	Finally delete "ddd", get "aa"
 */
	public static String removeDuplicates(String s, int k) {
        
		//We'll be using Stack to avoid re iterating the string over and over again
		//since we need to remove the characters which counts to k
		//thus instead of removing and counting from the begining, 
		//we can remove them and again start countin from there
		
		//stack1 will store the character 
        Stack<Character> stack1=new Stack<>();
        //stack2 will store the adjancent character count
        Stack<Integer> stack2=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            
            //if stack is empty or we have a different character than the last one then just insert a new value
            if(stack1.isEmpty() || stack1.peek()!=ch){
                stack1.push(ch);
                stack2.push(1);
            }
            //if the current character is the same as the last one
            //then just increase it's character count
            else if(stack1.peek()==ch){
                int temp=stack2.pop();
                temp++;
                stack2.push(temp);
            }
            
            //if the character count reaches k, just pop it and pop it's character count
            //now we can resume check again from the previous character
            //thus saving time
            if(stack2.peek()==k){
                stack1.pop();
                stack2.pop();
            }
        }
        String res="";
        
        //the characters remaining in the stack is our ans
        while(!stack1.isEmpty()){
            char ch=stack1.pop();
            int n=stack2.pop();
            //printing the characers n times (n=character count)
            for(int i=0;i<n;i++)
                res=ch+res;
        }
        return res;
    }

}
