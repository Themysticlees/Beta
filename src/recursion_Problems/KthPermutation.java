package recursion_Problems;
import java.util.*;

/*
 * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

	"123"
	"132"
	"213"
	"231"
	"312"
	"321"
	Given n and k, return the kth permutation sequence.
 */

public class KthPermutation {
	/*
	 * Instead of generating all the permutations,
	 * we'll use maths to solve this problem, we'll calculate each digit one by one,
	 * Suppose we need to find the 4th ( or 3th since we'll use 0 index based) permutation of 123,
	 * So if we keep a number fixed, we can arrange the other three in 2!=2 ways
	 * 1 23
	 * 1 32  (0-1)
	 * 
	 * 2 13
	 * 2 31  (2-3)
	 * 
	 * 3 12
	 * 3 21	 (3-4)
	 * 
	 * Now if we divide 3/2=1, so we can understand that it will fall in the 1st quarter beginning with 2
	 * So we'll fix that, and from the remaining numbers, we need to find the 3%2=1 permutation
	 * Now we just do a recursive call
	 */
	public static String getPermutation(int n, int k) {
        
		//store the numbers in a ds and calculate the factorial
        List<Integer> list=new LinkedList<>();
        
        for(int i=0;i<n;i++){
            list.add(i+1);
        }
        
        int f=1;
        for(int i=1;i<=n;i++)
            f=f*i;
        
        
        return helper("",list,k-1,f);
    }
    
    public static String helper(String ans,List<Integer> list, int k, int fact){
        
    	//calculate the quater in which the permutation will fall
        int index=k/fact;
        //reduce k
        k=k%fact;
        
        //remove the curr element and add it to our ans
        int curr=list.remove(index);
        
        ans+=curr;
        //if list becomes empty just return the ans
        if(list.size()==0)
            return ans;
        
        //otherwise call the function with fact reduced	
        return helper(ans,list,k,fact/list.size());
    }
    
    public static void main(String[] args) {
		
    	System.out.println(getPermutation(4, 5));
	}

}
