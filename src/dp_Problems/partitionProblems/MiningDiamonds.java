package dp_Problems.partitionProblems;
import java.util.*;
/*
 * There are ‘N’ diamonds in a mine. The size of each diamond is given in the form of integer 
 * array ‘A’. If the miner mines a diamond, then he gets 'size of previous unmined diamond * size 
 * of currently mined diamond * size of next unmined diamond' number of coins. 
 * If there isn’t any next or previous unmined diamond then their size is replaced by 1 
 * while calculating the number of coins.
 * 
 * Vladimir, a dumb miner was assigned the task to mine all diamonds. 
 * Since he is dumb he asks for your help to determine the maximum number of coins that he 
 * can earn by mining the diamonds in an optimal order.
 * 
 *  Suppose ‘N’ = 3, and ‘A’ = [7, 1, 8]

	The optimal order for mining diamonds will be [2, 1, 3].
	State of mine -    [7, 1, 8]    [7, 8]    [8]
	Coins earned -    (7*1*8) + (1*7*8) + (1*8*1)  = 56 + 56 + 8 = 120
	Hence output will be 120.
 */
public class MiningDiamonds {
	/*
	 * This is not totally similar to all other partition problems, since in this case if we 
	 * make two partitions, the first one can reply on the second partition as maybe the right element
	 * belongs to the 2nd partition.
	 * 
	 * So in this problem, we solve from the bottom i.e we consider that a particular element will
	 * be the last element and then we start adding more elements.
	 * In this way the partitions will be independent.
	 * 
	 * For eg: Suppose we have 8 as the last number.
	 * then we can choose any number from the left partition but the right element will be 8.
	 * Similarly if we choose any number from the right partition then the left element has to be 8.
	 * 
	 * In this way, the partitions are independent. Thus this approach is from single element
	 * or last element to the full array.
	 */
	public static int maxCoins(int a[]) {
		
        // Write your code here..
         List<Integer> list=new ArrayList<>();
        int n=a.length;
        
        //Add 1 to the front and end of the array as if there are no numbers, we need to multiply 1
        list.add(1);
        for(int i=0;i<a.length;i++)
            list.add(a[i]);
        list.add(1);
        
        int[][] dp = new int[n+1][n+1];
        
        for(int[] i:dp)
            Arrays.fill(i,-1);
        return helper(1,list.size()-2,list,dp);
    }
    
	//Tabulation
	public static int tabulation(int[] a) {
		
		List<Integer> list=new ArrayList<>();
        int n=a.length;
        list.add(1);
        for(int i=0;i<a.length;i++)
            list.add(a[i]);
        list.add(1);
        
        int[][] dp = new int[n+2][n+2];
        
        //Changing variables are i and j
        //i will start from n to 1 (opposite to memoization)
        //j will start from 1 to n (opposite to memoization)
        for(int i=n;i>=1;i--){
            for(int j=1;j<=n;j++){
                
            	//base case
                if(i>j)
                    continue;
                
                //copy the recurrence relation
                int max=Integer.MIN_VALUE;
                for(int ind=i;ind<=j;ind++){
                    int cost=list.get(i-1)*list.get(ind)*list.get(j+1)
                        +dp[i][ind-1]+dp[ind+1][j];
                    max=Math.max(max,cost);
                }

                dp[i][j]=max;
            }
        }
        
        return dp[1][n];
	}
	
	//Memoization
    public static int helper(int i, int j,List<Integer> list,int[][] dp){
        
    	//if i crosses j then no elements exists in the partition
        if(i>j)
            return 0;
        
        //if already calculated
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        int max=Integer.MIN_VALUE;
        //now check for every element in the partition.
        //i and j are initially 0 and n which means their values are 1.
        //So for the first element there is no left or right thus 1 will be multiplied.
        //From the next time, the index in which partition was made will be considered as left or right.
        for(int ind=i;ind<=j;ind++){
            int cost=list.get(i-1)*list.get(ind)*list.get(j+1)
                +helper(i,ind-1,list,dp)+helper(ind+1,j,list,dp);
            
            //calculate the max amount possible and return it
            max=Math.max(max,cost);
        }
        
        return dp[i][j]=max;
    }

}
