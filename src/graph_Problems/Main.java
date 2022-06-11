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

	int[] topoSort() 
    {
        // add your code here
        int[] in = new int[n+1];
		indegree(n,in,alist);
		
		PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
			
		});
		
		for(int i=1;i<=n;i++) {
			//First we'll insert the starting nodes in the queue
			//as they don't have any parents
			if(in[i]==0)
				queue.add(i);
		}
		int[] res=new int[n+1];
		int k=0;
		
		while(!queue.isEmpty()) {
			int curr=queue.poll();
			res[k++]=curr;
			//now remove the edge which this particular node is connected with
			//thus removing it's indegree to get the next node which has no parents remaining
			//This is how we'll get a linear order
			for(int child:alist.get(curr)) {
				in[child]--;
				if(in[child]==0)
					queue.add(child);
			}
		}
		return res;
    }
    
    public static void indegree(int n,int[] in,ArrayList<ArrayList<Integer>> alist) {
		
		for(int i=1;i<=n;i++) {
			//we'll increase the indegree of the children as they have an incoming edgeb  
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
		
		Testing.Main.printArray(graph.topoSort());
		
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
