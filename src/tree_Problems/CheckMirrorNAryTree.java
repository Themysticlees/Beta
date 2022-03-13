package tree_Problems;
import java.util.*;
public class CheckMirrorNAryTree {
	
	/*
	 * Given two n-ary trees. Check if they are mirror images of each other or not. 
	 * You are also given e denoting the number of edges in both trees, and two arrays, 
	 * A[] and B[]. Each array has 2*e space separated values u,v denoting an edge from u to v 
	 * for the both trees.
	 * 
	 * 
	 * If you are given two roots of the trees, then first store elements from left to right in a stack
	 * then traverse the next array from right to left, pop the elements from the stack and match, if at any point
	 * they donot match, return -1
	 */
	static int checkMirrorTree(int n, int e, int[] A, int[] B) {
        // code here
        
		//for every parent node, there will be a stack which will store all it's children
        Map<Integer,Stack<Integer>> map = new HashMap<>();
        
        //here for every two elements, first element is the parent and 2nd is the child
        for(int i=0;i<2*e;i+=2){
        	
            if(!map.containsKey(A[i]))
                map.put(A[i],new Stack<>());
            //push the children into the stack for the particular parent
            map.get(A[i]).push(A[i+1]);
        }
        
        //now for the 2nd array, first element of a parent node should be last element of the other tree
        //since stack follow last in first out, thus when we pop, the last element will be popped
        //we'll check it with the first children of the same parent of the 2nd tree
        for(int i=0;i<2*e;i+=2){
           
        	//if it doesnt match, return -1
           if(map.get(B[i]).pop()!=B[i+1])
            return 0;
        }
        return 1;
    }

}
