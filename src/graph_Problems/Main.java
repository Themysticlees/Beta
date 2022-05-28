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
		for(int i=0;i<=n;i++)
			alist.add(new ArrayList<>());
		
		System.out.println("Enter the pair of nodes which contains an edge");
		while(e-->0)
		{
			int u=sc.nextInt();
			int v=sc.nextInt();
			
			addEdge(u, v);
		}
	}
	
	MyGraph(int n){
		this.n=n;
		for(int i=0;i<=n;i++)
			alist.add(new ArrayList<>());
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

	int timer=0;
	Set<Integer> set = new HashSet<>();
	public void findArticulationPoints() {
		
		boolean[] visited=new boolean[n+1];
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
		
		for(int child:alist.get(s)) {
			if(child==par)
				continue;
			if(visited[child]) {
				low[s]=Math.min(low[s], in[child]);
			}
			else {
				dfs(child,visited,in,low,s);
				
				if(low[child]>in[s]) {
					set.add(child);
					set.add(s);
				}
				
				low[s]=Math.min(low[s], low[child]);
			}
		}
		
	}
//---------------------------------------------------------------------------------------------------

	
	
}

public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		MyGraph graph = new MyGraph();
		
		graph.findArticulationPoints();
	}
}

class Pair
{
	int first;
	int second;
	
	public Pair(int first, int second) {
		// TODO Auto-generated constructor stub
		this.first=first;
		this.second=second;
	}

	@Override
	public String toString() {
		return "Pair [first=" + first + ", second=" + second + "]";
	}

}
