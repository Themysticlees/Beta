package dp_Problems.partitionProblems;
import java.util.*;
/*
 * Given a chain of matrices A1, A2, A3,.....An. Your task is to find out the minimum cost to multiply 
 * these matrices. The cost of matrix multiplication is defined as the number of scalar multiplications. 
 * A Chain of matrices A1, A2, A3,.....An is represented by a sequence of numbers in an array ‘arr’ 
 * where the dimension of 1st matrix is equal to arr[0] * arr[1] , 2nd matrix is arr[1] * arr[2], 
 * and so on.
 * 
 * Suppose there are two matrices A and B, A=10x5 and B=5x25
 * The cost of operations for multiplying is 10x5x25
 */
public class MatrixChainMultiplication {
	/*
	 * This is a partition problem where we need to make partitions of the given data structure 
	 * and solve the problem
	 * 
	 * Now suppose you are given 4 matrices A,B,C and D
	 * Thus multiplication will either (AxB)x(CxD), thus partition is made in the middle and then
	 * both the sides are multiplied
	 * 
	 */
	public static int matrixMultiplication(int[] arr , int n) {
		// Write your code here
        int[][] dp = new int[n][n];
        for(int[] i:dp)
            Arrays.fill(i,-1);
        
        return helper(arr,1,n-1,dp);
        
	}
    
	//Memoization
    public static int helper(int[] arr, int i, int j, int[][] dp){
        
    	//when there is just a single matrix no operations needed, return 0
        if(i==j)
            return 0;
        
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        int min=Integer.MAX_VALUE;
        //Thus the partition can be made anywhere from 1 to n-1, where the left side will be
        //1 to k and right side will be k+1 to n-1
        //The no.of operations needed to solve is no.of rows of the first matrix*partition row/coln and 
        //no.of columns of last matrix.
        //Now the partitions itself will need some operations, calculate them in the same way and 
        //add them to the final ans
        for(int k=i;k<j;k++){
            int steps=arr[i-1]*arr[k]*arr[j]
                +helper(arr,i,k,dp)+helper(arr,k+1,j,dp);
            
            min=Math.min(min,steps);
        }
        
        return dp[i][j]=min;
    }
    
    //Tabulation
    public static int tabulation(int[] arr , int n) {
    	
    	//create a similar size dp array
    	int[][] dp = new int[n][n];
    	
    	/*
    	 * Since in memoization, i started from 1, in tabulation i will start from n-1 to 1
    	 * and j will start from i+1 to n, since j cannot be less than i thus it begins from i
    	 */
    	for(int i=n-1;i>=1;i--){
            for(int j=i+1;j<n;j++){
            	
            	/*
            	 * Copy the recurrence relation and change the function calls
            	 */
                int min=Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int steps=arr[i-1]*arr[k]*arr[j]
                        +dp[i][k]+dp[k+1][j];

                    min=Math.min(min,steps);
                }

                dp[i][j]=min;
            }
        }
        
    	//since the initial function was from 1 to n-1 (partitions)
        return dp[1][n-1];
    }

}
