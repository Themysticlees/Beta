package stack_queueProblems;

import java.util.Stack;

public class QueueWith2Stacks {
	
	public static void main(String[] args) {
		
		MyStack2 q= new MyStack2();
		
		q.push(1);
		q.push(2);
		q.push(3);
		q.push(4);
		
		System.out.println(q.pop());
		System.out.println(q.pop());
	}
}

class MyQueue2{
	
	//First stack we'll use to insert the elements
	//2nd stack we'll use to delete the elements
	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();
	
	//while pushing we'll push all the elements in the first stack
	void push(int data) {
		
		if(s1.isEmpty())
		{
			while(!s2.isEmpty())
				s1.push(s2.pop());
		}
			s1.push(data);
	}
	
	//Now in case of deleting, we know Queue follows FIFO, thus we pop the elements from 1st stack
	//and push them in the 2nd stack, thus the last element is now the top element of 2nd stack
	//Now if we pop and element from 2nd stack, we'll delete in order
	int pop() {
		
		if(s2.isEmpty())
		{
			while(!s1.isEmpty())
				s2.push(s1.pop());
		}
		return s2.pop();
		
	}
	
	//same for peek, we'll pop from 2nd stack
	int peek() {
		
		if(s2.isEmpty())
		{
			while(!s1.isEmpty())
				s2.push(s1.pop());
		}
		return s2.peek();
		
	}
	
	boolean isEmpty() {
		if(s1.isEmpty() && s2.isEmpty())
			return true;
		return false;
	}
}

class MyStack2{
	
	MyQueue2 q1 = new MyQueue2();
	MyQueue2 q2 = new MyQueue2();
	
	//Whenever we add a new element, we'll add that to q2 and then add all the elements of q1 to q2
	//Then we'll pop elements from q2 and add them to q2 so that the last inserted element will be the first one to pop
	void push(int data) {
		q2.push(data);
		
		while(!q1.isEmpty())
			q2.push(q1.pop());
		
		while(!q2.isEmpty())
			q1.push(q2.pop());
		
	}
	
	//simply pop from q1
	int pop() {
		return q1.pop();
	}
	
	int peek() {
		return q1.peek();
	}
	
}
