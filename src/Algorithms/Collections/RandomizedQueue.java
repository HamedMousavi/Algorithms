
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;


public class RandomizedQueue<Item> implements Iterable<Item>
{

    private int count;
    private int capacity;
    private Item[] items;


    public RandomizedQueue()                // construct an empty randomized queue
    {
        init(10);
    }


    private void init(int itemsCapacity)                 // construct an empty randomized queue
    {
        count = 0;
        capacity = itemsCapacity;
        if (capacity > 0) items = duplicateArray(capacity);
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

        count++;
        if (count >= capacity) resizeQueu();

        items[count - 1] = item;
    }


    public Item dequeue()                    // remove and return a random item
    {
        // Items inserted in a random order so just remove the first item it will be random!
        if (count <= 0) throw new java.util.NoSuchElementException();

        int randomIndex = StdRandom.uniform(0, count);
        count--;
        Item result = items[randomIndex];

        if (randomIndex != count)
        {
            // last item is to be returned, hurray!
            shiftItems(randomIndex);
        }

        if (count < capacity / 4)
        {
            capacity /= 2;
            items = duplicateArray(capacity);
        }

        return result;
    }


    public Item sample()                     // return (but do not remove) a random item
    {
        if (count <= 0) throw new java.util.NoSuchElementException();

        return items[StdRandom.uniform(0, count)];
    }


    private void shiftItems(int randomIndex)
    {
        for (int i = randomIndex + 1; i <= count + 1; i++)
        {
            items[i - 1] = items[i];
        }
    }


    private void resizeQueu()
    {
        capacity *= 2;
        items = duplicateArray(capacity);
    }


    private Item[] duplicateArray(int newCapacity)
    {
        Item[] newArray = (Item[]) new Object[newCapacity];

        for (int i = 0; i < count; i++)
        {
            newArray[i] = items[i];
        }

        // System.gc();

        return newArray;
    }


    public Iterator<Item> iterator()         // return an independent iterator over items in random order
    {
        return new RandomizedQueueIterator();
    }


    private class RandomizedQueueIterator implements Iterator<Item>
    {
        private RandomizedQueue<Item> duplicate;

        private RandomizedQueueIterator()
        {
            // Todo: duplicate passed queue
            duplicate = new RandomizedQueue<Item>();
            duplicate.items = duplicateArray(capacity);
            duplicate.capacity = capacity;
            duplicate.count = count;
        }


        @Override
        public boolean hasNext() {
            return !duplicate.isEmpty();
        }


        @Override
        public Item next() {
            return duplicate.dequeue();
        }


        @Override
        public void remove()
        {
            throw new java.lang.UnsupportedOperationException();
        }
    }
}
