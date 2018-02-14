package leetcode;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ImplementStackUsingQueues {
	Queue<Integer> queue1 = new LinkedList<>();
	Queue<Integer> queue2 = new LinkedList<>();
	
	public void push(int x) {
		queue1.add(x);
	}
	public boolean isEmpty() {
		return queue1.size() + queue2.size() == 0;
	}
	public int pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("stack is empty");
		}
		
		while (queue1.size() > 1) {
			queue2.add(queue1.poll());
		}
		int value = queue1.remove();
		swapQueues();
		return value;
	}
	public void swapQueues() {
		Queue<Integer> queue3 = queue1;
		queue1 = queue2;
		queue2 = queue3;
	}
	
	
	//method2, 只用一个queue, 每次压入一个数之后，都把除了最后一个数之外的所有数字poll出来再enqueue
	//入队，这样最后压入的就成了出队的了符合stack.
//	Queue<Integer> queue;
//	
//	public ImplementStackUsingQueues() {
//		this.queue = new LinkedList<Integer>();
//	}
//	public void push(int x) {
//		queue.add(x);
//		for (int i = 0; i < queue.size() - 1; i++) {
//			queue.add(queue.poll());
//		}
//	}
//	
//	public void pop() throws Exception{
//		if (queue.isEmpty()) {
//			throw  new NoSuchElementException("stack is empty.");
//		}
//		queue.poll();
//	}
//	public int top() {
//		return queue.peek();
//	}
//	public boolean empty() {
//		return queue.isEmpty();
//	}
	
	public static void main(String[] args) throws Exception {
		//System.out.println();
		ImplementStackUsingQueues obj = new ImplementStackUsingQueues();
		obj.push(1);
		obj.push(2);
		obj.push(3);
	    obj.pop();
	}
}
