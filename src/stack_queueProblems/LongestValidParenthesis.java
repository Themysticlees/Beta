package stack_queueProblems;

/*
 * Given a string containing just the characters '(' and ')', find the length of the
 * longest valid (well-formed) parentheses substring.
 * 
 *  Input: s = ")()())"
	Output: 4
	Explanation: The longest valid parentheses substring is "()()".
	
	The valid parenthesis must be in a contiguous manner
 */
public class LongestValidParenthesis {
	
	public int longestValidParentheses(String s) {
        
        //count the no.of opening and closing brackets in two iteration
		
		//first time we'll iterate from 0 to n-1, add the opening and closing brackets and check 
		//every time if they are equal, if they are equal then they are always valid.
		//if the closing brackets count increases more then opening then re initialize the count
		//the reason being if we have extra closing bracket, we cannot add opening brackets at the end
		//to make it valid, thus make them zero if it occurs
		//if the left count is more and even if it misses some valid parenthesis then no problem
		//we'll run another loop from back of the string and in that iteration we'll calculate it's length
		
        
        int n=s.length();
        int left=0,right=0;
        int ans=0;
        
        //first iteration
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            
            if(ch=='(')
                left++;
            else
                right++;
            
            if(left==right){
            	//add left and right as they give count of the total no.of brackets
                ans=Math.max(left+right,ans);
            }
            else if(right>left)
            {
                left=0;
                right=0;
            }
        }
        
        //again re initialize them to 0
        left=0;right=0;
        
        //in this iteration, since we are starting from the end then if the opening brackets count increase
        //then re initialize to 0, since we cannot add closing brackets before the specified index to make 
        //it valid, thus make the pointers 0
        for(int i=n-1;i>=0;i--){
            char ch=s.charAt(i);
            
            if(ch=='(')
                left++;
            else
                right++;
            
            if(left==right)
                ans=Math.max(left+right,ans);
            else if(left>right)
            {
                left=0;
                right=0;
            }
        }
        
        return ans;
        
    }

}
