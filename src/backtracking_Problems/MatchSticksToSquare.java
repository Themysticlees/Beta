package backtracking_Problems;
import java.util.*;
/*
 * You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. 
 * You want to use all the matchsticks to make one square. You should not break any stick, 
 * but you can link them up, and each matchstick must be used exactly one time.
 * Return true if you can make this square and false otherwise.
 * 
 *  Input: matchsticks = [1,1,2,2,2]
	Output: true
	Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
	Example 2:
	
	Input: matchsticks = [3,3,3,3,4]
	Output: false
	Explanation: You cannot find a way to form a square with all the matchsticks.
 */
public class MatchSticksToSquare {
	//Use all the matchsticks to make a square
	//We have to use backtracking to solve this question. Explore all possible combinations
	public boolean makesquare(int[] match) {
        
        int total=0;
        
        for(int i:match)
            total+=i;
        
        //if the total is not a multiple of 4 then we cannot form a square
        if(total%4!=0)
            return false;
        
        //Sort the numbers to avoid tle, we'll start from the end(large numbers) and gradually
        //check the lesser numbers
        Arrays.sort(match);
        
        //target=total/4 as every side should meet the target to make a square
        return helper(match,match.length-1,0,0,0,0,total/4);
    }
    
    public boolean helper(int[] match, int index, int top, int bottom, int left, int right, int target){
        
    	//if all the criteria satisfies i.e. all the sides are equal to target 
        if(top==target && bottom==target && left==target && right==target)
            return true;
        
        //if any of the sides becomes more than the target then return false
        //and check for other possibilities
        if(top>target || bottom>target || left>target || right>target)
            return false;
        
        //take the current value(match size)from the array
        int val=match[index];
        
        //check for every side by adding the value to every side and check it this is the correct ans
        //if any of the one side fails, try for another side and perform similar checks
        if(helper(match,index-1,top+val,bottom,left,right,target))
            return true;
        
        if(helper(match,index-1,top,bottom+val,left,right,target))
            return true;
        
        if(helper(match,index-1,top,bottom,left+val,right,target))
            return true;
        
        if(helper(match,index-1,top,bottom,left,right+val,target))
            return true;
        
        return false;
    }

}
