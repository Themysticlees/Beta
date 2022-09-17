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
    int n;
    
    Pair(int a, int n){
        this.a=a;
        this.n=n;
    }

	@Override
	public String toString() {
		return "Pair [a=" + a + ", n=" + n + "]";
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

	public int[] findOriginalArray(int[] changed) {
        
		int n=changed.length;
        if(n%2 != 0)
            return new int[0];
            
        Arrays.sort(changed);
        
        int len=n/2;
        
//         Set<Integer> set = new HashSet<>();
        
        int[] temp=new int[100001];
        for(int i=0;i<n;i++){
            temp[changed[i]]++;
        }
        
        int[] ans=new int[len];
        
        int i=0,j=0;
        while(i<len && j<n) {
        	if(temp[changed[j]]>0)
	            if(temp[changed[j]*2]>0){
	                ans[i]=changed[j];
	                temp[changed[j]]--;
	                temp[changed[j]*2]--;
	                i++;
	            }
        	
        	j++;
        }
        
        for(i=0;i<=100000;i++)
            if(temp[i]>0)
                return new int[0];
        
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
		
		 int[] arr= {4,4,16,20,8,8,2,10};
		 
		 System.out.println(Arrays.toString(ob.findOriginalArray(arr)));
		
	}
	
}



	
