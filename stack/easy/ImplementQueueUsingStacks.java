package Stack.Easy;

import datastructures.stack.LinkedStack;
import datastructures.stack.Stack;

import java.util.NoSuchElementException;

/**
 * Problem: Acceptance: 37.8%
 *
 * Implement the following operations of a queue using stacks.
 *    1. push(x) -- Push element x to the back of queue.
 *    2. pop()   -- Remove the element from in front of queue.
 *    3. peek()  -- Get the front element.
 *    4. empty() -- Return whether the queue is empty.
 *
 *
 * Notes:
 *    1. You must use only standard operations of a stack -- which means only
 *    push to top, peek/pop from top, size and is empty operations are valid.
 *    2. Depending on your language, stack may not be supported natively. You may
 *    simulate a stack by using a list or deque (double-ended queue), as long as you
 *    use only standard operations of a stack.
 *    3. You may assume that all operations are valid (for example, no pop or peek
 *    operations will be called on an empty queue).
 *
 * @author rovo98
 * Date: 13/2/2018
 */
public class ImplementQueueUsingStacks {
    //Solution one: ^
    class MyQueue {
        // Initialize your data structure here.
        Stack<Integer> queue;
        public MyQueue() {
            queue = new LinkedStack<>();
        }
        // Push element x to the back of queue.
        public void push(int x) {
            queue.push(x);
            Stack<Integer> stack = new LinkedStack<>();
            while (!queue.isEmpty()) {
                stack.push(queue.pop());
            }
            queue = stack;
        }
        // Removes the element from in front of queue and returns that element.
        public int pop() {
            return queue.pop();
        }
        // Get the front element.
        public int peek() {
            if (empty()) {
                throw new NoSuchElementException("The queue is underflow.");
            }
            return queue.peek();
        }
        // Returns whether the queue is empty.
        public boolean empty() {
            return queue.isEmpty();
        }
    }

    public void test() {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        int param_1 = queue.peek();
        int param_2 = queue.pop();
        boolean empty = queue.empty();
        System.out.println("Get the front element: " + param_1);
        System.out.println("Remove the element from in front of queue: " + param_2);
        System.out.println("Is empty: " + empty);
    }
    /**
     * Unit tests {@code MyQueue} data type.
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        ImplementQueueUsingStacks iqus = new ImplementQueueUsingStacks();
        iqus.test();
    }
}
/*
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
