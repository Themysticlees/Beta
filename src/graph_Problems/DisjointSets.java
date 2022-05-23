package graph_Problems;

//This Data structure is used to detect cycles in a graph
//and thus used in Kruskal algo for finding MST
public class DisjointSets {
	
	int[] par = new int[10000];
	int[] rank = new int[10000];
	
	public DisjointSets(int n) {
		// TODO Auto-generated constructor stub
		//initially we are initializing the parents of each node as themselves
		//the top node of a component will always have it's parent as itself 
		for(int i=0;i<=n;i++) {
			par[i]=i;
		}
	}
	
	//This method will find the topmost or root parent of this node
	public int findPar(int a) {
		
		//if we reach the root node, then return
		if(par[a]==a)
			return a;
		
		//otherwise do a recursive call and assign the top parent as this node's parent
		return par[a]=findPar(par[a]);
	}
	
	//this method connects two nodes or components
	//if two nodes have same rank then increase the rank of the parent node
	//otherwise the node with larger rank will be the parent of the other
	public void union(int u, int v) {
		
		if(rank[u]>rank[v])
			par[v]=u;
		else if(rank[v]>rank[u])
			par[u]=v;
		else {
			par[v]=u;
			rank[u]++;
		}
		
	}
	
	public static void main(String[] args) {
		
		DisjointSets ob = new DisjointSets(5);
		ob.union(1, 2);
		ob.union(2, 3);
		ob.union(4, 5);
		
		System.out.println(ob.findPar(3));
	}

}
