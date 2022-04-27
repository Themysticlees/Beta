package graph_Problems;

/*
 * Given a grid of size n*m (n is number of rows and m is number of columns grid has) 
 * consisting of '0's(Water) and '1's(Land). Find the number of islands.
 * Note: An island is surrounded by water and is formed by connecting adjacent lands horizontally 
 * or vertically or diagonally i.e., in all 8 directions.
 * 
 *  Input:
	grid = {{0,1,1,1,0,0,0},{0,0,1,1,0,1,0}}
	Output:
	2
	Expanation:
	The grid is-
	0 1 1 1 0 0 0
	0 0 1 1 0 1 0 
	There are two islands one is colored in blue 
	and other in orange.
 */
public class FindIslands {
	
	//Do a DFS call to visit all the nodes that are adjacent and 1
	
	public static int numIslands(char[][] grid) {
        // Code here
        int m=grid.length;
        int n=grid[0].length;
        
        boolean[][] visited=new boolean[m][n];
        int islands=0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
            	//if you find 1 then it is an island, now this function helper will find all
            	//the adjacent nodes which are 1 forming an complete island.
            	//Increase the count and check, if there is any other node which is unvisited and 1
            	//then more islands are present
                if(grid[i][j]=='1' && visited[i][j]==false){
                    islands++;
                    helper(i,j,grid,visited);
                }
            }
        }
        return islands;
    }
    
    public static void helper(int x, int y, char[][] grid, boolean[][] visited){
        
        if(x<0 || y<0 || x>grid.length-1 || y>grid[0].length-1 
                || grid[x][y]=='0' || visited[x][y]==true)
            return;
            
        visited[x][y]=true;
        
        //up
        helper(x-1,y,grid,visited);
        //left
        helper(x,y-1,grid,visited);
        //down
        helper(x+1,y,grid,visited);
        //right
        helper(x,y+1,grid,visited);
        //top left
        helper(x-1,y-1,grid,visited);
        //top right
        helper(x-1,y+1,grid,visited);
        //bottom left
        helper(x+1,y-1,grid,visited);
        //bottom right
        helper(x+1,y+1,grid,visited);
    }
    
    public static void main(String[] args) {
    	char[][] grid = {{'0','1','1','1','0','0','0'},{'0','0','1','1','0','1','0'}};
		System.out.println(numIslands(grid));
	}

}
