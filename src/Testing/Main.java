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
	
//	public static long gergovia(int[]arr, int n) {
//		
//		int i=0;
//		long time=0;
//		
//		while(i<n) {
//			
//			int j=i+1;
//			
//			while(j<n) {
//				
//				//for searching buyer
//				if(arr[i]<0) {
//					
//					if(arr[j]>0) {
//						int diff=arr[i]+arr[j];
//						if(diff>0) {
//							time+=(j-i)*(arr[j]-diff);
//							arr[j]=diff;
//							arr[i]=0;
//						}
//						else if(diff<0) {
//							time+=(j-i)*arr[j];
//							arr[i]=diff;
//							arr[j]=0;
//							
//						}
//						else{
//							time+=(j-i)*arr[j];
//							arr[i]=0;
//							arr[j]=0;
//						}
//						
//						
//					}	
//				}
//				
//				//for searching seller
//				else{
//					
//					if(arr[j]<0) {
//						int diff=arr[i]+arr[j];
//						if(diff<0) {
//							time+=(j-i)*arr[i];
//							arr[j]=diff;
//							arr[i]=0;
//						}
//						else if(diff>0) {
//							time+=(j-i)*(arr[i]-diff);
//							arr[i]=diff;
//							arr[j]=0;
//						}
//						else
//						{
//							time+=(j-i)*arr[i];
//							arr[i]=0;
//							arr[j]=0;
//						}
//							
//					}
//					
//				}
//				if(arr[i]==0)
//					break;
//				j++;
//				
//			}
//			i++;
//		}
//		return time;
//	}
	
	
//	public static long gergovia(int[]arr, int n) {
//		
//		Stack<Pair> pos=new Stack<>();
//		Stack<Pair> neg=new Stack<>();
//		
//		for(int i=n-1;i>=0;i--) {
//			if(arr[i]>0)
//				pos.add(new Pair(arr[i],i));
//			else
//				neg.add(new Pair(arr[i],i));
//		}
//		
//		int time=0;
//		while(!pos.isEmpty() && !neg.isEmpty()) {
//			Pair buy=pos.peek();
//			Pair sell=neg.peek();
//			
//			int diff=buy.val+sell.val;
//			
//			if(diff>0)
//			{
//				time+=Math.abs(buy.index-sell.index)*(buy.val-diff);
//				buy.val=diff;
//				sell.val=0;
//			}
//			else
//			{
//				time+=Math.abs(buy.index-sell.index)*buy.val;
//				buy.val=0;
//				sell.val=diff;
//			}
//			
//			if(buy.val==0)
//				pos.pop();
//			if(sell.val==0)
//				neg.pop();
//		}
//		return time;
//	}
	
	
	public static int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        Queue<int[]> queue = new LinkedList<>();
        
        if(KnightPos[0]==TargetPos[0] && KnightPos[1]==TargetPos[1])
            return 0;
            
        int[][] visited=new int[N+1][N+1];
        
        visited[KnightPos[0]][KnightPos[1]]=0;
        queue.add(KnightPos);
        
        while(!queue.isEmpty()){
            int[] temp=queue.poll();
            
            int col=temp[0];
            int row=temp[1];
            
            //for uppemost row chances
            if(col-1>=1 && row+2<=N && visited[col-1][row+2]==0){
                // if(col-1==TargetPos[0] && row+2==TargetPos[1])
                //     return steps;
                visited[col-1][row+2]=1+visited[col][row];
                queue.add(new int[]{col-1,row+2});
            }
            
            if(col+1<=N && row+2<=N && visited[col+1][row+2]==0){
                // if(col+1==TargetPos[0] && row+2==TargetPos[1])
                //     return steps;
                visited[col+1][row+2]=1+visited[col][row];
                queue.add(new int[]{col+1,row+2});
            }
                
            //for upper row chances
            if(col-2>=1 && row+1<=N && visited[col-2][row+1]==0){
                // if(col-2==TargetPos[0] && row+1==TargetPos[1])
                //     return steps;
                visited[col-2][row+1]=1+visited[col][row];
                queue.add(new int[]{col-2,row+1});
            }
            
            if(col+2<=N && row+1<=N && visited[col+2][row+1]==0){
                // if(col+2==TargetPos[0] && row+1==TargetPos[1])
                //     return steps;
                visited[col+2][row+1]=1+visited[col][row];
                queue.add(new int[]{col+2,row+1});
            }
                
            //for lower row chances
            if(col-2>=1 && row-1>=1 && visited[col-2][row-1]==0){
                // if(col-2==TargetPos[0] && row-1==TargetPos[1])
                //     return steps;
                visited[col-2][row-1]=1+visited[col][row];
                queue.add(new int[]{col-2,row+1});
            }
            
            if(col+2<=N && row-1>=1 && visited[col+2][row-1]==0){
                // if(col+2==TargetPos[0] && row-1==TargetPos[1])
                //     return steps;
                visited[col+2][row-1]=1+visited[col][row];
                queue.add(new int[]{col+2,row+1});
            }
                
            //for lowest row chances
            if(col-1>=1 && row-2>=1 && visited[col-1][row-2]==0){
                // if(col-1==TargetPos[0] && row-2==TargetPos[1])
                //     return steps;
                visited[col-1][row-2]=1+visited[col][row];
                
                queue.add(new int[]{col-1,row-2});
            }
            
            if(col+1<=N && row-2>=1 && visited[col+1][row-2]==0){
                // if(col+1==TargetPos[0] && row-2==TargetPos[1])
                //     return steps;
                visited[col+1][row-2]=1+visited[col][row];
                queue.add(new int[]{col+1,row-2});
            }
        }
        return visited[TargetPos[0]][TargetPos[1]];
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
		
//		int[] arr= {5,-4,1,-3,1};
//		System.out.println(gergovia(arr, arr.length));
		
		int knightPos[ ] = {4, 5};
		int targetPos[ ] = {1, 1};
		
		System.out.println(minStepToReachTarget(knightPos, targetPos, 6));
		
	}
	
}


	
