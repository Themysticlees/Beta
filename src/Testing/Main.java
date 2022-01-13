package Testing;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
	
	public static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        // add code here.
        
        int[] arr=new int[q.size()];
        int j=0;
        
        while(j<q.size())
            arr[j++]=q.poll();
        
        for(int i=k-1;i>=0;i--)
            q.offer(arr[i]);
        
        for(int i=k;i<arr.length;i++)
            q.offer(arr[i]);
        
        return q;
        
    }
		
	
	public static void main(String[] args) {
		
		Queue<Integer> q= new LinkedList<>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		
		q=modifyQueue(q, 3);
		System.out.println(q);
	}
	
}


