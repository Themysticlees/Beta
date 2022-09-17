package dp_Problems.partitionProblems;
import java.util.*;
/*
 * You are given an expression ‘EXP’ in the form of a string where operands will be : (TRUE and FALSE) 
 * and operators will be : (AND, OR, XOR). Now you have to find the number of ways we can parenthesize 
 * the expression such that it will evaluate to TRUE.
 * 
 * Note :
	‘T’ will represent the operand TRUE.
	‘F’ will represent the operand FALSE.
	‘|’ will represent the operator OR.
	‘&’ will represent the operator AND.
	‘^’ will represent the operator XOR.
	
	For example :
	 Input: 
	 'EXP’ = T|T & F
	 There are total 2  ways to parenthesize this expression:
	 (i) (T | T) & (F) = F
	 (ii) (T) | (T & F) = T
	 Out of 2 ways, one will result in True, so we will return 1.
	
	 Output :
	 1
 */
public class Boolean_Evaluation {
	/*
	 * This is another partition problem, where we have make partitions and check how many ways we can
	 * get a True result.
	 * In the String expression every 2nd character is an operator, so we have to make partitions
	 * on those indexes.
	 * After making a partition, we need to find the no.of ways inorder to get a True result.
	 * generate the no.of ways we can get true and false from the left and right partitions.
	 * 
	 * Now check the operator and do the following operations,
	 * if the operator is OR (|), then we can get a TRUE result in 3 ways,
	 * 		ways to get true from left side * ways to get true from right side 
	 * 	+ true from left side * false from right side + false from left side * true from right side
	 * 
	 * Since incase of OR operator TT, TF, FT gives us true so we need to add all three possibilities.
	 * 
	 * Similary if the operator is AND, then TT will only give True
	 * 
	 * For XOR, TF and FT gives True.
	 * 
	 * Note that we require the ways to get FALSE and ways to get TRUE from either sides.
	 * 
	 * Thus we need to have a parameter telling what condition we want (i.e true or false)
	 * 
	 * At the end add all the ways and return
	 * 
	 */
	public static int evaluateExp(String exp) {
        // Write your code here.
        int n=exp.length();
        
        //Since there are 3 changing parameters,
        //i being the starting index
        //j being the ending index
        //isTrue telling us what condition we requires
        int[][][] dp = new int[n][n][2];
        
        for(int[][] i:dp)
            for(int[] j:i)
                Arrays.fill(j,-1);
        
        return helper(0,n-1,exp,1,dp);
    }
    
	//Since the ans can be large
    static int mod=1000000007;
    public static int helper(int i, int j, String exp, int isTrue,int[][][] dp){
        
    	//Base case--------------------
    	/*
    	 * If i surpasses j, then no more partition return 0.
    	 * If there is only 1 character remaining, check if the required cond is true or not,
    	 * if the condition satisifies, return 1 otherwise 0.
    	 */
        if(i>j)
            return 0;
        if(i==j)
        {
            if(isTrue==1 && exp.charAt(i)=='T')
                return 1;
            if(isTrue==0 && exp.charAt(i)=='F')
                return 1;
            return 0;
        }
        
        //If already calculated
        if(dp[i][j][isTrue]!=-1)
            return dp[i][j][isTrue];
        
        long total_ways=0;
        //since the operators are in every alternate indexes
        for(int ind=i+1;ind<j;ind+=2){
            
        	//ways to get true from left side
            int LT=helper(i,ind-1,exp,1,dp);
            //ways to get false from left side
            int LF=helper(i,ind-1,exp,0,dp);
            
            //Similar cases for right side
            
            int RT=helper(ind+1,j,exp,1,dp);
            int RF=helper(ind+1,j,exp,0,dp);
            
            long ways=0;
            //check the operators and perform the necessary operations
            if(exp.charAt(ind)=='|'){
                if(isTrue==1)
                    ways=((LT*RT)%mod + (LT*RF)%mod + (LF*RT)%mod)%mod;
                else
                    ways=(LF*RF)%mod;
            }
            
            else if(exp.charAt(ind)=='&'){
                if(isTrue==1)
                    ways=(LT*RT)%mod;
                else
                    ways=((LF*RF)%mod + (LT*RF)%mod + (LF*RT)%mod)%mod;
            }
            
            else if(exp.charAt(ind)=='^'){
                if(isTrue==1)
                    ways=((LT*RF)%mod + (LF*RT)%mod)%mod;
                else
                    ways=((LT*RT)%mod + (LF*RF)%mod)%mod;
            }
            
            total_ways=(total_ways+ways)%mod;
                
        }
        
        return dp[i][j][isTrue]=(int)total_ways;
    }

}
