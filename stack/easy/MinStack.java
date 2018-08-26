package Stack.Easy;

import datastructures.stack.LinkedStack;
import datastructures.stack.Stack;

import java.util.NoSuchElementException;

/**
 * Problem: Acceptance: 30.4%
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element
 * in constant time.
 *
 *   1. push(x) -- Push element x into stack.
 *   2. pop()   -- Removes the element on top of stack.
 *   3. top()   -- Get the top element.
 *   4. getMin() -- Retrieve the minimum element in the stack.
 *
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns -2.
 * minStack.getMin();   --> Returns -2.
 *
 * @author rovo98
 * Date: 13/2/2018
 */
public class MinStack {

    /** initialize your data structure here. */
    /*
    use two stack to implement it.
     */
    private Stack<Integer> stack;
    private Stack<Integer> minElem;

    /**
     * Initializes an empty MinStack.
     */
    public MinStack() {
        stack = new LinkedStack<>();
        minElem = new LinkedStack<>();
    }

    /**
     * Add an item into the stack.
     * @param x the item to add to the stack.
     */
    public void push(int x) {
        if (stack.isEmpty()) {
            minElem.push(x);
        } else if (minElem.peek() > x) {
            minElem.push(x);
        }
        stack.push(x);
    }

    /**
     * Remove an item from the stack.
     * @return the item removed from the stack.
     * @throws  NoSuchElementException if the stack is underflow.
     */
    public int pop() {
        if (stack.isEmpty()) {
            throw new NoSuchElementException("The minStack is underflow.");
        }
        if (stack.peek().equals(minElem.peek())) {
            minElem.pop();
        }
        return stack.pop();
    }

    /**
     * Get the top item of the stack.
     * @return the top item of the stack.
     * @throws NoSuchElementException if the stack is underflow.
     */
    public int top() {
        if (stack.isEmpty()) {
            throw new NoSuchElementException("The minStack is underflow.");
        }
        return stack.peek();
    }

    /**
     * Get the minimum item in the stack.
     * @return the minimum item in the stack.
     * @throws NoSuchElementException if the stack is underflow.
     */
    public int getMin() {
        if (minElem.isEmpty()) {
            throw new NoSuchElementException("The minStack is underflow");
        }
        return minElem.peek();
    }

    /**
     * Unit tests the data type {@code MinStack}.
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(-2);
        ms.push(-3);
        System.out.println("The minimum element in stack: " + ms.getMin());
        System.out.println("Remove the element from stack: " + ms.pop());
        System.out.println("The top element in stack: " + ms.top());
        System.out.println("Now the minimum element in stack: " + ms.getMin());
    }
}

/*
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
