package graph_Problems;
import java.util.*;
//Function to find number of strongly connected components in the graph.
/*
 * Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, 
 * Find the number of strongly connected components in the graph.
 */
public class KosarajuAlgo {
	
	//There are 3 steps:
	//1. do a DFS call and fill the stack according to the out time of the nodes
	//2. Reverse the graph (A->B) => (B->A)
	//3. now pop out each element from a stack and do a dfs call, all the nodes which will be visited
	//   through this dfs call will belong to one Strong connected component.
	//	 Similarly we'll also maintain a visited array, which will check if the element popped out from
	//	 the stack has already been visited or not, if not then it is a part of a new Strongly connected
	//	 components
	
    public int kosaraju(int n, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        Stack<Integer> stack = new Stack<>();
        boolean[] visited=new boolean[n];
        
        //storing the elements in the stack according to their out time
        for(int i=0;i<n;i++){
            if(visited[i]==false)
                dfshelper(i,visited,stack,adj);
        }
        
        //then reverse the graph
        adj=reverseGraph(adj,n);
        Arrays.fill(visited,false);
        
        int count=0;
        
        //now for every element in the stack if it is not visited, perform a dfs and increase count
        //we can also print the strongly connected components, just add a sysout in the dfshelper2 function
        while(!stack.isEmpty()){
            int curr=stack.pop();
            
            if(visited[curr])
                continue;
            
            dfshelper2(curr,visited,adj);
            count++;
        }
        
        return count;
    }
    
    public ArrayList<ArrayList<Integer>> reverseGraph(ArrayList<ArrayList<Integer>> alist,int n) {
			// TODO Auto-generated method stub
			ArrayList<ArrayList<Integer>> templist = new ArrayList<>();
			
			for(int i=0;i<n;i++)
				templist.add(new ArrayList<>());
			
			for(int i=0;i<n;i++) {
				for(int child:alist.get(i)) {
					templist.get(child).add(i);
				}
			}
			
			return templist;	
	
	}
	
	public void dfshelper(int s, boolean[] visited, Stack<Integer> stack, 
	ArrayList<ArrayList<Integer>> alist) {
			// TODO Auto-generated method stub
			
			visited[s]=true;
			
			for(int child:alist.get(s)) {
				if(visited[child]==false)
					dfshelper(child,visited,stack,alist);
			}
			stack.push(s);
	}
	
	public void dfshelper2(int s, boolean[] visited,ArrayList<ArrayList<Integer>>alist) {
		if(visited[s]==true)
			return;
		
		visited[s]=true;
		//System.out.print(s+"->");
		
		for(int i:alist.get(s))
			dfshelper2(i,visited,alist);
	}

}
