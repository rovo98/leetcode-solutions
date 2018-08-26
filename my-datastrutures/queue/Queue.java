package datastructures.queue;

/**
 * ADT Queue (LILO)
 *
 * Data
 *       queue
 *       int n                  the number of items in queue.
 * Operation
 *      boolean isEmpty()       Returns true if queue is empty, otherwise false.
 *      int size()              Returns the number of items in queue.
 *      void enqueue(Item item) Add an item to queue.
 *      Item dequeue()          Remove an item from queue.
 *      Item top()             Get the front element.
 *
 * endADT
 * @author rovo98
 */
public interface Queue<Item> extends Iterable<Item> {
    boolean isEmpty();
    int size();
    void enqueue(Item item);
    Item dequeue();
    Item peek();
}
