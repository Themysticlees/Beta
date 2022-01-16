package Testing;
import java.util.*;
import java.util.regex.Pattern;

import searching_Problems.BinarySearch;

public class Main {
	
	public static boolean searchMatrix(int[][] matrix, int target) {
        
        int low=0,high=matrix[0].length;
        
        int i=0;
        while(i<matrix.length){
            if(matrix[i][matrix[0].length-1]>=target){
                low=i;
                //high=matrix[i-1].length;
                break;
            }
            i++;
        }
        
        for(i=0;i<matrix[0].length;i++){
            if(matrix[low][i]==target)
                return true;
        }
        return false;
        
    }
	
	public static void main(String[] args) {
		
		int[][] matrix = {{1,3,5,7},
				  		  {10,11,16,20},
				  		  {23,30,34,60}};
		
		System.out.println(searchMatrix(matrix, 7));
	}
}


