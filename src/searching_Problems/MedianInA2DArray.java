package searching_Problems;

//Find the median in a 2D array, where every row is sorted
//The number of elements are always odd.

//Solving this using Binary Search
public class MedianInA2DArray {
	
	int median(int matrix[][], int r, int c) {
		//We are taking a range where all the numbers will lie
        int low = 1;
        int high = 2000;
        
        //For a number to be median, there should be n/2 numbers which are smaller than it.
        
        int half = (r * c) / 2;
        
        while (low <= high) {
            int mid = (high + low) / 2;
            
            //We take the mid and then we try to find the count of numbers which are less than mid
            //if the number is greater than n/2 then decrease high
            //if the number is smaller or equal to n/2 then increase low
            //ultimately the answer will lie in low
            //thus return low
            int cnt = helper(matrix, r, c, mid);

            if (cnt <= half) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return low;
    }
    
	//This function will return the count of numbers from the matrix which are less than mid using Binary Search
    int helper(int[][] matrix, int r, int c, int target) {
        
        int ans = 0;
        
        for (int i = 0; i < r; i++) {
        	//for each row, we'll do a binary search check
            int low = 0;
            int high = c - 1;
            while (low <= high) {
                int mid = (high + low) / 2;
                //we'll take the mid index and check whether that value is less than our target
                //if yes then increase low because there may be more numbers
                //if the value is more than target then reduce the high
                if (matrix[i][mid] <= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            //the low represents the numbers that are less or equal to target
            //finally add the low to the ans
            ans += low;
        }
        
        return ans;
    }

}
