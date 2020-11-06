package 알고리즘인터뷰.스택큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Implement_Stack_using_Queues {
}

class MyStack {
    Queue<Integer> queue;
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int count = 1;
        while(count++ < queue.size()) {
            queue.add(queue.poll());
        }
        int ret = queue.poll();

        return ret;
    }

    /** Get the top element. */
    public int top() {
        int count = 1;
        while(count++ < queue.size()) {
            queue.add(queue.poll());
        }
        int ret = queue.peek();

        return ret;

    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */