package datastructures.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ADT LinkedBag, an implement of bag using linked list.
 *
 * Data
 *      Node first
 *      int n               the number of items in bag.
 * Operation
 *      LinkedBag()         Initial an empty bag.
 *      boolean isEmpty()   Returns true if bag is empty, otherwise false.
 *      int size()          Returns the number of items in the bag.
 *      void add(Item item) Add an item to the bag.
 *
 * endADT
 * @author rovo98
 */
public class LinkedBag<Item> implements Bag<Item> {
    private Node<Item> first;
    private int n;

    private class Node<Item> {
        Item item;
        Node<Item> next;
    }
    /**
     * Initial an empty bag.
     */
    public LinkedBag() {
        first = null;
        n = 0;
    }

    /**
     * Returns true if bag is empty.
     * @return    {@code true} if bag is empty;
     *            {@code false} otherwise.
     */
    @Override
    public boolean isEmpty() {
        return first == null; // or n == 0;
    }

    /**
     * Returns the number of items in bag.
     * @return the number of items in bag.
     */
    @Override
    public int size() {
        return n;
    }
    @Override
    public void add(Item item) {
        // insert the item to the head of the linked list.
        Node<Item> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    /**
     * Returns an iterator to the bag that iterates over items in the bag.
     * @return An iterator to the bag that iterates over items in the bag.
     */
    @Override
    public Iterator<Item> iterator() {
        return new LinkedBagIterator<>(first);
    }
    private class LinkedBagIterator<Item> implements Iterator<Item> {
        private Node<Item> current;
        private LinkedBagIterator(Node<Item> first) {
            current = first;
        }
        @Override
        public boolean hasNext() {
            return current != null;
        }
        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Unit tests {@code LinkedBag} data type.
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        Bag<Integer> bag = new LinkedBag<>();
        for (int i = 0; i < 10; i++) {
            bag.add(i);
        }
        System.out.println("The input test bag is the following:");
        for (int item : bag) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
