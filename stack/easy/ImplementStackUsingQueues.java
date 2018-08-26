package Stack.Easy;

import datastructures.queue.LinkedQueue;
import datastructures.queue.Queue;

import java.util.NoSuchElementException;

/**
 * Problem: Acceptance: 33.9%
 *
 * Implement the following operations of a stack using queues.
 *    1. push(x) -- Push element x into stack.
 *    2. pop()   -- Removes the element on top of the stack.
 *    3. top()   -- Get the top element.
 *    4. empty() -- Return whether the stack is empty.
 *
 *  Notes:
 *    1. You must use only standard operations of a queue -- which means only push
 *    to back, peek/pop from front, size, and is empty operations are valid.
 *    2. Depending on your language, queue may not be supported natively. You may
 *    simulate a queue by using a list or deque (double-ended queue), as long as
 *    you use only standard operations of a queue.
 *    3. You may assume that all operations are valid(for example, no pop or top
 *    operations will be called on an empty stack).
 *
 * @author rovo98
 * Date: 13/2/2018
 */
public class ImplementStackUsingQueues {
    class MyStack {
        // Initialize your data structure here.
        Queue<Integer> stack;
        public MyStack() {
            stack = new LinkedQueue<>();
        }
        /** Push element x onto stack. */
        public void push(int x) {
            int[] temp = new int[stack.size()];
            for (int i = temp.length-1; i >= 0; i--) {
                temp[i] = stack.dequeue();
            }
            stack.enqueue(x);
            for (int e : temp) {
                stack.enqueue(e);
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if (empty()) {
                throw new NoSuchElementException("The stack is underflow.");
            }
            return stack.dequeue();
        }

        /** Get the top element. */
        public int top() {
            if (empty()) {
                throw new NoSuchElementException("The stack is underflow.");
            }
            return stack.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return stack.isEmpty();
        }
    }
    public void test() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println("Remove element from stack: " + stack.pop());
        System.out.println("Get top element: " + stack.top());
        System.out.println("If the stack is empty: " + stack.empty());
    }

    /**
     * Unit tests {@code MyStack} data type.
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        ImplementStackUsingQueues isuq = new ImplementStackUsingQueues();
        isuq.test();
    }
}
/*
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
