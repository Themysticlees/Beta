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
	
	public boolean isPossible(int N)
    {
        // Your Code goes here
        
        boolean[] visited=new boolean[N];
        int[] status=new int[N];
        
        for(int i=0;i<N;i++){
            boolean f=(iscyclic(i,visited,status));
            if(f==true)
                return false;
        }
        return true;
    }
    
    public boolean iscyclic(int s, boolean[] visited, int[] status){
        //status=1=running
        //status=0=finished
        visited[s]=true;
        status[s]=1;
        
        for(int child:alist.get(s)){
            if(visited[child] && status[child]==1)
                return true;
            if(visited[child]==false){
                if(iscyclic(child,visited,status)==true)
                    return true;
            }
        }
        
        status[s]=0;
        return false;
    }
	
//---------------------------------------------------------------------------------------------------
	
}

public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		MyGraph graph = new MyGraph();
		System.out.println(graph.isPossible(graph.n));
		
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
