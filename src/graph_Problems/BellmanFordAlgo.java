package graph_Problems;
import java.util.*;

/*
 * Given a weighted, directed and connected graph of V vertices and E edges, 
 * Find the shortest distance of all the vertex's from the source vertex S.
 * Used to find the shortest distance for graphs containing negative weight
 */

public class BellmanFordAlgo {
	
	//Here we use the term relaxation
	//It means every node shall be relaxed or finished checking after n-1 times
	//We will keep on checking to find the shortest path from the source to every node
	static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> adj, int S)
    {
        //Initialize a distance array and fill all the nodes with infinity or max value
		int[] dis=new int[V+1];
		
		for(int i=0;i<dis.length;i++)
			dis[i]=Integer.MAX_VALUE;
		
		//as we are starting from source
		dis[S]=0;
		
		//we'll perform the same check n-1 times as the values will keep on changing because of the negative weights  
		for(int x=1;x<=V-1;x++)
			for(int i=0;i<adj.size();i++) {
				//now check every edge
				int u=adj.get(i).get(0);
				int v=adj.get(i).get(1);
				int w=adj.get(i).get(2);
				
				//if u is not visited then skip and move to the next edge
				if(dis[u]==Integer.MAX_VALUE)
					continue;
				
				//otherwise check if the curr dist and weight is less than the dist of v
				//if yes update the value and continue checking
				if(dis[u]+w<dis[v])
					dis[v]=dis[u]+w;
			}
		
		return dis;
        
    }
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		
		
		int con=1;
		while(con==1) {
			
			int u=sc.nextInt();
			int v=sc.nextInt();
			int w=sc.nextInt();
			
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(u);
			temp.add(v);
			temp.add(w);
			
			adj.add(temp);
			
			//System.out.println("Do you want to continue ? (1/0)");
			
			con=sc.nextInt();
		}
		
		bellman_ford(4, adj, 1);
	}

}
