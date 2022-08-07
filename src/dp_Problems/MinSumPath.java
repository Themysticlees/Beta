package dp_Problems;
import java.util.*;

public class MinSumPath {
	
	public static int minPathSum(int[][] grid) {
        
        int m=grid.length;
        int n=grid[0].length;
        
        int[][] dp=new int[m][n];
        
        for(int[] i:dp)
            Arrays.fill(i,-1);
        
//        return helper(m-1,n-1,grid,dp);
        
        //Tabulation
        /*
         * No recursion stack space used
         * 1. write the base case
         * 2. copy the recurrence relation
         */
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
            	//when we reach 0th index just return it
                if(i==0 && j==0)
                    dp[0][0]=grid[0][0];
                else{
                    int top=Integer.MAX_VALUE,left=Integer.MAX_VALUE;
                    //if i or j is greater than 0, (to neglect the cases where i or j crosses boundaries)
                    if(i>0)
                     top=grid[i][j]+dp[i-1][j];
                    if(j>0)
                     left=grid[i][j]+dp[i][j-1];
                    
                    //for every index we just need the values of top and left index,
                    //since we are doing bottom top approach, the bottom values are already calculated
                    dp[i][j]=Math.min(top,left);
                }
            }
        }
        
        return dp[m-1][n-1];
        
    }
    
	//Memoization
	/*
	 * We start from the last index and try to reach the first index
	 * We'll move top and left since we are traversing the opposite way (from last to first)
	 * For each index we'll check the top path and the left path, and choose the minimum one
	 */
    public static int helper(int m, int n, int[][] grid, int[][] dp){
        
    	//if we reach the 0th index, just return that number
        if(m==0 && n==0)
            return grid[m][n];
        
        //if m or n crosses boundaries, return a large number as we are finding the min number possible
        //Thus returning 0 will result in wrong output thus return a large number
        if(m<0 || n<0)
            return 9999999;
        
        //if already calculated
        if(dp[m][n]!=-1)
            return dp[m][n];
        
        //calculate top and left and store the min
        int top=grid[m][n]+helper(m-1,n,grid,dp);
        int left=grid[m][n]+helper(m,n-1,grid,dp);
        
        return dp[m][n]=Math.min(top,left);
        
    }
    
    //Space optimzation using 1D array
    public int minPathSum2(int[][] grid) {
        
        int m=grid.length;
        int n=grid[0].length;
        /*
         * If you look closely, we need the curr row and the prev row to calculate the value of any index
         * so just carry the curr and prev row instead of storing the entire 2D array
         */
        int[] prev=new int[n];
        int[] curr=new int[n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
            	//when we are at the 0th row, no need of prev row, thus just store the 0th data in curr row
                if(i==0 && j==0)
                    curr[j]=grid[0][0];
                    
                else{
                    int top=999999,left=999999;
                    //for top use the prev row values and for left use the curr row values
                    if(i>0)
                     top=grid[i][j]+prev[j];
                    if(j>0)
                     left=grid[i][j]+curr[j-1];
                    
                    //store the result in the curr row at jth index
                    curr[j]=Math.min(top,left);
                }
            }
            //now the curr becomes the prev and the curr becomes empty
            //and the same steps are repeated
            prev=curr.clone();
            Arrays.fill(curr,0);
        }
        
        return prev[n-1];
        
    }
    
    
    public static void main(String[] args) {
		
    	int[][] grid= {{1,3,1},
				   {1,5,1},
				   {4,2,1}};
    	
	
    	System.out.println(minPathSum(grid));
	}

}
