package graph_Problems;
import java.util.*;
//If two nodes of same edge have the same color then the graph is not bipartite

public class BipartiteGraph {
	
	public boolean isBipartite(int n, ArrayList<ArrayList<Integer>>alist)
    {
        // Code here
        boolean[] visited=new boolean[n];
		int[] color=new int[n];
		
		//there may be more than 1 cc (connected component)
 		for(int i=0;i<n;i++)
		{	
 			//if we get false, then just return false
			if(!visited[i])
				if(helper(i,0,visited,color,alist)==false)
					return false;
		}
 		return true;
    }
    
    public boolean helper(int s,int c,boolean[] visited, int[] color,
                                        ArrayList<ArrayList<Integer>>alist) {
		//we mark the current node as visted and assign it's color
		visited[s]=true;
		color[s]=c;
		
		for(int i:alist.get(s)) {
			//now for it's adjacent nodes, if it is not visited
			//do a recursive call (DFS) and check the ans
			//c^1 just inverts c from 0 to 1 or from 1 to 0
			if(!visited[i]) {
				if(helper(i, c^1, visited, color,alist)==false)
					return false;
			}
			
			//if it's adjacent node is visited, then check whether they have the same color,
			//then return false
			if(color[s]==color[i])
				return false;
		}
		return true;
		
	}
}
