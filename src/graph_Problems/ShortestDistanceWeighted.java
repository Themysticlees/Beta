package graph_Problems;

import java.util.*;
/*
 * Find the shortest distance from the source to every node in a directed and weighted graph
 */
public class ShortestDistanceWeighted {
	
	public void shortestDistance(int s, int n, ArrayList<ArrayList<Pair>> alist) {
		
		//First we'll do the topo sort
		//So we can start the iteration from a number which has least dependency
		//and ultimately we can reach from all the numbers
		Stack<Integer> stack = new Stack<>();
		topoSort(stack,n,alist);
		
		//initializing the distance array with max value
		int[] dis = new int[n];
		for(int i=0;i<n;i++)
			dis[i]=Integer.MAX_VALUE;
		
		//marking distance of souce node as 0
		dis[s]=0;
		
		while(!stack.isEmpty()) {
			int node=stack.pop();
			
			//if the node has not been reached then we can't travel from there
			//so we need a node which has been reached
			//the source node may not be the least dependent node thus
			//it wont be possible to reach all the nodes from the source in that case
			if(dis[node]!=Integer.MAX_VALUE) {
				for(Pair i:alist.get(node)) {
					//take out it's child and distance from the child
					int child=i.first;
					int distance=i.second;
					
					//add the distance with the current node distance and compare
					//if it is smaller then replace it
					distance+=dis[node];
					if(distance<dis[child])
						dis[child]=distance;
				}
			}
		}
		//Print the distance from each node
		System.out.println("Starting node : "+s);
		for(int i=0;i<n;i++)
			System.out.println(i+"->"+dis[i]);
	}
	
	public void topoSort(Stack<Integer> stack, int n, ArrayList<ArrayList<Pair>> alist) {
		// TODO Auto-generated method stub
		
		boolean[] visited=new boolean[n];
		
		for(int i=0;i<n;i++) {
			if(!visited[i])
				dfs(i,stack,alist,visited);
		}
		
	}

	public void dfs(int s, Stack<Integer> stack, ArrayList<ArrayList<Pair>> alist, boolean[] visited) {
		// TODO Auto-generated method stub
		visited[s]=true;
		
		for(Pair i:alist.get(s)) {
			int child=i.first;
			if(visited[child]==false)
				dfs(child,stack,alist,visited);
		}
		
		stack.push(s);
		
	}

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		ArrayList<ArrayList<Pair>> alist = new ArrayList<ArrayList<Pair>>();
		
		System.out.println("Enter the no.of nodes and edges");
		int n=sc.nextInt();
		int e=sc.nextInt();
		
		for(int i=0;i<=n;i++)
			alist.add(new ArrayList<>());
		
		System.out.println("Enter the pair of nodes which contains an edge and weight");
		while(e-->0)
		{
			int u=sc.nextInt();
			int v=sc.nextInt();
			int weight=sc.nextInt();
			
			alist.get(u).add(new Pair(v, weight));
			
		}
		
		new ShortestDistanceWeighted().shortestDistance(0, n, alist);
		
	}
	/*
	 *  0 1 2
		0 4 1
		1 2 3
		4 2 2
		2 3 6
		4 5 4
		
		5 3 1
	 */

}
