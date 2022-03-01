package stack_queueProblems;

public class MyQueue {
	
	
	int[] arr= new int[1000];
	
	int front=0;
	int rear=0;
	
	public boolean offer(int data) {
		
		arr[rear++]=data;
		return true;
	}
	
	public boolean poll() {
		if(front==rear)
			return false;
		
		front++;
		return true;
	}
	
	public int peek() {
		
		if(front==rear)
			return -1;
		return arr[front];
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(front==rear)
			return "Empty Queue";
		String res="[";
		for(int i=front;i<rear;i++)
			res=res+arr[i]+",";
		
		res=res+arr[rear]+"]";
		return res;
	}

}
