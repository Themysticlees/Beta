package array_Problems;

public class MaxPathSum {
	
	static int maxPathSum(int ar1[], int ar2[])
    {
        
        int m=ar1.length;
        int n=ar2.length;
        
        int i=0,j=0;
        
        //sum1 is calculation sum of elements of 1st array
        //sum2 for second array
        int sum1=0;
        int sum2=0;
        
        int res=0;
        while(i<m && j<n)
        {   
            //since the elements are sorted thus we use two
            //pointers. Increase the pointer whose value is less
            if(ar1[i]>ar2[j])
            {   
                sum2+=ar2[j];
                j++;
            }
            else if(ar1[i]<ar2[j])
            {
                sum1+=ar1[i];
                i++;
            }
            //if both the pointers have same values
            //then store the max of sum1,sum2 upto now
            else
            {
               //also store the common element and initialize sum1,sum2 with 0
               res+=Math.max(sum1,sum2)+ar1[i];
               i++;
               j++;
               sum1=0;
               sum2=0;
               //from the next iteration sum1 and sum2 will be calculate again
            }
        }
        
        //if some indexes are still left
            for(;i<m;i++)
                sum1+=ar1[i];
            
            for(;j<n;j++)
                sum2+=ar2[j];
        
        //again max of sum1 and sum2 is calculated and added with res
        //thus max sum path is achieved
        return res+Math.max(sum1,sum2);
        
    }
	
	public static void main(String[] args) {
		
		int[] A = {2,3,7,10,12};
		int[] B ={1,5,7,8};
		
		System.out.println(maxPathSum(A, B));
	}

}
