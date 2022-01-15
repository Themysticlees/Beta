package Testing;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
	
	public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
		String path="";
		ArrayList<String> list = new ArrayList<String>();
		int[][] visited= new int[n][n];
		
		
		find(m, visited, 0, 0, n, path, list);
		return list;
    }
	

	public static void find(int[][] m, int[][] visited, int i, int j, int n, String path, ArrayList<String> list){
        
        if(i==n-1 && j==n-1)
        {
        	visited[i][j]=0;
            list.add(path);
            return;
        }
        
        visited[i][j]=1;
        if(isPresent(m,visited, i-1, j, i, j))
            find(m,visited,i-1,j,n,path+"U",list);
        
        if(isPresent(m,visited, i+1, j, i, j))
            find(m,visited,i+1,j,n,path+"D",list);
        
        if(isPresent(m,visited, i, j-1, i, j))
            find(m,visited,i,j-1,n,path+"L",list);
        
        if(isPresent(m,visited, i, j+1, i, j))
            find(m,visited,i,j+1,n,path+"R",list);
        

        visited[i][j]=0;
    }
	
	public static boolean isPresent(int[][] m, int[][] visited, int i, int j,int pi, int pj) {
		
		if((i>=0 && i<m.length)&&(j>=0 && j<m.length)) {
			if((i!=pi || j!=pj)&&(visited[i][j]!=1)) {
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


