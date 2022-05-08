package graph_Problems;
import java.util.*;

//Topological sort using BFS (Kahn's Algo)
//Here we use the concept of indegree
//The nodes which have indegree 0, means they have no parents thus they'll be printed first
//then one by one we'll start removing the parent edges and once a node has zero parents, we'll print that
//Thus we'll maintain the linear order
public class Kahn_Algo {
	
	static int[] topoSort(int n, ArrayList<ArrayList<Integer>> alist) 
    {
        // add your code here
        int[] in = new int[n];
		indegree(n,in,alist);
		
		Queue<Integer> queue=new LinkedList<>();
		
		for(int i=0;i<n;i++) {
			//First we'll insert the starting nodes in the queue
			//as they don't have any parents
			if(in[i]==0)
				queue.add(i);
		}
		int[] res=new int[n];
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
		
		for(int i=0;i<n;i++) {
			//we'll increase the indegree of the children as they have an incoming edgeb  
			for(int child:alist.get(i))
				in[child]++;
		}
		
	}

}
