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

	
	
//---------------------------------------------------------------------------------------------------

	
}

public class Main{
	
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		MyGraph graph = new MyGraph();
		
//		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
//		
//		
//		int con=1;
//		while(con==1) {
//			
//			int u=sc.nextInt();
//			int v=sc.nextInt();
//			int w=sc.nextInt();
//			
//			ArrayList<Integer> temp = new ArrayList<Integer>();
//			temp.add(u);
//			temp.add(v);
//			temp.add(w);
//			
//			adj.add(temp);
//			
//			//System.out.println("Do you want to continue ? (1/0)");
//			
//			con=sc.nextInt();
//		}
		
		
	
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
