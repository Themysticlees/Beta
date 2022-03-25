package Testing;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class Node {
	 
	int data;
	//Node left;
	//Node right;
	Node next;
	    
	Node(int d) {
	    data = d; 
	    //left=null;
	    //right=null;
	    next=null;
	}

}

class Pair{
	
	Node val;
	int level;
	public Pair(Node val, int level) {
		super();
		this.val = val;
		this.level = level;
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
	
	public static String reorganizeString(String s) {
	      
        Map<Character,Integer> map=new HashMap<>();
        
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            
            map.putIfAbsent(ch,0);
            
            map.put(ch,map.get(ch)+1);
        }
        
        Comparator<Character> com=new Comparator<>(){

			@Override
			public int compare(Character ch1, Character ch2) {
				// TODO Auto-generated method stub
				return map.get(ch2)-map.get(ch1);
			}
        };
        
        PriorityQueue<Character> queue=new PriorityQueue<>(com);
        
        for(Character ch:map.keySet())
        	queue.add(ch);
        String res="";
        
        while(queue.size()>1)
        {
            char c1=queue.remove();
            char c2=queue.remove();
            res+=c1;
            res+=c2;
            
            if(map.get(c1)-1 > 0) {
                map.put(c1,map.get(c1)-1);
                queue.add(c1);
            }
            
            if(map.get(c2)-1 > 0) {
                map.put(c2,map.get(c2)-1);
                queue.add(c2);
            }
        }
        
        if(queue.size()==1)
        {
            char ch=queue.remove();
            if(map.get(ch)>1)
                return "";
            
            res+=ch;
        }
        return res;
        
    }
	
	public static void main(String[] args) {
    	
		/*
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
		
		*/
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
		
		System.out.println(reorganizeString("aaaabbcdef"));
	}
	
}


	
