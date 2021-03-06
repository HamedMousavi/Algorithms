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
        if (item == null) throw new java.lang.NullPointerException();

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
        Item result = first.item;

        if (count <= 0)
        {
            first = null;
            last = null;
        }
        else
        {
            first = first.next;
        }

        return result;
    }


    public Item removeLast()                 // remove and return the item from the end
    {
        if (count <= 0) throw new java.util.NoSuchElementException();

        count--;
        Item result = last.item;
        if (count <= 0)
        {
            first = null;
            last = null;
        }
        else
        {
            last = last.previous;
        }

        return result;
    }


    public Iterator<Item> iterator()         // return an iterator over items in order from front to end
    {
        return new DequeueIterator();
    }


    private class DequeueIterator implements Iterator<Item>
    {
        private Node current;

        @Override
        public boolean hasNext()
        {
            return count > 0 && current != last;
        }

        @Override
        public Item next()
        {
            if (count <= 0) throw new NoSuchElementException();
            if (current == null) current = first;
            else if (current == last) throw new java.util.NoSuchElementException();
            else current = current.next;

            if (current == null) throw new java.util.NoSuchElementException();

            return current.item;
        }

        @Override
        public void remove()
        {
            throw new java.lang.UnsupportedOperationException();
        }
    }


    private class Node
    {
        private Item item;
        private Node next;
        private Node previous;

        private Node(Item wrappedItem, Node nextNode, Node previousNode)
        {
            this.item = wrappedItem;
            next = nextNode;
            previous = previousNode;
        }
    }
}