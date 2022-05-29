package Testing;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Node {
	 
	int data;
//	Node left;
//	Node right;
	Node next;
	//char ch;
	    
	Node(int d) {
	    data = d; 
//	    left=null;
//	    right=null;
	    next=null;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
	
}

class Pair{
    
	long weight;
    long profit;
    double ratio;
    
    Pair(long wt, long pr, double ratio){
        this.weight=wt;
        this.profit=pr;
        this.ratio=ratio;
    }

	@Override
	public String toString() {
		return "Pair [weight=" + weight + ", profit=" + profit + ", ratio=" + ratio + "]";
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
	
	static void formCoils(int n) {
        // code here
        int len=4*n;
        
        int[][] matrix=new int[len][len];
        
        int x=1;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                matrix[i][j]=x++;
            }
        }
        
        int[][] ans = new int[2][8*n*n];
        int index1=ans[0].length-1;
        int index2=ans[0].length-1;
        
        
        int left=0,right=len-1;
        int top=0,down=len-1;
        
        int turn=0;
        
        while(top<down && left<right){
            
            if(turn==0){
                
                for(int i=top;i<=down;i++){
                	ans[1][index2--]=matrix[i][left];
                   
                }
                left++;
                
                for(int i=down;i>=top;i--){
                	ans[0][index1--]=matrix[i][right];
                    
                }
                right--;
            }
            
            else if(turn == 1){
                
                for(int i=left;i<=right;i++){
                	ans[1][index2--]=matrix[down][i];
                    
                }
                down--;
                
                for(int i=right;i>=left;i--){
                	ans[0][index1--]=matrix[top][i];
                    
                }
                top++;
            }
            
            else if(turn==2){
                
                for(int i=down;i>=top;i--){
                	ans[1][index2--]=matrix[i][right];
                    
                }
                right--;
                
                for(int i=top;i<=down;i++){
                	ans[0][index1--]=matrix[i][left];
                    
                }
                left++;
            }
            else if(turn ==3){
                
                for(int i=right;i>=left;i--){
                	ans[1][index2--]=matrix[top][i];
                    
                }
                top++;
                
                for(int i=left;i<=right;i++){
                	ans[0][index1--]=matrix[down][i];
                    
                }
                down--;
            }
            
            turn=(turn+1)%4;
        }
        
    }
    

//-------------------------------------------------------------------------------------------------------//
	public static void main(String[] args) {
    		
		Scanner sc=new Scanner(System.in);
		
//    	Node root=new Node(1);
//		root.left=new Node(2);
//		root.right=new Node(9);
//		root.left.left=new Node(4);
//		root.left.right=new Node(6);
//		root.right.left=new Node(5);
//		root.right.right=new Node(7);
//		root.left.left.left=new Node(8);
//		root.left.left.right=new Node(19);
// 		root.left.right.right=new Node(9);
		
		
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
		
		formCoils(2);

	}
	
}


	
