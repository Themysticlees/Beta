package graph_Problems;
import java.util.*;

/* Problem link : https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 * 
 * There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network 
 * where connections[i] = [ai, bi] represents a connection between computers ai and bi. 
 * Any computer can reach any other computer directly or indirectly through the network.
 * You are given an initial computer network connections. You can extract certain cables between two 
 * directly connected computers, and place them between any pair of disconnected computers to make them
 *  directly connected.
 *  Return the minimum number of times you need to do this in order to make all the computers connected. 
 *  If it is not possible, return -1.
 *  
 *  Input: n = 4, connections = [[0,1],[0,2],[1,2]]
	Output: 1
	Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
 */
public class MakeConnected {
	//We need to count the no.of connected components, subtract -1 thus we'll get the disconnected computers
	//Now we need that many back edges so that we can connect all the computers
	//back edge =  extra or useless edge
	public static int makeConnected(int n, int[][] connections) {
		
		//creating the adjacency list
        ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
        for(int i=0;i<n;i++)
            alist.add(new ArrayList<>());
        
        for(int i=0;i<connections.length;i++){
            int a=connections[i][0];
            int b=connections[i][1];
            
            alist.get(a).add(b);
            alist.get(b).add(a);
        }
        
        int[] edges = {0};
        int nodes=-1;
        boolean[] visited=new boolean[n];
        
        //Counting the Connected Components
        for(int i=0;i<alist.size();i++){
           if(visited[i]==false){
               nodes++;
                helper(i,-1,visited,edges,alist);
           }
            
        }
        //we'll get twice the no.of back edge because we'll get the edge two times for two nodes
        //thus we'll divide the number / 2  to get the correct number
        if(edges[0]/2>=nodes)
            return nodes;
        return -1;
        
    }
    //DFS
    static void helper(int s, int parent, boolean[] visited, int[] edges,ArrayList<ArrayList<Integer>> alist){
        
        visited[s]=true;
        
        for(int i:alist.get(s)){
        	//if the child is the parent then continue
            if(i==parent)
                continue;
            //if it is visited already and not it's parent then we can say that edge is a back edge
            else if(visited[i]==true)
                edges[0]++;
            //otherwise do a recursive call
            else
                helper(i,s,visited,edges,alist);
        }
    }
    
    public static void main(String[] args) {
    	
    	int[][] conn= {{0,1},{0,2},{0,3},{1,2}};
		
		System.out.println(makeConnected(6, conn));
	}

}
