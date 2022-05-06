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
	int timer;
	boolean hasBridge;
	
	ArrayList<Pair2> edges=new ArrayList<Pair2>();
	
	public void bertownRoads() {
		
		boolean[] visited=new boolean[n+1];
		int[] in = new int[n+1];
		int[] low = new int[n+1];
		
		helper(1,-1,visited, in, low);
		
		if(!hasBridge) {
			for(Pair2 i:edges) {
				System.out.println(i.first+"-"+i.second);
			}
		}
		else
			System.out.println(0);
	}
	
	public void helper(int s, int parent, boolean[] visited, int[] in, int[] low) {
		
		in[s]=low[s]=timer++;
		
		visited[s]=true;
		
		for(int child:alist.get(s)) {
			if(child==parent)
				continue;
			if(visited[child]) {
				//back edge
				low[s]=Math.min(low[s], in[child]);
				
				if(in[child]<in[s])
					edges.add(new Pair2(s,child));
			}
			else {
				//front edge
				helper(child,s,visited,in,low);
				
				if(low[child]>in[s])
				{
					hasBridge=true;
					return;
				}
				
				low[s]=Math.min(low[s], low[child]);
				
				edges.add(new Pair2(s,child));
			}
		}
	}
	
//---------------------------------------------------------------------------------------------------
	
}

public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		MyGraph graph = new MyGraph();
		graph.bertownRoads();
		
	}
}

class Pair2
{
	int first;
	int second;
	
	public Pair2(int first, int second) {
		// TODO Auto-generated constructor stub
		this.first=first;
		this.second=second;
	}

	@Override
	public String toString() {
		return "Pair [first=" + first + ", second=" + second + "]";
	}

}
