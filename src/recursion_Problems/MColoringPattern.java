package recursion_Problems;
import java.util.*;
/*
 * Given an undirected graph and an integer M. The task is to determine if the graph can be colored 
 * with at most M colors such that no two adjacent vertices of the graph are colored with the same color. 
 * Here coloring of a graph means the assignment of colors to all vertices. Print 1 if it is 
 * possible to colour vertices and 0 otherwise.
 * 
 *  Input:
	N = 4
	M = 3
	E = 5
	Edges[] = {(0,1),(1,2),(2,3),(3,0),(0,2)}
	Output: 1
	Explanation: It is possible to colour the
	given graph using 3 colours.
 */
public class MColoringPattern {
	
	//This is similar to Bipartite graph, the only difference is we can fill the graph with m different 
	//colors, so we'll check all the possibilities.
	
	public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        
		//for storing the color for each node
        int[] color=new int[n];
        Arrays.fill(color,-1);
        
        return helper(0,graph,color, m,n);
    }
    
    public boolean helper(int s, boolean[][] graph, int[] color,int m, int n){
        
    	//if we manage to color all the nodes, then return true
        if(s>=n)
            return true;
        
        //check for all the m colors, if it is possible call the function for the next node
        for(int i=1;i<=m;i++){
        	//if we can fill this s node with i color, 
            if(valid(s,i,graph,color,n)){
            	//then update it in color array and call the function
                color[s]=i;
                //if this function returns true, that means all the nodes were successfully colored
                //no need to check for more, return true
                if(helper(s+1,graph,color,m,n)==true)
                    return true;
                
                //if this color was the wrong choice, then remove it from the array and check 
                //for other colors
                color[s]=-1;
            }
        }
        return false;
    }
    
    public boolean valid(int s,int c,boolean[][] graph, int[]color, int n){
        
    	//We have an adjacency matrix, so we'll check the particular s coloumn,
    	//if we get a true, then we have an edge between the two nodes, then check if it has color c
        for(int i=0;i<n;i++){
            if(graph[s][i]==true && color[i]==c)
                return false;
        }
        
        //if none of the child/neighbour nodes has color c, then this color is valid
        return true;
    }
    
    public static void main(String[] args) {
		
    	MColoringPattern ob = new MColoringPattern();
    	
    	boolean[][] graph= {{false,true,true,true},
				{true,false,true,false},
				{true,true,false,true},
				{true,false,true,false}};

    	System.out.println(ob.graphColoring(graph, 3, graph.length));
	}

}
