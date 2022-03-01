package stack_queueProblems;

public class MyStack {

	int n;
	public MyStack(int size) {
		// TODO Auto-generated constructor stub
		n=size;
	}
	int[] arr= new int[n];;
	
	int top=-1;
	public String push(int data) {
		if(top==n)
			return "Stack Full";
		arr[++top]=data;
		return data+" successfully added!";
	}
	
	public int pop() {
		if(top==-1)
			return -1;
		return arr[top--];
	}
	
	public int peek() {
		return arr[top];
	}
	
	public boolean search(int data) {
		for(int i=0;i<=top;i++) {
			if(arr[i]==data)
				return true;
		}
		return false;
	}
	
	public boolean isEmpty() {
		if(top==-1)
			return true;
		return false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(top==-1)
			return "Empty Stack";
		String res="[";
		for(int i=0;i<top;i++)
			res=res+arr[i]+",";
		
		res=res+arr[top]+"]";
		return res;
	}
}


