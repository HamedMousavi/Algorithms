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
        Point[] points = new Point[] { new Point(1,1), new Point(1,2), new Point(1,3) };
        BruteCollinearPoints alg = new BruteCollinearPoints(points);

        Assert.assertEquals(alg.numberOfSegments(), 1);
        Assert.assertNotNull(alg.segments());

        points = new Point[] { new Point(1,1), new Point(2,2), new Point(3,3), new Point(4,4) };
        alg = new BruteCollinearPoints(points);

        Assert.assertEquals(alg.numberOfSegments(), 1);
        Assert.assertNotNull(alg.segments());

        points = new Point[] { new Point(1,1), new Point(2,1), new Point(3,1), new Point(4,1) };
        alg = new BruteCollinearPoints(points);

        Assert.assertEquals(alg.numberOfSegments(), 1);
        Assert.assertNotNull(alg.segments());

        points = new Point[] { new Point(1,1), new Point(2,1), new Point(1,3), new Point(1,4), new Point(3,1), new Point(4,1), new Point(1,2)  };
        alg = new BruteCollinearPoints(points);

        Assert.assertEquals(alg.numberOfSegments(), 2);
        Assert.assertNotNull(alg.segments());

    }


    @Test(expected=java.lang.NullPointerException.class)
    public void FastTestExpectedNullElementException()
    {
        new FastCollinearPoints(new Point[] { new Point(1,1), new Point(1,2), null, new Point(1,1) });
    }


    @Test(expected=java.lang.IllegalArgumentException.class)
    public void FastTestExpectedDuplicateElementException()
    {
        new FastCollinearPoints(new Point[] { new Point(1,1), new Point(1,2), new Point(1,1) });
    }


    @Test
    public void FastTestLessThan4Elements()
    {
        Point[] points = new Point[] { new Point(1,1), new Point(1,2), new Point(1,3) };
        FastCollinearPoints alg = new FastCollinearPoints(points);

        Assert.assertEquals(alg.numberOfSegments(), 0);
        Assert.assertNull(alg.segments());
    }


    @Test
    public void FastTest4Elements()
    {
        FastCollinearPoints alg = new FastCollinearPoints(new Point[] { new Point(1,1), new Point(1,2), new Point(1,3), new Point(1,4) });
        Assert.assertEquals(alg.numberOfSegments(), 1);
        Assert.assertNotNull(alg.segments());

        alg = new FastCollinearPoints(new Point[] { new Point(1,1), new Point(2,2), new Point(3,3), new Point(4,4) });
        Assert.assertEquals(alg.numberOfSegments(), 1);
        Assert.assertNotNull(alg.segments());

        alg = new FastCollinearPoints(new Point[] { new Point(1,1), new Point(2,1), new Point(3,1), new Point(4,1) });
        Assert.assertEquals(alg.numberOfSegments(), 1);
        Assert.assertNotNull(alg.segments());

        alg = new FastCollinearPoints(new Point[] { new Point(1,1), new Point(2,1), new Point(1,3), new Point(1,4), new Point(3,1), new Point(4,1), new Point(1,2)  });
        Assert.assertEquals(alg.numberOfSegments(), 2);
        Assert.assertNotNull(alg.segments());

    }
}
