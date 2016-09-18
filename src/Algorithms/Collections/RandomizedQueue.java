// package Algorithms.Collections;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;


public class RandomizedQueue<Item> implements Iterable<Item>
{

    private int count;
    private Node first;
    private Node current;


    public RandomizedQueue()                 // construct an empty randomized queue
    {
        count = 0;
        first = null;
        current = null;
    }


    public boolean isEmpty()                 // is the queue empty?
    {
        return count == 0;
    }


    public int size()                        // return the number of items on the queue
    {
        return count;
    }


    public void enqueue(Item item)           // add the item
    {
        if (item == null) throw new java.lang.NullPointerException();

        insertBeforeOrAfter(findRandomNode(), new Node(item, null, null));
        count++;
    }


    private void insertBeforeOrAfter(Node oldNode, Node newNode)
    {

        if (oldNode == null)
        {
            first = newNode;
        }
        else
        {
            if (StdRandom.uniform(1, 2) == 1)
            {
                // Before old Node
                newNode.previous = oldNode.previous;
                newNode.next = oldNode;
                if (oldNode.previous != null) oldNode.previous.next = newNode;
                oldNode.previous = newNode;

                if (newNode.previous == null) first = newNode;
            }
            else
            {
                // After the old Node
                newNode.next = oldNode.next;
                newNode.previous = oldNode;
                oldNode.next.previous = newNode;
                oldNode.next = newNode;
            }
        }
    }


    public Item dequeue()                    // remove and return a random item
    {
        // Items inserted in a random order so just remove the first item it will be random!
        if (count <= 0) throw new java.util.NoSuchElementException();
        if (first == null || first.item == null)
        {
            return null;
        }
        count--;

        Item result = first.item;


        if (count <= 0)
        {
            first = null;
            current = null;
        }
        else
        {
            first = first.next;
            first.previous = null;
        }

        return result;
    }


    public Item sample()                     // return (but do not remove) a random item
    {
        if (count <= 0) throw new java.util.NoSuchElementException();
        if (current == null)
        {
            current = first;
        }

        Item result = current.item;
        current = current.next;

        return result;
    }


    private Node findRandomNode()
    {
        if (count <= 0) return null;

        int index = StdRandom.uniform(0, count);
        Node random = first;

        for (int i = 1; i < index; i++)
        {
            random = random.next;
        }

        return random;
    }


    public Iterator<Item> iterator()         // return an independent iterator over items in random order
    {
        return new RandomizedQueueIterator(this);
    }


    // public static void main(String[] args)   // unit testing
    // {}


    private class RandomizedQueueIterator implements Iterator<Item>
    {
        private RandomizedQueue<Item> duplicate;

        private RandomizedQueueIterator(RandomizedQueue<Item> originalQueue)
        {
            duplicate = new RandomizedQueue<Item>();

            if (!originalQueue.isEmpty()) {
                duplicate.first = new Node(originalQueue.first.item, originalQueue.first.next, originalQueue.first.previous);
                Node orgCurrent = originalQueue.first;
                Node dupCurrent = duplicate.first;
                for (int i = 1; i < originalQueue.size(); i++)
                {
                    orgCurrent = orgCurrent.next;
                    dupCurrent.next = new Node(orgCurrent.item, orgCurrent.next, orgCurrent.previous);
                    dupCurrent = dupCurrent.next;
                }

                duplicate.count = originalQueue.count;
            }
        }


        @Override
        public boolean hasNext() {
            return !duplicate.isEmpty();
        }


        @Override
        public Item next() {
            return duplicate.sample();
        }


        @Override
        public void remove()
        {
            throw new java.lang.UnsupportedOperationException();
        }  }


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
