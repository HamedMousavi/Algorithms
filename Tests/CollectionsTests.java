import Algorithms.Collections.Deque;
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
}
