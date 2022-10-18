package Testing;
import java.util.*;

class Node {
	 
	int data;
	Node left;
	Node right;

    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }

	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
	}

}

class Pair{
    
	 int a;
	    int b;
	   
	    Pair(int a,int b){
	        this.a=a;
	        this.b=b;
	    }

		@Override
		public String toString() {
			return "Pair [a=" + a + ", b=" + b + "]";
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

	public String countAndSay(int n) {
       
        
        String s="1";
        n--;
        while(n-->0)
        {
            List<Pair> p=createPairs(s);
            s=createString(p);
        }
       
        return s;
    }
   
    public List<Pair> createPairs(String s){
       
        List<Pair> list = new ArrayList<>();
       
        int prev=s.charAt(0)-'0';
        int count=1;
        for(int i=1;i<s.length();i++){
            int ch = s.charAt(i)-'0';
            if(ch==prev)
                count++;
            else
            {
                list.add(new Pair(prev,count));
                prev=ch;
                count=1;
            }
        }
       
        list.add(new Pair(prev,count));
       
        return list;
    }
   
    public String createString(List<Pair> list){
       
        String ans="";
       
        for(Pair p:list){
            ans+=p.a;
            ans+=p.b;
        }
       
        return ans;
    }
    
//-------------------------------------------------------------------------------------------------------//
	public static void main(String[] args) {
    		
		Scanner sc=new Scanner(System.in);
		
    	Node root=new Node(1);
		root.left=new Node(9);
		root.right=new Node(1);
//		root.left.left=new Node(3);
		root.left.right=new Node(1);
//		root.right.left=new Node(5);
		root.right.right=new Node(1);
//		root.left.left.left=new Node(0);
		//root.left.left.right=new Node(19);
// 		root.left.right.right=new Node(4);
// 		root.right.left.left=new Node(2);
// 		root.right.left.right=new Node(11);
// 		root.right.left.left.right=new Node(4);
// 		root.right.right.right=new Node(12);
		root.right.right.left=new Node(7);
		root.right.right.left.right=new Node(4);
		
		
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
		
//		int[] arr = new int[3];
//		
//		System.out.println("Enter:");
//		for(int i=0;i<arr.length;i++) {
//			arr[i]=sc.nextInt();
//		}
		
//		char[][] mat = {{'S','N','B','S','N'},
//			       {'B','A','K','E','A'},
//			       {'B','K','B','B','K'},
//			       {'S','E','B','S','E'}};
//		
//		System.out.println(ob.findOccurrence(mat, "SNAKES"));
		
		System.out.println(ob.countAndSay(4));
	}
	
}



	
