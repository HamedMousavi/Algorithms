import Algorithms.Collections.Deque;
import edu.princeton.cs.algs4.StdOut;
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
