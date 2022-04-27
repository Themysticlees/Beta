package graph_Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//convert a to b by changing 1 digit and the changed number should be a prime number
//calculate the min such operations required to change from a to b 
//a and b are both 4 digit number
public class PrimePath {
	
	ArrayList<ArrayList<Integer>> alist = new ArrayList<>();
	int n;
	
	public void addEdge(int u, int v) {
		alist.get(u).add(v);
		alist.get(v).add(u);
	}
		
	public void createGraph(int n) {
		
		List<Integer> list = new ArrayList<>();
		//Check all the 4digit primes and add them to the list
		for(int i=1000;i<=9999;i++) {
			if(isPrime(i))
				list.add(i);
		}
		//now two numbers will share a edge if only 1 digit differs between them
		for(int i=0;i<list.size();i++) {
			for(int j=i+1;j<list.size();j++) {
				int a=list.get(i);
				int b=list.get(j);
				
				//this function will check if a and b only have 1 dig diff
				if(valid(a,b))
					addEdge(a, b);
			}
		}
	}
	
	public boolean valid(int a, int b) {
		// TODO Auto-generated method stub
		
		int count=0;
		while(a>0 && b>0) {
			if(a%10!=b%10)
				count++;
			a/=10;
			b/=10;
		}
		if(count==1)
			return true;
		return false;
	}

	public boolean isPrime(int n) {
	// TODO Auto-generated method stub
		for(int i=2;i*i<=n;i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}

	public int primePath(int a, int b) {
		
		boolean[] visited=new boolean[10001];
		//the distance required to reach that number from the root node
		int[] distance=new int[10001];
		//for storing the parent of each number
		int[] parent=new int[10001];
		
		createGraph(n);
		//we fill the arrays with -1 as -1 indicates that no solution is obtained
		Arrays.fill(distance, -1);
		Arrays.fill(parent, -1);
		//distance a should be 0
		distance[a]=0;
		bfs(a,visited,distance,parent);
		
		//if after performing bfs, distance[b] still remains -1, then it is impossible to reach b from a
		if(distance[b]==-1)
			return -1;
		//otherwise we print the path from a to b
		//the path may differ but it is correct
		int p=b;
		do{
			System.out.println(p);
			p=parent[p];
		}while(p!=a);
		
		System.out.println(a);
		
		return distance[b];
	}

	public void bfs(int a, boolean[] visited, int[] distance,int[] parent) {
	// TODO Auto-generated method stub
		
		Queue<Integer> queue=new LinkedList<>();
		queue.add(a);
		visited[a]=true;
		
		while(!queue.isEmpty()) {
			int curr=queue.poll();
			
			for(int i:alist.get(curr)) {
				if(visited[i]==false) {
					//we visit the child node
					//initialize it's distance
					//and update it's parent
					visited[i]=true;
					distance[i]=1+distance[curr];
					parent[i]=curr;
					queue.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new PrimePath().primePath(1373 , 8017));
	}
}
