package graph_Problems;
import java.util.*;
//Find MST of a given graph
public class Kruskal_Algo {
	
	public static int createMST(ArrayList<Node2> alist, DisjointSets obj) {
		
		Collections.sort(alist, new Comparator<Node2>() {

			@Override
			public int compare(Node2 o1, Node2 o2) {
				// TODO Auto-generated method stub
				return o1.weight-o2.weight;
			}
			
		});
		
		int total=0;
		
		for(Node2 i:alist) {
			int u=i.u;
			int v=i.v;
			int weight=i.weight;
			
			if(obj.findPar(u)!=obj.findPar(v)) {
				obj.union(u, v);
				System.out.println(u+"->"+v);
				total+=weight;
			}
			
		}
		
		return total;
	}
	
	public static void main(String[] args) {
		ArrayList<Node2> alist = new ArrayList<Node2>();
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int e=sc.nextInt();
		
		DisjointSets obj = new DisjointSets(n);
		
		while(e-->0) {
			int u=sc.nextInt();
			int v=sc.nextInt();
			int weight=sc.nextInt();
			
			alist.add(new Node2(u,v,weight));
		}
		
		System.out.println(createMST(alist, obj));
	}

}

class Node2{
	int u,v,weight;
	
	Node2(int u, int v, int weight){
		this.u=u;
		this.v=v;
		this.weight=weight;
	}

	@Override
	public String toString() {
		return "Node2 [u=" + u + ", v=" + v + ", weight=" + weight + "]";
	}
	
}
