package graph_Problems;
import java.util.*;
import Testing.Main;
/*
 * Given a weighted, undirected and connected graph of V vertices and E edges, 
 * Find the shortest distance of all the vertex's from the source vertex S.
 */
public class Dijkstras_Algorithm {
	//We'll put the nodes in a priority queue (Min heap) instead of queue because we want 
	//to find the route using the nodes which has less weight until1 now
	public static int[] dijkstrasAlgo(int s,ArrayList<ArrayList<Pair>> alist, int n, int[] par) {
			
		int[] dis = new int [n];
		
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return o1.second-o2.second;
			}
			
		});
		
		Arrays.fill(dis, Integer.MAX_VALUE);
		
		dis[s]=0;
		//for storing the parent so later on we can print the entire shortest path 
		par[s]=0;
		
		pq.add(new Pair(s,0));
		
		while(!pq.isEmpty()) {
			//taking out the least weight node
			Pair curr=pq.poll();
			int node=curr.first;
			int weight=curr.second;
			
			//traversing through the children
			for(Pair i:alist.get(node)) {
				int child=i.first;
				int cweight=i.second;
				
				//add the weight of the node to it's children and check if is less than the previous
				//also change it's parent
				//and it in the pq
				cweight+=weight;
				if(cweight<dis[child])
				{
					dis[child]=cweight;
					par[child]=node;
					pq.add(new Pair(child,cweight));
				}
			}
			
		}
		
		return dis;
	}
	
	public static void main(String[] args) {
		
		ArrayList<ArrayList<Pair>> alist = new ArrayList<ArrayList<Pair>>();
		
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		
		for(int i=0;i<=n;i++) {
			alist.add(new ArrayList<>());
		}
		int e=sc.nextInt();
		
		while(e-->0) {
			int u=sc.nextInt();
			int v=sc.nextInt();
			int weight=sc.nextInt();
			
			alist.get(u).add(new Pair(v,weight));
			alist.get(v).add(new Pair(u,weight));
		}
		
		int[] par=new int[n];
		Arrays.fill(par, -1);
		
		int[] dis = dijkstrasAlgo(1, alist, n,par);
		
		
		Main.printArray(par);
		Main.printArray(dis);
		
		int des=5;
		System.out.print("Shortest Distance \n"+des+"->");
		while(des!=1) {
			System.out.print(par[des]+"->");
			des=par[des];
		}
	}
	

}
