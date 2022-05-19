package graph_Problems;

public class DisjointSets {
	
	int[] par = new int[10000];
	int[] rank = new int[10000];
	
	public DisjointSets(int n) {
		// TODO Auto-generated constructor stub
		for(int i=0;i<=n;i++) {
			par[i]=i;
		}
	}
	
	public int findPar(int a) {
		
		if(par[a]==a)
			return a;
		
		return par[a]=findPar(par[a]);
	}
	
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
