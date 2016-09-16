package Algorithms.Collections;

import java.util.Iterator;


public class Deque<Item> implements Iterable<Item>, Iterator<Item> {

    private int count;

    private class Node
    {
        public Item item;
        public Node next;
        public Node previous;

        public Node(Item item)
        {
            this.item = item;
        }
    }

    private Node first;
    private Node last;
    private Node current;


    public Deque()                           // construct an empty deque
    {
        count = 0;
        first = null;
        last = null;
    }


    public boolean isEmpty()                 // is the deque empty?
    {
        return first == null;
    }


    public int size()                        // return the number of items on the deque
    {
        return count;
    }


    public void addFirst(Item item)          // add the item to the front
    {
        Node node = new Node(item);
        node.next = first;

        if (first != null) first.previous = node;
        first = node;

        if (last == null) last = first;
        if (current == null) current = first;
        count++;
    }


    public void addLast(Item item)           // add the item to the end
    {
        Node node = new Node(item);

        node.previous = last;
        if (last != null) last.next = node;
        last = node;

        if (first == null) first = last;
        if (current == null) current = last;

        count++;
    }


    public Item removeFirst()                // remove and return the item from the front
    {
        count--;

        Node result = first;
        first = first.next;

        return result.item;
    }


    public Item removeLast()                 // remove and return the item from the end
    {
        count--;
        Node result = last;
        last = last.previous;

        return result.item;
    }


    public Iterator<Item> iterator()         // return an iterator over items in order from front to end
    {
        return this;
    }



    @Override
    public boolean hasNext()
    {
        return current != null && current.next != null;
    }


    @Override
    public Item next()
    {
        if (current == null) current = first;
        Node result = current;
        current = result == null ? null : result.next;

        return result.item;
    }

    @Override
    public void remove()
    {
        throw new java.lang.UnsupportedOperationException();
    }


    //public static void main(String[] args)   // unit testing
    //{}
}