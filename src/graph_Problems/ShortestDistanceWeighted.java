package graph_Problems;

import java.util.*;

public class ShortestDistanceWeighted {
	
	public void shortestDistance(int s, int n, ArrayList<ArrayList<Pair2>> alist) {
		//topo sort
		Stack<Integer> stack = new Stack<>();
		topoSort(stack,n,alist);
		
		int[] dis = new int[n];
		for(int i=0;i<n;i++)
			dis[i]=Integer.MAX_VALUE;
		
		dis[s]=0;
		
		while(!stack.isEmpty()) {
			int node=stack.pop();
			
			if(dis[node]!=Integer.MAX_VALUE) {
				for(Pair2 i:alist.get(node)) {
					int child=i.first;
					int distance=i.second;
					
					distance+=dis[node];
					if(distance<dis[child])
						dis[child]=distance;
				}
			}
		}
		System.out.println("Starting node : "+s);
		for(int i=0;i<n;i++)
			System.out.println(i+"->"+dis[i]);
	}
	
	public void topoSort(Stack<Integer> stack, int n, ArrayList<ArrayList<Pair2>> alist) {
		// TODO Auto-generated method stub
		
		boolean[] visited=new boolean[n];
		
		for(int i=0;i<n;i++) {
			if(!visited[i])
				dfs(i,stack,alist,visited);
		}
		
	}

	public void dfs(int s, Stack<Integer> stack, ArrayList<ArrayList<Pair2>> alist, boolean[] visited) {
		// TODO Auto-generated method stub
		visited[s]=true;
		
		for(Pair2 i:alist.get(s)) {
			int child=i.first;
			if(visited[child]==false)
				dfs(child,stack,alist,visited);
		}
		
		stack.push(s);
		
	}

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		ArrayList<ArrayList<Pair2>> alist = new ArrayList<ArrayList<Pair2>>();
		
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
			
			alist.get(u).add(new Pair2(v, weight));
			
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
