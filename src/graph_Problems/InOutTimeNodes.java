package graph_Problems;

import java.util.*;

//This calculates the In and Out time of the nodes
//It also tells if a node belongs to the subtree of another node
public class InOutTimeNodes {
	
	public boolean isSubNode(ArrayList<ArrayList<Integer>> alist, int a, int b, int n) {
		
		boolean[] visited=new boolean[n];
		int[] in = new int[n];
		int[] out = new int[n];
		
		for(int i=0;i<n;i++) {
			if(visited[i]==false && alist.get(i).size()!=0)
				helper(i,alist,in,out,visited);
		}
		
		if(in[a]<in[b] && out[a]>out[b])
			return true;
		return false;
	}
	int timer=1;
	public void helper(int s,ArrayList<ArrayList<Integer>> alist, int[] in, 
															int[] out, boolean[] visited) {
		
		visited[s]=true;
		in[s]=timer++;
		
		for(int i:alist.get(s)) {
			if(!visited[i])
				helper(i,alist,in,out,visited);
		}
		
		out[s]=timer++;
		
	}

}
