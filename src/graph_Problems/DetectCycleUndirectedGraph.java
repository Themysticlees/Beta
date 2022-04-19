package graph_Problems;

import java.util.ArrayList;
/*
 * Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not. 
 */
public class DetectCycleUndirectedGraph {
	ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
	int n;
	
	//If a cycle exist, then our graph will form a loop
	//That means, from a particular node, we'll reach a node which has already been visited but it is
	//not that node's parent
	//If such condition occurs, then we can say the graph contains a cycle.
	public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited=new boolean[V];
		
        //There can be more than 1 connected graphs thus we need to check for all
        //Or it may not contain all the nodes from 1 to V
		for(int i=0;i<V;i++){
		    if(visited[i])
		        continue;
		    //If the function returns true, i.e we have found a cycle
		    //No need to check more
		    boolean temp=helper(i,i,visited,adj);
		    if(temp==true)
		        return true;
		}
		//If at the end of the loop, we couldnt find a cycle, then return false
		return false;
    }
    
    public boolean helper(int s, int p, boolean[] visited,ArrayList<ArrayList<Integer>> alist) {
		
		
		visited[s]=true;
		
		for(int i:alist.get(s))
		{
			//if the adjacent node of the current node is visited and is not it's parent
			//Then there is a cylce
			if(visited[i] && i!=p)
				return true;
			if(visited[i])
				continue;
			
			//If at an moment we get a cycle, then no need to check more
			boolean temp=helper(i,s,visited,alist);
			if(temp==true)
			    return true;
		}
		return false;
	}
    
}
