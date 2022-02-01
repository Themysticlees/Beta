package array_Problems;

public class ProductExpSelf {
	
	public static long[] productExceptSelf(int nums[], int n) 
	{ 
        //to store the result array
        long[] res=new long[n];
        if(n==1)
        {
        	//if there is a single element then insert 1 and return
        	//because except that element product will be 1
            res[0]=1;
            return res;
        }
        
        //taking two arrays
        //left will store the current product of the elements from the left upto that index
        //right will store the current product of the elements from the left upto that index
        long[] left=new long[n];
        long[] right=new long[n];
        
        long product=1;
        for(int i=0;i<n;i++){
            product*=nums[i];
            left[i]=product;
        }
        
        product=1;
        for(int i=n-1;i>=0;i--){
            product*=nums[i];
            right[i]=product;
        }
        
        //The idea is to find the product for every except the current element
        for(int i=0;i<n;i++){
        	//handling the corner cases
        	//when i=0, i.e first element then product of all the elements to the right 
        	//should be the answer, we have stored that in right array
        	//when we are the last element then product of all the left elements
            if(i==0)
                res[i]=right[i+1];
            else if(i==n-1)
                res[i]=left[i-1];
            else{
            	//normal case : we need to find the product of all the left elements of the array
            	//and product of all the right elements of the array
            	//and then take the product of them
            	//left[i-1] has the product upto i-1 index from left
            	//right[i+1] has the product upto i+1 index from right
                res[i]=left[i-1]*right[i+1];
            }
        }
        
        return res;
	}
	
	public static void main(String[] args) {
		
		int nums[] = {10, 3, 5, 0, 2};
		
		long[] arr=productExceptSelf(nums, nums.length);
		
		for(long i: arr)
			System.out.print(i+" ");
	}

}
