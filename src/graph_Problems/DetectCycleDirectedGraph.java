package graph_Problems;
import java.util.*;
//Detect cycle in a directed graph

public class DetectCycleDirectedGraph {
	//The approach here will be a little bit different from the undirected graph
	//Here if a node is already visited, we need to check whether it's recursive call is still alive
	//i.e it hasn't finished it's function
	
	public boolean isCyclic(int n, ArrayList<ArrayList<Integer>> alist) {
        // Code here
        
        int[] visited=new int[n];
        
        for(int i=0;i<n;i++){
            if(visited[i]==0)
		        if(helper(i,visited,alist)==true)
		            return true;
        }
        return false;
    }
    
    public boolean helper(int s, int[] visited,ArrayList<ArrayList<Integer>> alist) {
		
		//1=recursion going on
    	//2=function call finished
    	//3=not visited
		visited[s]=1;
		
		//So for a node, we'll check all it's adjacent nodes
		for(int child:alist.get(s)){
			//if we get a node whose recursion call is still alive, then we return true
			//as that satisfies our condition
			if(visited[child]==1)
				return true;
			//if the child is unvisited, then we'll make a recursion call and if we get a true value
			//then return true
			if(visited[child]==0)
				if(helper(child,visited,alist)==true)
					return true;
		}
		//once we have checked all the children then we can say, we have finished it's function call
		//thus update visited to 2
		visited[s]=2;
		return false;
	}
    
}
