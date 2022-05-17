package dp_Problems;
/*
 * In the game of Broken Blocks, the player is allowed to move on m x n blocks i.e. m levels 
 * and n stone blocks on each level such that one level is vertically above the previous level 
 * (as in a staircase), with some of its stone blocks replaced by wooden blocks.
 * The player at the start of the game is present on the ground level (which should be considered 
 * as level 0 or it can be considered as level -1). The player can start from any of the blocks 
 * present on the level 0 and start moving further to next levels. The player can only move to 
 * the stone-block just above to the present stone-block or diagonally to the left or to the right. 
 * The player cant move on the same level.
 * If the player steps on any of the wooden block (denoted by -1), 
 * he will fall off the board and die as the wood-block will not able to hold players weight. 
 * Each of the stone-block has some gold coins present on it (wooden blocks doesnt have any coins on them). 
 * If at any point the player cant move to further level due to any reason, 
 * the game ends and his present total coin score will be considered.
 * The players aim is to collect as many gold coins as he can without falling off the board.
 * 
 *  Input: matrix = {{2,5,6},{-1,3,2},{4,-1,5}}
	Output: 14
	Explanation: Assume 0-based indexing.The matrix 
	is:
	2 5 6 (level 0)
	-1 3 2 (level 1)
	4 -1 5 (lever 2)
	The player can collect maximum number of coins 
	by moving through:matrix[0][2] + matrix[1][1] 
	+ matrix[2][2] = 6 + 3 + 5 = 14 coins.
 */
public class BrokenWoods {
	
	public int MaxGold(int[][] matrix)
    {
        // Code here
        int m=matrix.length;
        int n=matrix[0].length;
        
        int[][] dp = new int[m][n];
        int max=0;
        for(int i=0;i<n;i++) {
        	//initially we have to choose where to start thus we'll check for every column 
        	//for index 0 and check for max
        	max=Math.max(max,helper(0,i,matrix,dp));
        }
        return max;
    }
    
    public int helper(int i,int j,int[][] matrix, int[][] dp){
        
    	//if we have reached the last row, just return the no.of coins
        if(i==matrix.length-1)
            return matrix[i][j];
		
        //if we have already calculated for that index
        //return it
		if(dp[i][j]!=0) {
			return dp[i][j];
		}
		
		//otherwise check it's left middle and right
		int a=0,b=0,c=0,sum=0;
		
		if(matrix[i][j]!=-1){
            //left
            if(j-1>=0 && matrix[i+1][j-1]!=-1)
                a=helper(i+1,j-1,matrix,dp);
            //middle
            if(matrix[i+1][j]!=-1)
                b=helper(i+1,j,matrix,dp);
            //right
            if(j+1<matrix[0].length && matrix[i+1][j+1]!=-1)
                c=helper(i+1,j+1,matrix,dp);
            
            //take the max of three and store it in dp for that block
            //and return the total no.of coins
            sum=Math.max(a,Math.max(c, b));
            return dp[i][j]=matrix[i][j]+sum;
		}
		
		return 0;
    }

}
