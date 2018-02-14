package leetcode;

import java.util.Stack;

public class MinStack {
	public static void main(String[] args) {
		MinStack obj = new MinStack();
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.push(-1);
		obj.pop();
		System.out.println(obj.top());
		System.out.println(obj.getMin());
	}
	
	Stack<Integer> stack;
	int min;
	
	public MinStack() {
		stack = new Stack<>();
		min = Integer.MAX_VALUE;
	}
    
    public void push(int x) {
        // only push the old minimum value when the current 
        // minimum value changes after pushing the new value x
        if(x <= min){          
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
    
    
}
