package graph_Problems;

import java.util.ArrayList;
/*
 * Problem link : https://codeforces.com/contest/118/problem/E
 * 
 * Bertown has n junctions and m bidirectional roads. We know that one can get from any junction 
 * to any other one by the existing roads.As there were more and more cars in the city, traffic jams
 * started to pose real problems. To deal with them the government decided to make the traffic
 * one-directional on all the roads, thus easing down the traffic. Your task is to determine 
 * whether there is a way to make the traffic one-directional so that there still is the possibility
 * to get from any junction to any other one. If the answer is positive, you should also find one
 * of the possible ways to orient the roads.
 */
public class BertownRoads {
	
	//We have make the edges uni directional keeping in mind that we can travel to any node 
	//from any other node, if such combition is possible then return the edges otherwise zero
	//We'll take the help of DFS tree and back edge concept inoder to solve
	
	ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
	int n;
	int timer;
	//if the graph has a bridge then making that edge uni directional is not possible
	boolean hasBridge;
	
	//to store the edges of new combination
	ArrayList<Pair> edges=new ArrayList<Pair>();
	
	public void bertownRoads() {
		
		boolean[] visited=new boolean[n+1];
		
		//to find out any bridge
		int[] in = new int[n+1];
		int[] low = new int[n+1];
		
		helper(1,-1,visited, in, low);
		
		if(!hasBridge) {
			for(Pair i:edges) {
				System.out.println(i.first+"-"+i.second);
			}
		}
		else
			System.out.println(0);
	}
	
	public void helper(int s, int parent, boolean[] visited, int[] in, int[] low) {
		
		in[s]=low[s]=timer++;
		
		visited[s]=true;
		
		for(int child:alist.get(s)) {
			if(child==parent)
				continue;
			if(visited[child]) {
				//back edge
				low[s]=Math.min(low[s], in[child]);
				
				//if we get a back edge
				//then check if the child is an ancestor then make an edge between them
				if(in[child]<in[s])
					edges.add(new Pair(s,child));
			}
			else {
				//front edge
				helper(child,s,visited,in,low);
				
				if(low[child]>in[s])
				{
					//if we get a bridge, then return 
					hasBridge=true;
					return;
				}
				
				low[s]=Math.min(low[s], low[child]);
				
				//add the front edges
				edges.add(new Pair(s,child));
			}
		}
	}

}
