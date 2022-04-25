package graph_Problems;

import java.util.ArrayList;
import java.util.Arrays;

public class Diamater_Tree {
	ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
	int n;
	
	public int Caldiameter(int root) {
		boolean[] visited=new boolean[n];
		int[] maxd= {0};
		int[] res= {root};
		//first we find the farthest node from the root
		dfs(root,visited,maxd,res,0);
		Arrays.fill(visited, false);
		maxd[0]=0;
		//then we again find the farthest node from the farthest node found in the previous dfs call
		dfs(res[0],visited,maxd,res,0);
		
		return maxd[0];
	}

	public void dfs(int root, boolean[] visited, int[] maxd, int[] res, int dis) {
		// TODO Auto-generated method stub
		visited[root]=true;
		if(dis>maxd[0]) {
			maxd[0]=dis;
			res[0]=root;
		}
		for(int i:alist.get(root)) {
			if(visited[i]==false)
				dfs(i, visited, maxd, res, dis+1);
		}
	}

}
