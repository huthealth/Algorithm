package 알고리즘인터뷰.스택큐;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Implement_Queue_using_Stacks {

}

class MyQueue {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {

        inStack.push(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty())outStack.push(inStack.pop());
        }
        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty())outStack.push(inStack.pop());
        }
        return outStack.peekFirst();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return  inStack.isEmpty() && outStack.isEmpty();
    }
}