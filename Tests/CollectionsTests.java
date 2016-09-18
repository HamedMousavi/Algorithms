import Algorithms.Collections.Deque;
import Algorithms.Collections.RandomizedQueue;
import org.junit.Assert;
import org.junit.Test;

public class CollectionsTests
{
    @Test
    public void DequeTest()
    {
        Deque<Integer> deq = new Deque<Integer>();
        Assert.assertEquals(deq.isEmpty(), true);

        deq.addLast(20);
        Assert.assertEquals(deq.isEmpty(), false);
        Assert.assertEquals(deq.hasNext(), true);

        deq.removeFirst();
        Assert.assertEquals(deq.isEmpty(), true);
        Assert.assertEquals(deq.hasNext(), false);

        deq.addFirst(0);
        Assert.assertEquals(deq.isEmpty(), false);
        Assert.assertEquals(deq.hasNext(), true);

        deq.removeLast();
        Assert.assertEquals(deq.isEmpty(), true);
        Assert.assertEquals(deq.hasNext(), false);

        deq.addFirst(0);
        deq.addFirst(0);
        Assert.assertEquals(deq.isEmpty(), false);
        Assert.assertEquals(deq.hasNext(), true);

        deq.removeLast();
        deq.removeLast();
        Assert.assertEquals(deq.isEmpty(), true);
        Assert.assertEquals(deq.hasNext(), false);

        deq.addFirst(0);
        deq.addFirst(0);
        Assert.assertEquals(deq.isEmpty(), false);
        Assert.assertEquals(deq.hasNext(), true);

        deq.removeFirst();
        deq.removeLast();
        Assert.assertEquals(deq.isEmpty(), true);
        Assert.assertEquals(deq.hasNext(), false);

        deq.addLast(0);
        deq.addFirst(0);
        Assert.assertEquals(deq.isEmpty(), false);
        Assert.assertEquals(deq.hasNext(), true);

        deq.removeFirst();
        deq.removeFirst();
        Assert.assertEquals(deq.isEmpty(), true);
        Assert.assertEquals(deq.hasNext(), false);

        deq.addLast(0);
        deq.addLast(0);
        Assert.assertEquals(deq.isEmpty(), false);
        Assert.assertEquals(deq.hasNext(), true);

        deq.removeFirst();
        deq.removeFirst();
        Assert.assertEquals(deq.isEmpty(), true);
        Assert.assertEquals(deq.hasNext(), false);

        deq.addLast(20);
        deq.addFirst(10);
        deq.addFirst(8);
        deq.addFirst(6);
        deq.addFirst(4);
        deq.addFirst(2);

        Assert.assertEquals(deq.isEmpty(), false);

        //for(int item: deq) {
        //    StdOut.printf("%d, ", item);
        //}

        int last = deq.removeLast();
        Assert.assertEquals(last, 20);
        Assert.assertEquals(deq.isEmpty(), false);

        last = deq.removeLast();
        Assert.assertEquals(last, 10);
        Assert.assertEquals(deq.isEmpty(), false);

        last = deq.removeFirst();
        Assert.assertEquals(last, 2);
        Assert.assertEquals(deq.isEmpty(), false);
    }


    @Test
    public void RandomizedQueueTest()
    {
        RandomizedQueue<Integer> deq = new RandomizedQueue<Integer>();
        Assert.assertEquals(deq.isEmpty(), true);

        deq.enqueue(100);
        deq.enqueue(90);
        deq.enqueue(80);
        deq.enqueue(70);
        deq.enqueue(60);
        deq.enqueue(50);
        deq.enqueue(40);
        deq.enqueue(30);
        deq.enqueue(20);
        deq.enqueue(10);

        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();


        deq.enqueue(8);
        deq.enqueue(6);
        deq.enqueue(4);
        deq.enqueue(2);

        deq.enqueue(100);
        deq.enqueue(90);
        deq.enqueue(100);
        deq.enqueue(90);
        deq.enqueue(80);
        deq.enqueue(70);
        deq.enqueue(60);
        deq.enqueue(50);
        deq.enqueue(40);
        deq.enqueue(30);
        deq.enqueue(20);
        deq.enqueue(10);
        deq.enqueue(8);
        deq.enqueue(6);
        deq.enqueue(4);
        deq.enqueue(2);

        deq.enqueue(80);
        deq.enqueue(70);
        deq.enqueue(60);
        deq.enqueue(50);
        deq.enqueue(40);
        deq.enqueue(30);
        deq.enqueue(20);
        deq.enqueue(10);
        deq.enqueue(8);
        deq.enqueue(6);
        deq.enqueue(4);
        deq.enqueue(2);

        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        deq.dequeue();
        Assert.assertEquals(deq.isEmpty(), false);
        deq.dequeue();
        Assert.assertEquals(deq.isEmpty(), true);

        //for(int item: deq) {
        //    StdOut.printf("%d, ", item);
        //}

        //int last = deq.dequeue();
        //Assert.assertEquals(last, 20);
        //Assert.assertEquals(deq.isEmpty(), false);

        //last = deq.dequeue();
        //Assert.assertEquals(last, 10);
        //Assert.assertEquals(deq.isEmpty(), false);
    }
}
