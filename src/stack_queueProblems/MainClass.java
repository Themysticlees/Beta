package stack_queueProblems;

public class MainClass {
	
	public static void main(String[] args) {
		
		MyQueue queue = new MyQueue();
		
		
		System.out.println(queue.offer(1));
		System.out.println(queue.offer(2));
		System.out.println(queue.offer(3));
		System.out.println(queue.offer(4));
		System.out.println(queue.offer(5));
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.offer(6));
		System.out.println(queue.offer(7));
	}
}
