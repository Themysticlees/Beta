package Testing;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Node {
	 
	int data;
    Node next;

    Node(int item)
    {
        data = item;
        next=null;
    }

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}

	
	
}

class Pair{
    
	int index;
    int rating;
    
    Pair(int index, int rating){
        this.index=index;
        this.rating=rating;
    }

	@Override
	public String toString() {
		return "Pair [index=" + index + ", rating=" + rating + "]";
	}
	
}

public class Main{
	
	public static void swap(char[] arr, int i, int j) {
		char temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void printArray(int[] arr) {
		
		int n=arr.length;
		System.out.print("[");
		for(int i=0;i<n-1;i++)
			System.out.print(arr[i]+" ,");
		
		System.out.println(arr[n-1]+"]");
	}
	
	static boolean patternMatch(String A, String B) {
		
		int n=B.length();
		long hashcode=0;
		for(int i=0;i<n;i++) {
			int ch=B.charAt(i)-'a'+1;
			hashcode+=ch*(int)Math.pow(26, n-i-1);
		}
		
		long check=0;
		int i=0;
		for(i=0;i<n;i++) {
			int ch=A.charAt(i)-'a'+1;
			check+=ch*(int)Math.pow(26, n-i-1);
		}
		
		int j=0;
		while(i<A.length()) {
			
			int ch=A.charAt(j)-'a'+1;
			j++;
			check=(check-ch*(int)Math.pow(26, n-1))*26;
			check=check+((int)A.charAt(i)-'a'+1);
			i++;
			if(check==hashcode && B.equals(A.substring(j, i)))
				return true;
			
		}
		
		return false;
	}
	
//-------------------------------------------------------------------------------------------------------//

	public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        
        int[] color=new int[n];
        Arrays.fill(color,-1);
        
        return helper(0,graph,color, m,n);
    }
    
    public boolean helper(int s, boolean[][] graph, int[] color,int m, int n){
        
        if(s>=n)
            return true;
            
        for(int i=1;i<=m;i++){
            if(valid(s,i,graph,color,n)){
                color[s]=i;
                if(helper(s+1,graph,color,m,n)==true)
                    return true;
                    
                color[s]=-1;
            }
        }
        return false;
    }
    
    public boolean valid(int s,int c,boolean[][] graph, int[]color, int n){
        
        for(int i=0;i<n;i++){
        	
            if(graph[s][i]==true && color[i]==c)
                return false;
        }
        return true;
    }
	

//-------------------------------------------------------------------------------------------------------//
	public static void main(String[] args) {
    		
		Scanner sc=new Scanner(System.in);
		
//    	Node root=new Node(2);
//		root.left=new Node(1);
//		root.right=new Node(6);
//		root.left.left=new Node(5);
//		root.left.right=new Node(2);
//		root.right.left=new Node(3);
//		root.right.right=new Node(7);
		//root.left.left.left=new Node(8);
		//root.left.left.right=new Node(19);
// 		root.left.right.right=new Node(4);
// 		root.right.left.left=new Node(2);
// 		root.right.left.right=new Node(11);
// 		root.right.left.left.right=new Node(4);
// 		root.right.right.right=new Node(12);
		
		
		//root.right.right.right=new Node(5);
		//root.right.right.right.right=new Node(6);
		//root.left.right.left=new Node(6);
		//root.right.right.left=new Node(13);
		
		//int[] pre= {10,5,3,2,4,6,9,13,11,14};
		//int[] in = {2,3,4,5,6,9,10,11,13,14};
		
		//int[][] arr= {{1,3},{8,10},{2,6},{15,18}};
		
		/*Comparator<int[]> com=new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				
			}
		};
		
		
		int[] arr = new int[20];
		
		System.out.println("Enter:");
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
		*/
		
		Main ob = new Main();
		
		boolean[][] graph= {{false,true,true,true},
							{true,false,true,false},
							{true,true,false,true},
							{true,false,true,false}};
		
		ob.graphColoring(graph, 3, graph.length);
		
		

	}
	
}


	
