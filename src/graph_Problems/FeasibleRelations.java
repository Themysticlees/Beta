package graph_Problems;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * As a programmer, you sometimes have to deal with some math and this is the time to do it. 
 * You are given a list of binary relations, equalities and inequalities, like a = b, a != d, b = c etc. 
 * Your task is to output YES if you can assign integers to input variables in such a way, 
 * that you can satisfy all equalities and inequalities. Otherwise you should output NO.
 */
public class FeasibleRelations {
	//We have to check whether all the relations are feasible
	
	public static void helper(int s, boolean[] visited, int ccno, int[] cc, ArrayList<ArrayList<Integer>> alist) {
		
		visited[s]=true;
		cc[s]=ccno;
		
		for(int i:alist.get(s)) {
			if(visited[i]==false)
				helper(i,visited,ccno,cc,alist);
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0) {
			int n=sc.nextInt();
			MyGraph graph = new MyGraph(n);
			
			int rel=sc.nextInt();
			
			ArrayList<Pair> list = new ArrayList<>();
			while(rel-->0) {
				//We'll take input all the relations
				int a=sc.nextInt();
				String op=sc.next();
				int b=sc.nextInt();
				
				//if there is an "=" operator then we'll basically create an edge between them
				//which signifies they are equal
				if(op.equals("=")) {
					graph.addEdge(a, b);
				}
				else
				{
					//otherwise we'll keep that pair in a List
					list.add(new Pair(a, b));
				}
				
			}
			
			int[] cc=new int[n+1];
			int ccno=0;
			boolean[] visited = new boolean[n+1];
			
			//Now we'll assign the component number to each node present in the graph
			for(int i=1;i<=n;i++) {
				if(visited[i]==false) {
					ccno++;
					helper(i,visited,ccno,cc,graph.alist);
				}
			}
			int f=0;
			//Now let's iterate the list which has all the "!=" relations
			//if the component number of both the nodes are same then they are equal but in the provided
			//relation they are unequal, thus we'll return "NO", otherwise return "YES"
			for(int i=0;i<list.size();i++) {
				int a=list.get(i).first;
				int b=list.get(i).second;
				
				if(cc[a]==cc[b]) {
					System.out.println("NO");
					f=1;
					break;
				}
			}
			
			if(f==0)
				System.out.println("YES");
		}
	
	}

}
