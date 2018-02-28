package datastructures.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ADT ArrayStack, an implement of stack using array.
 *
 * Data
 *      Item[] stack
 *      int n                   the number of items in stack.
 * Operation
 *      ArrayStack()            Initial an empty stack.
 *      boolean isEmpty()       Returns true if stack is empty, otherwise false.
 *      void push(Item item)    Add an item to stack.
 *      Item pop()              Remove an item from stack.
 *      Item peek()             Get an item from stack.
 *      int size()              Returns the number of items in stack.
 *
 * endADT
 * @author rovo98
 */
@SuppressWarnings("unchecked")
public class ArrayStack<Item> implements Stack<Item> {
    private Item[] stack;
    private int n;

    /**
     * Initial an empty stack.
     */
    public ArrayStack() {
        stack = (Item[]) new Object[1];
        n = 0;
    }

    /**
     * Returns true if the stack is empty.
     * @return {@code true} if the stack is empty;
     *         {@code false} otherwise.
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of items in the stack.
     * @return the number of items in the stack.
     */
    public int size() {
        return n;
    }

    /**
     * Resize the stack.
     * @param max the size of the new stack.
     */
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < n; i++) {
            temp[i] = stack[i];
        }
        stack = temp;
    }

    /**
     * Add an item to the stack.
     * @param item the item to add to the stack.
     */
    public void push(Item item) {
        if (n == stack.length) { // If the stack is full, resize the stack.
            resize(2*stack.length);
        }
        stack[n++] = item;
    }

    /**
     * Remove an item from the stack.
     * @return the item removed from the stack.
     */
    public Item pop() {
        Item item = stack[--n];
        stack[n] = null;
        if (n > 0 && n == stack.length/4) {
            resize(stack.length/2);
        }
        return item;
    }

    /**
     * Get an item from the stack.
     * @return the item got from the stack.
     */
    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("The stack is underflow");
        }
        return stack[n-1];
    }

    /**
     * Returns an iterator to the stack that iterates through items in the stack in LIFO order.
     * @return An iterator to the stack that iterates through items in the stack in LIFO order.
     */
    public Iterator<Item> iterator() {
        return new ArrayStackIterator();
    }
    private class ArrayStackIterator implements Iterator<Item>{
        private int i = n;
        public boolean hasNext() {
            return i > 0;
        }
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return stack[--i];
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Unit tests the {@code LinkedStack} data type.
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        Stack<String> stack = new ArrayStack<>();
        String[] testTobe = {"to", "-", "or", "not", "to", "be", "-", "that", "is"};
        for (int i = 0; i < testTobe.length; i++) {
            if (testTobe[i].equals("-")) {
                System.out.print(stack.pop()+" ");
            } else {
                stack.push(testTobe[i]);
            }
        }
        System.out.print("("+stack.size()+" left on stack).");
    }
}
