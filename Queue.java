package leetcode;
import java.util.Stack;

public class Queue {
	Stack<Integer> s1;
	Stack<Integer> s2;
	public static void main(String[] args) throws InterruptedException {
        Queue queue = new Queue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
  
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }

    public Queue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        s2.push(x);
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }

    public int pop() {
    	if (!s2.isEmpty()) {
    		return s2.pop();
    	}
        return Integer.MAX_VALUE;
    }
    
//    public boolean empty() {
//        return s1.isEmpty() && s2.isEmpty();
//    } 
}
