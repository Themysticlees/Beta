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
		System.out.print(s+" ");
		
		for(int i:alist.get(s))
			DFShelper(i,visited);
	}

	
//-------------------------------------------------------------------------------------------------------
	
	//Kahn's algo
	public void topo_sort() {
		
		int[] in = new int[n];
		indegree(in);
		
		Queue<Integer> queue=new LinkedList<>();
		
		for(int i=0;i<n;i++) {
			if(in[i]==0)
				queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			int curr=queue.poll();
			System.out.println(curr);
			for(int child:alist.get(curr)) {
				in[child]--;
				if(in[child]==0)
					queue.add(child);
			}
		}
		
	}
	
	public void indegree(int[] in) {
		
		for(int i=0;i<n;i++) {
			for(int child:alist.get(i))
				in[child]++;
		}
		
	}
//---------------------------------------------------------------------------------------------------
	
}

public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		MyGraph graph = new MyGraph();
		graph.topo_sort();
		
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
