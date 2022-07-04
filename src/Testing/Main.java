package Testing;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Node {
	 
	int data;
	Node left;
	Node right;
//	Node next;
	//char ch;
	    
	Node(int d) {
	    data = d; 
	    left=null;
	    right=null;
//	    next=null;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
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
	
	public static void swap(int[] arr, int i, int j) {
		int temp=arr[i];
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
	
	int[] level=new int[10001];
	int[] par=new int[10001];
	
	Node lca(Node root, int n1,int n2)
	{
		// Your code here
		
		
		Arrays.fill(par, -1);
		
		levelOrderTraversal(root,0,-1);
		return helper(n1,n2,level,par);
		
	}
	
	public Node helper(int a, int b, int[] level,int[] par) {
		
		if(level[b]>level[a]) {
			return helper(b,a,level,par);
		}
		
		int diff=level[a]-level[b];
		
		while(diff>0) {
			a=par[a];
			diff--;
		}
		
		if(a==b)
		    return new Node(a);
		    
		while(par[a]!=par[b]){
			a=par[a];
			b=par[b];
		}
		
		return new Node(par[a]);
	
	}
	
	
	
	public void levelOrderTraversal(Node s,int lvl,int parent) {
		
		level[s.data]=lvl;
		par[s.data]=parent;
		
		if(s.left!=null)
		levelOrderTraversal(s.left, lvl+1, s.data);
		
		if(s.right!=null)
		levelOrderTraversal(s.right, lvl+1, s.data);
		
	}
	
	
	
	
	
//-------------------------------------------------------------------------------------------------------//
	public static void main(String[] args) {
    		
		Scanner sc=new Scanner(System.in);
		
    	Node root=new Node(2);
		root.left=new Node(1);
		root.right=new Node(9);
//		root.left.left=new Node(5);
//		root.left.right=new Node(2);
		root.right.left=new Node(3);
		root.right.right=new Node(10);
		//root.left.left.left=new Node(8);
		//root.left.left.right=new Node(19);
// 		root.left.right.right=new Node(4);
// 		root.right.left.left=new Node(8);
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
		
		ob.lca(root, 9, 10);

	}
	
}


	
