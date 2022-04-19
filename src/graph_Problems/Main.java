package graph_Problems;
import java.util.*;
class MyGraph {
	
	ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
	int n;
	
	MyGraph(int n,int e){
		this.n=n;
		for(int i=0;i<n;i++)
			alist.add(new ArrayList<>());
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the pair of nodes which contains an edge");
		while(e-->0)
		{
			int u=sc.nextInt();
			int v=sc.nextInt();
			
			addEdge(u, v);
		}
	}
	
	public void addEdge(int u, int v) {
		alist.get(u).add(v);
		alist.get(v).add(u);
	}
	
	public void DFS(int s) {
		boolean[] visited = new boolean[n];
		
		for(int i=0;i<n;i++) {
			if(visited[i]==false)
				DFShelper(i,visited);
		}
	}
	
	public void DFShelper(int s, boolean[] visited) {
		if(visited[s]==true)
			return;
		
		visited[s]=true;
		System.out.print(s+" ");
		
		for(int i:alist.get(s))
			DFShelper(i,visited);
	}
	
	public boolean detectCycle() {
		
		boolean[] visited=new boolean[n];
		
		return helper(1,1,visited);
	}
	
	public boolean helper(int s, int p, boolean[] visited) {
		
		
		visited[s]=true;
		
		for(int i:alist.get(s))
		{
			if(visited[i] && i!=p)
				return true;
			if(visited[i])
				continue;
			return helper(i,s,visited);
		}
		return false;
	}
	
}

public class Main{
	public static void main(String[] args) {
		
		MyGraph graph = new MyGraph(6, 4);
		System.out.println(graph.detectCycle());
		
	}
}
