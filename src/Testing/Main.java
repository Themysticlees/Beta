package Testing;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Node {
	 
	int data;
	Node left;
	Node right;
	//Node next;
	char ch;
	    
	Node(int d) {
	    data = d; 
	    left=null;
	    right=null;
	    //next=null;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + ", ch=" + ch + "]";
	}
	
	

}

class Pair{
    
    double ratio;
    int weight;
    
    Pair(double ratio, int weight){
        this.ratio=ratio;
        this.weight=weight;
    }
}

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

public class Main{
	
	public static void swap(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void printArray(int[] arr, int n) {
		
		for(int i=0;i<n;i++)
			System.out.println(arr[i]);
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
	
	static double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        Comparator<Pair> com = new Comparator<Pair>(){
            
            @Override
            public int compare(Pair a, Pair b){
                if(b.ratio>a.ratio)
                    return 1;
                else if(a.ratio>b.ratio)
                    return -1;
                return 0;
            }
        };
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(com);
        
        for(int i=0;i<n;i++){
            double ratio=(double)arr[i].value/(double)arr[i].weight;
            pq.add(new Pair(ratio,arr[i].weight));
        }
        
        double sum=0;
        while(!pq.isEmpty() && pq.peek().weight<W)
        {
            Pair temp=pq.remove();
            sum+=temp.weight*temp.ratio;
            W-=temp.weight;
        }
        
        if(W!=0){
            Pair temp=pq.remove();
            sum+=temp.ratio*W;
        }
        
        return sum;
        
    }
	
	public static void main(String[] args) {
    	
		
    	Node root=new Node(10);
		root.left=new Node(5);
		root.right=new Node(13);
		root.left.left=new Node(3);
		root.left.right=new Node(6);
		root.right.left=new Node(11);
		root.right.right=new Node(14);
		root.left.left.left=new Node(2);
		root.left.left.right=new Node(4);
		root.left.right.right=new Node(9);
		
		
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
				
				return o1[1]-o2[1];
			}
		};
		*/
		
		Item a=new Item(60, 10);
		Item b=new Item(100, 20);
		Item c=new Item(120, 30);
		//Item d=new Item(60, 10);
		
		Item[] arr= {a,b,c};
		System.out.println(fractionalKnapsack(50, arr, arr.length));
		
		
	}
	
}


	
