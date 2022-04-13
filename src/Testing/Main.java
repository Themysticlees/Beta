package Testing;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Node {
	 
	int data;
	Node left;
	Node right;
	//Node next;
	//char ch;
	    
	Node(int d) {
	    data = d; 
	    left=null;
	    right=null;
	    //next=null;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}
	
	

}

class Pair{
    
	int upp;
	int low;
	int i;
	int j;
	
	public Pair(int upp, int low, int i, int j) {
		super();
		this.upp = upp;
		this.low = low;
		this.i = i;
		this.j = j;
	}

	@Override
	public String toString() {
		return "Pair [upp=" + upp + ", low=" + low
				+ ", i=" + i + ", j=" + j + "]";
	}
	

    
}

public class Main{
	
	public static void swap(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void printArray(int[] arr, int n) {
		
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
	
	public static int dieHard(int armor, int health) {
		//1 air-health+3 armor+2
		//2 water-health-5 armor-10
		//3 fire-health-20 armor+5
		
		int[][] dp=new int[1000][1000];
		
		for(int i=0;i<1000;i++)
			for(int j=0;j<1000;j++)
				dp[i][j]=-1;
		
		dp[0][0]=0;
		
		return helper(armor,health,dp,0);
	}
	
	public static int helper(int armor,int health,int[][] dp, int choice) {
		
		if(armor==0 || health==0)
			return 0;
		
		if(choice==0) {
			int a=0,w=0,f=0;
			
			if(armor+2>=0 && health+3>=0) 
				a=helper(armor+2,health+3,dp,1);
			if(armor-10>=0 && health-5>=0) 
				w=helper(armor-10,health-5,dp,2);
			
			if(armor+5>=0 && health-20>=0) 
				f=helper(armor+5,health-20,dp,3);
			
			return Math.max(a,Math.max(w,f));
		}
		
		//if we jump from air
		else if(choice==1) {
			
			//for water
			int subans=0;
			if(armor-10>=0 && health-5>=0) {
				
				if(dp[armor-10][health-5]!=-1)
					subans=dp[armor-10][health-5];
				else
					subans=helper(armor-10,health-5,dp,2);
			}
			
			
			int subans2=0;
			//for fire
			if(armor+5>=0 && health-20>=0) {
				if(dp[armor+5][health-20]!=-1)
					subans2=dp[armor+5][health-20];
				else
					subans2=helper(armor+5,health-20,dp,3);
			}
			
			int ans=Math.max(subans, subans2)+1;
			dp[armor][health]=ans;
			return ans;
		}
		
		//if we jump from water
		else if(choice==2) {
			
			//for air
			int subans=0;
			if(armor+2>=0 && health+3>=0) {
				
				if(dp[armor+2][health+3]!=-1)
					subans=dp[armor+2][health+3];
				else
					subans=helper(armor+2,health+3,dp,1);
			}
			
			
			int subans2=0;
			//for fire
			if(armor+5>=0 && health-20>=0) {
				if(dp[armor+5][health-20]!=-1)
					subans2=dp[armor+5][health-20];
				else
					subans2=helper(armor+5,health-20,dp,3);
			}
			
			int ans=Math.max(subans, subans2)+1;
			dp[armor][health]=ans;
			return ans;
		}
		
		//if we jump from fire
		else {
			
			//for air
			int subans=0;
			if(armor+2>=0 && health+3>=0) {
				
				if(dp[armor+2][health+3]!=-1)
					subans=dp[armor+2][health+3];
				else
					subans=helper(armor+2,health+3,dp,1);
			}
			
			
			int subans2=0;
			//for water
			if(armor-10>=0 && health-5>=0) {
				
				if(dp[armor-10][health-5]!=-1)
					subans2=dp[armor-10][health-5];
				else
					subans2=helper(armor-10,health-5,dp,2);
			}
			
			int ans=Math.max(subans, subans2)+1;
			dp[armor][health]=ans;
			return ans;
		}

	}
	
//-------------------------------------------------------------------------------------------------------//
	public static void main(String[] args) {
    		
		Scanner sc=new Scanner(System.in);
		
    	Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(9);
		root.left.left=new Node(4);
		//root.left.right=new Node(6);
		root.right.left=new Node(5);
		root.right.right=new Node(7);
		root.left.left.left=new Node(8);
		root.left.left.right=new Node(19);
		//root.left.right.right=new Node(9);
		
		
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
		
		System.out.println(dieHard(20, 20));
	}
	
}


	
