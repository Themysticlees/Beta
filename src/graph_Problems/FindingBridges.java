package graph_Problems;

import java.util.ArrayList;

//Bridges are those edges which when removed increases the number of connected components
public class FindingBridges {
	
	ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
	int n;
	int timer;
	
	public void findBridges() {
		
		//in to maintain the in time of every node
		int[] in=new int[n+1];
		//low to track the in time of the lowest ancestor
		int[] low=new int[n+1];
		
		boolean[] visited=new boolean[n+1];
		
		for(int i=0;i<=n;i++) {
			if(alist.get(i).size()!=0 && visited[i]==false)
				helper(i,-1,in,low,visited);
		}
	}
	
	public void helper(int s, int par, int[] in, int[] low, boolean[] visited) {
		
		visited[s]=true;
		//initialize in and low by timer
		//low and in will be same when we start traversing, ancestor will only exist if their is a cycle
		in[s]=low[s]=timer++;
		
		for(int child:alist.get(s)) {
			//if the child is the parent then continue
			if(child==par)
				continue;
			//if the child is already visited then it is an ancestor
			//so we need to update the low of this node
			//we are taking the min as we need to store the in time of it's lowest ancestor
			else if(visited[child]) {
				//back edge
				low[s]=Math.min(in[child], low[s]);
			}
			else {
				//otherwise do a dfs call
				//front edge
				helper(child,s,in,low,visited);
				
				//after making the dfs call check whether the child node has lower ancestor than the
				//in time of the current node i.e whether it is accessible from any other node
				//if the low[child] is greater than in[s] that means there is no ancestor of the child
				//there exists only one path thus we can call it a bridge
				if(low[child]>in[s])
					System.out.println(child+"-"+s+" is a bridge");
				
				//The current node will also update itself to it's lowest ancestor
				low[s]=Math.min(low[child],low[s]);
			}
		}
		
	}
}
