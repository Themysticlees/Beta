package greedy_Problems;

/*
 * Given an integer array, find the maximum product of its elements among all its subsets.
	For example,
	Input:  nums[] = { -6, 4, -5, 8, -10, 0, 8 }
	 
	Output: The maximum product of a subset is 15360
	 
	The subset with the maximum product of its elements is { -6, 4, 8, -10, 8 }
	Input:  nums[] = { 4, -8, 0, 8 }
	 
	Output: The maximum product of a subset is 32
	 
	The subset with the maximum product of its elements is { 4, 8 }
 */
public class MaxProductSubset {
	
	
	public static int findMaxProduct(int[] arr)
	{
		int n=arr.length;
		// Write your code here...
		
		if(n==1)
			return arr[0];
		
		//We'll keep a count of all the negative, positive and zeros present in the array
        int neg=0,pos=0,zero=0;
        //for calculating the product of all no zero elements
        int p=1;
        //for finding the neg no. with least absolute value
        int minneg=Integer.MAX_VALUE;
        
        
        for(int i=0;i<n;i++){
            if(arr[i]<0)
                neg++;
            else if(arr[i]>0)
                pos++;
           	else
                zero++;
            
            if(arr[i]!=0)
                p*=arr[i];
            
            if(arr[i]<0 && Math.abs(arr[i])<minneg)
                minneg=Math.abs(arr[i]);
        }
        
        //if we have no elements
        if (zero == n) {
            return 0;
        }
        
        //If we have zeros and only 1 neg and 0 positive then definitely the max product is 0
         if(zero!=0 && neg==1 && pos==0)
                return 0; 
         //if there are even neg numbers or just 1 neg number then just return the product
         //else if there are odd neg numbers, then divide the least negative number and return 
         if((neg&1)==0 || (neg==1 && pos==0))
                return p;
         else
            	return p/(-minneg);
	}

}
