package recursion_Problems;
import java.util.*;

//All the CombinationalSum questions from 1 to 3 are included here 
public class CombinationalSumAll{
	
	public static void main(String[] args) {
		
		CombSum1 cs1=new CombSum1();
		int[] arr= {2,3,6,7};
		System.out.println(cs1.combinationSum(arr, 7));
		
		CombSum2 cs2=new CombSum2();
		int[] arr2= {10,1,2,7,6,1,5};
		System.out.println(cs2.combinationSum2(arr2, 8));
		
		CombSum3 cs3=new CombSum3();
		System.out.println(cs3.combinationSum3(3, 9));
	}
	
}

/*
 * COMBINATIONAL SUM 1
 * 
 * Given an array of distinct integers candidates and a target integer target, return a list 
 * of all unique combinations of candidates where the chosen numbers sum to target. 
 * You may return the combinations in any order.
 * The same number may be chosen from candidates an unlimited number of times. 
 * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * It is guaranteed that the number of unique combinations that sum up to target is 
 * less than 150 combinations for the given input.
 * 
 *  Input: candidates = [2,3,6,7], target = 7
	Output: [[2,2,3],[7]]
	Explanation:
	2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
	7 is a candidate, and 7 = 7.
	These are the only two combinations.
 */
class CombSum1{
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        
        helper1(0,candidates,ans,temp,target,candidates.length);
        return ans;
    }
    
	
    public void helper1(int ind, int[] arr, List<List<Integer>> ans,List<Integer> temp, int target, int n ){
        /*
         * In this we have to find unique combinations which sum up to target, any number can used multiple times
         * This a problem of finding subsequences which sum up to target, since we'll use
         * the idea of take and not take
         * Every time we'll take a number find all the possible combinations and not take the number and 
         * find all the possible combinations.
         * We'll do this for all the numbers and store those combinations which sum up to target
         */
    	
    	//if target becomes 0, then we have all the numbers, just add it and return
        if(target==0)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        //if index becomes more than n, then return
        if(ind>=n)
            return;
        
        //if only the curr number is smaller than the target
        if(arr[ind]<=target){
        	//take the number
            temp.add(arr[ind]);
            //call the function, decrease target as we have taken the curr num
            helper1(ind,arr,ans,temp,target-arr[ind],n);
            
            //after the function call is over, remove it
            temp.remove(temp.size()-1);
        }
        
        //then again call the function, without taking the number
        //if the curr number is greater than the target, automatically we will not take it thus only
        //this function will be executed
        helper1(ind+1,arr,ans,temp,target,n);
    }
}

/*
 * COMBINATIONAL SUM 2
 * Given a collection of candidate numbers (candidates) and a target number (target), 
 * find all unique combinations in candidates where the candidate numbers sum to target.
 * Each number in candidates may only be used once in the combination.
 * Note: The solution set must not contain duplicate combinations.
 * 
 *  Input: candidates = [10,1,2,7,6,1,5], target = 8
	Output: 
	[
	[1,1,6],
	[1,2,5],
	[1,7],
	[2,6]
	]
 */

class CombSum2{
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        
        Arrays.sort(candidates);
        
        helper(0,ans,ds,target,candidates,candidates.length);
        
        return ans;
    }
    
	/*
	 * This problem is a little bit different than the prev one, here we can take a number only once,
	 * combinations must be unique.
	 * There can be duplicate elements in the array so if we use the take/not take approach, then it will
	 * generate duplicate combinations and inorder to filter out them we'll take alot time
	 * 
	 * Thus, we'll try another approach, first sort the array 
	 * For each index we can select a unique number, for example, we can only take 1 in index 0, if we take 
	 * it again that will result duplicate combinations, thus for every index, we'll take a unique number
	 * and call the function for the rest of the indexes
	 */
    public void helper(int i,List<List<Integer>> ans,List<Integer> ds,int target,int[] can,int n){
        
    	//base cond
        if(target==0)
        {
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        //we'll iterate from i to n and check if we have already taken a number in consideration
        for(int j=i;j<n;j++){
        	//j!=i means the first index check will be not be performed since there is no prev index
        	//even if there is, we cannot check that
        	//so if the curr number is already taken for the particular index, then just skip it
            if(j!=i && can[j]==can[j-1])
                continue;
            
            //if the curr number is greater than target, then break the loop, as rest of the elements
            //will also be greater or equal to the curr element so no need to check
            if(can[j]>target)
                break;
            
            //add the curr element and call the function from the next index
            ds.add(can[j]);
            helper(j+1,ans,ds,target-can[j],can,n);
            //remove the curr element and check for the other elements
            ds.remove(ds.size()-1);
        }
    }
}

/*
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. 
 * The list must not contain the same combination twice, and the combinations may 
 * be returned in any order.
 * 
 *  Example 1:
	
	Input: k = 3, n = 7
	Output: [[1,2,4]]
	Explanation:
	1 + 2 + 4 = 7
	There are no other valid combinations.
	Example 2:
	
	Input: k = 3, n = 9
	Output: [[1,2,6],[1,3,5],[2,3,4]]
	Explanation:
	1 + 2 + 6 = 9
	1 + 3 + 5 = 9
	2 + 3 + 4 = 9
	There are no other valid combinations.
 */

class CombSum3{
	/*
	 * Here the elements are from 1 to 9, numbers can be chosen once and the length of the combinations
	 * must be k
	 */
	public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        
        helper(1,ds,ans,k,n,0);
        
        return ans;
    }
    
    public void helper(int i, List<Integer> ds, List<List<Integer>> ans, int k, int target, int count){
        //count is used to count the no.of elements in a combination
    	//if count becomes equal or more than k,
        if(count>=k){
        	//check if target is 0 or not, if yes add it and return
            if(target==0)
                ans.add(new ArrayList<>(ds));
            return;
        }
        
        //for every index we can put any of the 9 elements, so pick one and check for the rest indexes
        for(int j=i;j<=9;j++){
            
            ds.add(j);
            helper(j+1,ds,ans,k,target-j,count+1);
            ds.remove(ds.size()-1);
        }
    }
}
