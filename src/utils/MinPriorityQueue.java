package utils;
import java.util.NoSuchElementException;

public class MinPriorityQueue<T extends Comparable<T>> {
    
    private int capacity;
    private int size;   // size <= capacity
    private T[] priorityTree;
    // index of the next avaiable slot
    private int queueTail;

    /**
     * Creates an empty queue.
     */
    public MinPriorityQueue() {
        capacity = 1;
        size = 0;
        queueTail = 1;
        // we don't use priorityTree[0]
        priorityTree = (T[]) new Comparable[capacity + 1];
    }

    /**
     * Returns the number of elements currently in the queue.
     */
    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    /**
     * Double the capacity of the queue
     */
    private void doubleQueue()
    {
        // make copy
        T[] newTree = (T[]) new Comparable[capacity*2+1];
        for(int i = 1; i <= capacity; i++)
        {
            newTree[i] = priorityTree[i];
        }

        priorityTree = newTree;

        // update the capacity
        capacity *= 2;
    }


    /**
     * Adds elem to the queue.
     */
    public void add(T elem) {
        // check if need to enlarge the queue
        if(size == capacity)
        {
            doubleQueue();
        }

        // adding item into the tail of the queue
        priorityTree[queueTail++] = elem;
        size++;

        // sort the queue
        for(int i = queueTail - 1; i > 0; i /= 2)
        {
            // only one root node: no need to sort
            if(i == 1)
            {
                break;
            }

            // test if the node is less than its parent
            if(priorityTree[i].compareTo(priorityTree[i/2]) < 0)
            {
                // swap
                T temp = priorityTree[i];
                priorityTree[i] = priorityTree[i/2];
                priorityTree[i/2] = temp;
            }
            else
            {
                break;
            }
        }
    }

    /**
     * Removes, and returns, the element at the front of the queue.
     */
    public T remove() throws NoSuchElementException{
        // check if the queue is empty
        if(isEmpty())
        {
            throw new NoSuchElementException(
                "Cannot remove from an empty queue.");
        }

        // get the element to be removed (the front)
        T target = priorityTree[1];

        // the last element becomes the root
        priorityTree[1] = priorityTree[--queueTail];
        size--;

        // sorting
        int i = 1;
        while(i < queueTail)
        {
            // doesn't have children at all
            if(2*i >= queueTail)
            {
                break;
            }

            // doesn't have a right child: must have a left child
            if(2*i+1 >= queueTail)
            {   
                // greater than the left child?
                if(priorityTree[i].compareTo(priorityTree[2*i]) > 0)
                {
                    // swap with the left chihld
                    T temp = priorityTree[i];
                    priorityTree[i] = priorityTree[2*i];
                    priorityTree[2*i] = temp;
                    // update
                    i *= 2;
                }

                break;
            }

            // has two children
            // test if the parent is greater than any of its children
            if(priorityTree[i].compareTo(priorityTree[2*i]) > 0 ||
                priorityTree[i].compareTo(priorityTree[2*i+1]) > 0)
            {
                // swap with the smaller child
                if(priorityTree[2*i].compareTo(priorityTree[2*i+1]) < 0)
                {
                    T temp = priorityTree[i];
                    priorityTree[i] = priorityTree[2*i];
                    priorityTree[2*i] = temp;
                    // update
                    i *= 2;
                }
                else
                {
                    T temp = priorityTree[i];
                    priorityTree[i] = priorityTree[2*i+1];
                    priorityTree[2*i+1] = temp;
                    // update
                    i = 2*i + 1;
                }
            }
            else
            {
                break;
            }
        }
        return target;
    }

    /**
     * Returns true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0? true : false;
    }


    public void printQueue()
    {
        for(int i = 1; i < queueTail; i++)
        {
            System.out.print(priorityTree[i]);
            System.out.print('\n');
        }
    }

    public static void main(String args[])
    {
        MinPriorityQueue<Integer> pq = new MinPriorityQueue<Integer>();
        pq.add(-1);
        pq.add(43);
        pq.add(6);
        pq.add(38);
        pq.add(1);
        pq.add(0);
        pq.add(19);
        pq.add(-714);
        pq.add(2);
        pq.add(-8);
        pq.add(74);
        pq.add(41);
        pq.add(-23);
        pq.printQueue();
        System.out.println('\n');
        final int LEN = pq.size();
        for(int i = 0; i < LEN; i++)
        {
            // System.out.println("dequeue:");
            System.out.println(pq.remove());
            // System.out.println("after dequeue");
            // pq.printQueue();
        }
        System.out.println("after dequeuing the size now " + pq.size());
    }
    
}
