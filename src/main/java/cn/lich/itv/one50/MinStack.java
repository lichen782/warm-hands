package cn.lich.itv.one50;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author lich
 * @date 2024/1/17
 */
public class MinStack {

    private PriorityQueue<Integer> pq;

    private Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
        pq = new PriorityQueue<>();
    }

    public void push(int val) {
        stack.push(val);
        pq.add(val);
    }

    public void pop() {
        pq.remove(stack.pop());
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return pq.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());

        minStack.pop();

        System.out.println(minStack.top());

        System.out.println(minStack.getMin());
    }

}
