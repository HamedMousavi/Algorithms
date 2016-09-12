import Algorithms.ConnectedComponents.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.internal.Assignments;


public class UnionFindTest
{

    @Test
    public void QuickFindTest()
    {
        ConnectAndTest(new QuickFind(10));
    }


    @Test
    public void QuickUnionTest()
    {
        ConnectAndTest(new QuickUnion(10));
    }


    @Test
    public void QuickFindAndUnionTest()
    {
        ConnectAndTest(new QuickFindAndUnion(10));
    }


    @Test
    public void PercolationTest()
    {
        Percolation p = new Percolation(3);
        for (int i = 1; i <= 3; i++){
            for (int j = 1; j <= 3; j++){
                Assert.assertEquals(p.isOpen(i, j), false);
                Assert.assertEquals(p.isFull(i, j), false);
            }
        }

        p.open(1, 2);
        Assert.assertEquals(p.isOpen(1, 2), true);

        p.open(2, 2);
        Assert.assertEquals(p.isOpen(2, 2), true);
        Assert.assertEquals(p.isFull(2, 2), true);

        Assert.assertEquals(p.percolates(), false);

        p.open(2, 3);
        Assert.assertEquals(p.isFull(2, 3), true);
        Assert.assertEquals(p.percolates(), false);

        p.open(3, 3);
        Assert.assertEquals(p.isFull(3, 3), true);
        Assert.assertEquals(p.percolates(), true);
    }


    private void ConnectAndTest(IUnionFind uf)
    {
        uf.Union(3, 4);
        uf.Union(3, 8);
        uf.Union(6, 5);
        uf.Union(9, 4);
        uf.Union(2, 1);
        uf.Union(8, 9);
        uf.Union(5, 0);
        uf.Union(7, 2);
        uf.Union(6, 1);

        Assert.assertEquals(uf.IsConnected(3, 9), true);
        Assert.assertEquals(uf.IsConnected(4, 8), true);
        Assert.assertEquals(uf.IsConnected(9, 8), true);
        Assert.assertEquals(uf.IsConnected(2, 6), true);
        Assert.assertEquals(uf.IsConnected(2, 5), true);
        Assert.assertEquals(uf.IsConnected(0, 6), true);
        Assert.assertEquals(uf.IsConnected(0, 7), true);
        Assert.assertEquals(uf.IsConnected(0, 9), false);
        Assert.assertEquals(uf.IsConnected(7, 8), false);
        Assert.assertEquals(uf.IsConnected(2, 3), false);
        Assert.assertEquals(uf.IsConnected(2, 4), false);
        Assert.assertEquals(uf.IsConnected(2, 9), false);
        Assert.assertEquals(uf.IsConnected(1, 3), false);
        Assert.assertEquals(uf.IsConnected(1, 9), false);
        Assert.assertEquals(uf.IsConnected(6, 4), false);
        Assert.assertEquals(uf.IsConnected(5, 8), false);
        Assert.assertEquals(uf.IsConnected(0, 3), false);
    }

}
