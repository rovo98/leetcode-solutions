package datastructures.bag;

/**
 * ADT Bag
 *
 * Data
 *      bag
 *      int n                   the number of items in bag.
 * Operation
 *      boolean isEmpty()       Returns true if bag is empty, otherwise false.
 *      int size()              Returns the number of items in bag.
 *      void add(Item item)     Add an item to the bag.
 *
 * endADT
 * @author rovo98
 */
public interface Bag<Item> extends Iterable<Item> {
    boolean isEmpty();
    int size();
    void add(Item item);
}
