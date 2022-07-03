package matrix_Problems;
import java.util.*;

/*
 * Problem link: https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
 * 
 * You are given a rectangular cake of size h x w and two arrays of integers horizontalCuts
 * and verticalCuts where:
 * horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal 
 * cut and similarly, and
 * verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.
 * Return the maximum area of a piece of cake after you cut at each horizontal and vertical position 
 * provided in the arrays horizontalCuts and verticalCuts. Since the answer can be a large number, 
 * return this modulo 109 + 7.
 */
public class MaxAreaCake {
	
	//The logic is simple, first we try to find the max distance between two horizontal cuts
	//similarly find the max distance between two vertical cuts
	 public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
	        

	        int m=horizontalCuts.length;
	        int n=verticalCuts.length;
	        
	        //sorting them as we'll be subtracting the curr from prev to find the distance
	        Arrays.sort(horizontalCuts);
	        Arrays.sort(verticalCuts);
	        
	        long maxh=0,maxv=0;
	        int diff=0;
	        
	        for(int i=0;i<m;i++){
	            //if i is 0, i.e first cut, then we cannot subtract it from any cut before as there is none
	        	//so we'll take the entire distance as diff (from start to that cut)
	            if(i==0){
	                diff=horizontalCuts[i];
	            }
	            
	            else
	                diff=horizontalCuts[i]-horizontalCuts[i-1];
	            
	            maxh=Math.max(maxh,diff);
	        }
	        //at last we need to find the difference between last cut and the last end of the matrix
	        maxh=Math.max(maxh,h-horizontalCuts[m-1]);
	        
	        
	        //Similarly for vertical cuts
	        for(int i=0;i<n;i++){
	            
	            if(i==0){
	                diff=verticalCuts[i];
	            }
	            
	            else
	                diff=verticalCuts[i]-verticalCuts[i-1];
	            
	            maxv=Math.max(maxv,diff);
	        }
	        maxv=Math.max(maxv,w-verticalCuts[n-1]);
	        
	        //since the ans can be big we'll do a modulus operation
	        long ans = maxh*maxv % 1000000007;
	        return (int)ans;
	        
	    }

}
