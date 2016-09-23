import Algorithms.Sort.BruteCollinearPoints;
import Algorithms.Sort.Point;
import org.junit.Assert;
import org.junit.Test;


public class SortTests
{

    @Test(expected=java.lang.NullPointerException.class)
    public void BruteTestExpectedNullElementException()
    {
        new BruteCollinearPoints(new Point[] { new Point(1,1), new Point(1,2), null, new Point(1,1) });
    }


    @Test(expected=java.lang.IllegalArgumentException.class)
    public void BruteTestExpectedDuplicateElementException()
    {
        new BruteCollinearPoints(new Point[] { new Point(1,1), new Point(1,2), new Point(1,1) });
    }


    @Test
    public void BruteTestLessThan4Elements()
    {
        Point[] points = new Point[] { new Point(1,1), new Point(1,2), new Point(1,3) };
        BruteCollinearPoints alg = new BruteCollinearPoints(points);

        Assert.assertEquals(alg.numberOfSegments(), 0);
        Assert.assertNull(alg.segments());
    }


    @Test
    public void BruteTest4Elements()
    {
        Point[] points = new Point[] { new Point(1,1), new Point(1,2), new Point(1,3), new Point(1,4) };
        BruteCollinearPoints alg = new BruteCollinearPoints(points);

        Assert.assertEquals(alg.numberOfSegments(), 1);
        Assert.assertNotNull(alg.segments());
    }
}
