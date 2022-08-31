package matrix_Problems;
import java.util.*;
/*
 * Problem link: https://leetcode.com/problems/sort-the-matrix-diagonally/
 * 
 * A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row 
 * or leftmost column and going in the bottom-right direction until reaching the matrix's end. 
 * For example, the matrix diagonal starting from mat[2][0], where mat is a 6 x 3 matrix, 
 * includes cells mat[2][0], mat[3][1], and mat[4][2].
 * Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and 
 * return the resulting matrix.
 * 
 * Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
 * Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
 */
public class SortMatrixDiagonally {
	/*
	 * Store the elements of the diagonal in a map
	 * Inorder to identify each element of the same diagonal, just subtract the indexes 
	 * i-j, the elements belonging to the same diagonal will have the same value
	 */
	public int[][] diagonalSort(int[][] mat) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
            	//store them in a map
                int key=i-j;
                
                map.putIfAbsent(key,new LinkedList<>());
                map.get(key).add(mat[i][j]);
            }
        }
        
        //Now sort all the lists 
        for(int i:map.keySet()){
            Collections.sort(map.get(i));
        }
        
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                int key=i-j;
                //now just replace them with the elements in the sorted order
                mat[i][j]=map.get(key).get(0);
                //do remove the elements as it is difficult to have so many pointers
                map.get(key).remove(0);
            }
        }
        
        return mat;
    }
	

}
