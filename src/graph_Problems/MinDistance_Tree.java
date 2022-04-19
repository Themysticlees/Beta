package graph_Problems;

import java.util.ArrayList;
//Only applicable for tree
public class MinDistance_Tree {
	
	ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
	int n;
	//Calculate distance using DFS
	public void minDistance(int s) {
		boolean[] visited = new boolean[n];
		//for tracking the distance of every node from the starting node
		int[] dis = new int[n];
		
		helper(s,0,visited,dis);
		
		for(int i:dis)
			System.out.print(i+" ");
	}
	
	public void helper(int s,int count,boolean[] visited, int[] dis) {
		
		if(visited[s]==true)
			return;
		
		visited[s]=true;
		dis[s]=count;
		//increase count as we move to it's adjacent node
		for(int i:alist.get(s))
			helper(i,count+1,visited,dis);
	}

}
