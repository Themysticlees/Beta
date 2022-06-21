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

	int timer=1;
    ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
    
    public ArrayList<ArrayList<Integer>> tarjans() 
    {
        // code here
        Stack<Integer> stack = new Stack<>();
        boolean[] active=new boolean[n];
        boolean[] visited=new boolean[n];
        int[] low=new int[n];
        int[] in=new int[n];
        
        for(int i=0;i<n;i++){
            if(visited[i]==false)
                dfshelper(i,visited,stack,active,low,in);
        }
        // Collections.sort(ans,Collections.reverseOrder());
        return ans;
    }
    
    
    
    public void dfshelper(int s, boolean[] visited, Stack<Integer> stack, 
        boolean[] active, int[] low,int[] in)
    {
        in[s]=low[s]=timer++;
        visited[s]=true;
        stack.push(s);
        active[s]=true;
        
        for(int child:alist.get(s)){
            if(visited[child] && active[child]){
                low[s]=Math.min(low[s],in[child]);
            }
            else{
                dfshelper(child,visited,stack,active,low,in);
                
                if(active[child]){
                    low[s]=Math.min(low[s],low[child]);
                }
            }
        }
        
        if(low[s]==in[s]){
            ArrayList<Integer> temp=new ArrayList<>();
            while(true){
                int curr=stack.pop();
                temp.add(curr);
                active[curr]=false;
                if(curr==s)
                    break;
            }
            Collections.sort(temp);
            ans.add(0,temp);
        }
        
    }
	
//---------------------------------------------------------------------------------------------------

	
}

public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		MyGraph graph = new MyGraph();
		graph.tarjans();
		
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
