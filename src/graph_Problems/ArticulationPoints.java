package graph_Problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;



//Articulation points are those which when removed increases the no.of components
/*
 * 1. End points of a bridge will be an articulation point if that node has degree atleast two
 * 2. It is not necessary for an articulation point to be an endpoint of a bridge
 * 3. Finding Bridges algo cannot be used to find articulation points
 * 
 * If the low of the child node is bigger or equal to the in time of the parent node
 * then the parent node is an articulation point, the reason is if we remove the parent node then there 
 * would be no other path left for the chil nodes as the low time of the child is equal or more than in time
 * of parent
 * 
 * The root will always have it's in time less or equal to the child nodes but it doesnt mean it always has
 * to be an articulation point, for the root we'll write another condition.
 * If the root have more more than 1 distinct branches (branches which donot connect) then we can say
 * the root is an articulation point
 */
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
		
		//for calculating the distinct children
		int children=0;
		for(int child:alist.get(s)) {
			if(child==par)
				continue;
			//back edge => reduce the lowest ancestor time as it can reached from that node
			if(visited[child]) {
				low[s]=Math.min(low[s], in[child]);
			}
			else {
				dfs(child,visited,in,low,s);
				
//				If the low of the child node is bigger or equal to the in time of the parent node
//				then the parent node is an articulation point,
				// we'll also exclude the root node from this comparison
				if(low[child]>=in[s] || par!=-1) {
					set.add(s);
				}
				
				//reduce the low time of the parent
				low[s]=Math.min(low[s], low[child]);
				
				//if the node makes a dfs call then it is an unique branch
				children++;
			}
		}
		
		//for the root node, if it has more than 1 distinct children then it is also an articulation point
		if(par==-1 && children>1)
			set.add(s);
		
	}
}
