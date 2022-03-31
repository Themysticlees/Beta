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
    
	int value;
    int day;
    
    Pair(int value, int day){
        this.value=value;
        this.day=day;
    }

	@Override
	public String toString() {
		return "Pair [value=" + value + ", day=" + day + "]";
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
	
	public static int maxStock(int[] prices, int n, int amount ) {
        // Write your code here
            ArrayList<Pair> list = new ArrayList<>();
            
            for(int i=0;i<n;i++){
                list.add(new Pair(prices[i],i+1));
            }
            Comparator<Pair> com = new Comparator<Pair>(){
                public int compare(Pair a, Pair b){
                    
                	if(a.value==b.value)
                        return b.day-a.day;
                    
                    return a.value-b.value;
                }
            };
            
            Collections.sort(list,com);
            int curr=0;
            int max=0,i=0;
           for(;i<n;i++){
               Pair temp=list.get(i);
               
               if(curr+temp.value*temp.day<=amount){
                   max+=temp.day;
                   curr+=temp.value*temp.day;
               }
               else
                   break;
           }
           
           if(i<n) {
            int rem=amount-curr;
            Pair temp=list.get(i);
            int day=temp.day;
            while(rem>=temp.value && day>0)
            {
                max++;
                day--;
                rem-=temp.value;
            }
           }
        return max;
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
		
		int[] prices= {3,4,2};
		System.out.println(maxStock(prices, prices.length, 10));
		
	}
	
}


	
