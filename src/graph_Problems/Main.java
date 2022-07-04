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
		//alist.get(v).add(u);
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
		System.out.print(s+"->");
		
		for(int i:alist.get(s))
			DFShelper(i,visited);
	}

	
//-------------------------------------------------------------------------------------------------------

	public int LCA(int a, int b) {
		
		int[] level=new int[n];
		int[] par=new int[n];
		Arrays.fill(par, -1);
		;
		
		levelOrderTraversal(0, level,par);
		
		return helper(a,b,level,par);
	}
	
	public int helper(int a, int b, int[] level,int[] par) {
		
		if(level[b]>level[a])
			helper(b,a,level,par);
		
		int diff=level[a]-level[b];
		
		while(diff-->0) {
			a=par[a];
		}
		
		while(par[a]!=par[b]){
			a=par[a];
			b=par[b];
		}
		
		return par[a];
	
	}

	int lvl=0;
	
	public void levelOrderTraversal(int s,int[] level, int[] par) {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		lvl++;
		
		while(!queue.isEmpty()) {
			int node=queue.poll();
			
			for(int child:alist.get(node)) {
				level[child]=lvl;
				par[child]=node;
			}
			lvl++;
		}
		
		
	}
	
//---------------------------------------------------------------------------------------------------

	
}

public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		MyGraph graph = new MyGraph();
		
		
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
