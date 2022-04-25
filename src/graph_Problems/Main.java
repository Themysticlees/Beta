package graph_Problems;
import java.util.*;
class MyGraph {
	
	ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
	int n;
	
	MyGraph(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no.of nodes and edges");
		int n=sc.nextInt();
		int e=sc.nextInt();
		
		this.n=n;
		for(int i=0;i<n;i++)
			alist.add(new ArrayList<>());
		
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

	
//-------------------------------------------------------------------------------------------------------

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
			if(visited[i]==false)
				size[s]+=dfs(i,visited,size);
		}
		size[s]++;
		return size[s];
	}
	
//---------------------------------------------------------------------------------------------------
	
	
}

public class Main{
	public static void main(String[] args) {
		
		MyGraph graph = new MyGraph();
		System.out.println(Arrays.toString(graph.subtree_size()));
	}
}
