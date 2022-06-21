package graph_Problems;
import java.util.*;

//Function to return a list of lists of integers denoting the members 
//of strongly connected components in the given graph.
public class TarjanAlgo {
	
	/*
	 * This Algo is similar to finding articulation points using in and low time
	 * We'll calculate the in and low time of every node.
	 * We'll maintain a stack which will have all the active nodes(dfs call active)
	 * And we'll keep a boolean active array to check whether a particular node is active or not
	 * and we also need a visited array
	 * 
	 * Now we do a dfs call, if the child of the current node is visited and it is active
	 * then minimize the low time with the child's in time
	 * if the child is not visited, then do a dfs call for the child , after it is over
	 * check whether the child is active or not and then minimize the low time with child's low time
	 * 
	 * after the dfs call is over for the current node, check if the in time and low time is same,
	 * if it is same, this indicates this is the root of a SCC(Strongly Connected Component), 
	 * start poping from the stack untill we reach the curr node in the stack, all the nodes popped along 
	 * with the curr node will become 1 SCC. Remember to mark them false in the active array
	 * Now continue the dfs call for the other nodes. These nodes which formed a SCC are marked unactive
	 * thus they will never be part of any other SCC.
	 */
	int timer=1;
    ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
    
    public ArrayList<ArrayList<Integer>> tarjans(int n, 
                                        ArrayList<ArrayList<Integer>> adj) 
    {
//    	We'll maintain a stack which will have all the active nodes(dfs call active)
//   	And we'll keep a boolean active array to check whether a particular node is active or not
//   	and we also need a visited array
        Stack<Integer> stack = new Stack<>();
        boolean[] active=new boolean[n];
        boolean[] visited=new boolean[n];
        int[] low=new int[n];
        int[] in=new int[n];
        
        for(int i=0;i<n;i++){
            if(visited[i]==false)
                dfshelper(i,visited,stack,active,adj,low,in);
        }
        
        //sort to print the list in lexographical manner
        Collections.sort(ans, (a, b) -> a.get(0) - b.get(0));
        return ans;
    }
    
    
    
    public void dfshelper(int s, boolean[] visited, Stack<Integer> stack, 
        boolean[] active,ArrayList<ArrayList<Integer>> alist, int[] low,int[] in)
    {
    	//Mark the curr node active, push it in the stack, put it's in and low time
        in[s]=low[s]=timer++;
        visited[s]=true;
        stack.push(s);
        active[s]=true;
        
        for(int child:alist.get(s)){
        	
//        	if the child of the current node is visited and it is active
//       	then minimize the low time with the child's in time
            if(visited[child] && active[child]){
                low[s]=Math.min(low[s],in[child]);
            }
//          if the child is not visited, then do a dfs call for the child , after it is over
//       	check whether the child is active or not and then minimize the low time with child's low time
            else if(visited[child]==false){
                dfshelper(child,visited,stack,active,alist,low,in);
                
                if(active[child]){
                    low[s]=Math.min(low[s],low[child]);
                }
            }
        }
        
//       * check if the in time and low time is same,
//   	 * if it is same, this indicates this is the root of a SCC(Strongly Connected Component), 
//   	 * start poping from the stack until we reach the curr node in the stack, all the nodes popped along 
//   	 * with the curr node will become 1 SCC. Remember to mark them false in the active array
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
            ans.add(temp);
        }
        
    }

}
