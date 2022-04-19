package matrix_Problems;
/*
 * Given a 2D matrix M of dimensions RxC. Find the maximum sum submatrix in it.
 *  R=4
	C=5
	M=[[1,2,-1,-4,-20],
	   [-8,-3,4,2,1],
	   [3,8,10,1,3],
	   [-4,-1,1,7,-6]]
	Output:
	29
 */
public class MaxSumRectangle {
	//We have use Kaden's algo to find the max sum subarray
	//But kaden's algo only works for 1d array, thus we need to convert our 2d to 1d
	//for every row, we check from that row to the bottom row
	//we'll create a temp array, where we'll store the elements of each row column wise
	//as we move to the next row, we'll add the elements to the previous elements of the same column
	//and check for the max subarray
	//Similarly we will do this for every row so that we check all the possible sub matrixes
	static int maximumSumRectangle(int R, int C, int M[][]) {
        // code here
        int max=Integer.MIN_VALUE;
        for(int i=0;i<R;i++){
        	//temp array to store the elements 
            int[] temp=new int[C];
            
            for(int r=i;r<R;r++){
            	//add the elements of the particular row to the temp array
                for(int col=0;col<C;col++)
                    temp[col]+=M[r][col];
                
                //calculate kaden's and store it in max
                int tempsum=kadens(temp,C);
                max=Math.max(max,tempsum);  
            }
        }
        
        //Now suppose, upto the 3rd row from the 1st row, the max subarray is from index 2 to 3
        //Thus we can say, the max submatrix upto now is from row 1 index 2 to 3 to row 3 index 2 to 3
        return max;
    }
    
    static int kadens(int[] arr, int n){
        
        int max=Integer.MIN_VALUE;
        int sum=0;
        
        for(int i=0;i<n;i++){
            sum+=arr[i];
            
            max=Math.max(max,sum);
            
            if(sum<0)
                sum=0;
        }
        return max;
    }
    
    public static void main(String[] args) {
		
    	int[][] M= {{1,2,-1,-4,-20},
    			   {-8,-3,4,2,1},
    			   {3,8,10,1,3},
    			   {-4,-1,1,7,-6}};
    			
    	System.out.println(maximumSumRectangle(M.length, M[0].length, M));
	}

}
