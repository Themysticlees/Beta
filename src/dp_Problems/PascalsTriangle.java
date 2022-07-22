package dp_Problems;
import java.util.*;
/*
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * 
 * Problem link : https://leetcode.com/problems/pascals-triangle/
 */
public class PascalsTriangle {
	//Compute the value from the previous values
	//The first and the last index will always contain 1
	//Rest needs to be calculated
	public List<List<Integer>> generate(int n) {
        
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            
            List<Integer> temp = new ArrayList<>();
            for(int j=0;j<=i;j++){
                //first and last index
                if(j==0 || j==i)
                    temp.add(1);
                else{
                	//take the previous two indexes and add them 
                    int a=list.get(i-1).get(j-1);
                    int b=list.get(i-1).get(j);
                    
                    temp.add(a+b);
                }
                    
            }
            list.add(temp);
        }
        
        return list;
    }

}
