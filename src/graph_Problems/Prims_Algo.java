package graph_Problems;
import java.util.*;

/*
 * Given a weighted, undirected and connected graph of V vertices and E edges. 
 * The task is to find the sum of weights of the edges of the Minimum Spanning Tree.
 */
public class Prims_Algo {
	
	static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
		
		//We need to initialize 3 arrays to store 
		//key=the current weight to reach the node
		//par=parent of the node
		//mst=is the node part of mst
		
		int [] key = new int[V];
		int [] par=new int[V];
		boolean[] mst = new boolean[V];
		
		for(int i=0;i<V;i++) {
			key[i]=Integer.MAX_VALUE;
			par[i]=-1;
			mst[i]=false;
		}
		key[0]=0;
		
		//we are taking priority queue
		//because every time we'll take the node which has min weight and start our traversal
		//to save time we can use a min heap
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.weight-o2.weight;
			}
			
		});
		
		//adding the first node
		pq.add(new Node(0,key[0]));
		
		while(!pq.isEmpty()) {
			Node curr=pq.remove();
			
			int node=curr.node;
			//int weight=curr.weight;
			
			//marking mst of the current node as true
			mst[node]=true;
			
			//iterating for it's children
			for(ArrayList<Integer> i:adj.get(node)) {
				int child=i.get(0);
				int weight=i.get(1);
				
				//if the child is already a part of mst then skip
				//otherwise update it's key, parent and add it to the priority queue
				if(mst[child]==false && weight<key[child]) {
					par[child]=node;
					key[child]=weight;
					pq.add(new Node(child,key[child]));
				}
			}
		}
		int sum=0;
		for(int i=1;i<V;i++) {
			System.out.println(par[i]+"->"+i);
			sum+=key[i];
		}
		
		return sum;
		
	}
	
	public static void main(String[] args) {
		 ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
		 Scanner sc=new Scanner(System.in);
		 int V=sc.nextInt();
		 int e=sc.nextInt();
		 
		 
		 for(int i=0;i<V;i++) {
			 adj.add(new ArrayList<>());
		 }
		 
		 while(e-->0) {
			 int u=sc.nextInt();
			 int v=sc.nextInt();
			 int w=sc.nextInt();
			 ArrayList<Integer> list1 = new ArrayList<Integer>();
			 list1.add(v);
			 list1.add(w);
			 
			 adj.get(u).add(list1);
			 
			 ArrayList<Integer> list2 = new ArrayList<Integer>();
			 
			 list2.add(u);
			 list2.add(w);
			 
			 adj.get(v).add(list2);
			 
		 }
		 
		 System.out.println(spanningTree(V, adj));
		
	}

}

class Node{
	int node;
	int weight;
	
	Node(int node, int weight){
		this.node=node;
		this.weight=weight;
	}
}

