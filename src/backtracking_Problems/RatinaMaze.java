package backtracking_Problems;

import java.util.ArrayList;

public class RatinaMaze {
	
	public static ArrayList<String> findPath(int[][] m, int n) {

		//It will store the path from the first to last index
		//The rat can only travels in the 1s, 0s act as walls
		String path="";
		ArrayList<String> list = new ArrayList<String>();
		
		//for marking the visited indexes
		int[][] visited= new int[n][n];
		
		
		find(m, visited, 0, 0, n, path, list);
		return list;
    }
	
	
	public static void find(int[][] m, int[][] visited, int i, int j, int n, String path, ArrayList<String> list){
        
		//this means we have reached the last index
		//store the path in the list and return to find other suitable paths
        if(i==n-1 && j==n-1)
        {
        	//make the last index 0 as we'll find more suitable paths
        	visited[i][j]=0;
            list.add(path);
            return;
        }
        
        //mark the current index as visited
        visited[i][j]=1;
        //check for it's upper index whether it is safe
        if(isPresent(m,visited, i-1, j, i, j))
            find(m,visited,i-1,j,n,path+"U",list);
        
        //check for it's lower index whether it is safe
        if(isPresent(m,visited, i+1, j, i, j))
            find(m,visited,i+1,j,n,path+"D",list);
        
        //check for it's left index whether it is safe
        if(isPresent(m,visited, i, j-1, i, j))
            find(m,visited,i,j-1,n,path+"L",list);
        
        //check for it's right index whether it is safe
        if(isPresent(m,visited, i, j+1, i, j))
            find(m,visited,i,j+1,n,path+"R",list);
        
        //if none of the indexes are safe then the current index will not
        //lead to the correct path hence make it 0 thus backtrack to find another 
        //suitable index
        visited[i][j]=0;
    }
	
	public static boolean isPresent(int[][] m, int[][] visited, int i, int j,int pi, int pj) {
		
		//This fn will check whether the index is safe or not
		//if the index is not out of bounds
		if((i>=0 && i<m.length)&&(j>=0 && j<m.length)) {
			//if the index is not already visited
			if((i!=pi || j!=pj)&&(visited[i][j]!=1)) {
				//if all the conditions satisfies then return this index as safe
				if(m[i][j]==1)
					return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int m[][] = {{1, 1, 1, 1, 0},
		         	 {0, 0, 1, 0, 0}, 
		         	 {1, 0, 1, 1, 0},
		         	 {0, 0, 1, 1, 0},
		         	 {0, 0, 1, 1, 1}};
		
		int m1[][]= {{1,0},
					{1,0}};
		
		if(m[0][0]==0)
			System.out.println("No paths");
		else
		{
			int n=5;
			ArrayList<String> list = findPath(m, n);
			System.out.println(list);
		}
	}
}
