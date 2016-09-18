// package Algorithms.Collections;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class Deque<Item> implements Iterable<Item> {

    private int count;
    private Node first;
    private Node last;


    public Deque()                           // construct an empty deque
    {
        count = 0;
        first = null;
        last = null;
    }


    public boolean isEmpty()                 // is the deque empty?
    {
        return count == 0;
    }


    public int size()                        // return the number of items on the deque
    {
        return count;
    }


    public void addFirst(Item item)          // add the item to the front
    {
        if (item == null) throw new java.lang.NullPointerException();

        Node node = new Node(item, first, null);

        if (first != null) first.previous = node;
        first = node;

        if (last == null) last = first;
        count++;
    }


    public void addLast(Item item)           // add the item to the end
    {
        Node node = new Node(item, null, last);

        if (last != null) last.next = node;
        last = node;

        if (first == null) first = last;

        count++;
    }


    public Item removeFirst()                // remove and return the item from the front
    {
        if (count <= 0) throw new java.util.NoSuchElementException();

        count--;
        Node result = first;

        if (count <= 0)
        {
            first = null;
            last = null;
        }
        else
        {
            first = first.next;
        }

        return result.item;
    }


    public Item removeLast()                 // remove and return the item from the end
    {
        if (count <= 0) throw new java.util.NoSuchElementException();

        count--;
        Node result = last;
        if (count <= 0)
        {
            first = null;
            last = null;
        }
        else
        {
            last = last.previous;
        }

        return result.item;
    }


    public Iterator<Item> iterator()         // return an iterator over items in order from front to end
    {
        return new DequeueIterator(this);
    }


    private class DequeueIterator implements Iterator<Item>
    {

        private Deque<Item> owningQueue;
        private Node current;


        public DequeueIterator(Deque<Item> owner)
        {
            owningQueue = owner;
        }

        @Override
        public boolean hasNext()
        {
            return owningQueue.count > 0;
        }


        @Override
        public Item next()
        {
            if (owningQueue.count <= 0) throw new NoSuchElementException();

            // return owningQueue.removeFirst();

            if (current == null) current = owningQueue.first;
            Node result = current;
            current = result.next;
            return result.item;
        }

        @Override
        public void remove()
        {
            throw new java.lang.UnsupportedOperationException();
        }
    }


    // public static void main(String[] args)   // unit testing
    // {}


    private class Node
    {
        private Item item;
        private Node next;
        private Node previous;

        // private Node(Item wrappedItem)
        // {
        //     this.item = wrappedItem;
        // }

        private Node(Item wrappedItem, Node nextNode, Node previousNode)
        {
            this.item = wrappedItem;
            next = nextNode;
            previous = previousNode;
        }
    }
}