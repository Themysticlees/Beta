package graph_Problems;
import java.util.*;

public class Topological_Sort {
	//Only for DAG (Directed Acyclic Graph)
	//If there exists an edge between u and v (u->v), then u must appear before v in the sorted order.
	static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
		//We are using stack to store the elements 
		//Elements which come at the last and have no children  will be added first thus fulfilling 
		//our conditions
        Stack<Integer> stack=new Stack<>();
        int n=adj.size();
        boolean[] visited=new boolean[n];
        
        //check for every vertex
        for(int i=0;i<V;i++){
            if(!visited[i])
                dfs(i,visited,adj,stack);
        }
        int[] res=new int[V];
        int k=0;
        
        while(!stack.isEmpty()){
           
            res[k++]=stack.pop();
            
        }
        
        return res;
    }
    
	//DFS
    public static void dfs(int s, boolean[] visited, ArrayList<ArrayList<Integer>> adj,
                                    Stack<Integer> stack){
    
        visited[s]=true;
        
        for(int child:adj.get(s)){
            if(visited[child]==false)
                dfs(child,visited,adj,stack);
        }
        
        //when the function call of that particular element is finished then add it to the stack
        //if u->v, then function call of v will finish first thus it will be added before u.
        stack.push(s);
    }

}
