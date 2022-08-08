package dp_Problems;
import java.util.*;
/*
 * Ninja has a 'GRID' of size 'R' X 'C'. Each cell of the grid contains some chocolates. 
 * Ninja has two friends Alice and Bob, and he wants to collect as many chocolates as possible 
 * with the help of his friends.
 * Initially, Alice is in the top-left position i.e. (0, 0), and Bob is in the top-right place 
 * i.e. (0, 'C' - 1) in the grid. Each of them can move from their current cell to the cells just 
 * below them. When anyone passes from any cell, he will pick all chocolates in it, and then the 
 * number of chocolates in that cell will become zero. If both stay in the same cell, only one of 
 * them will pick the chocolates in it.
 * 
 * If Alice or Bob is at (i, j) then they can move to (i + 1, j), (i + 1, j - 1) or (i + 1, j + 1). 
 * They will always stay inside the 'GRID"'.
 * Your task is to find the maximum number of chocolates Ninja can collect with the help of 
 * his friends by following the above rules.
 */
public class ChocolatePickup {
	/*
	 * Two friends start from either corners of the 0th row
	 * Both will move down to the last row and try to achieve the max path (together)
	 * If they land on the same index then it will be counted once
	 * They can move to the left and right diagonal and bottom
	 * 
	 * If you observe carefully, they will always be in the same row
	 * We'll use a 3D dp array containing the row no. index of friend A and index of friend B
	 * We'll store the max possible in that position
	 */
	public static int maximumChocolates(int n, int m, int[][] grid) {
		// Write your code here.
        int[][][] dp = new int[n][m][m];
        
        //3D Dp array
         for(int[][] i:dp)
             for(int[] j:i)
                 Arrays.fill(j,-1);
        
         return helper(0,0,n-1,grid,n,m,dp);
	}
	
	//Tabulation
	public static int maximumChocolates2(int n, int m, int[][] grid) {
		// Write your code here.
        int[][][] dp = new int[n][m][m];
        
        //Initialize the base cases
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(i==j)
                    dp[n-1][i][j]=grid[n-1][j];
                else
                    dp[n-1][i][j]=grid[n-1][i]+grid[n-1][j];
            }
        }
        
        //Since we have completed n-1, the loop will run from n-2 to 0
        //The following two loops are for the two friends, we have to check all the possibilities
        for(int i=n-2;i>=0;i--){
            for(int j1=0;j1<m;j1++){
                for(int j2=0;j2<m;j2++){
                    
                	//This is just the same as the Memoization
                	//We'll check all the 9 combos for both the friends
                    int maxi=-1;
                    for(int a=-1;a<=1;a++){
                        for(int b=-1;b<=1;b++){
                            int value=0;

                            if(j1==j2)
                                value=grid[i][j1];
                            else
                                value=grid[i][j1]+grid[i][j2];
                            
                            //edge case
                            if(j1+a>=0 && j1+a<m && j2+b>=0 && j2+b<m)
                                value+=dp[i+1][j1+a][j2+b];
                            else
                                value=-999;
                            maxi=Math.max(maxi,value);
                        }
                    }
        
                    dp[i][j1][j2]=maxi;  
                }
            }
        }
        //since we are moving up, the final ans will be stored in the index where the two friends started
        return dp[0][0][m-1];
	}
	
	//Memoization
	public static int helper(int i, int j1, int j2, int[][] grid, int r, int c, int[][][] dp){
        
		//if the indexes go out of bounds then return a negative number as we'll be calculating the max
        if(j1<0 || j1>=c || j2<0 || j2>=c)
            return -999;
        
        //if we reach the last index
        if(i==r-1)
        {
        	//check if both the friends are in the same index, if yes just return the value
        	//otherwise add both the values and return it
            if(j1==j2)
                return grid[i][j1];
            else
                return grid[i][j1]+grid[i][j2];
        }
        
        //if we already have the ans for the particular values
        if(dp[i][j1][j2]!=-1)
            return dp[i][j1][j2];
        
        //Now Friend A can move in three directions
        //For every move of Friend A, Friend B can move in three directions
        //Thus we need to try every directions and calculate the max path
        int maxi=-1;
        for(int a=-1;a<=1;a++){
            for(int b=-1;b<=1;b++){
                int value=0;
                //if they are in the same index
                if(j1==j2)
                    value=grid[i][j1];
                else
                    value=grid[i][j1]+grid[i][j2];
                //Try for every combination of moves
                value+=helper(i+1,j1+a,j2+b,grid,r,c,dp);
                //At the end only the max value will be stored here
                maxi=Math.max(maxi,value);
            }
        }
        
        //store that value in the dp array
        return dp[i][j1][j2]=maxi;
    }

}
