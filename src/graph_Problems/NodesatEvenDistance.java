package graph_Problems;
import java.util.*;

/*
 * Given a connected acyclic graph with n nodes and n-1 edges, 
 * count the pair of nodes that are at even distance(number of edges) from each other.
 * 
 * Input:
	n = 3
	graph = {{}, {2}, {1, 3}, {2}}
	Output: 1
	Explaination: Here there are three pairs {1,2},{1,3}
	and {2,3} and only {1,3} has even distance between them.
	i.e           1
	             /
	            2
	           /
	          3
	          
	n = 5
	graph = {{}, {2,4}, {1,3}, {2}, {1,5}, {4}}
	Output: 4
	Explaination: There are four pairs {1,3},{1,5},{2,4}
	and {3,5} which has even distance.
 */
public class NodesatEvenDistance {
	
	//For every odd to odd node, there is an even distance
	//For every even to even node, there is an odd distance
	//So we'll calculate the no.of odds and evens and then they'll form pairs among themselves
	//If there are n numbers, no.of pairs among them = n*(n-1)/2;

	int countOfNodes(ArrayList<ArrayList<Integer>> graph, int n) 
    {
        // Write your code here
        boolean[] visited = new boolean[n+1];
        
        //Since 1 is odd, we'll get all the odd nodes as the answer as 1 will make an even distance
        //with the odd nodes
        int[] count= {0};
        countPairs(1,graph,visited,0,count);
        
        if(count[0]==0)
            return 0;
        //no.of even nodes = n-no.of odd nodes
        //calculate the pairs both odds and evens will form and add them
        return count[0] * (count[0] - 1) / 2 + (n - count[0]) * (n - count[0] - 1) / 2;
    }
    
    void countPairs(int i,ArrayList<ArrayList<Integer>> graph, boolean[] visited,
                                    int count, int[] pairs){
        
    	//as we move from one node to the other, we increase count
    	//if we move 2 or 4 nodes, i.e even distance then add 1 as they make a pair
        if((count&1)==0)
            pairs[0]++;
        
        //mark the current node as visited
        visited[i]=true;
        
        //check for the other nodes that can make a pair with 1
        //Generally all the odds will make pairs with 1, thus we'll get the total no.of odds in the graph
        for(int j:graph.get(i))
        {
            if(visited[j]==false)
                countPairs(j,graph,visited,count+1,pairs);
        }
    }
    
    //---------------------Another approach---------------------------
    
    /*
     * If odd numbers donot make pairs with odd numbers then we need to check the pairings for every node
     * 
     static int countOfNodes(ArrayList<ArrayList<Integer>> graph, int n) 
    {
        //for the nodes which are already visited
        int[] visited = new int[n];
        
        //this will store the no.of pairs, since arrays are mutable 
        int[] pairs= {0};
        for(int i=1;i<n;i++){
        	//creating a temp array and finding the no.of pairs for ith node
        	int[] temp = visited.clone();
            countPairs(i,graph,temp,0,pairs);
            
            //we'll mark i by -1 as this node is already visited and to avoid duplicate pairs
            visited[i]=-1;
        }
        return pairs[0];
    }
    
    //DFS
    static void countPairs(int i,ArrayList<ArrayList<Integer>> graph, int[] visited,
                                int count, int[] pairs){
        //If the node is already visited
        if(visited[i]==1)
            return;
        
        //if count is even and visited is not -1, i.e pairing is already present
        //eg: (1,2) exists then we dont need (2,1) as they are same
        //We donot mark them 1 at the begining as we need to check for the others through that node
        if(count>=2 && (count&1)==0 && visited[i]!=-1)
            pairs[0]++;
        visited[i]=1;
        
        //now go to the other connecting nodes and each time increase count by 1 denoting the distance
        for(int j:graph.get(i))
            countPairs(j,graph,visited,count+1,pairs);
    }
    */
}
