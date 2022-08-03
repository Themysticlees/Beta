package dp_Problems;
import java.util.*;
/*
 * A frog is crossing a river. The river is divided into some number of units, and at each unit, 
 * there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
 * Given a list of stones' positions (in units) in sorted ascending order, determine if the frog 
 * can cross the river by landing on the last stone. Initially, the frog is on the first stone 
 * and assumes the first jump must be 1 unit.
 * 
 * If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. 
 * The frog can only jump in the forward direction.
 * 
 *  Input: stones = [0,1,3,5,6,8,12,17]
	Output: true
	Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone, 
	then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone, 
	4 units to the 7th stone, and 5 units to the 8th stone.
 */
public class FrogJump2 {
	
	/*
	 * This is similar to Frog Jump 1, the onlu difference is there are stones with some marked values
	 * each time the frog can jump k-1,k or k+1 steps and it should land in any one of stones with the marked
	 * value.
	 */
	public boolean canCross(int[] stones) {
        
        int n=stones.length;
        //as mentioned in the question, the frog starts with 1 step jump thus if the second stone can't
        //be reached with 1 step then it cannot go further thus return false
        if(stones[1]!=1)
            return false;
        
        //store the stones along with their index
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<n;i++)
            map.put(stones[i],i);
        
        //2d array to store the index and k(step value) pair value
        int[][] dp = new int[n][n];
        
        for(int[] i:dp)
            Arrays.fill(i,-1);
        
        //1 = true, 0=false
        return helper(1,1,dp,map,stones,n)==1?true:false;
    }
    
    public int helper(int k, int ind, int[][] dp, Map<Integer,Integer> map,int[] stones, int n){
        
    	//base case, last index if reached
        if(ind==n-1)
            return 1;
        
        //if we already calculated for a stone with k value then the futher ans will be same thus return
        //the stored ans
        if(dp[ind][k]!=-1)
            return dp[ind][k];
        
        //iterate for the three values, k-1,k and k+1
        for(int i=-1;i<=1;i++){
            int temp=0;
            //find out the stone value with the steps taken
            int stone= stones[ind]+ k+i;
            
            //if the new stone value is more than the current stone value 
            //and the new stone exists in the array then call the function from the new stone
            if(stone>stones[ind] && map.get(stone)!=null)
                temp=helper(k+i,map.get(stone),dp,map,stones,n);
            
            //if temp=1 i.e true, then return true and store the value in the dp array
            //no need to check for other steps
            //since we just need to find whether it is possible or not, if it was mentioned
            //find all the ways, then we could have computed for other steps too.
            if(temp==1)
                return dp[ind][k]=1;
                
        }
        
        //if none of the steps can reach a stone, store it in the dp array and return 0, i.e false
        return dp[ind][k]=0;
        
    }

}
