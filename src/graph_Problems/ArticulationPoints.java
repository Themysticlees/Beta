package graph_Problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//Articulation points are those which when removed increases the no.of components
//This is similar to finding bridges
//The only difference is this time we have to store all the nodes which form a bridge
//we are using set because same node may form multiple bridges so to avoid that we are storing 
//the nodes in a set rather than printing them
public class ArticulationPoints {
	
	ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
	int n;
	int timer=0;
	Set<Integer> set = new HashSet<>();
	public void findArticulationPoints() {
		
		boolean[] visited=new boolean[n+1];
		
		//in time and lowest ancestor time
		int[] in=new int[n+1];
		int[] low=new int[n+1];
		
		for(int i=1;i<=n;i++) {
			if(visited[i]==false)
				dfs(i,visited, in , low,-1);
		}
		
		System.out.println(set);
 		
	}
	public void dfs(int s, boolean[] visited, int[] in, int[] low, int par) {
		// TODO Auto-generated method stub
		visited[s]=true;
		in[s]=low[s]=timer++;
		
		for(int child:alist.get(s)) {
			if(child==par)
				continue;
			//back edge => reduce the lowest ancestor time as it can reached from that node
			if(visited[child]) {
				low[s]=Math.min(low[s], in[child]);
			}
			else {
				dfs(child,visited,in,low,s);
				
				//if the low time is less than the in time of the parent node
				//that means this child node cannot be accessed anywhere above the parent node
				//thus they are articulation points
				if(low[child]>in[s]) {
					set.add(child);
					set.add(s);
				}
				
				//reduce the low time of the parent
				low[s]=Math.min(low[s], low[child]);
			}
		}
		
	}
}
