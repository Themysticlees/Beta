package graph_Problems;

import java.util.LinkedList;
import java.util.Queue;


/*
 *  Geek is in a maze of size N * M. Each cell in the maze is made of either '.' or '#'.
 *  An empty cell is represented by '.' and an obstacle is represented by '#'. If Geek starts at cell (R, C),
 *  find how many different empty cells he can pass through while avoiding the obstacles. He can move in any 
 *  of the four directions but he can move up at most U times and he can move down atmost D times.
 *  
 *  Input: 
	N = 3, M = 3
	R = 1, C = 0
	U = 1, D = 1
	mat = {{'.', '.', '.'},
	       {'.', '#', '.'},
	       {'#', '.', '.'}}
	Output: 5
	Explanation: Geek can reach 
	(1, 0), (0, 0), (0, 1), (0, 2), (1, 2) 
 */

//for every cell, we'll store their indexes and their up and down count
class Pair3{
    
	int upp;
	int low;
	int i;
	int j;
	
	public Pair3(int upp, int low, int i, int j) {
		super();
		this.upp = upp;
		this.low = low;
		this.i = i;
		this.j = j;
	}

	@Override
	public String toString() {
		return "Pair3 [upp=" + upp + ", low=" + low
				+ ", i=" + i + ", j=" + j + "]";
	}	
}

public class GeekMaze {
	
	//Solved using BFS
	//Initially we'll check for every valid cell, whether we can move to the other directions
	//We also need to keep in mind about the ups and downs
	public static int numberOfCells(int n, int m, int r, int c, int u, int d, char mat[][])
	{
		//For storing the cells
		Queue<Pair3> queue=new LinkedList<>();
		
		//For keeping a track of the visited nodes
		int[][] visited = new int[n][m];
		visited[r][c]=1;
		
		//if the starting node is an obstacle
		if(mat[r][c]=='#')
			return 0;
		
		//initially we are a particular cell, so we'll count that one too
		int cells=1;
		
		//checking the left cell
		if(c-1>=0 && mat[r][c-1]!='#') {
			queue.add(new Pair3(0,0,r,c-1));
			cells++;
			visited[r][c-1]=1;
		}
		
		//right
		if(c+1<m && mat[r][c+1]!='#') {
			queue.add(new Pair3(0,0,r,c+1));
			cells++;
			visited[r][c+1]=1;
		}

		//checking the upper index and also checking the up counter
		if(u>0 && r-1>=0 && mat[r-1][c]!='#') {
			queue.add(new Pair3(1,0,r-1,c));
			cells++;
			visited[r-1][c]=1;
		}
		
		//down
		if(d>0 && r+1<n && mat[r+1][c]!='#') {
			queue.add(new Pair3(0,1,r+1,c));
			cells++;
			visited[r+1][c]=1;
		}
		
		while(!queue.isEmpty()) {
			
			//Now for every cell, we'll check all the surrounding cells and add them to the queue if not
			//visited
			Pair3 temp=queue.poll();
			int i=temp.i;
			int j=temp.j;
			int up=temp.upp;
			int low=temp.low;
			
			//left
			if(j-1>=0 && mat[i][j-1]!='#' && visited[i][j-1]!=1) {
				queue.add(new Pair3(up,low,i,j-1));
				cells++;
				visited[i][j-1]=1;
			}
			
			//right
			if(j+1<m && mat[i][j+1]!='#' && visited[i][j+1]!=1) {
				queue.add(new Pair3(up,low,i,j+1));
				cells++;
				visited[i][j+1]=1;
			}

			//up
			if(up+1<=u && i-1>=0 && mat[i-1][j]!='#' && visited[i-1][j]!=1) {
				queue.add(new Pair3(up+1,low,i-1,j));
				cells++;
				visited[i-1][j]=1;
			}
			
			//down
			if(low+1<=d && i+1<n && mat[i+1][j]!='#' && visited[i+1][j]!=1) {
				queue.add(new Pair3(up,low+1,i+1,j));
				cells++;
				visited[i+1][j]=1;
			}
			
		}
		return cells;
	}
	
	public static void main(String[] args) {
		
		char[][] mat = {{'.', '.', '.'}, 
	       		{'.', '#', '.'}, 
	       		{'.', '.', '.'},
	       		{'#', '.', '.'}};

		System.out.println(numberOfCells(mat.length, mat[0].length, 1, 0, 1, 2, mat));
	}

}
