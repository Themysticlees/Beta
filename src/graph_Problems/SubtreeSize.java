package graph_Problems;

import java.util.ArrayList;
/*
 * Given a tree in the form of adjacency list we have to calculate the number of nodes
 * in the subtree of each node while calculating the number of nodes in the subtree of a particular
 * node that node will also be added as a node in subtree hence the number of nodes in subtree of leaves
 * is 1. 
 */
public class SubtreeSize {
	//DFS
	ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
	int n;
	
	public int[] subtree_size() {
		boolean[] visited=new boolean[n];
		
		int[] size=new int[n];
		
		dfs(1,visited,size);
		return size;
	}

	public int dfs(int s, boolean[] visited, int[] size) {
	// TODO Auto-generated method stub
		visited[s]=true;
		
		for(int i:alist.get(s))
		{
			//we'll add the size of the subtree to the root node
			if(visited[i]==false)
				size[s]+=dfs(i,visited,size);
		}
		//since we'll consider the root node as well thus +1
		size[s]++;
		return size[s];
	}
}
