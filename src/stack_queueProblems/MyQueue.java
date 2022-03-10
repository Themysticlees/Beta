package stack_queueProblems;

public class MyQueue {
	
	
	int[] arr= new int[5];
	
	int front=0;
	int rear=-1;
	
	public boolean offer(int data) {
		
		if(rear==front-1 && rear!=-1)
			return false;
		
		else if(rear>=arr.length-1) {
			if(front==0)
				return false;
			else
			{
				rear=0;
				arr[rear]=data;
			}
			
		}
		else
			arr[++rear]=data;
		
		return true;
	}
	
	public boolean poll() {
		if(front==rear)
			return false;
		else if(front==arr.length-1)
			front=0;
		else
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
		
		/*if(front>rear)
		{
			for(int i=rear;i<front;i++)
				res=res+arr[i]+",";
			
			res=res+arr[rear]+"]";
		}
		else {
			for(int i=front;i<rear;i++)
				res=res+arr[i]+",";
			
			res=res+arr[rear]+"]";
		}*/
		
		for(int i=0;i<arr.length;i++)
			if(arr[i]!=0)
				res+=arr[i]+",";
		return res;
	}

}
