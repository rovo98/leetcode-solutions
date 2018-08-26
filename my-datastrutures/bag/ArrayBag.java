package datastructures.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ADT ArrayBag, an implement of bag using array.
 *
 * Data
 *      Item[] bag
 *      int n               the number of items in bag.
 * Operation
 *      ArrayBag()          Initial an empty bag.
 *      boolean isEmpty()   Returns true if bag is empty, otherwise false.
 *      int size()          Returns the number of items in bag.
 *      void add(Item item) Add an item to the bag.
 * endADT
 * @author rovo98
 */
@SuppressWarnings("unchecked")
public class ArrayBag<Item> implements Bag<Item> {
    private Item[] bag;
    private int n;

    /**
     * Initial an empty bag.
     */
    public ArrayBag() {
        bag = (Item[]) new Object[1];
        n = 0;
    }

    /**
     * Returns true if bag is empty.
     * @return {@code true} if bag is empty;
     *         {@code false} otherwise.
     */
    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of items in bag.
     * @return the number of items in bag.
     */
    @Override
    public int size() {
        return n;
    }

    /**
     * Resize the bag.
     * @param max the size of the new bag.
     */
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < n; i++) {
            temp[i] = bag[i];
        }
        bag = temp;
    }

    /**
     * Add an item to the bag.
     * @param item the item to add to the bag.
     */
    @Override
    public void add(Item item) {
        if (n == bag.length) { // If bag is full, resize it.
            resize(2*bag.length);
        }
        bag[n++] = item;
    }

    /**
     * Returns an iterator to the bag that iterates over items in the bag.
     * @return An iterator to the bag that iterates over items in the bag.
     */
    @Override
    public Iterator<Item> iterator() {
        return new ArrayBagIterator();
    }
    private class ArrayBagIterator implements Iterator<Item> {
        private int i = n;
        @Override
        public boolean hasNext() {
            return i > 0;
        }
        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return bag[--i];
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Unit tests {@code ArrayBag} data type.
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        Bag<Integer> bag = new ArrayBag<>();
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
